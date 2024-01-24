package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.domain.Pelicula;

//Contiene las operaciones a ejecutar en el archivo de peliculas.txt
//Esta interface define los metodos para interactuar con el catalogo de peliculas => los comportamientos se definiran en la impl
//Si tuviera distintas implementaciones, una podria guardar en un archivo, y otra en una BBDD
public interface IAccesoDatos {

    void existe(String nombreArchivo);//boolean

    void listar(String nombre);//List<Pelicula> => pero liste Strings... si lee Strings.. como hago sino ?

    void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);//void

    void buscar(String nombreArchivo, String buscar);//String

    void crear(String nombreArchivo);//void

    void borrar(String nombreArchivo);//void
}
