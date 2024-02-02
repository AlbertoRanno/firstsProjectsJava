package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;

public class TestManejoPersonas {

    public static void main(String[] args) {
        /*llamare a los metodos definidos en PersonaJDBC
        PersonaJDBC personaJDBC = new PersonaJDBC();*/

        Connection conexion = null;

        try {
            //Primero creo objeto del tipo conexion (Este es el que esta fuera de la clase PersonaJDBC
            conexion = Conexion.getConnection();

            //Reviso en que estado esta autocommit:
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); //Lo que explicaba antes, lo saco de automatico
            }

            //lo paso ahora a la variable que me va a permitir llamar todos los metodos,
            //pero usando el constructor que recibe un objeto del tipo Connection => Mi nueva conexion externa
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);

            //AHora ejecuto varias sentencias dentro de la transaccion:
            //Las importantes son las que modifican el estado de la BBDD (un select, no iria dentro, dado que no cambia nada)
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(10);
            cambioPersona.setNombre("Perez");
            cambioPersona.setApellido("Pedro");
            cambioPersona.setEmail("pp@mail.com");
            cambioPersona.setTelefono("5491164236665");
            personaJDBC.actualizar(cambioPersona);

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Mario");
//Si corro con la siguiente linea, se guardan las modificaciones de todas las sentencias            
nuevaPersona.setApellido("Gonzales");
//Pero si genero un fallo, por ejemplo, excederme en el numnero de caracteres que almacena la columna de apellido
//en la tabla, definida como VARCHAR45, esto deberia de arrojar error, y no deberia de guardarse ninguna modificacion,
//de las de dentro del bloque de ejecucion, por mas que esas esten ok => todas o nada!
          //  nuevaPersona.setApellido("Gonzalesssssssssssssssssssssssssssssssssssssssssssssssssss");
            //seleccionando el apellido abajo a la derecha, veo la cantidad de caracteres: 46:97/1:58 => 58 > 45 caracteres => error
            //pero un cambio necesario antes de ejecutar y ver el rollback, es corregir el manejo de excepciones! (*2)
            nuevaPersona.setEmail("mp@email.com");
            nuevaPersona.setTelefono("5491135636699");
            personaJDBC.insertar(nuevaPersona);

            //indico el cierre del bloque con commit(). Es ahora donde se van a guardar los cambios 
            conexion.commit(); //=> en caso de error, entramos al rollback => (*1)

        } catch (SQLException ex) {
            ex.printStackTrace(System.out); 
            /*(*2) Si surge primero la expecion del metodo insertar, no se llega a esta
            por lo tanto no se llega a la parte del rollback => tengo que hacer que los metodos arrojen excepciones (throws)
            en lugar de que las procesen (try/catch) => corrijo en personaJDBC
            Y luego, si corro, arroja error => Data truncation: Data too long for column 'apellido' at row 1 y no actualiza
            a Perez Pedro ni inserta a Mario GOnzalez*/
            //(*1):
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        }

    }

}
