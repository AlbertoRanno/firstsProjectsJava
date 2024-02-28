package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;

public class PersistenciaCascadaTest {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Zuviria");
        domicilio.setNroCalle("1122");
        domicilio.setPais("Argentina");

        Contacto contacto = new Contacto();
        contacto.setEmail("dmalvran@mail.com");
        contacto.setTelefono("99552233");

        /*Sin la persistencia en cascada, primero deberia guardar esos objetos en la bbdd, para que se generen
        los IDs, y luego, con esos IDs, guardar el objeto alummno. Pero gracias a la persistencia en cascada,
        eso se hace forma automatica*/
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Diego");
        alumno.setApellido("Malvran");
        //La parte importante, que guarde el objeto completo:
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        try {
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            System.out.println("alumno = " + alumno);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

    }
}
