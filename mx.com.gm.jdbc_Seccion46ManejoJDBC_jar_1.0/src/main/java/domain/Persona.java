/* Clases de domain o entidad (porque tienen una representacion en la BBDD)
Un objeto de tipo persona, representa un registro en la tabla de BBDD
En esta clase voy a representar las columnas de la tabla persona (version generica del codigo en TestMyqlJDBC)
Obs! la tabla del ejercicio original era id_Persona... la cual yo escribi como idpersona (por error, omiti la P)
pero en Java NO se usan "_"...
Cada columna sera un atributo de la clase, ojo con la sintaxis
Esta clase se vinculara con la clase que voy a crear para los INSERT / SELECT / UPDATE / DELETE
a esa clase se la conoce como !  DAO - Data Access Object / Es un patron de diseño => la clase sera PersonaDAO
*/
package domain;

public class Persona {

    private int idPersona; //lo mapeo con la columna de la BBDD llamada (idpersona o id_persona)
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
    /*  Constructores (depende lo que necesite... Por eso tiene sentido la sobrecarga de constructores
    por ej, para eliminar, podria hacer un constructor con idPersona, dado que es lo unico que necesito...
    otro ej. para insertar un registro, no necesito aclarar el id, dado que es autoincrementable
    otro ej. modificar un registro => indicar el id y cada uno de los atributos*/

    public Persona() {
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
    
    /*Si por alguna razón se necesita modificar algún atributo de manera individual, cargo los get and sets*/

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
    
    //Para mandar imprimir el estado del objeto en cualquier momento

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }
    

}
