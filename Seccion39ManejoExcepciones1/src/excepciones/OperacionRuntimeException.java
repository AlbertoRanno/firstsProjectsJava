package excepciones;

/*La otra version, extiendo de runtime...*/
public class OperacionRuntimeException extends RuntimeException {

    public OperacionRuntimeException(String mensaje) {
        super(mensaje);
    }
}

//Notar que respecto a la otra clase de Excepcion, no cambia mas que de donde extiende... 
//Lo que si cambia es como la llamo
