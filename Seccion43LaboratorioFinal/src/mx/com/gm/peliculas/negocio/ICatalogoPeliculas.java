package mx.com.gm.peliculas.negocio;

//contiene las operaciones necesarias de la app CAtalogoPeliculas

import mx.com.gm.peliculas.domain.Pelicula;

//sera intermediario entre la interfaz con el usuario (metodo main con ingreso de consola) y el guardado de info (paquete datos)
//Presentara las opciones a las que se puede acceder desde main
//Pero sera su implementacion, la que determine como se hace. Para eso va a interactuar con AccesoDatos (manejo de archivos)
public interface ICatalogoPeliculas {

    void agregarPelicula(Pelicula pelicula, String nombreArchivo); //void

    void listarPeliculas(String nombreArchivo); //void

    void buscarPelicula(String nombreArchivo, String buscar); //void

    void iniciarArchivo(String nombreArchivo); //void
}
