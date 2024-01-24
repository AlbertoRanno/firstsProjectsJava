package mx.com.gm.peliculas.negocio;

//import static mx.com.gm.peliculas.datos.*;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.domain.Pelicula;


/*va a determinar en cada metodo, como interactua con el manejo del archivo (AccesoDatosImpl)
Al hacer uso de una interfaz, en cualquier momento se podria cambiar la implementacion, y se afectaria lo menos posible al codigo
caracteristica que se la conoce como 'BajoAcoplamiento', y significa que cualquier cambio en una clase, afecte lo menos posible
a otras clases */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas{
    
    AccesoDatosImpl datos = new AccesoDatosImpl();

    @Override
    public void agregarPelicula(Pelicula pelicula, String nombreArchivo) {
        datos.escribir(pelicula, nombreArchivo, true);
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        datos.listar(nombreArchivo);
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        datos.buscar(nombreArchivo, buscar);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        datos.crear(nombreArchivo);
    }
    
}
