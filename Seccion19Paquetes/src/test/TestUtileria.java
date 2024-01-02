package test;

/*Formas de importar:
import mx.com.globalmentoring.Utileria; //(*1)
import mx.com.globalmentoring.*; 
//Importa todas las clases! Las clases NO ocupan espacio en memoria hasta que se utilizan dentro del programa!
import static mx.com.globalmentoring.Utileria.imprimir; //(*2)
*/


public class TestUtileria {
    public static void main(String[] args) {
      //(*1)  Utileria.imprimir("Saludos");
      //(*2) imprimir("Adiós");
      //Sino, sin import, con "el nombre completamente calificado: - no recomendado, salvo un caso..."
      mx.com.globalmentoring.Utileria.imprimir("Bienvenido");
      
    }
}
