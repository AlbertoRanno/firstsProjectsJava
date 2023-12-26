package text; //Quise poner "test" - mal tipeado

import dominio.Persona; //lo importo porque esta en otro paquete

public class PersonaPrueba {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Mariana", 9000.00, false);
        //Al ser los atritubtos de la clase, privados, ya no es posible:
        //persona1.nombre = "Mari"; 
        //System.out.println("Nombre: " + persona1.nombre);
        
        //System.out.println("persona1 nombre = " + persona1.getNombre());
        System.out.println(persona1.toString()); // se puede poner (*1) el ".toString()"
        
        persona1.setNombre("Mari");
        //System.out.println("persona1 nombre post cambio = " + persona1.getNombre());
        //System.out.println("sueldo = " + persona1.getSueldo());
        //System.out.println("fue eliminado de la lista? " + persona1.isEliminado());
        System.out.println(persona1); // (*1) u omitirlo, si la clase lo tiene, obviamente 

    }
}
