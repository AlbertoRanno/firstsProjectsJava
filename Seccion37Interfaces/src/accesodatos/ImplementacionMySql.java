package accesodatos;

/*Ahora es una clase, porque es la implementacion de la interface, para eso uso 'implements' */
public class ImplementacionMySql implements IAccesoDatos {

    /*El ide nos obliga a implementar entonces todos los metodos abstractos de la interface
    Nota la 'i' de implementacion en cada uno de ellos
    A priori, los completa con una excepcion, pero todavia no lo vi en java...  */

    @Override
    public void insertar() {
        System.out.println("insertar desde MySQL");
    }

    @Override
    public void listar() {
        System.out.println("listar desde MySQL");
    }

    @Override
    public void actualizar() {
        System.out.println("actualizar desde MySQL");
    }

    @Override
    public void eliminar() {
        System.out.println("eliminar desde MySQL");
    }

}
