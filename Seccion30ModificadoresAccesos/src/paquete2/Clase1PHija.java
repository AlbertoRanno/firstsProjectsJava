package paquete2;

import paquete1.Clase1P;

/*A los atributos, contructores y metodos protegidos de una clase padre, puedo acceder desde una clase hija,
por mas que esta se encuentre en otro paquete*/

public class Clase1PHija extends Clase1P {
    
    public Clase1PHija(){
    super(); //llamo al constructor protegido de la clase padre
    this.atributoProtected = "Modificacion atributo protected de la clase padre";
        System.out.println("atributoProtected = " + atributoProtected);
    this.metodoProtected(); //llamo al metodo protegido
    }
    
    
}
