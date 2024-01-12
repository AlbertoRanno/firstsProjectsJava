package paquete1;

class Clase1Private { //no se puede usar en clases: private class Clase1Private {.... NO!

    private String atributoPrivado = "Valor atributo privado";
    //Directamente no se puede modificar este atributo desde otra clase, no importa si es Hija, o esta en el mismo paquete
    //Por ello el concepto de encapsulamiento. Debo agregar el metodo get o set para poder leerlo o modificarlo

    private Clase1Private() { //No puedo crear objetos de este tipo fuera de esta clase... **
        System.out.println("Constructor privado");
    }

    /*...**.. la unica forma es, pasando un constructor, con un argumento cualquiera, para distinguirlo,
    que sea publico, y llame a este constructor desde aquí:    */
    public Clase1Private(String argumento) {
        this(); //llama al constructor privado, gracias a este this
        System.out.println("Constructor publico");
    }
    // Gracias a esto puedo llamar al constructor desde la clase hija

    private void metodoPrivado() {
        System.out.println("Metodo privado");
    }

    //Necesarios para leer o modificar la info de los atributos
    public String getAtributoPrivado() {
        return this.atributoPrivado;
    }

    public void setAtributoPrivado(String atributoPrivado) {
        this.atributoPrivado = atributoPrivado;
    }
    
    
}
