package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Podria llamar a esta Clase PersonaDTO (Data transfer Object)

//Las anotaciones @Entity, @Id, y demases, son JPA (Java Persistence API)

@Entity //se vincula una clase a una tabla
@Table(name = "persona") //por si el nombre de la clase, difiere del de la tabla
public class Persona implements Serializable { //Para indicar que los objetos de esta clases pueden ser pasados a O y 1

    private static final long serialVersionUID = 1L; //Para que Java no asigne automaticamente. Para manejar versiones

    //Atributos
    @Column(name = "idpersona") //difiere el nombre de columna. Buenas practicas BBDD deberia haber sido id_persona
    @Id //Indico que este atributo va a ser el ID de la BBDD
    private int idPersona;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    //Constructor Vacío, Getters and Setters, y toString
    public Persona() {
    }

    public Persona(int idPersona) {
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
