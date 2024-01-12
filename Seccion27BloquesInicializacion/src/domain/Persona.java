package domain;

public class Persona {

    /*Lo siguiente es real, pero no es lo mas usado. Lo mas usado es inicializar los atributos en el constructor,
    pero tenerlo en cuenta por si lo ves en algun proyecto.
    
    Antes del constructor, se inicializan dos bloques, el primero, Estático, y el segundo No Estático (o Dinámico).
    El static, se inicializa solo la primera vez que se llama a la clase,
    Mientras que el no static, se inicializa cada vez que se itera la clase (se crea un objeto)
    
    Ejemplo:*/
    private final int idPersona;
    private static int contadorPersonas;

    static {
        System.out.println("Ejecucion bloque estatico");
        ++Persona.contadorPersonas;
        //dentro de los bloques estaticos, no tengo acceso a "this". Por eso lo llamo por la clase.
        //No puedo inicializar el idPersona, porque es NO estatico        
    }

    //No static:
    {
        System.out.println("Ejecucion bloque NO estatico");
        this.idPersona = Persona.contadorPersonas++; //Notar el post aumento, a diferencia del pre aumento en static
        //Esto se entiende asi: static, se inicializa solo una vez, y cambia el valor del contador, de 0 a 1
        //No static, despues de que lo asigna al primer objeto, con ese valor 1, lo va a volver a aumentar
        //Motivo por el que los siguientes objetos tendran los IDs consecutivos
    }

    //Constructor:
    public Persona() {
        System.out.println("Ejecucion del constructor");
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + '}';
    }

}
