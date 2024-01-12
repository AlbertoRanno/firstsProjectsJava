package paquete1;

public class Clase1PrivateHija extends Clase1Private {

    /*NO Accede al constructor, metodos, y atributos de la clase padre, por MAS que este en el mismo paquete, y sea HIJA*/
//    public Clase1PrivateHija() {
//        super(); 
//        this.atributoPrivate = "No accedo al atributo private de la clase padre";
//        System.out.println("atributoPrivate = " + atributoPrivate);
//        this.metodoPrivate();
//     }
    // Si a la clase padre, le pongo un constructor publico, que derive desde alli al privado, puedo acceder:
    public Clase1PrivateHija() {
        super("Publico");
//Le tengo que poner cualquier String de argumento, para que reconozca que quiero usar el publico
    }
    
    

}
