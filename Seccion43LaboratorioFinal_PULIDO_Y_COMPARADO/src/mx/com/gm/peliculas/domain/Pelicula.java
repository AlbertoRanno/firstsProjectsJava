package mx.com.gm.peliculas.domain;

/*Clase que sirve para representar los objetos pelicula utilizados en la app CatalogoPeliculas
Las clases de domain o clases de Entidad, suelen ser JavaBeans que es lo que necesitan los frameworks
Pero como en esta app no se usan frameworks, y no se hace ninguna conexion con ningun server, omito la parte de:
public class Pelicula implements Serializable {
En el siguiente nivel, este tipo de clases, corresponderán a una tabla en la BBDD
Los atributos se corresponderan con columnas de esas tablas
*/
public class Pelicula {
    

    private String nombre;

    public Pelicula() {
    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Como el toString se usa para escribir el archivo, lo modifico a que solo muestre el nombre de la pelicula
    @Override
    public String toString() {
        return this.nombre;
    }
}
