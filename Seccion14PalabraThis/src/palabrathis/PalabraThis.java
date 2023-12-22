package palabrathis; //Nomenclatura paquetes, todo en minuscula! sin guiones ni nada . los puntos crean subpaquetes

public class PalabraThis { //Solo una clase por archivo puede ser de tipo publico

    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Perez"); //(*2) por lo cual hay que pasar valores
        System.out.println("persona = " + persona);
        System.out.println("persona nombre " + persona.nombre);
        System.out.println("persona apellido " + persona.apellido);

    }
}

class Persona { //al omitir public, es "default" o "package".
    //Y significa que solo podremos acceder desde otras Clases definidas dentro del mismo paquete

    //Atributos
    String nombre;
    String apellido;

    //Constructor - Recordar que al declarar este, el vacío ya No viene por default (*1)
    Persona(String nombre, String apellido) {
        //super(); (*3) el constructor vacío de la clase padre, osea de la clase "Object", es quien
        // se encarga de reservar el espacio en memoria. Por eso es la primera y mas importante, 
        // si bien es una llamada implícita
        this.nombre = nombre;
        this.apellido = apellido;
        System.out.println("objeto persona usando this: " + this); //(*4)
       // Imprimir imprimir = new Imprimir(); - RETOMAR DESDE ACA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       // Imprimir imprimir().imprimir(this)
    }
    
    /*Falta ver mejor Herencia aun... pero, notar que:
    - control + click en Persona, y veo "class Persona extends Object"
    - es decir que hereda las propiedades de su clase padre, en este caso Object
    - Object es la clase padre, de TODAS las clases en JAVA
    - y, aunque No lo veamos, hay una llamada al constructor de la clase padre (*3) 
    - Es por eso que this (*4), ya sabe cual es el espacio asignado en memoria */
}

class Imprimir {
    public void imprimir (Persona persona){
        System.out.println("persona desde imprimir: " + persona);
        System.out.println("impresion del objeto actual (this)" + this);
    }
}
