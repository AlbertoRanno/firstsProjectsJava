package paquete1;

public class TestModificadoresAccesoD {

    public static void main(String[] args) {
        
        /*Hice una copia de test a este paquete, para hacer las pruebas de la clase default:*/
        Clase1D clase1D1 = new Clase1D(); //accedo al constructor default de Clase1D
        clase1D1.atributoDefault = "Cambio desde la prueba";
        System.out.println("atributo default de clase1D1 = " + clase1D1.atributoDefault);
        clase1D1.metodoDefault();
        
        System.out.println("");
        System.out.println("Pruebo la clase privada:");
        Clase1Private clase1Private1 = new Clase1Private("Publico"); //uso constructor publico
        System.out.println("clase1Private1 = " + clase1Private1);
        //Notar que primero llama al privado y despues al publico - Logico, primero el this(), luego el sout
        System.out.println("clase1Private1 atributo privado = " + clase1Private1.getAtributoPrivado());
        clase1Private1.setAtributoPrivado("Cambio el atributo privado mediante el set");
        System.out.println("clase1Private1 atributo privado = " + clase1Private1.getAtributoPrivado());
        
        
      
    }
}
