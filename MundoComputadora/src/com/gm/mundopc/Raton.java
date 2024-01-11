package com.gm.mundopc;

public class Raton extends DispositivoEntrada {

    private final int idRaton;
    private static int contadorRatones;

    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idRaton = ++Raton.contadorRatones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raton{");
        sb.append("idRaton=").append(idRaton);
        sb.append(", ").append(super.toString());//Para incluir los atributos de la clase padre (tipoENtrada y Marca)
        sb.append('}');
        return sb.toString();
    }

}
