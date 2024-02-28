package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();

        /*Para recuperar el objeto, solo tengo que leer (listar), no estoy introduciendo cambios en la bbdd,
        por lo que no seria necesario abrir una transaccion*/
        //defino la variable donde voy a guardar al objeto que recupero
//        Contacto contacto = null;
//
//        //Recupero un objeto de la base de datos
//        contacto = em.find(Contacto.class, 3);
//        
//        //una vez que lo recupero, estoy separado de la bbdd
//        System.out.println("contacto = " + contacto);

        /*Como puedo ver, lo recupero, sin iniciar una transaccion, pero si lo quisiera recuperar dentro de una, 
        tambien podria: */
        Contacto contacto = null;

        em.getTransaction().begin();
        contacto = em.find(Contacto.class, 3);
        /*La unica diferencia, es que el objeto aqui, estaria en estado persistente, por lo que cualquier
        modificacion que le haga, se guardaria en la bbdd*/
        
        em.getTransaction().commit();

        System.out.println("contacto = " + contacto);
    }
}
