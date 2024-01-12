package paquete1;

public class Clase1DHija extends Clase1D {

    /*Accede al constructor, metodos, y atributos de la clase padre, por estar en el mismo paquete, y ser HIJA*/
    public Clase1DHija() {
        super(); //llamo al constructor DEFAULT de la clase padre
        this.atributoDefault = "Modificacion atributo DEFAULT de la clase padre";
        System.out.println("atributoProtected = " + atributoDefault);
        this.metodoDefault(); //llamo al metodo Default

    }
}
