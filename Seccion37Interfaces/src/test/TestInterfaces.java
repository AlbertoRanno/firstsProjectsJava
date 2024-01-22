package test;

import accesodatos.*;

public class TestInterfaces {

    public static void main(String[] args) {
        /*Aqui arranca lo interesante, 
        IDEM clases abstractas, no puedo instanciar una interface:
        IAccesoDatos datos = new IAccesoDatos(); //Da error
        pero puedo crear variables del tipo Interface.
        COn el objetivo, de toda POO, de hacer codigo lo mas generico posible*/
        IAccesoDatos datos = new ImplementacionMySql();
        //System.out.println("datos = " + datos);
        //Por polimorfismo puedo llamar a los metodos que estan en ambos (interface y clase)
//        datos.listar();
        imprimir(datos);

        datos = new ImplementacionOracle(); //Le asigno la referencia a un objeto de otra implementacion
        //System.out.println("datos = " + datos);
//        datos.listar();
        imprimir(datos);

    }

    //Si deseara un metodo generico de impresion:
    public static void imprimir(IAccesoDatos datos) {
        datos.listar();
    }
}
