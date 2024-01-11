package com.gm.mundopc;

public class DispositivoEntrada {

    private String tipoEntrada;
    private String marca;

    public DispositivoEntrada(String tipoEntrada, String marca) {
        System.out.println("Constructor de la clase DispositivoEntrada");
        this.tipoEntrada = tipoEntrada;
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoEntrada() {
        return this.tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DispositivoEntrada{");
        sb.append("tipoEntrada=").append(tipoEntrada);
        sb.append(", marca=").append(marca);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
