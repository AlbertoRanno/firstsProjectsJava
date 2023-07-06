package operaciones;

public class PruebaAritmetica {

    public static void main(String[] args) {
        Aritmetica aritmetica1 = new Aritmetica();
        aritmetica1.a = 3;
        aritmetica1.b = 2;
        aritmetica1.sumar(); //no es necesario soutv dado que ya viene en el metodo
        
        //para utilizar un metodo que regresa un valor, lo mas comun es definir variables de ese tipo
        
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
    }
}
