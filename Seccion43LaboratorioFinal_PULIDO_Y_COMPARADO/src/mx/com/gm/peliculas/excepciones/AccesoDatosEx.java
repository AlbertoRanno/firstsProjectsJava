package mx.com.gm.peliculas.excepciones;

public class AccesoDatosEx extends Exception {

    /*Esta es la clase padre propuesta para mi propio manejo de errores. 
    Es para aquellos que no son especificos de Lectura o Escritura (para eso estarán las hijas).
    Por ser la clase padre, y como quiero que el ide la tome como una clase de error, extiende de Exception.
    Y de Exception, y No RuntimeException, para que asi me obligue a poner los try/catch y ver todos los casos necesarios. 
    
    La idea es Propagar un msj a la clase padre (Exception) => super
    Genero su constructor:  */
    public AccesoDatosEx(String mensaje) {
        super(mensaje);
    }
}

/*Proyecto divido en paquetes/capas de forma ideal:
-excepciones, por un lado. Fue solo extender el padre a (Exception o RuntimeException), y las hijas a su padre
-*/