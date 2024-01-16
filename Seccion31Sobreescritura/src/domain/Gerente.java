package domain;

public class Gerente extends Empleado {

    private String departamento;

    public Gerente(String nombre, double sueldo, String departamento) {
        super(nombre, sueldo);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /*Si corriera el test, sin lo que viene aqui abajo, podria acceder al metodo de la clase padre,
    pero este solo mostraria los atributos para los que fue diseñado, es decir, nombre y sueldo.
    omitiendo departamentos...    
    
    Sobreescribir metodos, hace referencia a lo siguiente:
    Por ser una clase hija, puedo acceder al metodo mostrarDetalles de la clase padre.
    El problema radica, en que ese metodo, asi como esta, no mostraba el atributo de departamento,
    dado que es propio de la clase hija... 
    Por lo que, mediante @Override, le indico al compilador que voy a sobreescribir el metodo,
    mediante "super.mostrarDetalles(), llamo al metodo
    Y finalmente, le concateno, el atributo faltante
    
    Nota: si el metodo de la clase padre, estaba como protected, desde la hija lo puedo sobreescribir,
    con el mismo o menos nivel de proteccion, (protected, default, public), pero no con mas nivel (private)*/
    @Override
    public String mostrarDetalles() {
        return super.mostrarDetalles() + ", departamento: " + this.departamento;

    }

}
