package test;

import domain.*;

public class TestConversionObjetos {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Horacio", 10000);
        System.out.println("empleado = " + empleado.mostrarDetalles());

//         empleado = new Gerente("Joaquin", 20000, "Contabilidad");
//         System.out.println("empleado = " + empleado.mostrarDetalles());
//         /* Por el Polimorfismo, aca esta llamando al metodo mostrarDEtalles, de la clase hija,
//         el cual fue sobreescrito para agregar el departamento*/
        /*Cree una variable de tipo Empleado, esta puede almacenar referencias de objetos
        de clases tipo hija, entonces:*/
        empleado = new Escritor("Carla", 25000, TipoEscritura.MODERNA);
        System.out.println("empleado = " + empleado.mostrarDetalles());
        /* Por el Polimorfismo, aca esta llamando al metodo mostrarDEtalles, de la clase hija,
         el cual fue sobreescrito para agregar el tipo de escritura
         OBS! Notar, que frente al Ctrl+Click deriva al metodo de la clase padre...es decir, recien
         en tiempo de ejecucion recibe la indicacion correcta de a cual apuntar*/

         /*Es decir, desde una variable, de la clase padre, puedo:
            -si completara los toStrings, ver los atributos de la clase padre e hija
            -si los quiero ver mediante los metodos de mostrarDetalles, tambien es posible, dado
            que por el polimorfismo, en el caso de la clase hija, accede al metodo sobreescrito.
            -el problema viene, cuando quiero llamar a un metodo de la clase hija, el cual no esta
            en la clase padre.... por ej: 
             empleado.getTipoEscritura();
            en esos casos, tengo que aplicar una conversion de tipo,
            pasar el objeto 'empleado', del tipo padre, al tipo hijo. Esto se llama DOWNCASTING.
            Y asi podre acceder al metodo deseado:  */
        ((Escritor) empleado).getTipoEscritura(); //DOWNCASTING => Convierto de la clase Padre a Hijo
        System.out.println("empleado = " + ((Escritor) empleado).getTipoEscritura());
        //La forma anterior, es la simplifica de una linea, la clasica seria:
        Escritor escritor = (Escritor) empleado;
        escritor.getTipoEscritura();

        /*SI ahora quisiera convertir una variable del tipo hija, al tipo padre => UPCASTING,
        es mas sencillo, dado que se hace forma automatica:     */
        Empleado empleado2 = escritor;
        //UPCASTING => Convierto de 'empleado' (actualmente tipo Escritor), a 'empleado2' (tipo Empleado - Padre)
        System.out.println("empleado2 = " + empleado2.mostrarDetalles());

    }

}
