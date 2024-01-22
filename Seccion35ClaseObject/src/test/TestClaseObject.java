package test;

import domain.Empleado;

public class TestClaseObject {

    public static void main(String[] args) {
        //Voy a comparar 2 objetos, utilizando los metodos que tiene por default la clase object
        Empleado empleado1 = new Empleado("Juan", 5000);
        Empleado empleado2 = new Empleado("Juan", 5000);

        //Comparo referencias:
        if (empleado1 == empleado2) {
            System.out.println("Tienen la misma referencia en memoria (No necesariamente en contenido)");
        } else {
            System.out.println("Tienen diferente referencia en memoria");
        }

        /*Comparo contenido:
        Para eso, necesito utilizar los metodos Equals, o hashCode. Ambos los puedo agregar en la clase padre,
        mediante la ayuda del IDE, el cual, por buenas practicas (sino traerá errores en otras cosas), a priori
        recomienda agregar ambos, con los mismos componentes para los 2
        
        hashCode:
        En base a los atributos del objeto, le asigna un valor entero, tratando de que sea único para cada clase,
        aunque podría darse, posible, pero no probable, de que con distintos atributos, llegue al mismo valor...
        
        equals:
        Hace varias comparaciones: 
        -(this = obj), si ambas referencias en memoria son iguales, ambos objetos son iguales
        - lo compara con null, si es verdadero, entonces los objetos son distintos (porque this (1era comparacion)
        es distinto a nulo, entonces, si el objeto 'obj' es nulo, no son los mismos
        -si el tipo de la clase son diferentes, entonces no son los mismos 
        -si se llego al 4to, es porque es de la misma clase, hago un cast para pasarlo a la clase hija, y comparo
        los atributos, si son distintos, no son el mismo objeto
        -ultimo if, compara el atributo nombre mediante equals, si son distintos, entonces false...
        sino, finalmente corrobora que es verdadero, es decir que son el mismo objeto*/
        if (empleado1.equals(empleado2)) {
            System.out.println("Los objetos son iguales en contenido");
        } else {
            System.out.println("Los objetos son distintos en contenido");
        }

        //Si equals devuelve verdadero, hashCode debe devolver el mismo valor para ambos objetos
        if (empleado1.hashCode() == empleado2.hashCode()) {
            System.out.println("el valor de hashCode es igual");
        } else {
            System.out.println("el valor de hashCode es distinto");
        }
        
        //Obs, con solo cambiar "Juan", por "juan", los objetos tendrán distinto contenido
        
        //OBS IMPORTANTE! Para cuando empieces a usar los frameworks, acostumbrate a dejar las clases ya con estos metodos
        //porque los van a usar de forma automatica

    }

}
