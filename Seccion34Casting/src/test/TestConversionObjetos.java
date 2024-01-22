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
        //Notar que al hacer el upcasting, y pasar al tipo padre, vuelve a quedar inaccesible
        //el metodo que es exclusivo del hijo (no esta en el padre como 'mostrarDetalles'):
       // System.out.println("empleado2 = " + empleado2.getTipoEscritura());
        
        /*Ergo,
        -UPCASTING => Convierto de la clase Hijo a Padre, No es necesario hacer una conversion 
        -DOWNCASTING => Convierto de la clase Padre a Hijo, Es necesario hacer una conversion
        
        Es lo mismo que con los tipos primitivos, cuando los tipos soportan mas bytes, no hay que hacer
        ninguna conversion, pero si quisiera guardar algo que ocupa mucho, en un tipo que no tiene capacidad,
        si que hay que hacer una conversion*/
        
        /* Respuestas a dudas:
        
        *empleado2.mostrarDetalles(), la razón por la que muestra el tipo de escritura es que la variable empleado2 
        es en realidad un objeto de tipo Escritor (clase hija), aunque esté declarado como Empleado (clase padre) debido al UPCASTING.
        Esto se debe a que la instancia original era un objeto de la clase Escritor. El método mostrarDetalles() llamado en empleado2 
        ejecuta la versión sobreescrita en la clase hija (Escritor), ya que Java usa el polimorfismo para determinar en tiempo de 
        ejecución qué versión del método debe ejecutarse según el tipo real del objeto.
        
        *UPCASTING: Es cuando conviertes un objeto de una clase hija a un tipo de referencia de la clase padre.
        Empleado empleado2 = escritor; UPCASTING
        No necesitas hacer ninguna conversión explícita, ya que esto se realiza automáticamente de la clase hija a la clase padre.
        
        *DOWNCASTING: Es cuando conviertes un objeto de una clase padre a un tipo de referencia de la clase hija. 
        ((Escritor) empleado).getTipoEscritura(); DOWNCASTIN
        Aquí sí necesitas una conversión explícita, ya que estás pasando de un tipo más general a un tipo más específico. 
        Es importante tener cuidado con el DOWNCASTING, ya que puede generar errores en tiempo de ejecución si el objeto original
        no es realmente una instancia de la clase hija.

        *Polimorfismo en Java:
        El polimorfismo en Java es un principio que permite a un objeto ser tratado como una instancia de su clase base (clase padre)
        o como una instancia de cualquiera de sus clases derivadas (clases hijas). 
        Se puede lograr a través del uso de interfaces, clases abstractas y la capacidad de las clases hijas de sobrescribir 
        los métodos de la clase padre.
        En Java, el polimorfismo se implementa principalmente mediante la herencia y la sobreescritura de métodos.
        Cuando un objeto de una clase hija es referenciado por una variable de la clase padre, se puede acceder a los métodos 
        de la clase hija siempre y cuando esos métodos estén sobreescritos en la clase hija.
        
        *Relación con lo Anterior:
        En el código, se ilustra el polimorfismo mediante el uso de clases Empleado, Escritor, y Gerente. 
        La variable empleado se utiliza para referenciar instancias de estas clases. Cuando se asigna una instancia de 
        Escritor a empleado, y posteriormente se realiza el UPCASTING a Empleado empleado2 = escritor;, 
        estamos aprovechando el polimorfismo. 
        La llamada a empleado2.mostrarDetalles() ejecutará el método sobreescrito en la clase Escritor, ya que el tipo real del 
        objeto es Escritor.
        
        En resumen, el polimorfismo en Java te permite tratar objetos de clases derivadas de manera uniforme, facilitando la 
        flexibilidad y extensibilidad del código.*/

    }

}
