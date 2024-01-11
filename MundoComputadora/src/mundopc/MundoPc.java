package mundopc;

import com.gm.mundopc.*;

public class MundoPc {

    public static void main(String[] args) {
        Raton raton1 = new Raton("Analógico", "Logitech");
        Raton raton2 = new Raton("Inalámbrico", "Genius");

        Teclado teclado1 = new Teclado("Analógico", "Logitech");
        Teclado teclado2 = new Teclado("Inalámbrico", "Genius");

        Monitor monitor1 = new Monitor("LG", 42.00);
        Monitor monitor2 = new Monitor("Apple", 55.00);

        Computadora computadora1 = new Computadora("Mix1", monitor1, teclado1, raton1);
        Computadora computadora2 = new Computadora("Mix2", monitor2, teclado2, raton2);

        Orden orden1 = new Orden();
        orden1.agregarComputadora(computadora1);
        orden1.agregarComputadora(computadora2);
        orden1.mostrarOrden();
    }

}
