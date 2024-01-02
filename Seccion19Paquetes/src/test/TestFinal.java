package test;

import mx.com.globalmentoring.Utileria;

public class TestFinal {
    public static void main(String[] args) {
        /*usos de la palabra "final"*/
        final int miVariable = 10;
        System.out.println("miVariable = " + miVariable);
        // miVariable = 5; //En variables, final, implica que no se puede cambiar su valor
        
        System.out.println("Utileria.MI_CONSTANTE = " + Utileria.MI_CONSTANTE);
        
        // Utileria.MI_CONSTANTE = 5; // Idem, para constantes, que son atributos, estaticos, con final
        
        final Utileria utileria1 = new Utileria(); //final en objetos:
        //utileria1 = new Utileria(); //No permite agregar una nueva referencia de memoria, es decir,
        //una nueva referencia a otro nuevo objeto, a esta variable. Si se guardó en una celda, esa celda se mantiene.
        // pero si se pueden modificar los valores de los atributos del objeto, mediante los setters:
        utileria1.setNombre("MecanismoPrincipal"); 
        //el valor por default era null, porque se uso el constructor por default, que es el vacio
        System.out.println("utileria1 = " + utileria1.getNombre());
        utileria1.setNombre("Mecanismo"); 
        System.out.println("utileria1 = " + utileria1.getNombre());
     
        
                
    }
}
