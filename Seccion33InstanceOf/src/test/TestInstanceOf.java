package test;

import domain.*;

public class TestInstanceOf {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Ximena", 300000);
        System.out.println("El 1er valor de 'empleado' ");
        determinarTipo(empleado);

        System.out.println("");

        empleado = new Gerente("Roberto", 400000, "Sistemas");
        System.out.println("El 2do valor de 'empleado' ");
        determinarTipo(empleado);

    }

    /* Dado el Polimorfismo, un metodo puede manejar distintos tipos de objetos.
    instanceOf, sirve para determinar el tipo del objeto que recibe por referencia
    La variable va a ser siempre de tipo Empleado (la clase padre, que puede abarcar a ambas)
    Pero el tipo del objeto que recibe por referencia, puede variar, en este caso, un objeto es
    propiamente de la clase padre (Empleado), y otro es de la clase hija (Gerente) 
     */
    public static void determinarTipo(Empleado empleado) { //(*)
//        if (empleado instanceof Gerente) {
//            System.out.println("Es de tipo Gerente");
//        } else if (empleado instanceof Empleado) {
//            System.out.println("Es de tipo Empleado");
//        } else if (empleado instanceof Object) {
//            System.out.println("Es de tipo Object");
//        }

        /* Siempre tengo que preguntar desde lo mas especifico a los mas general        
        
        Sin los if else, como puedo ver en el siguiente codigo comentado, se aprecia que instanceOf
        da verdadero, desde el tipo más especifico con el que coincide, y tambien verdadero, para todos
        los mas genericos que le siguen luego de ese:
         */
//        if (empleado instanceof Gerente) {
//            System.out.println("Es de tipo Gerente");
//        }
//        if (empleado instanceof Empleado) {
//            System.out.println("Es de tipo Empleado");
//        }
//        if (empleado instanceof Object) {
//            System.out.println("Es de tipo Object");
//        }

        /*Todo esto de ver instanceOf, sirve para confirmar el tipo de un objeto, y en base a eso,
        utilizar los metodos disponibles, o realizar las conversiones de tipo, de ser necesarias.
        El ide ayuda a esto ultimo:
         */
        if (empleado instanceof Gerente) {
            System.out.println("Es de tipo Gerente");
            /*Al confirmar que es de tipo gerente, convierto la variable empleado (de tipo empleado linea 26 (*))
            al tipo gerente:    */
            Gerente gerente = (Gerente) empleado; //Mismo estilo de conversion que para los primitivos
            System.out.println("Al ser gerente, accedo al departamento = " + gerente.getDepartamento());
            /*Si hubiese hecho, en lugar de lo anterior, 'empleado.getDepartamento() - autocompletado por el IDE,
            el mismo me hubiese devuelto lo siguiente:
            ((Gerente) empleado).getDepartamento();
            que no es mas que lo mismo que puse antes, pero en una sola linea de codigo.
            Se lee como: "a 'empleado', lo convirtio a '(Gerente) empleado', y de eso convertido '((Gerente) empleado).'
            llamo al metodo*/

        } else if (empleado instanceof Empleado) {
            System.out.println("Es de tipo Empleado");
            //Cuando es del tipo empleado, puedo acceder a sus metodos:
            System.out.println("empleado = " + empleado.getNombre());
            //Pero no puedo convertirlo a la clase hija, o usar los metodos de la misma:
//            Gerente gerente = (Gerente) empleado; // El error lo marca en tiempo de ejecucion
//            System.out.println("gerente = " + gerente.getDepartamento()); // Error
        } else if (empleado instanceof Object) {
            System.out.println("Es de tipo Object");
            //Y si directamente solo es de tipo Object, desde ya que no puedo acceder mas
            //que a los metodos propios de object, como .toString, pero no a lo de las clases padre o hija
            empleado.toString();
        }

    }
}
