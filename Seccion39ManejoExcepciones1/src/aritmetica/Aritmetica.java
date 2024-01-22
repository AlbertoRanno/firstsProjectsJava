package aritmetica;

import excepciones.*;

public class Aritmetica {

    /*Si bien se que el compilador va a arrojar una excepcion, mediante un condicional, creo la mia: 
    
    Version Excepcion:*/
    public static int division(int numerador, int denominador) throws OperacionExcepcion { //posiblemente arroje una excepcion
        if (denominador == 0) {
            throw new OperacionExcepcion("Mensaje de Error - Version Excepcion");
        }
        return numerador / denominador;
    }

    //Version RuntimeException:
    public static int divisionRuntime(int numerador, int denominador) { //se omite el throws...
        if (denominador == 0) {
            throw new OperacionRuntimeException("Mensaje de Error - Version RuntimeException");
        }
        return numerador / denominador;
    }
}
