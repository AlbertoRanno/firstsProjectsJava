package mx.com.globalmentoring;

/* Los nombre de los paquetes, por lo gral, son los nombre del dominio de nuestra app, pero escritos de forma inversa.
intranet.com.ar... tendría por paquete: ar.com.intranet
donde cada "." lo que hace es crear un subpaquete, o carpeta
 */
//public final class Utileria { //Con la palabra "final", en una clase, ninguna otra puede heredarla con "extends"...
public class Utileria {

    //final, en atributos:
    /*Un atributo, marcado como final, generalmente se convina con static, para hacer las famosas CONSTANTES
    public final static  = CONSTANTE 
    ojo a la sintaxis:*/
    public final static int MI_CONSTANTE = 1;

//Atributo privado:
    private String nombre;
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void imprimir(String s) {
        System.out.println("s = " + s);
    }

    public final void imprimir() {
        //Con la palabra "final en el metodo, el mismo no se puede sobreescribir desde las clases hijas        
        System.out.println("Mensaje Original");
    }

    
}
