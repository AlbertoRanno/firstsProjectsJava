package test;

public class TestArreglos {

    public static void main(String[] args) {
        int edades[] = new int[3];
        /* como creando una variable, el tipo, el nombre (en plural, por ser un conjunto), pero para indicar 
        que es un arreglo, van los [], estos pueden ir: []edades, edades [], pero lo más común es: edades[]
        Se instancian con la palabra reservada "new", dado que los arreglos son un tipo object. Un arreglo
        hereda de la clase object.
        Luego de new, de indica el tipo de dato, y, entre corchetes, la cantidad de elementos (length).
        A los arreglos siempre hay que indicarle la cantidad de elementos que va a almacenar, y una vez indicada,
        no puede crecer ( a diferencia de las Listas )*/
        System.out.println("edades = " + edades); //Como un arreglo es un objeto, veo su direccion en memoria

        //Accedo a los elementos del arreglo que quiera modificar:
        edades[0] = 10;
        System.out.println("edades[0] = " + edades[0]);
        edades[1] = 36;
        System.out.println("edades[1] = " + edades[1]);
        edades[2] = 2;
        System.out.println("edades[2] = " + edades[2]);

        //Si quisiera cambiar un valor fuera del rango del arreglo, da error, al ejecutar, no al compilar. Ej:
        // edades[3] = 9; // Recordar que si length = n, índices: desde 0 a n-1
        for (int i = 0; i < edades.length; i++) {
            System.out.println("edades[" + i + "] = " + edades[i]);
        }

        //"Sintaxis resumida" - cuando se definen ya de entrada los valores del arreglo:
        String frutas[] = {"Melón", "Frutilla", "Uvas"};
        for (int i = 0; i < frutas.length; i++) {
            System.out.println("frutas[" + i + "] = " + frutas[i]);
        }

    }
}
