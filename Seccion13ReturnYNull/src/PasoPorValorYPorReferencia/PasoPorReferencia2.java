package PasoPorValorYPorReferencia;

public class PasoPorReferencia2 {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Alfi";
        persona1.desplegarInfo();

        cambiarValor(persona1);
        System.out.println("persona1 cambió de nombre a: " + persona1.nombre);
        
        persona1 = cambiarValorObjeto(persona1);
        System.out.println("persona1 = " + persona1 + "\n Nombre: " + persona1.nombre);
    }

    public static void cambiarValor(Persona persona) { 
        persona.nombre = "Karla"; //Notar que NO es necesario retornar el objeto, solo cambio el valor de su atributo
        //la palabra RETURN siempre está presente, si No se ve, es porque en los metodos VOID, esta oculta,
        //pero es como si tuviera:
        // return; 
        //y eso le vuelve a otorgar el control a la linea que llamó a este metodo.
    }
    
    //En caso que SI fuera necesario retornar un objeto:
    
    public static Persona cambiarValorObjeto (Persona persona){
        persona.nombre = "Joaquín";
        return persona; // vuelvo a regresar la misma referencia del objeto
        
        //Al igual que en JS, todo metodo tiene que tener un return. Con VOID, es implicito.
        //Y podria tener más de uno, si pongo condicionales.
    }

}

class Persona {

    String nombre;

    public void desplegarInfo() {
        System.out.println("nombre = " + nombre);
    }
}
