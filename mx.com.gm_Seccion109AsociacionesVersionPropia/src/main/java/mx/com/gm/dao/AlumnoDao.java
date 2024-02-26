package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Alumno;

//extends GenericDao...
public class AlumnoDao extends GenericDao {

    /* ...para que, en lugar de en cada clase tener:
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public AlumnoDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }
    ... */
    public List<Alumno> listar() {
        String hql = "SELECT a from Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Object buscarPorId(Alumno alumno) {
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }

    public void actualizar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void eliminar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
