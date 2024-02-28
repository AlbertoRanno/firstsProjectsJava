package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Domicilio;

public class DomicilioDao extends GenericDao {

    //public void listar() {    //Envio la lista en lugar de imprimirla en consola
    public List<Domicilio> listar() {
        String hql = "SELECT d from Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
        /*List<Domicilio> domicilios = query.getResultList();
        for (Domicilio d : domicilios) {
            System.out.println("domicilio = " + d);
        }*/
    }

    public void insertar(Domicilio domicilio) {
        try {
            em = getEntityManager();
            //Dado que voy a modificar el estado de la base de datos, inicio una transaccion:
            em.getTransaction().begin();
            em.persist(domicilio);
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

    public Object buscarPorId(Domicilio domicilio) {
        em = getEntityManager();
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
        //Al metodo find le paso el tipo de objeto, y la llave primaria
    }

    public void actualizar(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
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

    public void eliminar(Domicilio domicilio) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
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
