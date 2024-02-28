package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {

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

        //Inicio transaccion
        em.getTransaction().begin();

        //Dentro de la transaccion estoy en estado persistente
        //3. Remove (Existe tambien el metodo Delete, => pero Remove es de JPA, y como Hibernate se alineo con JPA => Remove, mejor
        em.remove(em.merge(contacto));
        /* Primero se sincronizan todos los cambios pendientes en el objeto, y luego se elimina*/

        //Sincronizo con la bbdd
        em.getTransaction().commit();

        //Al terminar la transaccion pasa al estado detached
        System.out.println("contacto = " + contacto);
    }
}
