
public class Seccion7Ciclos {

    public static void main(String args[]) {
        /*Ciclos, tiene que ver con la repetecion de lineas de codigo..
        Se evalúa una condición, y si es V, se ejecuta 1 o vs sentencias, y se vuelve a evaluar la condición y si es V, se vuelve a ejecutar*/

        //WHILE
        var contador = 0;
        while (contador < 3) {
            System.out.println("contador = " + contador);
            contador++;
        }
        /**
         * ****************** IMPORTANTE ********************** Breakpoint en
         * la linea de definicion de la variable CLick derecho, debug file,
         * avanzo de a un paso con F8 No tengo que tener codigo seleccionado
         * mientras debuggeo, sino se ejecuta esa linea, y no el orden correcto
         * En caso de que no viera la consola de "Variable" ir a Windows
         * Debugging Variables Puedo seleccionar la condicion dentro del while,
         * click derecho, y ponerle "New watch" Eso lo pasa como variable a la
         * consola, y veré con el correr del debug que es de tipo booleano, y es
         * True, hasta que contador pasa a ser = 3,
         */

        //DO WHILE -Similar, pero al menos se ejecuta una vez (indistinto de la condicion sea T o F)
        var contador1 = 0;

        do {
            System.out.println("contador1 = " + contador1);
            contador1++;
        } while (contador1 < 3);

        //FOR
        for (var contador2 = 0; contador2 < 3; contador2++) { //a diferencia de las otras variables, esta es interna, y solo se puede usar dentro del ciclo
            System.out.println("contador2 = " + contador2);
        }

        //BREAK y CONTINUE
        for (var contador3 = 0; contador3 < 3; contador3++) {
            if (contador3 % 2 == 0) {
                System.out.println("contador3 = " + contador3);
                break; //una vez que encuentra el primer numero par, sale del ciclo
            }
        }

        for (var contador4 = 0; contador4 < 3; contador4++) {
            if (contador4 % 2 != 0) {
                continue; //continue hace que no sigue ejecutando las lineas de codigo, sino que pase a la siguiente iteracion              
            }
            System.out.println("contador4 = " + contador4); //Por lo tanto, en este ej, con otra logica, pero tmb, se imprimiran solo los pares,
            //ya que a los impares, el continue, los hace pasar a la siguiente iteracion (par)
        }

        //ETIQUETAS (GO TO.. NO ES BUENA PRACTICA, NO SE RECOMIENDA..
        //Lo que hacen es que, tanto el breaak, como el continue, vayan, en lugar de su siguiente paso por defecto, a la etiqueta que se le asigne, EJ
        inicio:
        for (var contador5 = 0; contador5 < 3; contador5++) {
            if (contador5 % 2 != 0) {
                continue inicio; //continue lleva a la linea de codigo de la etiqueta              
            }
            System.out.println("contador5 = " + contador5);// En este caso, esta yendo una linea mas atras, pero no cambia nada 
            //Teoricamente estos casos de etiquetas, solo podrian llegar a ser utiles en un for dentro de otro... pero no se recomiendan...

        }

    }
}
