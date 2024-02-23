/*
Notas al crearlo:
-acordarse de copiar el archivo de configuracion log4j
-copiar el persistence del proyecto 107, sino ojo de no comentarios, y nombre como HibernatePU

Proyecto, creado, con Maven, igual que los anteriores, en lugar de Webservice con Glassfish y JavaEE,
voy a esperar a ver Spring boot que tiene un servidor enbebido

Por lo tanto, no voy a poder mandarlo a un HTML (servlets), ni voy a poder hacer endpoints, ni Postman

La capa de servicios, que sería la clase de ServicioPersonas, incorpora los metodos con los que se podría interacturar
desde un front, pero al no tener un servidor, es mas complicado enrutarlos, y prefiero omitirlo y esperar a Spring.
Por lo tanto, los metodos que alli deje, no estan probados.

Arranco con Asosiaciones. Las que manejan Hibernate y JPA, son las mismas que las de las BBDD relacionales:
- 1 a 1
- 1 a Muchos o Muchos a 1
- Muchos a Muchos (=> mala practica, se usan tablas intermedias)

Ejemplo de Diagrama Entidad Relacion => En esta caso se llamara "SGA" (SIstema de gestion de alumnos)

verlo en MySQL => pero a groso modo:
(todo gira en torno a la tabla de alumno

tabla de domicilio (1 a muchos) => tabla de alumno (muchos a 1) //Ejemplo Hermanos... //id_domicilio en alumno
tabla de contacto (1 a muchos) => tabla de alumno (muchos a 1)  //Ejemplo CElu madre de hermanos //id_contacto en alumno
//Este tipo de relacion, siempre es asi, por los ejemplos, pero los voy a tratar como (1 a 1) en la app (y no en la BBDD)
tabla de alumno (muchos a muchos) => tabla de curso (muchos a muchos) 
Esto se entiende como 2 lineas en las tablas: 
muchos alumnos pueden tomar un curso + muchos cursos pueden ser tomados por un solo alumno

=> se crea tabla transitiva (intermedia) "asignacion" ("se normaliza la relacion")
Entonces: 
alumno (1 a muchos)  => asignacion (muchos a 1) //Asignacion va a vincular los ID de alumno y curso, y ademas tendra el propio
asignacion (muchos a 1) => curso (1 a muchos) //Asignacion suma el atributo turno, por lo que si hace varios cursos, podrian ser
                                                // en diferentes turnos

Nota, en este caso se aprovecha la tabla asignacion, para sumar el atributo de 'turno', podria sumar tambien, tipo_curso

Podria tener tambien una tabla Instructor (1 a muchos) => cursos (muchos a 1)

Orden sugerido para crear las tablas:
(1ero las que no tienen dependencias con las tablas ya creadas)
-domicilio
-contacto
-curso

(2do las que si tienen dependencias con las tablas ya creadas)
-alumno // (*1) con domicilio y contacto. con curso no, porque va la intermedia

-asignacion

=> workbench => nuevo schema => "sga" => aply => close => sga => tables => create table => "domicilio" => "id_domicilio"
=> pk (primary_key) nn (not null) ai (autoincremental) => resto de los atributos, varchar(45) => listo (no lleva indices ni
llaves foraneas porque no tiene relacion)

Notas: 
*los '_' => son buena practica en los nombres de las bbdd
*los nombres de las tablas son en singular (domicilio, contacto, curso, alumno) y minuscula
*precio => doble, para que pueda llevar decimales

*(*1) al llevar el id_contacto y id_domicilio, tengo que marcar que son llaves foraneas (fk) =>
solapa foreign keys => fk_domicilio (Foreign Key Name) => "sga"."domicilio" (Reference Table)
(se vincula con la tabla domicilio del schema "sga") =>
check en id_domicilio (Column) (la columna dentro de la tabla alumno ) => id_domicilio (Reference Column)
(la columna a la que hace referencia, y que se encuentra dentro de la tabla domicilio)

Luego, agrego la fk_contacto => y aplico. Luego creo la tabla intermedia con sus fk (curso y alumno), igual que recien.

EN este punto ya puedo agregar registros en cada una de las tablas
LLegado el caso de alumno, por ej, hardcodeo los nros de id de contacto y domicilio, para vincularlos
(Notar que si pongo un nro de id_contacto que no existe, dado que ya estan vinculados, dara error)
Nota que la tabla de asignacion la necesito cargar a lo ultimo, porque voy a necesitar de tener guardados
los registros, para que se generen los ids, que voy a vincular

Para ver las tablas relacionadas => Home => Database => REverse Engineer => Next... "sga" => Next... Close


 */
