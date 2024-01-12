package test;

import enumeraciones.Empleados;

public class TestEmpleados {

    public static void main(String[] args) {
        mostrarInfoEmpleado(Empleados.FERNANDO);//tengo que pasar algun item de la enumeración, y NO cualquier String
    }

    public static void mostrarInfoEmpleado(Empleados empleado) {
        switch (empleado) {
            case HERNAN:
                System.out.println("Empleado: " + Empleados.HERNAN);
                System.out.println("Puesto: " + Empleados.HERNAN.getPuesto());
                System.out.println("Edad: " + Empleados.HERNAN.getEdad());
                System.out.println("Es admin? " + Empleados.HERNAN.isAdmin());
                break;
            case FERNANDO:
                System.out.println("Empleado: " + Empleados.FERNANDO);
                System.out.println("Puesto: " + Empleados.FERNANDO.getPuesto());
                System.out.println("Edad: " + Empleados.FERNANDO.getEdad());
                System.out.println("Es admin? " + Empleados.FERNANDO.isAdmin());
                break;
            default:
                throw new AssertionError();
        }
    }
}
