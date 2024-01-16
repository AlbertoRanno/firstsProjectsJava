package test;

import domain.*;

public class TestSobreescritura {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Ximena", 300000);
//        System.out.println("empleado = " + empleado.mostrarDetalles());
        imprimir(empleado);

        Gerente gerente = new Gerente("Roberto", 400000, "Sistemas");
//        System.out.println("gerente = " + gerente.mostrarDetalles());
        imprimir(gerente);

    }

    /*En el siguiente metodo esta la gracia de Polimorfismo:
    
    La idea del mismo es lograr metodos mas genericos.
    Si veo los soutv previos, es más evidente que en el primero, se llama al metodo mostrarDetalles de 
    la clase empleado, y en el 2do, al metodo de la clase hija, el cual esta sobreescrito, para agregar
    el atributo departamento.
    
    Si las impresiones las quisiera derivar a un metodo a parte, podria pensar que necesito 2 metodos distintos,
    pero No, he aqui la gracia de poliformismo, que permite, en tiempo de ejecucion (no lo veo en codigo),
    decidir, en base a la referencia del objeto (uno es del tipo Empleado, y el otro del tipo Gerente),
    cual metodo usa en casa caso.
    
    Nota1: en el siguiente codigo, notar que como parametro, paso el tipo de dato de la clase padre,
    porque es el que abarca a ambas clases
    
    Nota2: notar que, a raiz de Nota1, en la linea 11, podria reemplazar "Gerente gerente", por la variable
    'empleado' de la definicion anterior, dado que es del mismo tipo, y ahorro definir un nueva variable: 
    empleado = new Gerente("Roberto", 400000, "Sistemas");
    imprimir(empleado);
    
    Nota3: notar que la variable "empleado" que se encuentra debajo, es una variable local a este metodo,
    que NADA tiene que ver con la variable empleado de las primeras lineas. Solo que es una buena practica
    llamar a los objetos, como las clases, pero en minuscula.
     */
    public static void imprimir(Empleado empleado) {
        System.out.println("empleado = " + empleado.mostrarDetalles());
    }
}
