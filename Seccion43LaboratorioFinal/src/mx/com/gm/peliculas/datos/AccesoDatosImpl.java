package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;

//Definira lo que hace cada metodo en esta implementacion. En este caso sera la parte tecnica de manipular archivos
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public void existe(String nombreArchivo) {
//        File archivo = new File(nombreArchivo);
//
//        if (archivo.exists()) {
//            System.out.println("El archivo '" + nombreArchivo + "' existe.");
//        } else {
//            System.out.println("El archivo '" + nombreArchivo + "' no existe.");
//        }
    }

    @Override
    public void listar(String nombre) {
        File archivo = new File(nombre);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            // List<Pelicula> listaPeliculas = new ArrayList<>();
            List<String> listaPeliculas = new ArrayList<>();

            while (lectura != null) {
                listaPeliculas.add(lectura);
                lectura = entrada.readLine();
            }
            listaPeliculas.forEach(pelicula -> System.out.println(pelicula));

            /*
            while (lectura != null) {
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }*/
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
// Aquí se utiliza el método toString() de la clase Pelicula, convirtiendo todos los atributos a un solo String que luego escribe
            salida.close();
            System.out.println("Se ha agregado la película al Catálogo indicado");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            while (lectura != null) {
                //   lectura = entrada.readLine();
                if (lectura.contains(buscar)) {
                    System.out.println("La pelicula se encuentra en el catálogo");
                    return; //Para que no siga buscando, y 'no imprima el No hubo coincidencias'
                }
                lectura = entrada.readLine();
            }

            System.out.println("No hubo coincidencias");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void crear(String nombreArchivo) {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            System.out.println("Se ha creado el nuevo Catálogo de películas (nuevo archivo creado)");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
    }

}
