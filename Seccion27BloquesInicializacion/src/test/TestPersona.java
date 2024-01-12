package test;

import domain.Persona;

public class TestPersona {
    public static void main(String[] args) {
        Persona persona1 = new Persona(); //Run
        System.out.println("persona1 = " + persona1);
        System.out.println("");
        Persona persona2 = new Persona(); //Notar que el static ya no se vuelve a ejecutar
        System.out.println("persona2 = " + persona2);
    }
}
