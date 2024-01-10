package mx.com.gm.ventas.test;

import mx.com.gm.ventas.*; //Orden y Producto

public class VentasTest {

    public static void main(String[] args) {
        Producto producto1 = new Producto("Camisa", 50.00);
        Producto producto2 = new Producto("Pantalón", 100.00);

        Orden orden1 = new Orden(); //Se inicializa el id, y array de productos
        orden1.mostrarOrden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        orden1.mostrarOrden();

        Producto producto3 = new Producto("Medias", 5.50);
        Producto producto4 = new Producto("Remeras", 45.00);

        Orden orden2 = new Orden();
        orden2.agregarProducto(producto4);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto3); //Hasta acá son 10 productos
        orden2.agregarProducto(producto3); //Con este supero el limite

        orden2.mostrarOrden();

    }
}
