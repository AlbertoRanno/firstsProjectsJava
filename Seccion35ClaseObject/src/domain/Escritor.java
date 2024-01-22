package domain;

public class Escritor extends Empleado {

    private final TipoEscritura tipoEscritura;

    public Escritor(String nombre, double sueldo, TipoEscritura tipoEscritura) {
        super(nombre, sueldo);
        this.tipoEscritura = tipoEscritura;
    }

    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + ", tipo de escritura: " + this.tipoEscritura.getDescripcion();
    }

    public TipoEscritura getTipoEscritura() {
        return this.tipoEscritura;
    }
    
    
}
