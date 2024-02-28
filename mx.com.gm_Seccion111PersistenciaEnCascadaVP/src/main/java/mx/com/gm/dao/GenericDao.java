package mx.com.gm.dao;

import javax.persistence.*;

/*  Esta clase la cree al darme cuenta de que habia creado todas las clasesDao, repitiendo al comienzo de cada una,
el mismo codigo de:

    private EntityManagerFactory emf;
    private EntityManager em;

    public CursoDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

Frente a esto, mejor es crear una clase padre abstracta (para que no se puedan crear objetos de ella, sino de sus hijos),
que contenga este codigo en comun, pero mejorado, con los condicionales, que preguntan, si ya se habia establecido una
conexion, o hay que crear una nueva.

Los atributos:
-son todos estaticos para indicar que en todas instancias de la clase los valores seran los mismos
-son protected para que puedan ser accecidos por los hijos

EntityManager y EntityManagerFactory son clases proporcionadas por JPA (Java Persistence API) para interactuar con la bbdd

EntityManagerFactory ayuda a crear EntityManager, y EntityManager permite hacer operaciones con la base de datos

PU representa el nombre de la unidad de persistencia,que se configura en el archivo persistence.xml.

El constructor es un conjunto de instrucciones que se ejecutan automáticamente cuando los hijos lo llaman mediante super()
*/

public abstract class GenericDao {

    protected static EntityManager em;
    protected static EntityManagerFactory emf;
    protected static final String PU = "HibernatePU";

    public GenericDao() {
        if (emf == null) {
            this.emf = Persistence.createEntityManagerFactory(PU); // Se crea una instancia de EntityManagerFactory
        }
    }

    protected EntityManager getEntityManager() {
        if (em == null) {
            this.em = emf.createEntityManager(); // Si la instancia de EntityManager no existe, se crea una nueva.
        }
        // Se devuelve la caja de herramientas para que se pueda usar en las operaciones con la base de datos.
        return em;
    }
}
