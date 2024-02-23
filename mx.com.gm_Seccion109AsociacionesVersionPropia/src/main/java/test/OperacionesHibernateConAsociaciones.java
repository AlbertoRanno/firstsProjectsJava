package test;

import mx.com.gm.dao.*;

public class OperacionesHibernateConAsociaciones {

    public static void main(String[] args) {
        DomicilioDao domicilioDao = new DomicilioDao();
        CursoDao cursoDao = new CursoDao();
        ContactoDao contactoDao = new ContactoDao();
        AlumnoDao alumnoDao = new AlumnoDao();
        AsignacionDao asignacionDao = new AsignacionDao();
        
        domicilioDao.listar();
        cursoDao.listar();
        contactoDao.listar();
        alumnoDao.listar();
        asignacionDao.listar();
    }
}
