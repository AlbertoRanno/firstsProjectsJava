package test;

import domain.Persona;

public class TestForEach {

    public static void main(String[] args) {
        /*ForEach - "es un FOR mejorado" - para mi es simplificado...
        Pro, no requiere contador
        COntra, no se puede acceder a un indice especifico, si lo necesitara recurrir ahi si al FOR
        Ej, defino un arreglo para recorrerlo:  */
        int edades[] = {5, 66, 7, 12, 81};

        for (int edad : edades) {
            System.out.println("edad = " + edad);
        }

        /*Estructura:
        for( tipoDeDatoDelArreglo nombreVariable: nombreArregloQueQuieroRecorrer*/
        String nombres[] = {"Juan", "Carlos", "Jeremias"};

        for (String nombre : nombres) {
            System.out.println("nombre = " + nombre);
        }

        /*Caso de Objetos:
        Defino e Inicializo un array de objetos:*/
        Persona personas[] = {new Persona("Juan"), new Persona("Tobías"), new Persona("Alonso")};
        for (Persona persona: personas){
            System.out.println("persona = " + persona);
        }
        /*Nota, para el tipoDeDatoDelArreglo dentro del FOR, podría usar la clase Padre 
        (Object, o, si la tuviera, la especifica:
        for (Object persona: personas){
            System.out.println("persona = " + persona);
        }
        
        Nota2, tene presente que para los arrays no se puede utilizar 'var' para el tipo de dato
        
        */
    }
}
