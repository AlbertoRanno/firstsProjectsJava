package mx.com.gm.peliculas.negocio;

//contiene las operaciones necesarias de la app CAtalogoPeliculas
/*Si bien con el paquete datos, ya podria trabajar con el cliente, lo ideal,es tener una capa mas! la capa de negocio!
Esta capa solo trata temas de la logica del negocio, es decir, que solo tienen que ver con la app, no tecnicos
Por ej, los metodos, existe, crear o borrar... no tienen que ver tanto con la app, son mas para el acceso a datos,
por lo que aqui no van a figurar.*/
import mx.com.gm.peliculas.domain.Pelicula;

//sera intermediario entre la interfaz con el usuario (metodo main con ingreso de consola) y el guardado de info (paquete datos)
//Presentara las opciones a las que se puede acceder desde main
//Pero sera su implementacion, la que determine como se hace. Para eso va a interactuar con AccesoDatos (manejo de archivos)
public interface ICatalogoPeliculas {

    /* Asi lo habia manejado, pero lo ideal seria hacer de otra forma, por ej, manteniendo el nombreArchivo, como una constante
    
    void agregarPelicula(Pelicula pelicula, String nombreArchivo); //void

    void listarPeliculas(String nombreArchivo); //void

    void buscarPelicula(String nombreArchivo, String buscar); //void

    void iniciarArchivo(String nombreArchivo); //void */
    String NOMBRE_RECURSO = "peliculas.txt"; //Luego lo usaré en la implementacion de esta interfaz
    //Por eso, los metodos ya no van a recibir este String como argumento, sino que se va a utilizar a nivel del negocio

    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPelicula(String buscar);

    void iniciarCatalogoPeliculas(); //Cambie el nombre para hacerlo mas de negocio <= iniciarArchivo();
}
