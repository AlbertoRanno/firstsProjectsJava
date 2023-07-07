package operaciones;

public class PruebaAritmetica {

    public static void main(String[] args) {
        Aritmetica aritmetica1 = new Aritmetica();
        aritmetica1.a = 3;
        aritmetica1.b = 2;
        aritmetica1.sumar(); //no es necesario soutv dado que ya viene en el metodo
        
        //para utilizar un metodo que regresa un valor, lo mas comun es definir variables de ese tipo, o usar var
        
        var resultado = aritmetica1.sumarConRetorno(); //"var resultado", comenzó como "int resultado", pero conviene var para que se adapte al tipo de cada metodo, por si es que difiere
        System.out.println("resultado desde la prueba = " + resultado);
        /**********IMPORTANTE**********
         Con un punto de ruptura en la linea de la variable resultado, y debugueando, con F7, o el iconito de la flechita hacia abajo
         Entro en el método que acá estoy invocando, pero que se encuentra y desarrolla en otra clase.
         Posando el cursor sobre las variables, puedo ir analizándolo. 
         En esta instancia en consola, veré un "this" que si los despliego tiene los valores de a y b, a esto volverá, es imp!
         con F8, avanzo, y vuelvo a esta clase.
         En consola vere el obj. aritmetica1, recordar de desplegarlos.*/
        
        resultado = aritmetica1.sumarConArgumentos(7, 8);
        System.out.println("resultado usando argumentos = " + resultado);
        
        /* (entendiendo this)
        con un punto de ruptura en resultado, analizo paso a paso,click derecho debug, y con el mouse sobre aritmetica1, 
        veré la direccion de memoria en la que esta almacenado. 
        F7
        Veré que en this, inicialmente a= 3 y b=2, con f8, veré como ambos se actualizan a 7 y 8, 
        luego llama al siguiente metodo, ahi tambien puedo entrar con F7
        ...y luego retorna el resultado
        
       */
        
        
        /*Retomo aqui, luego de constructores:*/
        Aritmetica aritmetica2 = new Aritmetica(); 
        System.out.println("aritmetica2 a = " + aritmetica2.a);
        System.out.println("aritmetica2 b = " + aritmetica2.b);
        /*IMPORTANTE: En la otra clase, no hacía falta llamar al constructor vacío, cuando era el único que usamos.
        Pero siendo que ya esta el otro constructor, el vacio debe estar, sino llamarlo, da error*/
        
        Aritmetica aritmetica3 = new Aritmetica(5,8);
        System.out.println("aritmetica3 a = " + aritmetica3.a);
        System.out.println("aritmetica3 b = " + aritmetica3.b);
        
        /*Seccion 11 - Alcance de Variables
        en lugar de pasar 5 y 8, como parametros, creo 2 variables locales (viven solo dentro del metodo donde se crean)
        VAR solo puede utilizarse con variable locales - NO para atributos de clases
        siempre que trabaje con atributos de la clase, poner los this, para que quede claro*/
        
        //variables locales
        var a = 10;
        var b = 2;
        miMetodo();
        /*Con pto. rup. en var a, veo, avanzando con F8, que se van creando las variables, pero que, si entro con
        F7 en miMetodo, las mismas ya no existen
        
        IMPORTANTE: AHÍ RADICA UNA DIFERENCIA PRINCIPAL CON LOS ATRIBUTOS DE LA CLASE, A LOS CUALES LLEGO DESDE
        CUALQUIER METODO - SU ALCANCE ES A NIVEL DE LA CLASE*/
    }
    
    public static void miMetodo(){ //sin static, no puede ser llamado por otro static // el orden de static - void, no importa
        //la variable "a" esta fuera del alcance donde fue definida
        System.out.println("otro metodo");
    }
    
    
    /* Seccion 58 - Memoria Stack y Heap en Java
    REsumen:
    2 tipos de variables:
    -las variables locales, definidas dentro de un metodo, las cuales se crean y terminan dentro del mismo
    -las variables tipo Object, estas se van a destruir solo cuando termine la ejecucion completa del programa
    (y no solo cuando termine la ejecucion del metodo donde fue creado el objeto, dados que esos objetos van
    a permanecer en otro lado de la memoria. Es el recolector de basura, el que se encarga de elimnarlos:
    System.gc() // gc de Garbage Collector
    con esa linea de codigo se programa al recolector para que se ejecute y libere a todos los objetos que ya 
    no estan siendo utilizados en nuestro programa.
    Si, a un objecto, que ya lo tenia definido, como aritmetica1, por ej, lo actualizo a null:
    aritmetica1 = null;
    System.gc();
    con esto lo vuelvo candidato a que el gc, se lo lleve de la memoria Heap
    SIn embargo el llamarlo ahí, no significa que sea inmediato, sino que lo va a llamar cuando sea posible,
    dado que es un programa bastante pesado, y no lo podemos llamar simplemente cuando quiera. Por lo tanto, 
    si bien existe, no se usa, y los programadores avanzados usan otras formas.
    TAmpoco es comun que cuando terminemos el metodo, le asignemos a las variables el valor de null)
    -Todas las variables locales se guardan en una parte de la memoria que se llama STACK <- IMPORTANTE
        ej. var a = 10; //  var b = 2; (memoria STACK)
    -al utilizar un constructor, se le asigna, a la variable (ej p1), una referencia a la memoria (ej 0x333)
        ej. Persona p1 = new Persona(); (memoria HEAP)
    pero este objeto, se crea en la memoria HEAP <- IMPORTANTE    
    */
    
    
    /*Seccion 11. 59 - Laboratorio - Proyecto caja */
}
