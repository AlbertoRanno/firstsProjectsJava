/*SEGURIDAD:
1-Agrego la dependencia de seguridad: POM => insert code => Spring Boot dependencies => Spring Security
Se agrega:
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
La agrega al final, pero la muevo luego de Data JPA
Cierro todo lo que este corriendo, clean and build, ver consola por el password:
"
Using generated security password: 1598f9a4-b984-4e0a-b5c0-1d493f58057a

This generated password is for development use only. Your security configuration must be updated before running your application in production.
"
Genera ese password, y el nombre del usuario es: user

Al agregar esa dependencia, y querer entrar ahora al local host, ya tiene seguridad, pide el usuario, y contraseña.
Lo cual es merito de Spring Boot










Arquitectura hasta el momento:

***Capa de Presentacion: aplico patrón MVC utilizando Spring
-Modelo: la clase de Persona

-Vista mediante Thymeleaf levanto un html

-Controlador

***Capa de Negocio: (no aun... por lo pronto la puenteo)

***Capa de Datos
-JPA (interface) con Hibernate (implementacion) a MySQL (bbdd)
Tengo la clase de entidad "Persona"

----
Para conectar la vista a la bbdd, utilizo lo que se llaman "repositorios de spring"
Antes se usaba la notacion de Repository, pero era bastante repetitivo, y se mejoro..
Creo la clase, en realidad INTERFACE, de tipo DAO, para la conexion, y sigo ahi... IPersonaDao

...Retomo, luego de lograr levantar las personas desde la bbdd y enviarla indo al html...

El paquete principal, es el que contiene la clase para correr la app,
El resto deben ser subpaquetes de este (notar que queda primero, porque el resto son del estilo .dao, .domain, .web...

Duda, en la clase, el idPersona es del tipo Long, y en la bbdd es del tipo Integer, y aún así funciona.. (supongo
que al generar el id la tabla, que la clase, tenga más capacidad, no seria un problema, pero tampoco suma... o si?
porque asi lo manejan en el tutorial, sin explicarlo)

Resumen del proyecto:
-Agregar las dependencias de: el driver de Mysql, y la de data jpa

-Luego agregue en el properties, la conexion a la base de datos
-Ahi tambien configure que se muestre el SQL en el log

-Modifique la clase, a entidad, con sus anotaciones

-Cree la interface IPersonaDao, y la extendí de CrudRepository, para poder tener acceso a los metodos que allí vienen
(se pueden agregar mas metodos a mi eleccion en el cuerpo de la interface)

-Inyecto la interface Dao en el controlador, gracias a @Autowired. Y con ese objeto ya inyecto, traje a las personas.
-Y desde el controlador, mando el listado al html

-en el html, se visualizacian gracias a thymeleaf

-Siguiente paso, crear la capa de datos, donde se tiene que manejar el concepto transaccional, con Spring 

-Listo todas las capas logicas:
CapaDatos: JPA - Hibernate (interfaz Dao)
CapaNegocio: Interfaz e implementacion, con notacion @Service
CapaPresentacion: MVC - Thymeleaf - Controlador

-Agrego las Operaciondes del CRUD:
AGREGAR: creo link en el index a una nueva pagina, y creo
el path, en el controlador, por get, para que levante la nueva pagina.
Y posteriormente el path, por POST, para que grabe en la BBDD


*/
