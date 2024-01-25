package mx.com.gm.peliculas.negocio;

//import static mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;


/*va a determinar en cada metodo, como interactua con el manejo del archivo (AccesoDatosImpl)
Al hacer uso de una interfaz, en cualquier momento se podria cambiar la implementacion, y se afectaria lo menos posible al codigo
caracteristica que se la conoce como 'BajoAcoplamiento', y significa que cualquier cambio en una clase, afecte lo menos posible
a otras clases 

Obs! Podria tener mas metodos que en la interface, pero no es comun hacerlo, dado que (si conecto otra clase a la interface,
y no directo a esta implementacion) ya no tendria acceso a esos metodos que no estuvieran en la interface */
public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    /*Para vincular como habia visto, esta implementacion, a la INTERFACE IAccesoDatos, creo un nuevo objeto de la misma.
    De manera de instanciarla, y poder asi usar sus metodos, dado que no son estaticos.
    Esta vinculacion va a ser un atributo de esta clase:    */
    private final IAccesoDatos datos; //(*)

    //Agrego un constructor vacio de esta clase para inicializar esta variable de datos
    public CatalogoPeliculasImpl() {
        //Y AQUI ES DONDE SE UTILIZA LA CLASE QUE IMPLEMENTA ESTA INTERFACE
        this.datos = new AccesoDatosImpl();
        /*Al conectar mediante la interface, voy a poder acceder a los metodos que esten en la misma
        Mediante this.datos.... borrar, crear, escribir...
        
        Aca elegi esa implementacion, pero bien podria ser una de acceso a una BBDD
        Por eso importante el elegir el tipo interface cuando especifico la variable (atributo)
        Por eso se dice que la conexion es la interface, y no directo a la implementacion de la misma.
        Si quiero cambiar luego a otro implementacion, solo se cambia esta partecita y listo
        
        Este tipo de cosas es la que resulve el framework de Spring. Spring utiliza el concepto de 
        inyeccion de dependencias todo el tiempo. Aca no se esta utilizando inyeccion de dependencias,
        Pero cuando llegue a Spring va a utilizar los mismos conceptos, cambiando la sintaxis, pero la teoria
        es la misma.
        
        Ergo, es muy importante usar el tipo interface, atributos de la clase   (*1) */

    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        //Recibo String, pero, lo convierto a un obj de tipo Pelicula:
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false; //defino variable para determinar si anexa o sobreescribe
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            //si existe, Se pasa (pelicula, nombreREcurso, y que, anexar o no, va a depender de si existe el archivo o no en el discoDuro
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            /*A esta altura puedo elegir si propagarla a las demas clases, que van a utilizar esta clase,
           (como se propago del metodo 'existe' a este) o directamente mandarla a imprimir. En este caso imprimo:*/
            System.out.println("Error de acceso a datos en el metodo agregar peliculas");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula); //A diferencia de mi version, se lista aqui...
            }
            //   } catch (LecturaDatosEx ex) { 
            //Se puede mantener el error de LecturaDatosEx, o pasar al de la clase padre, si quiero algo mas generico
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso datos en el metodo listar peliculas");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de Lectura de datos en el metodo buscar pelicula");
            ex.printStackTrace(System.out);
        }
        if (resultado == null) {
            System.out.println("No se ha encontrado la pelicula buscada");
        } else {
            System.out.println("resultado = " + resultado);
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            //Si, ya existe, lo borro, y luego lo vuelvo a crear. Seria un reinicio del catalogo
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else { //si no existe lo creo
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de Acceso datos en el metodo iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

    /* Asi lo tenia, pero al cambiar la interfaz, dada la constante NOMBRE_RECURSO, cambia todo)
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
    }*/
}
