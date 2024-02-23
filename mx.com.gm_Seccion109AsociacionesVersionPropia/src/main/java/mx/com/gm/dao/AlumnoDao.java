package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Alumno;

public class AlumnoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public AlumnoDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

    public void listar() {
        String hql = "SELECT a from Alumno a";
        Query query = em.createQuery(hql);
        List<Alumno> alumnos = query.getResultList();
        for (Alumno a : alumnos) {
            System.out.println("alumno = " + a);
        }
    }
}
