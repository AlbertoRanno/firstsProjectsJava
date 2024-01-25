package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

//Contiene las operaciones a ejecutar en el archivo de peliculas.txt
//Esta interface define los metodos para interactuar con el catalogo de peliculas => los comportamientos se definiran en la impl
//Si tuviera distintas implementaciones, una podria guardar en un archivo, y otra en una BBDD

/*Esta interface, es la que se vinculara a la clase que implementa la interfaz de CatalogoPeliculas (Negocio)
Y NO se vincularan las clases implementadas entre si
Esto permite lo que tanto se busca de "Bajo Acoplamiento" y "Alta Cohesión". Porque si posteriormente modifico 
la clase AccesoDatosImpl, gracias a que la clase CatalogoPelicuasImpl, esta vinculada a la interface IAccesoDAtos,
la modificacion en AccesoDatosImpl no la va a afectar, manteniendo la capa de negocios intacta*/
public interface IAccesoDatos {

    //No son todos void, algunos devuelven un tipo especifico como boolean, List<Pelicula>, o string. 
    //Ya desde la interfaz indico que depende el metodo, puede arrojar una excepcion u otra
    //Por eso implemento 'la firma del metodo' que se debe implementar después en la clase
    //Dato que apunto a hacerlo generico, puedo cambiar el nombreArchivo a nombreRecurso (para cuando trabaje con BBDD)
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx; //Error mas especifico (aunque podria haber utilizado el padre)

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;
}
