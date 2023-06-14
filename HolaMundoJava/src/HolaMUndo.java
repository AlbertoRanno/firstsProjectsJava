
import java.util.Scanner;

//Mi clase en Java

/*
*Los proyectos crearlos no muy lejos de la raíz del disco “sino pueden fallar por la cantidad de niveles (subcarpetas)”
*Click derecho en Source packages, para crear una clase.
*Buena práctica PascalCase para nombres de clases
*Buena práctica camelCase para nombres de variables
*public porque es una clase que vamos a acceder de manera pública
*palabra reservada "class"
 */
public class HolaMUndo {

    //escribo un método (algo que voy a poder ejecutar 1 o + veces):
    public static void main(String args[]) {
        System.out.println("Hola Mundo desde Java");
        /*
        Variables, se reutilizan, pueden cambiar su valor con el tiempo
        tipo identificador
        defino variable:*/
        int miVariableEntera = 10;
        /* 
        
        ***********IMPORTANTE***********
        El 10 se va a conocer como "una literal" y en Java, las literales numéricas, van a ser del tipo int. Salvo que tenga punto flotante.
        Por ende, no solo las variables van a tener un tipo, sino también las literales, es decir los valores que les asigne
        
        
         */
        System.out.println(miVariableEntera);
        //Modifico valor de la variable:
        miVariableEntera = 5;

        /* 
        
        ***********IMPORTANTE***********
        Una variable que fue definida dentro de un método (main en este caso), no podrá ser utilizada fuera de ese método. Ese es su alcance.
        si escribo "sout" y presiono el tabulador, obtengo:        System.out.println("");
        si escribo "soutv" y presiono el tabulador, obtengo:        System.out.println("miVariableEntera = " + miVariableEntera); (debajo de la definición de la variable)
        click derecho "format" para emprolijar el código
        se recomiendo no utilizar acentos, NI EN LOS COMENTARIOS, dado que pueden provocar problemas al guardar el codigo, o para levantarlo desde otras herramientas
                
        Tipos de datos:
        *Primitivos: 
        -Enteros
        -Flotantes
        
        *Referenciados (Tipo Object): (ej. string)
        -Clases
        -Interfases
        -Arrays
        
        ***********IMPORTANTE***********
        -si declaro ahora una variable del tipo string, String va con mayúscula por tratarse de un tipo de dato Referenciado (y no primitivo como int)
        -presionando Ctrl + Espacio accedo a los nombres de las variables que tengo. Si voy avanzado en la escritura del nombre, filtra.
        -presionando Ctrl + CLick sobre el nombre de una variable, me lleva el cursor, a la línea donde se definió esa variable
        -en window -> resetWindows , me vuelven a aparecer las ventanas cerradas (la consola, al compilar, o en window->output)
        -una literal de tipo cadena, en automático, su tipo será string (comillas dobles)
        -las literales toman sentido, porque a partir de la version 10 de JAVA, se usa la palabra reservada var, para inferir el tipo de dato a partir de la literal
        
         */
        String miVariableCadena = "Saludos";
        System.out.println(miVariableCadena);

        miVariableCadena = "Adiós";
        System.out.println(miVariableCadena);

        /*
        VAR - Inferencia de tipos en Java a partir del valor que tome de la literal
        Esto cobrará importancia con tipos de datos más complejos, como objetos.
        
         */
        var miVariableEntera2 = 15;
        System.out.println(miVariableEntera2);

        /*
        click derecho en el nombre del proyecto, propiedades, y en sources / libraries veo las versiones del JDK que estoy usando, y puedo pasar a otras anteriores
         */
        var miVariableCadena2 = "Hola";
        System.out.println(miVariableCadena2);

        /* Reglas para nombres de variables: camelCase
        no puede tener delante numeros o caracteres especiales 
        - salvo "_guionBajo" y "$dineroAhorrado" 
        los acentos en las nombres están permitidos, pero no es recomendable*/
        var usuarioAdmin = "Juan";
        var titulo = "Ingeniero";

        var union = usuarioAdmin + " " + titulo;
        System.out.println("union = " + union);

        var numero1 = 3;
        var numero2 = 4;

        //***********IMPORTANTE***********   .
        System.out.println(numero1 + numero2 + usuarioAdmin);
        // "7Juan" - Primero se realiza la suma, y luego la concatenacion
        System.out.println(usuarioAdmin + numero1 + numero2);
        // "Juan34" - En la expresion evaluada de izq a der, si primero encuentra una cadena, todo lo que viene detras lo tomara como tal
        // A esto se lo llama Contesto Candena

        System.out.println(usuarioAdmin + (numero1 + numero2)); //A poner los () cambio la prioridad
        // "Juan7"

        var suma = numero1 + numero2;
        System.out.println("suma = " + suma);

        /*Leccion 13 - caracteres especiales*/
        var nombre = "Karla";

        System.out.println("Nueva linea: \n" + nombre);
        System.out.println("Nueva linea: \t " + nombre);
        System.out.println("Nueva linea: \b " + nombre); // Retroceso, se come el espacio del caracter anterior, en este caso el espacio en blanco anterior
        System.out.println("Nueva linea: \b\b\b " + nombre);
        System.out.println("Nueva linea: \'" + nombre + "\'"); // La \ podria o no ser requerida, luego ampliara
        System.out.println("Nueva linea: \"" + nombre + "\"");

        /*Leccion 14 - uso de la Clase Scanner
        
        ***********IMPORTANTE***********
        
        Es como el console.ReadLine() de .Net
        Es una clase predefina en Java que necesito importar, para eso, hacer click en la lamparita que aparece entre los nros de las lineas de codigo, 
        y ponerle que la agregue. Va a aparecer import java.util.Scanner; arriba de la clase en la que estoy trabajando
        Este tema se explicara mas adelante, pero necesitaba mecharlo, para incluir comandos de consola:
         */
        System.out.println("Escribe tu nombre:");
        Scanner consola = new Scanner(System.in);
        var usuario = consola.nextLine(); //Este metodo leera toda la siguiente linea de consola, hasta que el usuario pulse Enter

        System.out.println("usuario = " + usuario);

        System.out.println("Escribe tu cargo:");
        var cargo = consola.nextLine();

        System.out.println(usuario + " tiene el cargo de " + cargo);

        /*
        Se solicita incluir la siguiente información acerca de un libro:

        titulo
        autor

        Debes imprimir la información en el siguiente formato:

        Proporciona el titulo:
        Proporciona el autor:
        <titulo> fue escrito por <autor>
        Puedes utilizar el IDE de tu preferencia para desarrollar la solución y después pegar aquí tu respuesta, ya que este editor no contiene ningún tipo de ayuda.

        Preguntas de esta tarea
        ¿Cuál es el código del requerimiento solicitado?
         */
        
        System.out.println("Proporciona el titulo:");
        var tituloLibro = consola.nextLine();
        System.out.println("Proporciona el autor:");
        var autorLibro = consola.nextLine();
        System.out.println(tituloLibro + " fue escrito por " + autorLibro);
        
        
        /* En limpio:
        import java.util.Scanner;
 
        public class Main {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Escribe tu solucion aqui
        System.out.println("Proporciona el titulo:");
        String titulo = scanner.nextLine();
        System.out.println("Proporciona el autor:");
        String autor = scanner.nextLine();
        System.out.println(titulo + " fue escrito por " + autor);
        }
        }
        
        
        ACA TERMINA LA SECCION 3 - 12/6/2023*/
        
       /* OJO, es como .NET , y no como JS, importa el orden con que se definen las variables! 
        Lo siguiente da error!
        
    String color;    
    System.out.println(color);
    color = "Rojo";
    
    ¡Correcto! En el momento en que se imprime la variable, no se ha asignado aún un valor a la variable y el compilador manda el error: 
    variable color might not have been initialized (la variable color tal vez no ha sido inicializada)«*/
        
    }
}
