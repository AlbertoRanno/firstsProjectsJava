package genericos;

public class ClaseGenerica<T> {

    /*<T> - Un tipo generico, es una especie de comodin. 
    Es decir, no se aclara el tipo de dato que recibe hasta el momento de usar la clase
    Hay distintans letras:
    <E> Element (por lo gral usado por el framework colecciones de Java)
    <K> Key (llave, utilizado en maps)
    <N> Number (utilizado para números)
    <T> Tupe (represente un tipo, es decir, una clase)
    <V> Value (representa un valor, también se usa en maps)
    
    S, U, V, etc... que representan otros tipos
    
    Defino el tipo generico dentro de la clase*/
    private T objeto; //como un atributo que puede ser privado o no...

    public ClaseGenerica(T objeto) { //COnstructor para inicializarlo
        this.objeto = objeto;
    }

    //imprimo el tipo:
    public void obtenerTipo() {
        System.out.println("El tipo T es: " + objeto.getClass().getSimpleName());
    }

}
