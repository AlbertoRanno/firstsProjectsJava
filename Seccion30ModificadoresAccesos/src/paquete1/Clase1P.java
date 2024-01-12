package paquete1;

public class Clase1P { //no se puede hacer protected a la clase
    protected String atributoProtected = "Valor atributo protected";
    
    protected Clase1P(){
        System.out.println("Constructor protected");
    }
    
    public Clase1P(String argumento){
        System.out.println("Constructor publico");
    }
    
    protected void metodoProtected(){
        System.out.println("Metodo protected");
    }
}
