package com.gm.mundopc;

public class Orden {

    private final int idOrden;
    private Computadora computadoras[];
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private final static int MAX_COMPUTADORAS = 10;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];
    }

    public void agregarComputadora(Computadora computadora) {
        if (this.contadorComputadoras < Orden.MAX_COMPUTADORAS) {
            this.computadoras[this.contadorComputadoras++] = computadora;
        } else {
            System.out.println("Has alcanzado el límite de " + MAX_COMPUTADORAS + "computadoras por orden");
        }
    }

    public void mostrarOrden() {
        System.out.println("idOrden = " + this.idOrden);
        System.out.println("Computadoras: ");
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);
        }

    }
}
