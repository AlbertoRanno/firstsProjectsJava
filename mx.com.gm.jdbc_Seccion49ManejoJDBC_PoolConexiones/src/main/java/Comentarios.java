/*
POOL DE CONEXIONES - Con el Api de JDBC

Hasta el momento tenia una conexion individual a la BBDD
Para la cual utilizaba la clase DriverManager, y el metodo getConnection

Sin embargo para una app empresarial, se requien muchas conexiones
Y cada conexion, tiene un alto costo en recursos del sistema
Por lo que es conveniente es utilizar un Pool de conexiones

Este, permite, generar una conexion, por cada clase Java que necesite de una.
Es decir, tiene listas varias conexiones a la BBDD.
De manera que vuelve eficiente el proceso de obtener y liberar una conexion.
Dado que el proceso de administracion de cada conexion se delega al pool,
es decir, me despreocupo de abrir y cerrar una conexion, ya que será el pool quien se encargue

UN pool de conexiones se puede crear:
-mediante codigo propio (pero hay que mantenerlo...y si no lo manejo bien, se consumen muchos recursos, se omite)
-utilizar el proyecto de JDBC de Apache (el que usaré ahora...)
-otra es apoyarse del servidor de aplicaciones Java, como TomCat, Glassfish, JBoss, etc (veré más adelante)

Para este caso utilizo una dependencia de APache COmmons (un conjunto de librerias muy utilizadas en los proyectos)
Para esto, agrego otra dependencia al POM, dentro de <dependencies>:
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-dbcp2</artifactId>
            <version>2.7.0</version>
        </dependency>
Luego clean and build => BUild Success, ya puedo utilizar la clase para crear un pool de conexiones
Voy al paquete de datos, Conexion... y en lugar de usar la clase DriverManager, creo un metodo mas.. lo sigo alli...
 */

