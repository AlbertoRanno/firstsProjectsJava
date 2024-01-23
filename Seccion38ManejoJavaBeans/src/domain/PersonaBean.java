package domain;

import java.io.Serializable;

public class PersonaBean implements Serializable {

    /*Para que una clase sea considera un JAVABEAN debe cumplir una serie de requisitos.
    De cumplirlos, lo será, y como tal, podrá ser utilizada por java Enterprise, HIbernate, Spring...
    Con escribir 'implements Serializable' luego del nombre de la clase, se importa la clase Serializable del paquete de java.io
    Esta lo que permite, y para lo que sirve en si, es, considerar toda la clase con sus atributos, y metodos
    y convertirla en Beans (al lenguaje binario, es decir, unos y ceros). Esto le permite a la red, compartir
    esta clase con otros equipos, y le permite a los frameworks nombrados, realizar tareas de la misma indole.
    Serializacion (pasar a 0 y 1), Desserializacion ( tomar los 0 y 1 y volver a armar la clase)
    
    El resto de los requisitos:
    *es que sus atributos sean privados
    *Tengo un constructor publico vacio, de modo que los frameworks puedan utilizarlo despreocupandose de sus atributos,
    y lo hagan de forma generica. Esto no quita, que puede tener tambien, otros constructores para inicializarlos
    *TEngan los metodos get y set de sus atributos, de manera de poder usarlos en conjunto con el constructor vacio
    para inicializar los atributos (recordar que tildar el checkbox de encapsulate, lo que hace es pasar los 
    atributos a privado - si no era privado, lo convierte a privado... si lo estaban, no cambian nada)
    Los get y set, deben ser publicos
    Los metodos toString, hashCode y equals, complementarian la clase, pero ya no son necesarios para un javabean
     */
    private String nombre;
    private String apellido;

    public PersonaBean() {
    }

    public PersonaBean(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return "PersonaBean{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}
