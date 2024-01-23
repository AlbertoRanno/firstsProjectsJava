package test;

import aritmetica.Aritmetica;
import excepciones.OperacionExcepcion;
// import static aritmetica.Aritmetica.division;

public class TestExepciones {

    public static void main(String[] args) {
        //        int resultado = 10/0;
        //        System.out.println("resultado = " + resultado);
        /*
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	at test.TestExepciones.main(TestExepciones.java:5)
        Esto corta la ejecucion del programa de manera abrupta y msj en consola en rojo, no amigable.
        
        -------------------------
        
        Lo evito de la siguiente manera:   

        defino la variable fuera del bloque del error, ya que la voy a volver a usar posteriormente:        */
        int resultado = 0; // (Si el try/catch da error, se alerta, y se retoma el codigo desde este valor)
        //y envuelvo la expresion en un try/catch
        //        try {
        //            resultado = 10 / 0;
        //        } catch (Exception e) { //'e' es el nombre de la variable, que almacena la excepcion, que se genera en esa linea
        //        }
        //        
        /* Si ejecuto ahora, no da error, porque lo que hace es omitir la division, y devuelve el valor por default de resultado
        
        -------------------------

        Los errores se pueden dar en cadena, y con esto, imprimo toda la pila:  */
//        try {
//            resultado = 10 / 0;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//            // e.printStackTrace(); funciona igual, pero el IDE recomienda aclarar la salida a consola
//            //También puedo hardcodear el msj de error:
//            System.out.println("Ocurrió un error al dividir por cero");
//        }
//        System.out.println("resultado = " + resultado);
//    }

        /*La Clase padre de las exepciones es 'Exception' (try catch obligarorio).
    Las clases hijas pueden ser RuntimeException (try catch no obligatorio), SQLException, o NullPointerException
    En el caso 1, la clase era de runtime... (Exception in thread "main" java.lang.ArithmeticException: / by zero), por lo que 
    podria omitir el try catch, y no habria problema en el IDE, pero si en tiempo de ejecucion (por eso el nombre runtime...)
    
    Lo mismo podria darse en caso de una variable que no este apuntando a ningun objeto, es decir, que tenga asignado el valor 
    de null. Lo mismo, el compilador ni se entera del error, hasta que se ejecuta el programa
    
    -------------------------------
    Cree mi propia clase de Excepciones, en el paquete excepciones, y la clase aritmetica, para configurar cuando arroja
    el error. En este caso, cosidere que la clase OperacionException extiende de Exception (try catch obligatorio):
         */
//        try {
//            //o resultado = division(10, 0); si importo como: import static aritmetica.Aritmetica.division;
//            resultado = Aritmetica.division(10, 0);
//            /*Al definir en Aritmetica, el metodo
//           division, con un condicional de cuando arrojar el error, puedo hacer que se envie directamente 
//            el mismo, evitando todos los demas: (*1)    */
//
//        } catch (Exception e) {
////            e.printStackTrace(System.out);////            
////            System.out.println("Ocurrió un error al dividir por cero");
//            System.out.println(e.getMessage()); //COn esto llamo al msj de mi error (*1)
//        }
//        System.out.println("resultado = " + resultado);
        /*--------------------
        Version con RuntimeException:
        no hace falta try catch:    */
//        resultado = Aritmetica.divisionRuntime(10, 0);
//
//        System.out.println("resultado = " + resultado);
        /*--------------------
        
        Que version usar? antiguamente Exception... pero actualmente, se utiliza Exception solo para algunos 
        caso puntuales, y el resto con Runtime, dado que permite un codigo mucho mas limpio*/
 /*--------------------
        
        Version completa: a try catch, se le puede agregar un bloque FInally, el cual siempre se va a ejecutar.
        Sirve entre otras cosas para cerrar recursos, ej, las conexiones con las BBDD, o si se ha abierto un archivo*/
        try {

            resultado = Aritmetica.division(10, 0);
            //Tambien notar que esta expresion podria arrojar una o mas excepciones, por lo que se podrian
            //poner mas bloques catch. Pero se recomiendo 1ro procesar las de menor jerarquia:
        } catch (OperacionExcepcion e) {
            System.out.println("Ocurrió un error de tipo OperacionExcepcion");
            System.out.println(e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Ocurrió un error de tipo Exception"); //ClasePadre Exception, por ende, mayor jerarquia
            System.out.println(e.getMessage());

        } finally {
            System.out.println("Mensaje de error del finally");
        }
        System.out.println("resultado = " + resultado);

    }
}
