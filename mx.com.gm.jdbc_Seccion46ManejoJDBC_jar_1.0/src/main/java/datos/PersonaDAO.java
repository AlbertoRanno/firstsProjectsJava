package datos;
//Va a realizar los INSERT UPDATE SELECT DELETE sobre la tabla de persona

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO {

    //Buenas practicas => las sentencias como atributos
    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
    // En este caso nombra todas las columnas, si bien no hace falta por sintaxis, pero para estar seguro
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    //no se agrega ID al insertar dado que es automatico, y en cuanto a los valores "duros" no se pasan, sino que usa el simbolo=> '?'
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";

    /*Siempre probar la sentencia directo en el workbench (Ahi si con datos en lugar de los '?')   
    Cuando se prueba NO Pasarle los ";" si es que es la unica sentencia!  */

    //Cada renglon de la tabla lo voy a convertir en un objeto del tipo persona, y luego voy a listar todos los objetos 
    public List<Persona> seleccionar() {
        /*Defino variables a utilizar, fuera del bloque try/catch, para que en el bloque finally pueda utilizar 
        los metodos que las cierran */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            //Conecto a la BBDD => posible excepcion => try/catch
            //conn = Conexion.getConnection() => paso el import a static => getConnection()
            conn = getConnection(); // => conexion activa
            stmt = conn.prepareCall(SQL_SELECT); // => preparo query
            rs = stmt.executeQuery(); // => ejecuto query / consulta (no estoy actualizando nada)
            while (rs.next()) {// => itero cada uno de los registros // next para ver si tengo registros que iterar
                int idPersona = rs.getInt("idpersona");
                //OJO! idPersona == nomenclatura de JAVA = rs.getINt("idpersona"); idpersona == nombre en la BBDD!
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                /*TEngo varios constructores de la clase Persona, pero dado que quiero llenar un objecto del tipo Persona
                con cada uno de sus atributos, conviene usar el que viene completo*/
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                /*Aca no estoy mandando a imprimir, como en el generico, sino armando un objeto apto todo fin
                De la info de la BBDD, armo objectos JAVA en esta linea
                ESTO ES LO QUE HACE HIBERNATE O JPA INTERNAMENTE!!
                
                una vez que arme un objeto con una linea de la tabla, lo paso a la lista:   */
                
                personas.add(persona);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try { //Este bloque try / catch se podría mandar a la conexion (donde puse el throw..)
                //sin el import static => Conexion.close(conn);
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }
    
    public int insertar(Persona persona) {
        /*va a devolver un numero => cantidad de registros modificados => En este caso, solo 1 registro,
        pero se podria modificar a mas registros de una sola vez
            REcibe un objeto del tipo persona
            DEfino variables del metodo, para luego cerrarlas, por lo tanto quedan fuera del try/catch:  */
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT); //En este caso, no es el SQL_SELECT, sino el de insert => Lo defino
            /*Ojo, aca es setString, porque todos los parametros de : son Strings
             private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
            Entre parentesis, se indican las posiciones de los parametros: 1 => nombre // 2 => apellido....
            y se utilizan los metodos getNombre... porque son atributos privados
            
            REcordar que en la BBDD puse que los valores podian ser nulos, si no fuera el caso, tengo que usar validaciones aqui tmb*/
            
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
            //Se altera el estado de la BBDD para actualizarlo (Insert Update o Delete pueden ser ejecutadas por este metodo)

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }
    
    public int actualizar(Persona persona) { //Cuantos registros se han actualizado
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            //UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?
            //Es lo mismo con el orden de los parametros , pero nombre => 1, apellido => 2, .... idPersona => 5
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona()); //Ojo setInt
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }
    
    public int eliminar(Persona persona) { //Cuantos registros se han eliminado
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = getConnection();
            //DELETE FROM persona WHERE idpersona = ?
            //Es lo mismo con el orden de los parametros , pero idpersona => 1
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }
}
