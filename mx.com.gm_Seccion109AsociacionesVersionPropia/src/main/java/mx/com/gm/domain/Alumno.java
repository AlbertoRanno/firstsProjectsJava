package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

//Primero defino la clase, y luego sus relaciones, con otras tablas ya creadas)
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private int idAlumno;

    private String nombre;
    private String apellido;

    /*Aca empiezan las relaciones. 
    Del diagrama veo, que la recion de alumno a domicilio es de muchos a 1 (EJ Hemanos).
    Idem a contacto.
    
    Ojo con los atributos... NO SON DEL TIPO int, sino del tipo de la clase ya!
    private int idDomicilio;
    private int idContacto;
    y Ojo que es del tipo Domicilio, y se llama domiciolio, y no idDomicilio
    
    e indico el tipo de relacion:   
    
    tambien, aunque si son iguales, no haria falta (en este caso, ambas= id_domicilio => no haria falta...)
    es indicar el nombre de todas las columnas con las que se relacionan estas tablas.
    Con la forma: @JoinColumn(name="id_domicilio" (nombre EN LA ENTIDAD ALUMNO) , referencedColumnName = "id_domicilio"
    (nombre en la tabla a la que se referencia, en este caso, domicilio)    */
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne
    private Domicilio domicilio;

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto contacto;

    /*Ahora completar los getters and setters que faltaban, y el toString => COnviene todo post asociaciones
    
    Va a faltar la lista de asignaciones... pero primero hay que hacer la clase asignaciones    
    
    Luego de hacer la clase, OJO que NO va a ser: 
    
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @OneToMany
    private Asignacion asignacion;
    
    Dado que va a ser una lista! y no un solo valor! 
    Y dado que No va vincular 'id_alumno', sino el atributo 'alumno'
    
    y Ojo que si se usa el mappedBy, no se usa el JoinCOlumn!
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    */
    
    @OneToMany(mappedBy = "alumno")
    private List<Asignacion> asignaciones;

    /*La relacion esta mapeada por el atributo alumno
    Notar que es un mapeo bidireccional, dado que aca tengo esta relacion aca, y en Asignacion,
    tengo la relacion: 
    
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne
    private Alumno alumno;
    
    es decir, desde ambos lados, se puede reconstruir la relacion   */

 /* Agrego el get y set de asignaciones, pero ojo con el toString, que en las relaciones OneToMany, es una lista
    y no un simple valor! => se recomienda no ponerlas en el toString, sino seria demasiado engorroso*/
    public Alumno() {
    }

    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", contacto=" + contacto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return this.idAlumno == other.idAlumno;
    }

}
