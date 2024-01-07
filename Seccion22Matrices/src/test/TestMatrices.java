package test;

import domain.Persona;

public class TestMatrices {

    public static void main(String[] args) {
        /*Matrices, son dos arreglos, uno que controla los renglones, y otro que controla las columnas*/
        int edades[][] = new int[3][2]; //1er arreglo controla renglones, 2do, columnas.
        System.out.println("edades = " + edades); //es un object, y veo la direccion donde se guarda

        edades[0][0] = 5;
        edades[0][1] = 7;
        edades[1][0] = 8;
        edades[1][1] = 4;
        edades[2][0] = 15;
        edades[2][1] = -3;

//        System.out.println("edades[0][0] = " + edades[0][0]);
//        System.out.println("edades[0][1] = " + edades[0][1]);
//        System.out.println("edades[1][0] = " + edades[1][0]);
//        System.out.println("edades[1][1] = " + edades[1][1]);
//        System.out.println("edades[2][0] = " + edades[2][0]);
//        System.out.println("edades[2][1] = " + edades[2][1]);
        for (int renglones = 0; renglones <= 2; renglones++) {
//renglones <= 2 == renglones < edades,length
            for (int columnas = 0; columnas <= 1; columnas++) {
//columnas <= 1 == columnas < edades[renglones].length - Para la cantidad de columnas del renglon
                System.out.println("edades[" + renglones + "][" + columnas + "] = " + edades[renglones][columnas]);
            }
        }
    

        //Matriz de Strings
        //String frutas[][] = new String[2][2]; //y seguir como el anterior, u otra sintaxis:
        String frutas[][] = {{"Naranja", "Limón"}, {"Fresa", "Zarzamora", "Mora"}};
//La matriz no necesariamente tiene que ser cuadrada. Por eso sirve: frutas[renglones].length;
//        for (int renglones = 0; renglones < frutas.length; renglones++) {
//            for (int columnas = 0; columnas < frutas[renglones].length; columnas++) {
//                //System.out.println("frutas[" + renglones + "][" + columnas + "] = " + frutas[renglones][columnas]);
//                System.out.println("frutas[" + renglones + "][" + columnas + "] = " + frutas[renglones][columnas]);
//            }
//        }
        imprimir(frutas);

        //Matriz de objetos de tipo Persona
        Persona personas[][] = new Persona[2][3]; //nombre plural para matrices / arrays
        personas[0][0] = new Persona("Juan");
        personas[0][1] = new Persona("Karla");
        personas[0][2] = new Persona("Joaquín");
        personas[1][0] = new Persona("Marcos");
        personas[1][1] = new Persona("Layla");
        personas[1][2] = new Persona("Laura");

//        for (int renglones = 0; renglones < personas.length; renglones++) {
//            for (int columnas = 0; columnas < personas[renglones].length; columnas++) {
//                System.out.println("personas[" + renglones + "][" + columnas + "] = " + personas[renglones][columnas]);
//            }
//        }
        imprimir(personas);
        
        
    }
    
    /*Agrego metodo para no repetir a cada rato tanto codigo a la hora de imprimir:
     static (consuma de main) - void (imprime, no regresa nada) - Object para que pueda recibir el
     arreglo de personas, pero también el de String de frutas. Se indica que es una matriz, pero
    NO se indica ni cantidad de filas ni de columnas, porque como va a apuntar al objeto que se creo
    en cierto momento, y se va a llamar a imprimir, tomara del mismo estos valores*/
    public static void imprimir(Object matriz[][]){
         for (int renglones = 0; renglones < matriz.length; renglones++) {
            for (int columnas = 0; columnas < matriz[renglones].length; columnas++) {
                System.out.println("matriz[" + renglones + "][" + columnas + "] = " + matriz[renglones][columnas]);
            }
        }
    }

}
