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
        
        Con el metodo Buscar creado, procedo:   */
        Persona personaModificada = new Persona();
        personaModificada.setIdPersona(12);
        //La busco y guardo como objeto completo
        personaModificada = personaDao.buscarPersonaPorId(personaModificada);
        System.out.println("persona encontrada = " + personaModificada);

        //AHora si modifico los valores que quiera
        //personaModificada.setApellido("PuchaNoski");
        //personaDao.modificar(personaModificada);
        
        //Una vez encontrado (al igual que para modificar), lo puedo eliminar o lo puedo eliminar directamente seteando el ID  
        //Por eso es que se hace un merge, con el id, y luego se elimina
        personaDao.eliminar(personaModificada);

        personaDao.listar();

    }
}
