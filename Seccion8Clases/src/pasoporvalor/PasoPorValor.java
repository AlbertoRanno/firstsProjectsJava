package pasoporvalor;

public class PasoPorValor {

    public static void main(String[] args) {
        /*Seccion 12 - Creo esta clase y paquete 
        
         */
        var x = 10;
        System.out.println("x = " + x);

        cambioValor(x); //(*)

        System.out.println("x nuevo valor ? = " + x); //luego de teoricamente haberle cambiado el valor en (*)
        /*Esto imprime 10... osea que NO lo cambia!*/
        
        /*Luego de haber creado el cambioValor1:
        Le deberia de reasignar a x, el valor que trae este metodo: */
        
        x = cambioValor1(x);
        
        System.out.println("x ahora si, nuevo valor ! = " + x);
        
    }

    public static void cambioValor(int arg1) {
        /*static, para que lo consume el main que es static - void xq no regresa nada
    como argumentos, el paso por valor aplica a los tipos primitivos (INT - LONG - DOUBLE - ...) 
    se espera comprobar, que los metodos primitivos, solo pasan una copia de su valor a los demas metodos*/

        System.out.println("arg1 = " + arg1); // compruebo que se envia el valor de 10, del metodo main

        arg1 = 15; // acá le cambio el valor... (*)

        /* Resumen, al llamar al metodo cambioValor(x); en la linea 12, le estoy pasando una COPIA del valor de X
        al nuevo metodo. Este toma el valor como el de arg1, y procede con el mismo, hasta que se lo cambia con 
        arg1 = 15, pero, al seguir con la ejecucion, cosa que puedo ver bien paso a paso con un debug sobre la linea
        de cambioValor(x); y sus f8-f7, al seguir la ejecucion, vuelve al metodo main, por lo que dejo de ver arg1,
        y su valor, y vuelvo a ver x, con su valor de 10, esto es porque cada variable solo vive en su metodo, es su
        alcance, y un metodo no puede modificar los valores de otras variables que viven fuera de él. Esto, siempre 
        con objetos primitivos, pero difiere cuando se trabaja con Objetos - visto en paso por referencia!!
        
        
        Si, bien NO Puedo modificar el valor de una variable, ese 15, lo puedo enviar, como una copia de ese valor,
        modificando el void, por un INT, y retornando un valor:
        */
    }

    public static int cambioValor1(int arg1) {
        System.out.println("arg1 = " + arg1);

        return arg1 = 15;
    }

}
