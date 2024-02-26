/*
De nuevo, en el curso hicieron proyecto web con Glassfich y JavaEE, y yo hice uno SIN servidor ni capa web

Igualmente trataré de aplicar lo suficiente para configurar las asociaciones de manera local

A diferencia con el proyecto anterior, en Persistence, voy a cambiar:

*las clases, de:
<class>mx.com.gm.domain.Persona</class>

a:
<class>mx.com.gm.domain.Domicilio</class>
<class>mx.com.gm.domain.Contacto</class>
<class>mx.com.gm.domain.Curso</class>
<class>mx.com.gm.domain.Alumno</class>
<class>mx.com.gm.domain.Asignacion</class>

*en la URL, en lugar de conectarme a la BBDD de 'test', me voy a conectar a la de 'sga':
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/test?useSSL=true&amp;useTimezone=true&amp;serverTimezone=UTC"/>

pasa a:
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/sga?useSSL=true&amp;useTimezone=true&amp;serverTimezone=UTC"/>

y con eso queda actualizado Persistence, la config de log4j permanece igual

Creo todas las clases necesarias dentro de domain (una por tabla dentro del schema de la bbdd)
En el mismo orden que en la bbdd, primero las que no tienen relaciones con las clases creadas hasta el momento
Domicilio, Contacto, Curso => Luego las que si las tienen => ALumno => relaciono con Domicilio y Contacto
Por ultimo, la de transicion => Idem que en alumno, relaciono con ALumno y Curso
Finalmente, agrego las contracaras de estas relaciones con la tabla de transicion, desde alumno a asignacion
y desde curso a asignacion
En ambos casos, seran relaciones de OneToMany, y ojo, porque estas no van a devolver un simple atributo, sino una lista
Como tal, prestar atencion a los detalles, y si bien se agregan el set y get, no se agrega la lista al toString, porque
podria ser demasiado pesado

Leer Domicilio, que ahi aclaro unos detalles importantes
IDEM en alumno y asignacion

Entonces, primero, las configs, pom, persistence, log4j, clean and build. Segundo, las clases de domain, que son
las que tienen que estar en el persistence. 3ero, una clase Dao por cada clase de Entity, de modo que maneje sus
conexiones => Pero, para evitar la repeticion de:

    private EntityManagerFactory emf;
    private EntityManager em;

    public CursoDao() {
        this.emf = Persistence.createEntityManagerFactory("HibernatePU");
        this.em = emf.createEntityManager();
    }

en cada una de las clasesDao, se hace una clase abstracta (para que no se puedan crear objetos directos de ella) padre,
y el resto de las clases heredaran estas conexiones, y cada una tendra sus propios metodos (los cuales suelen ser parecidos,
por lo que se suele copiar y pegar, y refactorizar los nombres dentro)

*/
