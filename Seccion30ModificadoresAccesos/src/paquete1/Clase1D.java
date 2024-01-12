package paquete1;

class Clase1D { //no se puede usar fuera de este paquete
    String atributoDefault = "Valor atributo default";
    
    Clase1D(){
        System.out.println("Constructor default");
    }
        
    void metodoDefault(){
        System.out.println("Metodo default");
    }
}
