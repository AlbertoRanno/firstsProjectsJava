package test;

import genericos.ClaseGenerica;

public class TestGenerics {

    public static void main(String[] args) {
        //voy a usar la clase generica que genere, para eso le paso el <tipo>, en este caso, por ejemplo, Integer
        //ClaseGenerica<Integer> //Ojo que son las clases Envolventes, No los primitivos => es Integer, No int...
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica(15);
        objetoInt.obtenerTipo(); //El tipo T es: Integer
        
        ClaseGenerica<String> objetoString = new ClaseGenerica("15"); //Ojo el <tipo> y el valor que paso, deben 
        //ser compatibles! => hijos y padres, INterface y clase... pero si al 15, no le agregaba las ""... seguia diciendo Integer
        objetoString.obtenerTipo(); //El tipo T es: String
        
        
    }

}
