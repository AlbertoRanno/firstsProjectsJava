package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.negocio.*;

/*CLase con la que se interactua con el usuario final

Es la capa de presentacion, o capa de vista, en este caso es la consola, pero podria ser un cliente web, una app de escritorio,
una app movil, etc... pero el codigo seria el mismo, solo cambia como presentamos en esta capa.

Al cambiar la logica de que el archivo es siempre el mismo y se sobreescribe, y no que se crean otros, todo mi codigo
original lo comente y pase al fondo

 */
public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        var opcion = -1;
        var consola = new Scanner(System.in);//Clase tipo Scanner, y le paso la consola de entrada 'System.in'

        /* IMPORTANTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        AHora defino variable del tipo de la interface. Es decir, conecto la capa de presentacion con la interfaz
        de la capa de negocios. Y, en este caso, utilizo la implementacion de CatalgoPeliculasImpl: */
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        /*Esto, es lo mismo que hice con el constructor y el atributo constante, para seleccionar primero la interfaz
        de datos y luego su implementacion, pero en este caso, como estoy dentro de un metodo estatico, tengo que hacerlo
        de esta forma
        De nuevo lo estoy instanciando para usar sus metodos
        Notar que gracias a la capa de negocio, ya no interactuo con la capa de datos
        Manteniendo la idea de bajo acomplameniento, es decir, la menor cantidad de relaciones posibles entre clases
        Y la ALta cohesion significa que cada clase se encarga de realizar su tarea y no mas
        
        Bajo acomplamiento y ALta cohesion:
        capa de datos (se encarga de comunicarse con el archivo) => archivo
        negocios (funciones propias de la app) => datos
        presentacion (mostrar y capturar la info del usuario) => negocios
        
        Spring HIbernate y Java empresarial, utilizan estos conceptos*/

        //Hago el menu:
        while (opcion != 0) {
            System.out.println("\nElige una opción, luego presiona Enter:\n"
                    + "1.- Iniciar catálogo películas\n"
                    + "2.- Agregar pelicula\n"
                    + "3.- Listar pelicula\n"
                    + "4.- Buscar pelicula\n"
                    + "0.- Salir\n");
            opcion = Integer.parseInt(consola.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    var nombrePelicula = consola.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de una pelicula a buscar");
                    var buscar = consola.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opción que haz seleccionado no es válida. Por favor intenta nuevamente");
                    break;
            }
        }
    }
}

/*   int opcion;
        String nombreArchivo = null; //!important si no la inicializaba aca, no podia retener el nombre ingresado en la Op1
        //(salia msj de error de no inicializada... logico, solo estaba declarada...)
        String nombrePelicula;
        //indica la ruta donde se almacera el archivo "c:/CatalogoPeliculas/Peliculas.txt
        //importante la carpeta debe estar creada y tener permisos!
        String peliculaBuscada;
        var consola = new Scanner(System.in);

        // CatalogoPeliculasImpl nuevoCatalogo = new CatalogoPeliculasImpl();
        // Lo saque fuera, sino tenia que generar una nueva instancia en cada opcion
        // Lo mismo, lo tuve que inicializar como null, sino no me guardaba la info entre las opciones del switch
        CatalogoPeliculasImpl catalogo = null;
        /*Esto hace que cada vez que se corre la app, pida crear un nuevo archivo. Y con el objeto creado en el caso 1,
        en memoria aun, se tiene acceso a todos los datos que se van cargando  */
 /*
        do {
            System.out.println("\nElige una opción, luego presiona Enter:\n"
                    + "1.- Iniciar catálogo películas\n"
                    + "2.- Agregar pelicula\n"
                    + "3.- Listar pelicula\n"
                    + "4.- Buscar pelicula\n"
                    + "0.- Salir\n");
            opcion = Integer.parseInt(consola.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Ingresa el nombre del nuevo Catalogo:");
                    nombreArchivo = consola.nextLine();
                    catalogo = new CatalogoPeliculasImpl();
                    catalogo.iniciarArchivo(nombreArchivo);
                    break;
                case 2:
                    if (nombreArchivo == null) {
                        System.out.println("Primero debes iniciar un nuevo Catálogo");
                    } else {
                        System.out.println("Introduce el nombre de la pelicula a agregar:");
                        nombrePelicula = consola.nextLine();
                        Pelicula pelicula = new Pelicula(nombrePelicula);
                        catalogo.agregarPelicula(pelicula, nombreArchivo);
                    }
                    break;
                case 3:
                    System.out.println("El listado de peliculas es el siguiente:");
                    catalogo.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Ingresa el nombre de la pelicula que estas buscando:");
                    peliculaBuscada = consola.nextLine();
                    catalogo.buscarPelicula(nombreArchivo, peliculaBuscada);                    
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("La opción que haz seleccionado no es válida. Por favor intenta nuevamente");
                    break;
            }
        } while (opcion != 0);

    }*/
