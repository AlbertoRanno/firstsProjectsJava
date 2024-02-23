package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Curso;

public class CursoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CursoDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

    public void listar() {
        String hql = "SELECT c from Curso c";
        Query query = em.createQuery(hql);
        List<Curso> cursos = query.getResultList();
        for (Curso c : cursos) {
            System.out.println("cursos = " + c);
        }
    }
}
