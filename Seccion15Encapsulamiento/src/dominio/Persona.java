package dominio;
//nombre del paquete con minuscula - suele recibir el nombre "dominio", si va a guardar atributos privados

public class Persona { //Lo comun de cada clase es: atributos, constructores, metodos set y get de cada atributo
    //y el metodo toString, para imprimir el estado del objeto en cualquier momento

    //Atributos
    private String nombre;
    private double sueldo;
    private boolean eliminado;

    //Constructor con argumentos (deja de existir el vacio)
    public Persona(String nombre, double sueldo, boolean eliminado) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isEliminado() {
        /*OBS! Con los booleans es "isNombre" porque es como pregunta...*/
        return this.eliminado;
    }

    public void isEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String toString() {
        return "Persona [nombre: " + this.nombre + ", sueldo: " + this.sueldo
                + ", eliminado: " + this.eliminado + "]";
    }
}
