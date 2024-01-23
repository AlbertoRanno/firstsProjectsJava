package manejoArchivos;

import java.io.*;// 'io' == input output / entrada y salida

public class ManejoArchivos {

    /*Creo todos los metodos de forma estatica para no tener necesidad de crear un objeto de esta clase para utilizarlos*/
    public static void crearArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        try {
            //con esto todavia no se crea el archivo, sino que creo un objecto de la clase File en memoria y la importo
            //Para que se guarde, creo un objeto nuevo de la clase PrintWriter, la importo, y le paso el archivo creado
            PrintWriter salida = new PrintWriter(archivo); //el nombre es salida porque va a escribir en el disco duro
            //El try/catch es por una sugerencia del IDE, dado que sino arrojaría una excepcion

            //Hasta acá, se abrió el archivo, pero aun no se guardó en memoria. Para eso hay que cerrar el flujo:
            salida.close();
            System.out.println("Se ha creado el archivo");

        } catch (FileNotFoundException ex) {
            //Elimino: Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex); y sus import
            //E imprimo la pila:
            ex.printStackTrace(System.out);//Acordarse del System.out para que no marque errores
        }

    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            //En lugar de cerrar el flujo, escribo primero:
            salida.println(contenido); //puede ver desde el menu del ide, que pueden ser varios formatos...
            //Ahora si cerrar

            salida.close();
            System.out.println("Se ha escrito al archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void anexarArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        //Se necesita una clase intermedia para anexar info al archivo:
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); //El true para confirmar que se agrega info
            //Al agregar la clase intermedia, el ide indica agregar otro catch
            salida.println(contenido);

            salida.close();
            System.out.println("Se ha anexado info al archivo");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            // Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace(System.out);

        }
    }

    public static void leerArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo); //tambien puede ser var archivo = new ... por inferencia de tipos
        try {
            //Añado un objeto BufferedReader para leer lineas completas de un archivo. Almacena caracter a caracter
            //Y otro objecto new FileReader
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine(); //Con esto leo solo la primer linea, => un ciclo While
            while (lectura != null) {
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

}
