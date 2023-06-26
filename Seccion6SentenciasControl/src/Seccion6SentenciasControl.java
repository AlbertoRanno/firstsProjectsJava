
import java.util.Scanner;

public class Seccion6SentenciasControl {

    public static void main(String args[]) {
        var condicion = true;

        if (condicion) {
            System.out.println("Condicion verdadera");
            System.out.println("Nueva linea => llaves son necesarias, de hecho es buena practica");
        } else {
            System.out.println("Condicion falsa");
        }

        var numero = 5;
        var numeroTexto = "Numero desconocido";

        if (numero == 1) {
            numeroTexto = "Numero uno";
        } else if (numero == 2) { //"sino, si es = a 2"
            numeroTexto = "Numero dos";
        } else if (numero == 3) {
            numeroTexto = "Numero tres";
        } else if (numero == 4) {
            numeroTexto = "Numero cuatro";
        } else {
            //numeroTexto = "Numero no encontrado"; //al comentar esta linea, toma relevancia el "Numero desconocido"
        }

        System.out.println("numeroTexto = " + numeroTexto);

        /* Si usara solamente una sucesion de if - if - if ... estaria haciendo al programa trabajar de mas, dado que tendria que chequear el resto de las condiciones,
        por más que ya haya encontrado la respuesta. Por eso es importante ligar los casos.*/
        //Otro ej, con estaciones del año (aprox)
        //var mes = 10;
        var consola = new Scanner(System.in);
        System.out.println("Ingresa el mes del año (Ej. = \"2\"");
        var mes = Integer.parseInt(consola.nextLine());
        var estacion = "Estacion desconocida";

        if (mes == 1 || mes == 2 || mes == 12) {
            estacion = "Invierno";
        } else if (mes == 3 || mes == 4 || mes == 5) {
            estacion = "Primavera";
        } else if (mes == 6 || mes == 7 || mes == 8) {
            estacion = "Verano";
        } else if (mes == 9 || mes == 10 || mes == 11) {
            estacion = "Otoño";
        }

        System.out.println("estacion = " + estacion);

        /*switch
        A diferencia de la estructura IF, donde las comparaciones venían dadas por el tipo Booleano, 
        Aca las comparaciones pueden ser del tipo numerico o string 
        Es una estructura excelente para hacer menues
        Repito el Ej. de convertir numero a texto        */
        //var numero1 = 2;    esta definida al comienzo... modificar valores desde alli...        
        //var numeroTexto1 = "Valor desconocido";
        switch (numero) {
            case 1 :
                numeroTexto = "Numero uno";
                break;
            case 2:
                numeroTexto = "Numero dos";
                break;
            case 3:
                numeroTexto = "Numero tres";
                break;
            case 4:
                numeroTexto = "Numero cuatro";
                break;
            default:
                numeroTexto = "Caso no encontrado"; 
            
        }
        System.out.println("numeroTexto = " + numeroTexto);
        
        
        //repito ejercicio estaciones: utilizo sus variables
        switch (mes) {
            case 1: case 2: case 12:
                estacion = "Invierno";
                break;
            case 3:case 4: case 5:
                estacion = "Primavera";
                break;
            case 6:case 7: case 8:
                estacion = "Verano";
                break;
            case 9:case 10: case 11:
                estacion = "Otoño";
                break;
   
        }
        System.out.println("estacion = " + estacion);
        
        
         /* Ejercicio: Instrucciones de tareas
    El objetivo del ejercicio es crear un sistema de calificaciones, como sigue:

    El usuario proporcionará un valor entre 0 y 10.

    Si está entre 9 y 10: imprimir una A

    Si está entre 8 y menor a 9: imprimir una B

    Si está entre 7 y menor a 8: imprimir una C

    Si está entre 6 y menor a 7: imprimir una D

    Si está entre 0 y menor a 6: imprimir una F

    cualquier otro valor debe imprimir: Valor desconocido

    Por ejemplo:

    Proporciona un valor entre 0 y 10:
    A
    Puedes utilizar el IDE de tu preferencia para codificar la solución y después pegar tu solución en esta herramienta.    
    */
    
        System.out.println("Proporcionanos un valor entre 0 y 10");
        var calificacion = Integer.parseInt(consola.nextLine());
        
        switch (calificacion) {
            case 10:
                System.out.println("A");
                break;
            case 9:
            case 8:
                System.out.println("B");
                break;
            case 7:
            case 6:
                System.out.println("C");
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                System.out.println("F");
                break;
            default:
                System.out.println("Valor desconocido");
                break;
                
         /*
         La declaración switch en Java no admite la comparación de rangos con valores decimales (double). Solo puede comparar valores discretos específicos.

         Para comparar intervalos de valores decimales, necesito utilizar una estructura de control como if-else.       
                
        import java.util.Scanner;
 
        public class Main {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Proporciona un valor entre 0 y 10:");
                int calificacion = Integer.parseInt(scanner.nextLine());
                //Si esta entre 9 y 10 imprimir: A
                if (calificacion >= 9 && calificacion <= 10)
                    System.out.println("A");
                //Si esta entre  8 y menor a 9 imprimir: B
                else if(calificacion >= 8 && calificacion < 9)
                    System.out.println("B");
                //Si esta entre 7 y menor a 8 imprimir: C
                else if(calificacion >= 7 && calificacion < 8)
                    System.out.println("C");
                //Si esta entre 6 y menor a 7 imprimir: D
                else if(calificacion >= 6 && calificacion < 7)
                    System.out.println("D");
                //Si esta entre 0 y menor a 6 imprimir: F
                else if(calificacion >= 0 && calificacion < 6)
                    System.out.println("F");
                //Si no esta en el rago, imprimir: Valor desconocido
                else
                    System.out.println("Valor desconocido");
            }
        }
                
                PROXIMA SECCION 8: CICLOS
         */       
                
        }
    }
    
    
      

}
