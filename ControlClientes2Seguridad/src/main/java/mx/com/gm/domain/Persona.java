package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

/* Gracias a lombok, con la notacion Data, solo debo poner los atributos de la clase de Entidad, y este se encargara
de completar el resto del codigo para transforma la clase en un javabean. Es decir, el constructor vacio, los getters
and setters, los equals y hashcode y el metodo toString. Esto lo debería de poder apreciar en la ventana de abajo a la 
izquierda. Y era lo que no funcionaba con la configuracion de Ubuntu*/
@Data
/*La convierto en clase de entidad, porque va a representar a una tabla de la bbdd*/
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    
    private static final long serialVersionU1D = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;
    
    /*Las validaciones de formulario requieren de anotaciones en los atributos, y de la siguiente dependencia en el POM:
        <dependency>
            <groupId>javax.validation</groupId>
            <artifactId>validation-api</artifactId>
            <version>2.0.1.Final</version>
        </dependency>
    Se usa el @NotEmpty y no el NotNull, porque el último, chequea que no sea nulo, pero admite cadenas vacias, y el primero No.
    Hay distintas validaciones, y luego los msjs se podran cambiar desde un archivo de properties (cuando lo arme para cambiar
    de idioma la app.
    Recordar que tambien estan las validaciones del html (input tipo mail por ej), las cuales puedo omitir pasando a text, y mandando
    un mensaje propio. 
    
    Luego hay que modificar la vista, agregar los Span con los msjs...
    */
    
    
    @NotEmpty(message = "El nombre es requerido")
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email    
    private String email;
    
    //@NotEmpty - lo dejo para que sea posible no guardar ninguno
    private String telefono;
}
