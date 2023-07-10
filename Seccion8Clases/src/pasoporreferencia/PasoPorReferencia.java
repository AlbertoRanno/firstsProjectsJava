package pasoporreferencia;

import clases.Persona;

public class PasoPorReferencia {

    public static void main(String[] args) {
        /*AHora, para trabajar con la clase Persona, dado que se encuentra en otro paquete, la tengo que importar,
        como hice con la clase Scanner, con la siguiente linea, y tocando en el iconito que aparece al lado del
        numero de linea*/
        Persona persona1 = new Persona();
        /*Estas variables van a almacenar referencias a los objetos, a diferencia de un tipo primitivo, que almacena
        un valor, pero no almacena referencias
            Si ahora quisiera definir nuevos valores para los atributos de la clase persona, No puedo acceder, porque
        los atributos no estaban como publicos, por lo que voy a la clase y les agrego "public String nombre;..."
            OJO - ESTO NO ES BUENA PRACTICA!!, solo lo hago para poner a prueba lo del paso por referencia!! 
        */
        persona1.nombre = "Mariana";
        System.out.println("persona1.nombre = " + persona1.nombre);
        
        cambiarValor(persona1);  //recordar que esta almacenando la referencia del objeto creado en la linea 11
                                       // Ej 0x333 
        System.out.println("persona1.nombre cambio? SI!! = " + persona1.nombre);
    }
                                      //Acá tambien 0x333!!  
                                      //Por lo tanto aqui tmb recibira la referencia que almacena la variable persona1  
    public static void cambiarValor(Persona persona){ //Persona, es el tipo de la clase, y persona, la variable, Respetar Mayúsculas!
            //IMPORTANTE!!!!!         //por lo tanto, persona1, y persona, estan apuntando/referenciando al mismo objeto 
                                      //ENTONCES LO CAMBIA!!!
        persona.nombre = "Karla";                              
    }
}

/*A esto se lo conoce tambien como PASO POR VALOR POR REFERNCIA - LO IMPORTANTE ES QUE SE PUEDEN MODIFICAR LOS OBJETOS

Siguiente, seccion 13*/
