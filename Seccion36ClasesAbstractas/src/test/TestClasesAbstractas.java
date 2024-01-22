package test;

import domain.*;

public class TestClasesAbstractas {

    public static void main(String[] args) {
        //Si quisiera crear un objeto de la clase abstracta no puedo => 'can not be instantiated'
        // FiguraGeometrica figuraGeometrica1 = new FiguraGeometrica(tipoFigura);

        //Pero si puedo usarla mediante el polimorfismo, para hacer el codigo lo mas generico posible:
        FiguraGeometrica figura = new Rectangulo("Rectangulo"); //Upcasting
        //Asigno un tipo hijo a un tipo padre, sin ningun problema
        //No requiere la conversion:
        FiguraGeometrica figura1 = (FiguraGeometrica) new Rectangulo("Rectangulo");
        
        //Debido al polimorfismo, puedo llamar al metodo en comun que tengan las 2 clases,
        //TOmando prioridad, la clase de menor jerarquia, es decir, la hija.
        //Igualmente el de la clase padre no se podria aplicar porque es abstracto
        figura.dibujar();
        //Aunque con ctrl+click me lleve al padre... se aplica en tiempo de ejecucion el del hijo
    }

}
