package clases;

/*si ahora borrara este paquete, como mi clase Persona, esta dentro del mismo, me arrojaria un error, de que guarde la clase en la folder que corresponda.
Antes no salia error porque estaba en el paquete generico, por eso se omitia tmb el nombre del mismo*/

public class Persona {

    /*
    public - para que podamos accederlas desde otros archivos
    class - palabra reservada 
    Nombre - empieza con Mayuscula, y si tiene mas de una palabra => PascalCase 
    
    Diagrama fral de una clase:
    
    (nombre de la clase)
    Persona 
    
    (atributos - se recomienda que los declaremos al inicio de la clase - buena practica
    son caracteristicas que vamos a asociar a la clase)
    -nombre: String
    -genero: char
    -ocupacion: String
    
    (metodos)
    +obtenerNombre(): String
    +obtenerGenero(): String
    +obtenerOcupacion(): String
    +modificarNombre( nombre: String )
    +modificarGenero( genero: String )
    +modificarOcupacion( ocupacion: String )
    
    Las clases sirven para crear objetos
     */
    //Atributos de la clase
    public String nombre;
    public String apellido;

    //Metodos de la clase - codigo que vamos a reutilizar y pueden recibir valores (argumentos), y pueden devolver valores (valores de retorno)
    //public - para saber que lo podemos utilizar desde fuera de esta clase
    //void - para indicar que no regresa ningun tipo de informacion
    //() - para indicar que puede recibir o no info (argumentos)
    //{} - cuerpo del metodo
    public void desplegarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        //Por ser atributos de la clase, y no solo una simple variable, es que podemos acceder a ella sin que este definida dentro de este metodo

        //En window, navigator, abre ventana abajo a la izquiera, que muestra lo que tiene la clase (los metodos, atributos, y un "constructor")
        //EL constructor permitira crear el objeto - click podre ver que es publico, se llama igual a la clase y no recibe argumentos
        //Clase 48 - Como crear un Objeto
        //Una clase es un nuevo tipo definido en Java, por lo que no solo puedo usarlas dentro del proyecto, sino que podre compartir esta clase a otros proyectos
        //Si bien podria crear un metodo main aca, para crear los objetos, es preferible crear otra clase, y que sea la que tenga la prueba dondo vamos a crearlos
    }

    //en el lugar correcto... con psvm, y tabulador creo el metodo main:
    //public static void main(String[] args) {
    //y con click derecho, run file, podria correr la prueba, pero es recomendable hacerlo en otra clase
    //}
}
