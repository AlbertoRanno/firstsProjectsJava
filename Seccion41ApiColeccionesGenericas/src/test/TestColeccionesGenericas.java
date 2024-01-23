package test;

import java.util.*;

public class TestColeccionesGenericas {

    /*Todo el Api de collections, soporta el tipo generics, así que puedo cambiar la sintaxis: */
    public static void main(String[] args) {
//        List miLista = new ArrayList(); 
        List<String> miLista = new ArrayList<>(); //Añado <String> a izquierda... a derecha no hace falta ... <> == <mismoTipo>
        /*AHora al hacer '.add' ya no figura 'tipo object' sino 'tipo String'
        Esto evita errores, dado que a priori, el ide no hubiese marcado error, 
        si agregaba un Integer, un boolean, un object, o cualquier cosa... ahora, a priori, solo el <tipo> indicado
        Es decir, añade validaciones al agregar los elementos*/
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");

        /*Y tambien va a añadir validaciones al momento de recuperarlos, dado que no hará falta las conversiones de tipo
        String elemento = (String) miLista.get(0); */
        String elemento = miLista.get(0);
        //System.out.println("elemento = " + elemento);
        //imprimir(miLista);

        /*AHora convierto el set a generic:*/
        Set<String> miSet = new HashSet<>(); //Solo cambio esto, el metodo imprimir sirve el mismo
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        //imprimir(miSet);

        //Ahora convierto el Map a generic: indicando el tipo para la llave y el tipo para el valor, de forma separada!
        Map<String, String> miMapa = new HashMap<>(); //y ya está, no hace falta cambiar el tipo como antes (*1)
        miMapa.put("valor1", "Lunes");
        miMapa.put("valor2", "Martes");
        miMapa.put("valor3", "Miercoles");
        miMapa.put("valor4", "Jueves");
        miMapa.put("valor5", "Viernes"); 
        miMapa.put("valor5", "Sábado"); //importante! si repito la clave, con otro valor, se sobreescribe por el último
        //Eso porque las llaves se manejan por Set, y Set no admite valores duplicados!
        
        imprimir(miMapa.keySet());
        imprimir(miMapa.values());

        //(*1)
        //  String elementoMapa = (String) miMapa.get("valor1");
        String elementoMapa = miMapa.get("valor1");
        System.out.println("elementoMapa = " + elementoMapa);
        
    }

    //Esto cambia ahora , de  public static void imprimir(Collection coleccion) a
    public static void imprimir(Collection<String> coleccion) {
        //o podria ser: public static void imprimir(Collection<Object> coleccion)
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
        /*Observacion, al cambiar los tipos, cambian los metodos a los que tengo acceso, por ejemplo, al
        pasar a un tipo String puedo ver:  System.out.println("elemento = " + elemento.concat(elemento));
        Si fuera en lugar de String, un Object:     elemento.toString()...  
        
        Ergo, al hacerlo de manera generica, evito errores de tipo (validaciones), y evito cambios de tipo
        innecesarios, tanto en entrada, como en salida de datos*/

    }

}
