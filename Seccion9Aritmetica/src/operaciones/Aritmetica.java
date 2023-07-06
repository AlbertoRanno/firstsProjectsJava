package operaciones;

public class Aritmetica {
    /*Atributos de la clase*/
    int a; //Por default 0
    int b;
    
    /*Seccion 10 - Constructores
    Esto lo sume despues de los 3 , metodos y this
    Un constructor se puede utilizar para crear objetos, sin valores iniciales, ejemplo new Aritmetica().
    O, se pueden pasar, utilizando distintas configuraciones de valores iniciales, ej, Aritmetica(10,7) */
    
    //Constructor vacio - Public, para que se acceda de otra clase - Se llaman igual que la clase, y NO regresan ningun tipo de dato, ni void
    public Aritmetica(){
        System.out.println("Ejecutando constructor"); // veo que se ejecuta al comienzo de todo (cuando corro la clase de prueba)
        // a = 0; No hace falta, de hecho no se hace, porque JAVA les agrega los valores por default
        // b = 0;  Debugueando la linea "Aritmetica aritmetica1 = new Aritmetica();" de Prueba, veré esta asignacion por default  
        // Al llamar al constructor vacio, se espera que nosotros le carguemos los valores posteriomente, sino podemos llamar un 2do constructor:
    };
    
    /* Sobrecarga de constructores, agregar 1 o mas contructores */
    public Aritmetica(int a, int b){ //Obs! No esta permitido usar VAR en los arg de los metodos
        this.a = a; // IMPORTANTE!! - OJO DE HACER a = a xq estaria asignando al argumento, al mismo argumento (los veré del mismo color)
        this.b = b; // IMPORTANTE!! - HACER CTRL + CLICK en cada uno, para ver bien que uno es un atributo y el otro una variable
        System.out.println("Ejecutando constructor con argumentos");
        //COn este constructor, ya puedo crear objetos que directamente tengan un valor inicial distinto del default
    }
    
    
    //Método - inician con minúscula
    public void sumar(){
        /* Aqui dentro es el cuerpo de la clase - Y las variables que se crean acá, se destruyen al terminar de ejecutarse el metodo*/
        int resultado = a + b;
        System.out.println("resultado = " + resultado);
        /***********IMPORTANTE***********
        Mandar información a consola, NO ES LO MISMO que regresar un valor
        tener presente que lo definimos como metodo VOID (en ingles significa vacio)*/
    }
    
    public int sumarConRetorno(){ // se cambia el void por un tipo
       // int resultado = a + b;
       // return resultado;
       return a + b; //cualquiera de las 2 formas es valida mientras solo se retorne un valor. Sabemos que la suma va a regresar un INT
       //Teniendo presente que ese valor puede ser una lista, la cual puede tener multiples elementos pero de manera interna
        
    }
    
    //"modificador de acceso"(public)                              
    //"tipo de retorno" (int)
    //"nombre del metodo" (sumarConArgumentos)
    //"Argumentos"(int arg1, int arg2) - (eso, cuando estan aca, en la definicion, sino para involcarlos, "Parametros", pero nadie es tan tecnico, y todos los suelen llamar igual...
    public int sumarConArgumentos(int arg1, int arg2){
        //ya no utilizaría el valor de a y b que fue dado en los atributos, sino que lo modifico:
        a = arg1; 
        b = arg2;
        //return a + b; //aqui se podria llamar tmb al metodo sumarConRetorno, para no repetir este a+b, pero dado que es muy simple...
        return sumarConRetorno(); //al llamar a este metodo, el mismo tomara los valores que aqui puse como argumentos
        //luego de actualizar aca, guardar cambios para poder acceder desde otra clase
        
        //Este metodo modifico los atributos de nuestra clase de manera interna, lo cual no es un practica comun, ya que se suelen usar los contructores para ello.
        
        //Al momento de ejecturarse un objeto se crea de manera automatica la variable "this" (palabra reservada) Apuntando justamente a ese objeto
    
        /*conociendo esto, podria poner:
        this.a = arg1; // "El argumento "arg1", que bien podria haberse llamado tambien "a", se asigna al atributo this.a
        this.b = arg2;
        this.sumarConRetorno();
        si bien es opcional, da el plus de saber que estoy trabajando con atributos de mi clase, y No con variables locales
        Logicamente this sirve solo dentro de la clase
        Obs! Tmb notar que el IDE, presente en verde el nombre cuando es un atributo de la clase (use o no this)
        
        Convendria llamarlo asi: this.a = arg1;, para que, mas cuando tengo argumentos, no haya confusion
        
        Dentro de un metodo estatico NO Puedo utilizar el operador this! 
        
        */
    }
}
