package test;

//import manejoArchivos.ManejoArchivos; //(*1)
import static manejoArchivos.ManejoArchivos.*; //me traigo todos los metodos estaticos

public class TestManejoArchivos {

    public static void main(String[] args) {
        var nombreArchivo = "prueba.txt";
//        ManejoArchivos.crearArchivo(nombreArchivo);
        //Lo veo de la solapa de Files (Window => Files, para activarla)

        /*
        Se puede pasar una ruta donde generar el archivo, modificando en var nombreArchivo = "prueba.txt";
        En Windows:        "c:\\carpeta\\prueba.txt" 
        Donde la 1er '\' es para escapar la 2da '\'
        
        En Linux/Mac:       "/carpeta/prueba.txt"
        
        Estar seguro de tener los permisos para escribir en esa carpeta
        
        Click derecho en el archivo, y propiedades, para ver la ruta del archivo
         */
        // ManejoArchivos.escribirArchivo("prueba.txt", "Hola desde Java"); //(*1)
//        escribirArchivo("prueba.txt", "Escribo por primera vez");
//        escribirArchivo("prueba.txt", "Escribo por 2da vez - Sobreescribe a la primera");        
        //Creo entonces el metodo de anexarArchivo
        anexarArchivo("prueba.txt", "Escribo por primera vez");
        anexarArchivo("prueba.txt", "Escribo por 2da vez - Sobreescribe a la primera");

        leerArchivo("prueba.txt");
    }
}
