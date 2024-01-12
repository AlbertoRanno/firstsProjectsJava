package test;

public class TestAutoboxingUnboxing {
    public static void main(String[] args) {
        /*UNa literal, por ej, 10, se puede guardar como un tipo Primitivo: int, o por su clase Envolvente: Integer
        Si se va a usar para muchos calculos, se recomienda int, pero si fueran pocos, guardarla por su clase Envolvente,
        trae acceso a varios metodos, dependiendo del caso.
        Primitos y sus clases Envolventes:
        int         Integer
        long        Long
        float       Float
        double      Double
        boolean     Boolean
        char        Character
        short       Short
        
        Ejemplo:    */
        
        Integer entero = 10; //Guardarlo en su clase Envolvente, se conoce como Autoboxing
        System.out.println("entero = " + entero); //Se ve igual que siempre...
        System.out.println("entero double = " + entero.doubleValue()); //pero tengo acceso a convertirlo a double, por ej...
        System.out.println("entero string= " + entero.toString()); // a string para concatenarlo
        System.out.println("entero byte= " + entero.byteValue()); // a byte...
        
        int entero2 = entero; //Pasar de Envolvente a Primitivo, se conoce como Unboxing
        System.out.println("entero2 = " + entero2);
        
    }
}
