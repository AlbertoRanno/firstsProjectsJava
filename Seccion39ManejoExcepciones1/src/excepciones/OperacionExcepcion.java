package excepciones;

/*Creo mi propia clase de Excepcion, pero para que el compilador la tome como una, tiene 
que descender de alguna de las clases nombradas ( Exception, RuntimeException..)    */
public class OperacionExcepcion extends Exception { //COn Exception, me obliga al try/catch
    //Propago un msj a la clase padre=> super

    public OperacionExcepcion(String mensaje) {
        super(mensaje);
    }

}
