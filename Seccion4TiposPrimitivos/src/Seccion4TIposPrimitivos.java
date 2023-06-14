
import java.util.Scanner;


public class Seccion4TIposPrimitivos {

    public static void main(String args[]) {
        /*
        Tipos primitivos enteros: byte (8) short (16) int (32) long (64)
        
        ***********IMPORTANTE***********
        El más usado es el tipo int, dado que el tipo bipo byte, que ocupa 8 bytes, no garantiza que utilicemos solamente 8 bytes, ya que posiblemente,
        estos 8 bytes se van a almacenar en los 32 bytes, que componen una palabra de una arquitectura de 32 bytes
         */

        byte numeroByte = 10;
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("como saber el valor mínimo de byte: " + Byte.MIN_VALUE); //Las clases comienzan con Mayúscula, por eso Byte...
        System.out.println("como saber el valor mínimo de byte: " + Byte.MAX_VALUE);
        
        
        /************IMPORTANTE***********
         el (byte) lo convierte, y no da mensaje de error... pero guarda "sin precisión"... devuelve -127 en lugar de 129... por eso es importante conocer Máximos y Mínimos.
         Esto es para todos los casos*/
        
        numeroByte = (byte) 129;
        System.out.println("numeroByte = " + numeroByte);
        
        short numeroShort = 10;
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("como saber el valor mínimo de byte: " + Short.MIN_VALUE);
        System.out.println("como saber el valor mínimo de byte: " + Short.MAX_VALUE);
        
        int numeroInt = 10;
        System.out.println("numeroShort = " + numeroInt);
        System.out.println("como saber el valor mínimo de byte: " + Integer.MIN_VALUE);
        System.out.println("como saber el valor mínimo de byte: " + Integer.MAX_VALUE);
        /*Obs! Si en un int, me paso del 2147483647, su máximo, también se va de valor la literal, que es int por default. 
        Por lo que hay que pasarlo a long, agregando una "l o L" al final del numero, pero dado que la minuscula parece un 1, se suele poner la L
        2147483647L */
        
        long numeroLong = 10;
        System.out.println("numeroShort = " + numeroLong);
        System.out.println("como saber el valor mínimo de byte: " + Long.MIN_VALUE);
        System.out.println("como saber el valor mínimo de byte: " + Long.MAX_VALUE);
        
        //Si se pasan de estos máximos, hay que utilizar de tipo flotante
        
        /************IMPORTANTE***********
        Tipos primitivos flotantes: float (32) double (64)
        por utilizar anotación del tipo exponencial, los float pueden ocupar lo mismo, pero guardar nros más grandes
        float numeroFloat = 10.0; da error, porque los punto flotante, en java, por default, son Double, por lo que que ponerle la "f o F", o el (float)*/
        
        float numeroFloat = 10.0F;        
        System.out.println("numeroFloat = " + numeroFloat);
        System.out.println("como saber el valor mínimo de byte: " + Float.MIN_VALUE); //1.4E-45 - Es decir 45 posiciones hacia la izquierda
        System.out.println("como saber el valor mínimo de byte: " + Float.MAX_VALUE); //3.4028235E38 - Es decir 38 posiciones a derecha
        
        double numeroDouble = 10; //No hace falta aclarar la D, ya que por tener el puntito, por default es double
        System.out.println("numeroShort = " + numeroDouble);
        System.out.println("como saber el valor mínimo de byte: " + Double.MIN_VALUE); //4.9E-324 - Es decir 324 posiciones hacia la izquierda
        System.out.println("como saber el valor mínimo de byte: " + Double.MAX_VALUE); //1.7976931348623157E308 - Es decir 308 posiciones a derecha
        
        
        
        /*************IMPORTANTE***********
        DEBUG - Hacer click en el número de línea que quiera (debe poder ser ejecutada - Ejemplo donde declaro la variable)
        click derecho - debug file
        en el menu window, debugging, puedo configurar lo que veo en la consola al debuguear, por ejemplo, las variables
        presionar F8, o step over, para avanzar un paso
        */
        
        var numeroEntero = 10;
        System.out.println("numeroEntero = " + numeroEntero);
        
        var numeroDouble2 = 10.0;
        System.out.println("numeroDouble2 = " + numeroDouble2);
        
        var numeroFloat2 = 10.0F;
        System.out.println("numeroFloat2 = " + numeroFloat2);
        
        /* Tipo CHAR (16) - Se listan todos (casi 200 mil, en la lista UNICODE ver wikipedia)*/
        
        char miCaracter = 'a';
        System.out.println("miCaracter = " + miCaracter);
        
        /*************IMPORTANTE***********
         https://en.wikipedia.org/wiki/List_of_Unicode_characters */
        char varCharCode = '\u0021'; //"\u0021" para indicar que voy a ingresar el codigo unicode 0021
        System.out.println("varCharCode = " + varCharCode);
        //otra forma:
        char varCharDecimal = 33; // como indico que es del tipo char, el 33, no lo toma como numero, sino como el equivalente al codigo unicode 0021
        System.out.println("varCharDecimal = " + varCharDecimal);
        //otra forma:
        char varCharSimbolo = '!'; // directamente el símbolo entre comillas simples
        System.out.println("varCharSimbolo = " + varCharSimbolo);
        
        /*Ahora usando VAR:*/
        var varCharCode1 = '\u0021'; 
        System.out.println("varChar1 = " + varCharCode1);
       
        var varCharDecimal2 = 33; //OJO! Acá lo va a tomar como un INTEGER!!
        System.out.println("varCharDecimal2 = " + varCharDecimal2);
      
        var varCharSimbolo3 = '!'; 
        System.out.println("varCharSimbolo3 = " + varCharSimbolo3);
        
        /*************IMPORTANTE***********
         al guardar un simbolo como entero, obtengo su valor Decimal - Estos valores están en la columna de decimal de la lista Unicode de wiki*/
        int variableEnteraSimbolo = '!';
        System.out.println("variableEnteraSimbolo = " + variableEnteraSimbolo); // Esto da 33
        
        int letra = 'a';
        System.out.println("letra = " + letra);// Esto da 97
        
        /* Tipo Booleano - o "Bandera o semáforo" */
        boolean varBoolean = true;
        System.out.println("varBoolean = " + varBoolean);
        
        if (varBoolean){
            System.out.println("La bandera es verdadera");
        } else {
            System.out.println("La bandera es falsa");
        }
        
        var edad = 30;
               
        if (edad >= 18){
        System.out.println("Eres mayor de edad");
        } else {
        System.out.println("Eres menor de edad");
        }
        
        /*COnversión de tipos
        
        *************IMPORTANTE***********
        
        Convertir un tipo string a un tipo int */
        var años = Integer.parseInt("20");
        System.out.println("años = " + (años + 1)); //cambio prioridad, sino ... años = 201
        
        var valorPI = Double.parseDouble("3.1416");
        System.out.println("valorPI = " + valorPI);
        
        
        //Pedir un valor
        var consola = new Scanner(System.in);
        System.out.println("Proporciona tu edad: ");
       años = Integer.parseInt(consola.nextLine());
        System.out.println("años = " + años);
        

        /***************IMPORTANTE**********
         Metodo que cambia lo asignado a tipo String: */
        var edadTexto = String.valueOf(10);
        System.out.println("edadTexto = " + edadTexto);
        
        
        /***************IMPORTANTE**********
         Metodo que captura un caracter de un string, dado su índice */
        var caracter = "hola".charAt(0);
        System.out.println("caracter = " + caracter);
        
        System.out.println("Proporciona un caracter: ");
        caracter = consola.nextLine().charAt(0);// consola.nextLine(), trae un string, por eso le puedo aplicar charAt()
        System.out.println("caracter = " + caracter);
    }
    
    /*Ejercicios y consignas que no se entienden... 
    import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proporciona el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Proporciona el id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Proporciona el precio:");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Proporciona el envio gratuito:");
        boolean envioGratuito = Boolean.parseBoolean(scanner.nextLine());
 
        System.out.println(nombre + " #" + id);
        System.out.println("Precio: $" + precio);
        System.out.println("Envio Gratuito: " + envioGratuito);
    }
}
      
    */
}
