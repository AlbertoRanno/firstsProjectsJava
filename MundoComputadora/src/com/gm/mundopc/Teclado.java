package com.gm.mundopc;

public class Teclado extends DispositivoEntrada {

    /*Podria haber copiado el codigo de Raton, y seleccionaba la variable, click derecho, refactor, rename
    y lo cambia en todas las ubicaciones*/
    private final int idTeclado;
    private static int contadorTeclados;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclado = ++Teclado.contadorTeclados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Teclado{");
        sb.append("idTeclado=").append(idTeclado);
        sb.append("idTeclado=").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
