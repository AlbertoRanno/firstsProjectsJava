package domain;

public class Rectangulo extends FiguraGeometrica {

    /*El ide sugiere en automatico la obligacion de crear un constructor de la clase padre
    Y tambien la implementacion de todos los metodos abstractos. Notar que aqui no son abstractos*/
    public Rectangulo(String tipoFigura) {
        super(tipoFigura);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibuja un " + this.getClass().getSimpleName()); //NOTAR COMO OBTENGO EL NOMBRE DE LA CLASE!
    }

}
