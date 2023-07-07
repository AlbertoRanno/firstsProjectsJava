package Caja;

public class PruebaCaja {

    public static void main(String[] args) {
     
        //Creo 1er objeto con el constructor vacío
        Caja caja1 = new Caja();
        caja1.ancho = 3;
        caja1.alto = 2;
        caja1.profundo = 6;
        System.out.println("caja1 = " + caja1);
        int resultado1 = caja1.calcularVolumen();
        System.out.println("resultado1 = " + resultado1);
        
         //Creo 2do objeto con el constructor con argumentos
        Caja caja2 = new Caja(3, 2, 6);
        System.out.println("caja2 = " + caja2);
        int resultado2 = caja2.calcularVolumen();
        System.out.println("resultado2 = " + resultado2);
        
      /* Notas:
      - Hubiese estado bueno, crear las variables: medidaAncho - medidaAlto - medidaProfundo, asignarles el valor
      y luego pasar este valor a los atributos. Por la simple buena práctica de definir los valores una sola vez,
      y trabajar con variables, por si estos luego cambian, y replican en varios lados.

      - De entrada quise hacerlo con THIS, porque me había olvidado que This, no funciona en metodos staticos

      - Opté por llamar al metodo, guardarlo en una variable, y luego mostrarla con soutv, pero podría haber
      realizado directamente un metodo que ya tuviera el println? Si, luego lo hice, pero estimo el return
      tiene la ventaja de poder mechar ese resultado en otro lado y este no?  */
        
        caja1.mostrarVolumen();
    }

  
    
}
