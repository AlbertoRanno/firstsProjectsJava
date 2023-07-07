package Caja;

public class Caja {

    /*Se solicita crear una clase llamada Caja con las siguientes características:
    • Debe tener 3 atributos de tipo entero (ancho, alto y profundo)
    • Debe tener 2 constructores, uno vacío y uno con 3 argumentos, uno
    por cada atributo de la clase.
    • Debe tener el método que calcule el volumen de la caja según la
    formula de la lámina anterior.
    • Crear una clase de prueba para crear un objeto de tipo caja que tenga
    como valores: ancho=3, alto= 2, profundo = 6 y que mande a imprimir
    el volumen de la caja según los valores proporcionados
    anteriormente*/
    
    //Atributos
    int ancho, alto, profundo;

    //Constructores
    public Caja() { 
        System.out.println("Ejecutando constructor");
    }

    public Caja(int ancho, int alto, int profundo) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
        System.out.println("Ejecutando constructor con argumentos");
    }

    //Metodos - OJO con los nombres de los metodos! empiezan con minuscula, y por lo gral, definen una accion!
    public int calcularVolumen() {
        return ancho * alto * profundo;
    }
    
    public void mostrarVolumen(){ //Prueba particular por duda... // tuvo que ir sin STATIC, que me aporta ponerle STATIC??
        System.out.println("Volumen = " + this.ancho * this.alto * this.profundo);
    }
}
