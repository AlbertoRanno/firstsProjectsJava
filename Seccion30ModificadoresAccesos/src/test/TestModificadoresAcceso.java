package test;

import paquete1.Clase1;
import paquete1.Clase1P;
//import paquete1.Clase1Private;
import paquete1.Clase1PrivateHija;
import paquete2.Clase1PHija;

public class TestModificadoresAcceso {

    public static void main(String[] args) {

        //Prueba Clase1 (todo publico)
        Clase1 clase1 = new Clase1(); //Pude utilizarla, porque Clase1 es publica y se puede utilizar desde cualquier otra clase
        //Pude crear un objeto de esta clase, gracias a que el constructor es publico 
        System.out.println("clase1 = " + clase1.atributoPublico); //Acceso al atributo porque es publico
        clase1.metodoPublico(); //Acceso al metodo publico

        /*Ergo, public permite acceder a Clases, Contructores, Atributos, y Metodos
        Es el menos restrictivo. Le sigue 'protected'
        Protected, No es aplicable a clases =>No!  protected class Clase1 {  */
        //Prueba CLase1P (clase publica - Constructor, Atributos y Metodos Protected
        /*  No se pueden utilizar si no extiendo la clase, es decir, solo se pueden usar en clases Hijas
        Clase1P clase1P = new Clase1P();
        System.out.println("clase1 = " + clase1P.atributoProtected);
        clase1.metodoProtected();   */
        Clase1P clase1P = new Clase1P("Publico"); //utilizo el constructor publico, con cualquier argumento
        /*Para ver este caso, defino una clase hija    . Sabiendo que es lo que sucede si estuviera dentro del paquete1,
         la voy a crear fuera a ver que pasa*/

        System.out.println("");
        System.out.println("Prueba clase Hija en paquete aparte:");
        Clase1PHija clase1PHija1 = new Clase1PHija();
        System.out.println("clase1PHija1 = " + clase1PHija1);
        
        /*Ergo, protected, permite acceder a Contructores (mediante super), Atributos, y Metodos a sus clases Hijas
        esten en el mismo paquete o no*/

        /*AHora modificador de acceso: DEfault o Package
        Lo que significa es ausencia del modificador
        Nota: solo va a poder ser utilizada dentro del mismo paquete
        Nota1: una clase Default, no puede tener hijos fuera del paquete
        
        *Ergo, default, permite acceder a Contructores (mediante super), Atributos, y Metodos a sus clases Hijas, siempre
        que esten dentro del mismo paquete
        
        Ahora modificador de acceso: Private     
        NOTA: SI no es publica, no puede ser accedida fuera del paquete!
        //Clase1Private clase1Private1 = new Clase1Private("Publico"); // No se puede
        
        Ergo, Private, permite acceder a Contructores, Atributos, y Metodos solo dentro de la misma clase
        Fuera del paquete, nada.
        Dentro del paquete, a los hijos, pueden acceder al constructor privado, si se usa el artilugio de crear
        un constructor publico, dentro de la clase, el cual mediante 'this()' llame al constructor privado. 
        Para poder crear este contructor publico, hay que distinguirlo, por lo que se le suele pasar el paramentro
        generico: String argumento. ENtonces, en la clase hija, se lo llama, con un argumento dentro de super:
        public Clase1PrivateHija() {
            super("Publico");}
        La Clase test, debe estar en el mismo paquete, 
        Al igual que los hijos, deben usar el constructor publico con argumentos
        Se usan los metodos set y get para los atributos
        Los metodos privados, no se acceden fuera de la clase
        */
        
    }
}
