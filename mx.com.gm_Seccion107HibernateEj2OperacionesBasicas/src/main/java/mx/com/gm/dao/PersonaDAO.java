package mx.com.gm.dao;

import java.util.*;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class PersonaDAO {

    /*En el proyecto 106, en Test, se usan EntityManagerFactory y EntityManager, para poder crear una instancia,
    y conectarse a la BBDD. Y posteriormente, con el OBjeto entityManager, ejecutaba la consulta, ahora lo voy a hacer
    desde la clase Persona Dao: */
    //Declaro variables
    private EntityManagerFactory emf;
    private EntityManager em;

    //Constructor y en esta clase voy a crear la fabrica, 
    public PersonaDAO() {
        //el nombre de la unidad de persistencia, es el de la configuracion: 
        //<persistence-unit name="HibernatePU" transaction-type="RESOURCE_LOCAL">
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
        //AHora con 'em', puedo ejecutar las consultas o las operaciones con Hibernate
    }

    public void listar() {
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();
        for (Persona p : personas) {
            System.out.println("Persona = " + p);
        }
    }

    /*    CUando use Hibernate, pero no despliegue la app en un servidor (Ej, Glassfish, JBoss, u otro...),
    entonces seré el responsable de abrir y cerrar las transacciones (mientras que si hubiera un serivdor,
    lo hace manera automática)*/
    public void insertar(Persona persona) {

        try {
            em.getTransaction().begin();
            em.persist(persona);
            /*Con eso ya se graba. Recordar que en la columna idpersona de la tabla, la misma debe estar vacia,
        y estar marcada como autoincrementable. Ojo de no pasarle el idPersona en el objeto Persona
        Por ultimo, hago commit, para guardar => y agrego try catch, para que en caso de excepcion, haga un roleback*/
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            /*Dado que fui el responsable de abrir la transaccion, la tengo que cerrar*/
//            if (em != null) {
//                em.close();
//            }
        }

    }

    //Similar a insertar, pero usa el metodo 'merge' en lugar de 'persist'
    public void modificar(Persona persona) {
        //En este caso el Obj Persona, recordar que requiere el ID
        try {
            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }

    /*Busco y retorno un objeto del tipo persona
    Esto no hace modificaciones en la BBDD, por lo que no es necesario iniciar una transaccion*/
    public Persona buscarPersonaPorId(Persona p) {
        return em.find(Persona.class, p.getIdPersona());
    }

    /*Ahora, con este codigo, antes de modificar un objeto, primero lo busco*/

    public void eliminar(Persona persona) {
        try {
            em.getTransaction().begin();
            //Se debe actualizar primero, y luego eliminar
            em.remove(em.merge(persona));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }
}
