package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

//Definira lo que hace cada metodo en esta implementacion. En este caso sera la parte tecnica de manipular archivos
public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        /* throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   Las lineas esas indican que todavia no estan soportadas esas operaciones... y eso es porque justamente las tengo que escribir */

        File archivo = new File(nombreRecurso); //Solo creo la variable de archivo, y No el archivo en el disco duro
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            //Leo cada linea de mi archivo (un String) que va a ser el nombre de la pelicula
            //y con eso, por cada linea, creo un objecto de tipo pelicula
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            //variable para leer cada una de las lineas (cada linea es un string)
            String linea = null;
            linea = entrada.readLine();
            while (linea != null) {
                //ya no mando a consola, sino que creo una lista de objetos peliculas.
                //Este es el paso que no me había dado cuenta en mi resolucion, armar cada objeto de nuevo, antes de agregarlo.
                Pelicula pelicula = new Pelicula(linea);//Cada linea es un nombre de pelicula
                //Entonces, a raiz de cada linea leida, arma el objeto pelicula, y ahora lo mando a la lista:
                peliculas.add(pelicula);
                //vuelvo a leer la linea siguiente, y pregunto si es diferente de nulo, y sigo el while:
                linea = entrada.readLine();
            }
            entrada.close(); //Se podría agregar un bloque finally para que siempre se manda a llamar esta linea

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);//Capturo la excepción original(uso para visualizar internamente nosotros)
            //Propago mi propia excepcion (para que el usuario solo vea mi msj), indicando el msj que requiere el constructor:
            throw new LecturaDatosEx(" Excepcion al listar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx(" Excepcion al listar peliculas: " + ex.getMessage());
        }
        //Una vez que el listado ya se completo, lo retorno
        //(Obs! retorna el listado, pero no lo lista, eso lo hace la capa de negocios,a dfferencia de mi version
        return peliculas;

    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));//anexar para saber si anexa o sobreescribe
            //Escribo:
            salida.println(pelicula.toString()); //Limpio el toString
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al intentar escribir " + pelicula + " al catálogo: " + ex.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        //En esta version, devuelve ademas el nro de linea en que lo encontro:
        var archivo = new File(nombreRecurso);
        String resultado = null; //Si se encuentra la pelicula, se devuelve el nombre, sino, se devuelve null
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1; //para saber en que linea la encontró
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) { //no distingue entre mayus y minus
                    resultado = "Pelicula " + linea + " encontrada en la indice " + indice;
                    break; //para que no siga buscando            
                }
                //si no se encontró, vuelvo a leer, y aumento el indice
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al intentar buscar " + buscar + ": " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al intentar buscar " + buscar + ": " + ex.getMessage());
        }

        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al intentar crear el archivo");
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx { //Donde no arrojo excepciones, esta linea puedo dejarla o borrarla
        File archivo = new File(nombreRecurso);
        if (archivo.exists()) {
            archivo.delete();
        }
        System.out.println("Se ha borrado el archivo");
    }

}
