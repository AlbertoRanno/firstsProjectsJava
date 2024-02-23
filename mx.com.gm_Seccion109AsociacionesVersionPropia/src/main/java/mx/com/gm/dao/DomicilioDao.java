package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Domicilio;

public class DomicilioDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public DomicilioDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

    public void listar() {
        String hql = "SELECT d from Domicilio d";
        Query query = em.createQuery(hql);
        List<Domicilio> domicilios = query.getResultList();
        for (Domicilio d : domicilios) {
            System.out.println("domicilio = " + d);
        }
    }
}
