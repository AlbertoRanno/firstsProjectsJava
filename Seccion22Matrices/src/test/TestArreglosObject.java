package test;

import domain.Persona;

public class TestArreglosObject {

    public static void main(String[] args) {
        //Arreglo de tipo object (referencias a objetos)
        Persona personas[] = new Persona[2];
        //Por ser object, los valores de los indices por default, es null
        //Agrego una nueva referencia para que apunte a un objeto del tipo persona
        personas[0] = new Persona("Emiliano"); //Paso el único constructor, dado que definí uno con nombre
        personas[1] = new Persona("Romina");

        System.out.println("personas 0 = " + personas[0]); //Ahora apuntan a las direcciones donde se guardaron
        System.out.println("personas 1 = " + personas[1]); //los nuevos objetos
        // System.out.println("personas = " + personas.toString()); //El array completo se guarda en otra direccion

        for (int i = 0; i < personas.length; i++) {
            System.out.println("personas[" + i + "] = " + personas[i]);
        }
    }
}
