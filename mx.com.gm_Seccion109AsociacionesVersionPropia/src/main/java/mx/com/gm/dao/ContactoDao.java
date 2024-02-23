package mx.com.gm.dao;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class ContactoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ContactoDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

    public void listar() {
        String hql = "SELECT c from Contacto c";
        Query query = em.createQuery(hql);
        List<Contacto> contactos = query.getResultList();
        for (Contacto c : contactos) {
            System.out.println("contacto = " + c);
        }
    }

}
