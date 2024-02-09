package test;

import java.util.*;
import javax.persistence.*;
import mx.com.gm.domain.Persona;

public class HolaMundoHibernate {

    public static void main(String[] args) {
        //Ejecuto un Query de hql (Hibernate Query Language), que seria la variante de SQL en Hibernate para ejecutar queries
        String hql = "SELECT p FROM Persona p";
        /*Donde:
                -'p' es el nombre del alias de la clase java
                -Persona es el nombre de la clase entidad, y no de la tabla*/

        /*Ahora uso las clases correspondientes, que ya agregue en la configuracion, para conectarme a la BBDD
        de persistence: <persistence-unit name="HibernateEjemplo1" transaction-type="RESOURCE_LOCAL">:          */
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        EntityManager entityManager = fabrica.createEntityManager();
        
        /*Se usan EntityManagerFactory y EntityManager, para poder crear una instancia, y conectarse a la BBDD
        y posteriormente, con el OBjeto entityManager, ejecuto la consulta*/

        Query query = entityManager.createQuery(hql);//Esto regresa una lista de objetos del tipo Persona
        //Los recupero en una lista
        List<Persona> personas = query.getResultList();
        for (Persona p : personas) {
            System.out.println("Persona = " + p);
        }
        
        /* "Falta agregar el archivo de log4j para poder ver la info en la consola"... sin embargo, lo corri, y la veo...
        se referira a la consola del navegador o cambio por las versiones?
        ... siguiendo el tuto, dentro de src/main/resources, creo un archivo xml 'log4j2'
        solo dejo la linea: <?xml version="1.0" encoding="UTF-8"?>
        y agrego la configuracion:
        <Configuration status="INFO">
            <Appenders>
                <Console name="Console" target="SYSTEM_OUT">
                    <PatternLayout pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} - %msg%n" />
                </Console>
            </Appenders>
            <Loggers>
                <Logger name="org.hibernate.SQL" level="debug" additivity="false">
                    <AppenderRef ref="Console"/>
                </Logger>
                <Logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="trace" additivity="false">
                    <AppenderRef ref="Console"/>
                </Logger>
                <Root level="info">
                    <AppenderRef ref="Console"/>
                </Root>
            </Loggers>
        </Configuration>
        
        Con esto queda configurado log4j, y toda la app lista => vuelvo a hacer un clean and build de la app
        Para tener la ultima version de cada uno de los archivos creados
        
        */
    }
}
