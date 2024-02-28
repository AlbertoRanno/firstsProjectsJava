package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjetoPersistente {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();
        
        //Defino variable
        Contacto contacto = null;
        
        /*si es necesario estar dentro de una transaccion, porque voy a modificar la bbdd, la transaccion, la puedo
        iniciar antes o despues de recuperar el objeto. La diferencia es que si lo recupero antes, el estado
        del objeto sera detached, porque esta separado, y sino persistido. */
        
        //Recupero objeto ANTES de iniciar la transaccion => detached
        contacto = em.find(Contacto.class, 3);

        //Modifico el objeto
        contacto.setEmail("clara@mail.com");

        //Inicio transaccion
        em.getTransaction().begin();
        
        //Dentro de la transaccion estoy en estado persistente
        em.merge(contacto);
        /* podria usar
        em.persist(contacto);
        Para guardar los cambios, pero dado que es una actualizacion, la buena practica es usar el merge*/
        
        //Sincronizo con la bbdd
        em.getTransaction().commit();

        //Al terminar la transaccion pasa al estado detached
        System.out.println("contacto = " + contacto);
    }
}
