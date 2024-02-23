package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Asignacion;

public class AsignacionDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public AsignacionDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

    public void listar() {
        String hql = "SELECT a from Asignacion a";
        Query query = em.createQuery(hql);
        List<Asignacion> asignaciones = query.getResultList();
        for (Asignacion a : asignaciones) {
            System.out.println("asignacion = " + a);
        }

    }

}
