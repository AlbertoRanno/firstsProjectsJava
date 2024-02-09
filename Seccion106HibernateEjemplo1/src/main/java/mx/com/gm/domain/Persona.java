package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;

/*Esta es la clase de Entidad que se va a conectar a la tabla persona de la BBDD
Para convertirla a clase de Entidad uso el @Entity (javax.persistence)
Al marcar una clase con @Entity, se indica a JPA que esta clase debe ser mapeada a una tabla en la base de datos.
JPA utiliza el nombre de la clase como el nombre de la tabla por defecto, a menos que especifique un nombre de tabla
diferente mediante la anotación @Table => no suele haber problemas con en el tema de mayusculas y minusculas, pero,
si no la encuentra, o fuera que la clase y tabla tienen por X motivo, nombres distintos => @Table(name="nombre_tabla").
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    /*En el contexto de JPA (Java Persistence API), la implementación de la interfaz Serializable en una clase de entidad,
    como Persona, se utiliza para indicar que los objetos de esta clase pueden ser serializados y deserializados,
    lo que es necesario en ciertos casos, como el almacenamiento en caché, la replicación de datos (transferirlos entre
    diferentes nodos del sistema) o la transferencia de objetos a través de la red ( Si estoy construyendo una aplicación
    distribuida o cliente-servidor, puede ser necesario enviar objetos de entidad a través de la red, y la serialización
    es una forma común de lograr esto).*/

    private static final long serialVersionUID = 1L;
    /*define un campo estático en la clase Persona. Este campo se utiliza para controlar la versión de la clase durante
    la serialización y deserialización de objetos.
    Cuando una clase implementa la interfaz Serializable, Java asigna automáticamente un número de versión a esa clase.
    Este número de versión se utiliza para identificar la versión de la clase cuando se serializa un objeto y se almacena
    en un archivo o se envía a través de la red. Luego, cuando se deserializa el objeto, Java verifica si la versión de
    la clase actual coincide con la versión almacenada en el objeto serializado. Si las versiones no coinciden,
    se lanza una excepción InvalidClassException.
    El campo serialVersionUID permite especificar explícitamente el número de versión de la clase. Esto es útil en 
    situaciones en las que se necesita controlar manualmente la versión de la clase para garantizar la compatibilidad
    entre diferentes versiones de la aplicación. Al especificar un valor para serialVersionUID, puedo evitar que Java
    genere automáticamente un número de versión y asegurarte de que se utilice un valor específico en su lugar.
    El valor 1L asignado a serialVersionUID es simplemente un número de versión arbitrario. 
    Puedo elegir cualquier valor que desee, pero es común comenzar con 1L y aumentar el número si se realizan
    cambios significativos en la estructura de la clase que puedan afectar la serialización y deserialización de objetos.*/

    @Column(name = "idpersona") //El nombre exacto de la columna
    @Id //Para aclarar que va a ser el ID de la tabla de datos
    private int idPersona;

    //Si el nombre de los atributos, coincide con el nombre de las columnas, el @Column, no es necesario
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    //Constructor Vacío, Getters and Setters, y toString => Con esto termino la clase de entidad y creo la clase de prueba
    public Persona() {
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }

    
}
