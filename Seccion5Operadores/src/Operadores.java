
import java.util.Scanner;


public class Operadores {

    public static void main(String args[]) {
        int a = 3, b = 2;
        var resultado = a + b;
        System.out.println("resultado  suma = " + resultado);

        resultado = a - b;
        System.out.println("resultado rest = " + resultado);

        resultado = a * b;
        System.out.println("resultado multiplicacion = " + resultado);

        resultado = a / b;
        System.out.println("resultado division = " + resultado);
        //resultado se creo como tipo int - lo dedujo por var - entonces, va a mostrar "1", y no "1.5"

        //genero otra variable, y el primer nro lo pongo como flotante:
        var resultado2 = 3.0 / b;
        System.out.println("resultado2 division = " + resultado2);
        // o bien:
        resultado2 = 3D / b;
        System.out.println("resultado2 division = " + resultado2);

        //OJO que decir que es tipo flotante no es lo mismo que decir que es tipo float
        resultado = a % b;
        System.out.println("resultado resto o modulo = " + resultado);

        if (a % 2 == 0) {
            System.out.println("El nro es par");
        } else {
            System.out.println("El nro es impar");
        }
        // con una sola linea se puede omitir llaves, igual que .NET

        int c = a + 5 - b;
        // Orden: arranca del derecho del igual. Y ahí, de izquierda a derecha. + Y - tienen la misma prioridad, entonces hace: 3 + 5 - 2 = 6, por lo tanto le asigna 6 a c
        System.out.println("c = " + c);

        a += 1; // a = a + 1;
        System.out.println("a = " + a);

        a += 3; // a = a +3;
        System.out.println("a = " + a);

        a -= 2; // a = a -2;
        System.out.println("a = " + a);

        a *= 4; // a = a 4;
        System.out.println("a = " + a);

        a /= 5; // a = a /5 ;
        System.out.println("a = " + a);

        a %= 3; // a = a % 2;
        System.out.println("a = " + a);

        //Operadores Unarios:
        b = -a; // cambio de signo
        System.out.println("b = " + b);

        var d = true;
        var e = !d; // negación
        System.out.println("d = " + d);
        System.out.println("e = " + e);

        //incremento (idem decremento)
        //1. preincremento (simbolo antes de la variable)
        var f = 3;
        var g = ++f;
        System.out.println("f = " + f); // 4 - porque incrementé el valor de f en la linea anterior
        System.out.println("g = " + g); // 4 - incremente el valor de f antes de asignarlo a g
        //2. postincremento (simbolo despues de la variable)
        var h = 5;
        var i = h++; // primero se utiliza el valor de la variable, y luego se incrementa
        System.out.println("h = " + h); // 6 - porque se incremento en la linea anterior
        System.out.println("i = " + i); // 5 - porque se asigno antes de incrementarla

        var j = 2;
        var k = --j;
        System.out.println("j = " + j);
        System.out.println("k = " + k);

        var l = 4;
        var ll = l--;
        System.out.println("l = " + l);
        System.out.println("ll = " + ll);

        var a1 = 3;
        var b1 = 2;
        var c1 = (a1 == b1);
        System.out.println("c1 = " + c1);

        var d1 = (a1 != b1); //los ( ) no son necesarios, pero le dan claridad
        System.out.println("d1 = " + d1);

        // Para el caso de strings (asi como el de objetos, aunque este se vera mas adelante), la comparacion no es igual, sino que se usa el siguiente metodo:
        var cadena = "Hola";
        var cadena2 = "Adios";
        var e1 = (cadena == cadena2);
        System.out.println("e1 = " + e1);
        /* F - Pero esto NO es debido al contenido, sino que no está comparando el contenido de las cadenas, sino las referencias de objetos que almacenan ese contenido
         Supongo entonces, que compara "cadena" con "cadena2", esto se verá más adelante igual.
        Si en cadena2, pondria "Hola", tambien daria true pero por otro motivo en este caso, idem, mas adelante... */

        //****************IMPORTANTE********* Método para comparar Strings:
        var f1 = cadena.equals(cadena2);
        System.out.println("f1 = " + f1);

        //Operadores relacionales
        var g1 = a1 >= b1;
        System.out.println("g1 = " + g1);

        //Operadores Condicionales && (ambos V => V)  || ( V - F => V   //  V - V => V  //  F - F => F )
        var a2 = 10;
        var valorMinimo = 0;
        var valorMaximo = 10;

        var resultado3 = a2 >= valorMinimo && a2 <= valorMaximo;
        System.out.println("resultado3 = " + resultado3);

        //Operador ternario: util para reemplazar estructuras tipo if - else sencillas, sino No se recomienda
        var resultado4 = (3 > 2) ? "verdadero" : "falso";
        System.out.println("resultado4 = " + resultado4);

        var numero = 8;
        resultado4 = (numero % 2 == 0) ? "numero par" : "numero impar";
        System.out.println("resultado4 = " + resultado4);

        //****************IMPORTANTE*********/
        //Precedencia de Operadores - Orden en que se van a evaluar
        var x = 5;
        var y = 10;
        var z = ++x + y--;
        /*Primero se evalua ++x = 6
        Segundo se evalua y-- PEEERO ESTO SIGNIFICA, A POSTERIORI, ES DECIR LA PROXIMA VEZ QUE VEA A "Y" A SU VALOR HABRÁ QUE RESTARLE 1, PERO POR AHORA, SU VALOR ES DE 10 */

        System.out.println("x = " + x); //6
        System.out.println("y = " + y); //9  - Acá me encuentro con Y de nuevo, por lo que le resto ese 1...
        System.out.println("z = " + z); //16 - Porque la suma se efectua ANTES de restarle esa unidad a Y

        var resultado5 = 4 + 5 * 6 / 3; // 5*6 = 30 => 30/3 = 10 => 4 + 10 = 14
        System.out.println("resultado5 = " + resultado5);

        var resultado6 = (4 + 5) * 6 / 3;
        System.out.println("resultado6 = " + resultado6);

        /*
        En el siguiente ejercicio se solicita calcular el área y el perímetro de un Rectángulo, para ello deberemos crear las siguientes variables:

        alto (int)
        ancho (int)

        El usuario debe proporcionar los valores de largo y ancho, y después se debe imprimir el resultado en el siguiente formato(no usar acentos y respetar los espacios, mayúsculas, minúsculas y saltos de línea):

        Proporciona el alto:
        Proporciona el ancho:
        Area: <area>
        Perimetro: <perimetro>
        Las fórmulas para calcular el área y el perímetro de un Rectángulo son:

        Área: alto * ancho

        Perímetro: (alto + ancho) * 2

        Preguntas de esta tarea
        ¿Cuál es el código del requerimiento solicitado?
         */
        
        int alto, ancho;
        
        var consola = new Scanner (System.in);
        System.out.println("Vamos a calcular el area y perimetro de un rectangulo.\nPor favor, ingresa el alto del mismo: ");
        alto = Integer.parseInt(consola.nextLine());
        System.out.println("Ingresa el ancho: ");
        ancho = Integer.parseInt( consola.nextLine());
        
        System.out.println("Area = " + alto * ancho);
        System.out.println("Perimetro = " + (alto + ancho) * 2);
        
        /*
        Solicitar al usuario dos valores:

        numero1 (int)
        numero2 (int)

        Se debe imprimir el mayor de los dos números (la salida debe ser identica a la que sigue):

        Proporciona el numero1:
        Proporciona el numero2:
        El numero mayor es:
        <numeroMayor>
        
        Preguntas de esta tarea
        ¿Cuál es el código del requerimiento solicitado?
        */
        int numero1, numero2, numeroMayor;
        
        System.out.println("Proporciona el numero1: ");
        numero1 = Integer.parseInt(consola.nextLine());
        System.out.println("Proporciona el numero2: ");
        numero2 = Integer.parseInt(consola.nextLine());
        numeroMayor = numero1 > numero2 ? numero1 : numero2;
        System.out.println("numeroMayor = " + numeroMayor);
        
        
        //Termina la seccion 5
        //Proxima: 6 - Sentencias de Control        
                
                
                
    }
}
