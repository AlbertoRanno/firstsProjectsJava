package test;

import java.util.List;
import mx.com.gm.dao.*;
import mx.com.gm.domain.Domicilio;

public class OperacionesHibernateConAsociaciones {

    public static void main(String[] args) {
        DomicilioDao domicilioDao = new DomicilioDao();
        CursoDao cursoDao = new CursoDao();
        ContactoDao contactoDao = new ContactoDao();
        AlumnoDao alumnoDao = new AlumnoDao();
        AsignacionDao asignacionDao = new AsignacionDao();
        
        Domicilio nuevoDomicilio = new Domicilio();
        nuevoDomicilio.setCalle("Av Directorio");
        nuevoDomicilio.setNroCalle("425");
        nuevoDomicilio.setPais("Argentina");
//        domicilioDao.insertar(nuevoDomicilio);



        /* Modifique el metodo listar para que no imprima a consola desde el metodo, sino que creare un metodo imprimir aqui
        domicilioDao.listar();
        cursoDao.listar();
        contactoDao.listar();
        alumnoDao.listar();
        asignacionDao.listar();
         */
        imprimir(domicilioDao.listar());
//        imprimir(cursoDao.listar());
//        imprimir(contactoDao.listar());
//        imprimir(alumnoDao.listar());
//        imprimir(asignacionDao.listar());
        
        
    }

    public static void imprimir(List colecciones) {
        for (Object objeto : colecciones) {
            System.out.println("objeto = " + objeto);
        }
    }
}
