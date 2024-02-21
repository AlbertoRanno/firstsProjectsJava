package test;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {
    
    public static void main(String[] args) {
        //Instancio la clase PersonaDao, para poder usar sus metodos, dado que no son estaticos
        PersonaDao personaDao = new PersonaDao();

        //No cree el constructor para lo siguiente, asi que tengo que usar los sets
        //Persona personaNueva = new Persona("Horacio", "Bonaluce", "hbonaluce@mail.com","44556699");
        Persona personaNueva = new Persona();
        personaNueva.setNombre("Horacio");
        personaNueva.setApellido("Bonaluce");
        personaNueva.setEmail("hbonaluce@mail.com");
        personaNueva.setTelefono("44556699");
        //personaDao.insertar(personaNueva);
        
        //Para modificar, primero tengo que buscar, porque hice de buscar un codigo aparte        
        Persona personaAModificar = new Persona();
        personaAModificar.setIdPersona(14); //Defino que ID quiero modificar
        personaAModificar = personaDao.buscarPersonaPorId(personaAModificar); //Lo busco y guardo en variable
        System.out.println("personaAModificar = " + personaAModificar);
        personaAModificar.setApellido("Tronguldin");// Modifico solo los valores que necesite, el resto se mantiene
        //personaDao.modificar(personaAModificar);
        
        //Idem, primero lo busco, luego lo elimino
        personaDao.eliminar(personaAModificar);
        
        personaDao.listar();
        
    }
}
