package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        //personaDao.listar();

        Persona personaNueva = new Persona();
        personaNueva.setNombre("Alberto");
        personaNueva.setApellido("Ranno");
        personaNueva.setEmail("aranno@mail.com");
        personaNueva.setTelefono("4205-8087");
        //personaDao.insertar(persona);

        /* Lo siguiente dio error, 'sesion cerrrada' => para modificar un objeto, primero se tiene que recuperar de la BBDD
        => MODIFICO personaDao, agregando el metodo Buscar
        
        //Los campos que no quiero modificar, los omito:        
        Persona personaModificada = new Persona();
        personaModificada.setIdPersona(12);
        //personaModificada.setNombre("Alberto");
        personaModificada.setApellido("Puchanoski");
        //personaModificada.setEmail("aranno@mail.com");
        personaModificada.setTelefono("4335-8087");
        personaDao.modificar(personaModificada);
        
        TEnia 2 opciones para lograr esto:
        1- o le agregaba a 'modificar' el metodo 'buscar' dentro... para luego solo llamar a actualizar
        2- o creaba el metodo 'buscar', fuera de actualizar, y lo llamo desde test, antes de modificar...
        Opte por la 2, dado que asi tambien uso el mismo metodo buscar, para otros metodos como el de eliminar
        
        Con el metodo Buscar creado, procedo:   */
        Persona personaModificada = new Persona();
        personaModificada.setIdPersona(12);
        //La busco y guardo como objeto completo
        personaModificada = personaDao.buscarPersonaPorId(personaModificada);
        System.out.println("persona encontrada = " + personaModificada);

        //AHora si modifico los valores que quiera
        //personaModificada.setApellido("PuchaNoski");
        //personaDao.modificar(personaModificada);
        
        //Una vez encontrado (al igual que para modificar), lo puedo eliminar. 
        //personaDao.eliminar(personaModificada);
       
        /* Ojo que lo puedo eliminar directamente seteando el ID, es decir, sin la necesidad de usar el metodo BUscar.
        Es decir, en lugar de hacer: 

        Persona personaModificada = new Persona();
        personaModificada.setIdPersona(12);
        personaModificada = personaDao.buscarPersonaPorId(personaModificada);
        personaDao.eliminar(personaModificada);

        Puedo hacer Directamente: 
        Persona personaModificada = new Persona();
        personaModificada.setIdPersona(12);
        personaDao.eliminar(personaModificada);         */

        personaDao.listar();

    }
}
