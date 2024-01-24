package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

//Contiene el menu que permite al usuario seleccionar la accion a ejecutar sobre el catalogo de peliculas
public class CPJLaboratorioFinal {

    public static void main(String[] args) {
        int opcion;
        String nombreArchivo = null; //!important si no la inicializaba aca, no podia retener el nombre ingresado en la Op1
        //(salia msj de error de no inicializada... logico, solo estaba declarada...)
        String nombrePelicula;
        //indica la ruta donde se almacera el archivo "c:/CatalogoPeliculas/Peliculas.txt
        //!important la carpeta debe estar creada y tener permisos!
        String peliculaBuscada;
        var consola = new Scanner(System.in);

        // CatalogoPeliculasImpl nuevoCatalogo = new CatalogoPeliculasImpl();
        // Lo saque fuera, sino tenia que generar una nueva instancia en cada opcion
        // Lo mismo, lo tuve que inicializar como null, sino no me guardaba la info entre las opciones del switch
        CatalogoPeliculasImpl catalogo = null;
        /*Esto hace que cada vez que se corre la app, pida crear un nuevo archivo. Y con el objeto creado en el caso 1,
        en memoria aun, se tiene acceso a todos los datos que se van cargando  */

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

    }
}
