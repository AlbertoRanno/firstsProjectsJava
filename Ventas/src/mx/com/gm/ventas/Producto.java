package mx.com.gm.ventas;

public class Producto {

    private final int idProducto; //Para que no se pueda modificar - dara error el metodo set (no lo necesitaba, pero ojo...)
    private String nombre;
    private double precio;
    private static int contadorProductos; //Static para que mantenga el valor en cada nuevo objeto que se cree

    private Producto() { //Privado a pedido del diagrama
        System.out.println("Se utilizó el constructor vacío de la clase Producto");
        this.idProducto = ++Producto.contadorProductos; //Al utilizar el Constructor aumenta el ID
    }

    public Producto(String nombre, double precio) {
        this(); //llamo al constructor vacío - También aumento el ID cuando utilizo este constructor
        System.out.println("Se utilizó el constructor con argumentos de la clase Producto");
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return this.idProducto;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("idProducto=").append(idProducto);
        sb.append(", nombre=").append(nombre);
        sb.append(", precio=").append(precio);
        //sb.append(", ").append(super(toString()));
        sb.append('}');
        return sb.toString();
    }

}
