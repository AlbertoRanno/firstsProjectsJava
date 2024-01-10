package mx.com.gm.ventas;

public class Orden {

    private int idOrden; //No se puede poner 'final' antes de asociarla al codigo que la genera
    private Producto productos[]; // Solo se declara el arreglo, se inicializará en el constructor
    private static int contadorOrdenes;
    private int contadorProductos; //Variable para saber la cantidad de productos que se agregan a cada orden
    private static final int MAX_PRODUCTOS = 10;

    public Orden() {
        System.out.println("Se utilizó el constructor vacío de la clase Orden");
        this.idOrden = ++Orden.contadorOrdenes; //pre incremento para que arranque por el "1"
        this.productos = new Producto[Orden.MAX_PRODUCTOS]; // Se inicializa el array
        //Es importante inicializarlo, sino es null, por default, y no se le pueden sumar objetos!
    }

    public void agregarProducto(Producto producto) {
        if (this.contadorProductos < Orden.MAX_PRODUCTOS) {
            //si la orden aun no llega al maximo de productos, agrego el producto, indicando en que posicion lo agrego
            this.productos[this.contadorProductos++] = producto;
            //contadorProductos seria el indice, arrancando en 0, su valor default
            //se realiza un post incremento, para que el siguiente producto se almacene en la posicion siguiente
            //y tambien por la validacion del maximo            
        } else {
            System.out.println("Se ha superado el máximo de productos: " + MAX_PRODUCTOS);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) {
            //con contadorProductos, solo voy a considerar los objetos que se inicializaron, y no los 10 máximos posibles. Más performante
            // Producto producto = this.productos[i];
            //total += producto.getPrecio(); // total = total + producto.getprecio();
            total += this.productos[i].getPrecio();

        }
        return total;
    }

    public void mostrarOrden() {
        System.out.println("idOrden = " + this.idOrden);
        double totalOrden = this.calcularTotal();
        System.out.println("totalOrden = " + totalOrden);
        System.out.println("Productos de la orden: ");
        for (int i = 0; i < this.contadorProductos; i++) {
            System.out.println(this.productos[i]); //gracias al metodo toString de Productos
        }
    }

}
