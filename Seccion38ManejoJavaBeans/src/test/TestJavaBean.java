package test;

import domain.PersonaBean;

public class TestJavaBean {
    public static void main(String[] args) {
        //Mediante el constructor vacio + set + get, inicializo todo, sin la necesidad de un constructor con argumentos:
        PersonaBean persona = new PersonaBean();
        System.out.println("persona = " + persona);
        persona.setNombre("Alberto");
        persona.setApellido("Ranno");
        System.out.println("persona = " + persona);
    }
}
