package clases;

public class PruebaPersona {

    public static void main(String[] args) {
        //sin el main, no se puede ejecutar la prueba

        //creo el objeto - Defino variable
        Persona persona1; // El nombre del tipo, es el nombre de la clase
        persona1 = new Persona(); //aca se esta llamando al constructor.. luego ampliara...
        //esto permite reservar memoria, ya que las variables se almacenan en una parte de la memoria, y los objetos, en otra
        //una vez que se crea este objeto en memoria, entonces lo que sucede es que regresa la referencia donde se ha creado este objeto en memoria 
        //y esa referencia se le asigna a la variable llamada persona1
        //una vez que cuente con esta linea "persona1 = new Persona()" puedo acceder a los atributos y metodos creados en memoria. Para ello:
        //persona1.   - y vere los mismos. Puedo modificarlo mediante:
        persona1.nombre = "Juan";
        persona1.apellido = "Perez";
        persona1.desplegarInformacion(); // accedo al nombre y apellido

        /* Hasta aca, declaraba una variable "Persona p1;" , y reservaba su espacio en memoria. Pero esta es una variable local al metodo main, se declara en este metodo,
        y una vez que termina el metodo main, se destruye esta variable.
        En cambio, cuando defino una variable, pero que ademas le asigno una referencia de un objeto, me reserva en memoria una espacio para los atributos y metodos
        Persona p2 = new Persona(); 
        el contructor + new (siempre juntos), no se puede llamar al constructor en otro lugar
        la referencia en memoria Ram, sera un valor hexadecimal, del estilo 0x333 (los valores hexadecimales en java, comienza en cero X, que se asigna a la variable p2
        al poder acceder a los atributos puedo mostrarlos o modificarlos
         */
        Persona persona2 = new Persona(); //creo un nuevo objeto y referencia memoria
        //paquete.clase@referenciaDeMemoria
        System.out.println("persona1 = " + persona1);   //clases.Persona@5305068a 
        System.out.println("persona2 = " + persona2);   //clases.Persona@1f32e575

        persona2.desplegarInformacion();                //Da null, porque aun no defini sus nombres, por lo que esta vacio, y el default del string, es null

        //Los obj. no comparten informacion, sino las caracteristicas que se han definido en la clase
        //Cada obj. es distinto. Por eso se conocen como instancias
        persona2.nombre = "Karla";
        persona2.apellido = "Lara";

        persona2.desplegarInformacion();
        
        //Proxima Seccion 9

    }

}
