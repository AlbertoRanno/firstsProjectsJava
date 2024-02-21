package mx.com.gm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.com.gm.domain.Persona;

//patron de diseño DAO (Data Access Object) => Ubicado en paquete dao => Contendra Select, Insert, Find, Update y Delete
public class PersonaDao {

    //Atributos
    private EntityManagerFactory emf;
    private EntityManager em;
    //Se usan para, mediante la config en el archivo Persistence, crear una instancia, conectarse a la BBDD y generar la consulta

    //Constructor
    public PersonaDao() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");//HibernatePU fue el nombre dado en Persistence
        em = emf.createEntityManager(); //con 'em' voy a poder efectuar las consultas o las operaciones con Hibernate    
    }

    //Metodos
    // public void listar() { //(**)
    public List<Persona> listar() {
        String hql = "SELECT p from Persona p"; //Query de hql (Hibernate Query Language)
        //-'p' es el nombre del alias de la clase java
        //-Persona es el nombre de la clase entidad (Persona), y no de la tabla (persona)
        Query query = em.createQuery(hql); //'query' sera una lista de objetos del tipo Persona
        List<Persona> personas = query.getResultList(); //Guardo esa lista en un listado del tipo Persona

        /* Al agregar el paquete de servicios, necesito que en lugar de imprimirlo, me retorne el listado (**), 
        para poder enviarlo a la vista, o generar el endpoint
        for (Persona p : personas) {
            System.out.println("Persona = " + p);
        } */
        return personas;
    }

    public void insertar(Persona persona) {
        try {
            //Si hubiera un servidor del estilo GlassFish, JBoss... este se encarga de las conexiones, sino, hay que hacerlas.
            em.getTransaction().begin();
            em.persist(persona); //la pasa a la bbdd
            //Obs! ojo de no pasar un objeto con un ID, eso lo maneja la bbdd
            //Para que se guarde, hago el commit, pero si hay error, que haga un rollback
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } //creo que habria que agregar un finally para cerrar la transaccion, pero daba error, luego ver...

    }

    //Para modificar un registro, va a hacer falta primero buscarlo por Id
    //Podría incluir esa parte aqui, o hacer un metodo aparte, que fue por lo que opte
    public void modificar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.merge(persona); //IDEM insertar, pero merge
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    //Esto no hace modificaciones en la BBDD, por lo que no es necesario iniciar una transaccion
    public Persona buscarPersonaPorId(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    public void eliminar(Persona persona) {
        try {
            em.getTransaction().begin();
            em.remove(em.merge(persona)); //Se debe actualizar primero, y luego eliminar
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
}
