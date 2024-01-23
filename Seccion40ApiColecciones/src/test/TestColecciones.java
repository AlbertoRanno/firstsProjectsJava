package test;

import java.util.*;

public class TestColecciones {

    /*Dentro del paquete java.util, tengo varias interfaces:
    
    *Por un lado, Collection, es la interfaz padre. De ella heredan la interfaz List y la interfaz Set
    Para List, la clase que la implementa es ArrayList
    Para Set, la clase que la implementa es HashSet
    List, puede guardar cualquier tipo de dato (object), conserva el orden de carga y guarda duplicados.
    Set, puede guardar cualquiert tipo de dato (object), NO conserva el orden (pero es mas rapido), NO guarda duplicados
    
    *Por otro lado, Map, es la interfaz padre.
    La clase que la implementa es HashMap
    Map, maneja el concepto de clave-valor (hay que indicar en que llave,o clave, se guarda cada valor. Y lo mismo
    para recuperarlo)   
    
    *En todos los casos, la mejor practica es la de tomar por variable a las clases/interfaces padres
    o mejor dicho en este caso, la clase, que implementa la interface, se guarda en la interface    */
    public static void main(String[] args) {
        List miLista = new ArrayList();
        //Ventaja: crecen dinamicamente, no necesito indicar a priori la cantidad de elementos
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        //EL metodo add, se hereda de collection, por lo que tambien lo tiene Set

        /*
        //Forma clasica de imprimirlo:
        for (Object elemento : miLista) {
            System.out.println("elemento = " + elemento);
        }
        
        //Forma con funcion flecha (o lambda):
        miLista.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
         */
        imprimir(miLista);

        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");

        imprimir(miSet);

        Map miMapa = new HashMap();
        miMapa.put("valor1", "Lunes");
        //Aca no es 'add' porque hereda de la interfaz Map y no de Collection
        //Y la forma, es ...put( clave(cualquierObjeto), valor);
        miMapa.put("valor2", "Martes");
        miMapa.put("valor3", "Miercoles");
        miMapa.put("valor4", "Jueves");
        miMapa.put("valor5", "Viernes");
        /*imprimir(miMapa);//no puedo utilizar el metodo imprimir, porque Map es una interfaz distinta a Collection
        Tampoco sirve:
        miMapa.forEach(elemento->{
            System.out.println("elemento = " + elemento);
        });    
        Sino que se utiliza el metodo get:      */        
        System.out.println(miMapa.get("valor1")); 
        /*Ojo que devuelve un object, y podria necesitar hacer una conversion del tipo: */
        String elemento = (String) miMapa.get("valor2");
        System.out.println("elemento = " + elemento);
        
        //Para imprimir el conjunto de llaves puedo usar el metodo keyset, y dado que es un set: 
        imprimir(miMapa.keySet());
        //Idem para los valores, con el metodo values:
        imprimir(miMapa.values());
        //Notar la concordancia entre las llaves y valores se respecta (si bien no, el orden de ingreso,
        //lo cual es logico por ser un set

    }

    //Siguiendo la regla, recibo el tipo mas generico, en este caso Collection (clase padre de List y Set)
    public static void imprimir(Collection coleccion) {
        coleccion.forEach(elemento -> {
        });
        System.out.println("coleccion = " + coleccion);
    }

}
