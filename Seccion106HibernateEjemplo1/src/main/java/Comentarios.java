public class Comentarios {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
/*SECCION 106 - HIBERNATE FRAMEWORK (Clase 406) - Saltee:
Servlets y JSPs -> Capa de Presentación
JavaServer Faces -> Capa de Presentación
Java Empresarial (Java EE) -> No entendí nada.
Enterprise Java Beans (EJB's) -> Lo daban de la mano con Java EE
Struts -> Capa de Presentación

Hibernate ->

Notas:

    **JDBC (Java Database Connectivity):
JDBC es una API de Java que permite a los desarrolladores interactuar con bases de datos relacionales.
Con JDBC, necesitas escribir mucho código manualmente para establecer conexiones con la base de datos,
enviar consultas SQL y procesar los resultados.
Por ejemplo, para realizar consultas a una base de datos, debes abrir una conexión, crear un statement,
ejecutar la consulta, procesar los resultados y cerrar la conexión manualmente.

    **ORM (Object-Relational Mapping):
Es una técnica de programación que nos permite mapear objetos de un lenguaje de programación, como Java,
a tablas de una base de datos relacional, como MySQL o PostgreSQL, y viceversa.
-Donde "mapear" en el contexto de un ORM, significa establecer una relación entre las clases de objetos
en tu aplicación y las tablas en una base de datos relacional, de modo que puedan intercambiar información
de manera transparente y eficiente.
-Objeto: En programación, un objeto es una instancia de una clase que tiene atributos y métodos.
-Relacional: Se refiere a las bases de datos relacionales, donde la información se organiza en tablas 
que tienen filas y columnas.
El objetivo principal de un ORM es eliminar la brecha entre el modelo de datos en la base de datos relacional
y el modelo de objetos en la aplicación. Esto significa que en lugar de tener que escribir código manualmente
para convertir los objetos de la aplicación en filas de la base de datos y viceversa (como se haría con JDBC),
el ORM se encarga de esta conversión de manera automática.
Por ejemplo, si tienes una clase Usuario en Java y una tabla usuarios en tu base de datos con las mismas columnas,
el ORM se encargará de mapear los objetos de la clase Usuario a filas en la tabla usuarios y viceversa. 
Esto significa definir cómo se almacenarán estos objetos en la base de datos relacional.
Esta definición de cómo se mapean los objetos a las tablas se realiza típicamente mediante anotaciones en las clases
Java o mediante archivos de configuración XML. El ORM utiliza esta información de mapeo para traducir las operaciones
realizadas en los objetos de la aplicación (como crear, leer, actualizar y eliminar) en consultas SQL que manipulan
los datos en la base de datos relacional, y viceversa.

**Hibernate:
Hibernate es un framework de mapeo objeto-relacional (ORM) para Java.
Simplifica el desarrollo de aplicaciones que interactúan con bases de datos relacionales al mapear las
clases Java a tablas de base de datos y viceversa.
Hibernate maneja automáticamente la creación y ejecución de consultas SQL, lo que elimina la necesidad
de escribir código JDBC manualmente.
Además, proporciona funcionalidades adicionales como caché de consultas, administración de transacciones
y manejo de relaciones entre objetos.

**JPA (Java Persistence API):
JPA es una especificación estándar de Java para el mapeo objeto-relacional.
Define una INTERFAZ común para trabajar con ORM en Java, lo que permite a los desarrolladores escribir 
código independiente del proveedor específico de ORM.
Hibernate IMPLEMENTA JPA, lo que significa que puedes utilizar las anotaciones y métodos definidos por
JPA para mapear tus clases Java a tablas de base de datos y viceversa.
Esto hace que tu código sea más portátil, ya que puedes cambiar el proveedor de ORM sin tener que 
reescribir todo el código.

**En resumen,
mientras que JDBC te obliga a escribir mucho código manualmente para interactuar con la base de datos,
Hibernate simplifica este proceso al proporcionar una capa de abstracción que maneja automáticamente 
las operaciones de base de datos. JPA, por su parte, define un estándar para el desarrollo de aplicaciones
ORM en Java, permitiendo la portabilidad del código entre diferentes proveedores de ORM.

1er PASO
New Proyect, con Maven, que permite administrar las dependencias. Voy al pom, y debajo de </properties>
agrego:
    <dependencies>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.4.28.Final</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.13.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.13.3</version>
        </dependency>
    </dependencies>

Luego Clean and Build para que descargue las librerias
Obs! Ojo con la version de Java, tuve que pasar de 17 a 11, porque me daba error 

EL 2DO Paso => Crear el archivo de Persistence.xml, esto porque voy a estar usando
Hibernate con JPA (Java Persisntant API)

En la raiz del proyecto 'Seccion106HibernateEjemplo1' => New => Other => Filtro por XML => xml document
nombre => persistence => browse => src/main => creo las carpetas => src/main/resources/META-INF
Y quedaria => src/main/resources/META-INF/persistence.xml

Se abre, y borro todo, salvo la 1er linea: <?xml version="1.0" encoding="UTF-8"?>
Y debajo configuro el archivo con:

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2" xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence 
    http://xmlns.jcp.org/xml/ns/persistence_2_2.xsd">

    <persistence-unit name="HibernateEjemplo1" transaction-type="RESOURCE_LOCAL">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>mx.com.gm.domain.Persona</class> //(*1)
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/test?useSSL=true&amp;useTimezone=true&amp;serverTimezone=UTC"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="Halgren27!"/>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
        </properties>
    </persistence-unit>
</persistence> 

3er PASO => Crear la clase de Entidad Persona
Ojo al crearla, poner en el paquete, el mismo que puse en la configuracion! //(*1)
Package: mx.com.gm.domain

Operaciones Básicas - Leer, Insertar, Modificar, Eliminar de una tabla de una BBDD


*/