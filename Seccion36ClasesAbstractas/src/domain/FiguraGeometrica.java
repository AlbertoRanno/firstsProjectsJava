package domain;

public abstract class FiguraGeometrica {

    protected String tipoFigura;

    protected FiguraGeometrica(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    /*Las clases abstractas surgen a raíz de los métodos abstractos. 
    Si una clase tiene al menos un metodo abstracto, toda la clase se tiene que marcar como abstracta
    Un metodo abstracto, es quel que no tiene implementacion, como 'dibujar()'
    Esto permite que clases padres e hijas, compartan el mismo metodo, pero este pueda ser definido, de
    manera distinta en cada una de las clases hijas sin la necesidad de sobreescribirlo, dado que como realmente no 
    tiene un codigo definido en la clase padre, en la hija no lo estare sobreescribiendo, sino, implementando.
    Pero dado que el compilador lo registra en la clase padre, igualmente le pone Override, pero con una "i" de implementacion
    en el margen izquiedo.
    Ej, en una clase hija Rectangulo, se definira un metodo de dibujar, y en una Triangulo, otro.
    De no definirlo en las clases hijas, estas tambien se deben marcar como abstractas
    Al marcar una clase como abstracta, no se pueden generar objetos a partir de la misma.
    Es por eso que, a veces, incluso sin tener metodos abstractos, se las marca como abstractas con esa finalidad*/
    public abstract void dibujar(); //Notar que no abre y cierra el cuerpo => {}

    public String getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(String tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    @Override
    public String toString() {
        return "FiguraGeometrica{" + "tipoFigura=" + tipoFigura + '}';
    }

}
