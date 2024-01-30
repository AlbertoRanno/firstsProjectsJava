package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

public class TestManejoPersonas {

    public static void main(String[] args) {
        //llamare a los metodos definidos en PersonaDao
        PersonaDAO personaDao = new PersonaDAO();
        //PersonaDao en este caso es una implementacion directa, y seria mejor llamar un tipo interface (luego)

        //INSERTANDO NUEVO OBJETO DEL TIPO PERSONA: (usar constructor SIN ID)
//        Persona personNueva = new Persona("Carlos", "Ranno", "aranno@mail.com", "5491149246136");
//        personaDao.insertar(personNueva);

        //MODIFICANDO UN OBJETO DE PERSONA EXISTENTE: (usar constructor completo para indicarle el ID donde hacerlo)
        //Los valores donde no quiera modificarlos, volver a escribirlos iguales (ejemplo, mismo telefono)
//        Persona personaModificada = new Persona(10,"Juan Carlos", "Ranno", "j.a.ranno@email.com", "5491149246136");
//        personaDao.actualizar(personaModificada);

        //ELIMINANDO UN OBJETO DE PERSONA EXISTENTE: (usar constructor con solo ID)
//        Persona personaEliminada = new Persona(8);
//        personaDao.eliminar(personaEliminada);

        //LISTANDO OBJETOS:
        //personaDao.seleccionar(); ejecuto el metodo, y lo guardo en una variable del tipo Lista<Persona> y lo llamo 'personas'
        List<Persona> personas = personaDao.seleccionar();
        for (Persona persona : personas) {  //  personas.forEach(persona -> {
            System.out.println("persona = " + persona); //imprime por completo cada objeto //usa el metodo toString
            //Esto es lo que va a hacer Hibernate o JPA
            //Aca ya no tengo manejo de excepciones, eso lo dejo en la capa de datos

        }

    }
}
