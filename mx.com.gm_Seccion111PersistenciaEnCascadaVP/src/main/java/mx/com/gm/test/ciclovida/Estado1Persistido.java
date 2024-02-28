package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {

    public static void main(String[] args) {
        //No uso las conexiones de la clase Dao, para ver bien los distintos estados, en una clase aparte
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();

        /*Estados de un objeto: 
        -Transitivo: cuando está en la memoria virtual, pero No en la BBDD
        -Persistido: cuando se está en la transacción para guardarlo (con el commit o el flush), y aún puede ser modificado
        -Detach o 'separado': cuando ya está guardado en la bbdd, y se cerró la transaccion
        
        Tomo la entidad de Contacto, que tiene menos relaciones, por lo tanto es mas simple */
        //1.Estado Transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("11223344");

        //2.Persisto el objeto
        em.getTransaction().begin();

        em.persist(contacto);
        /*Ojo, con este metodo no significa que ya se haya guardado en la BBDD, sino hasta que:
        -se haga commit de la transaccion
        -o, se utilice el metodo flush, para, que antes de salir de la transaccion, sincronice lo que tiene pendiente
        con la BBDD, se guarde la informacion, y se puede continuar con la transaccion
        por ej, para que se genere el ID, y poder obtenerlo, para hacer algo antes de cerrar la transaccion
        contacto.getIdContacto();
        Eso, no funcionaria, salvo hiciera el:
        em.flush(); 
        antes...
         */

        em.getTransaction().commit();

        //3. detached o separado de la bbdd 
        System.out.println("contacto = " + contacto);
        /* una vez que se hace commit de la transaccion, si modifico algo en este estado, salvo abra una nueva
        transaccion, la modificacion no afectara la bbdd
        
        Se podria envolver todo en un try/catch... pero lo voy a dejar asi, para verlo mas simple*/
    }
}
