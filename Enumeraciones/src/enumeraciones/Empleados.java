package enumeraciones;

public enum Empleados {
    /*Las enumeraciones, son clases que contienen listados de valores estáticos, finales y CONSTANTES.
    Surgieron para evitar tener que definir todas estas caracteristicas como atributos de una clase.
    Se listan en MAYUSCULAS (CONSTANTES), se separan por comas, y se les pueden pasar tanto valores como se desee*/

    HERNAN(42, "Gte. Tecnología", true),
    FERNANDO(32, "Administrativo", false),
    FACUNDO(35, "Desarrollador", true),
    SARA(55, "Recepcionista", false),
    ROSA(23, "Diseñadora", false),
    ANA_PAWLITA(65, "RRHH", false); // Si el listado terminara aca no haría falta nada, 
    //pero si continua el codigo => ";"

    //Defino los atributos que va a tener cada una de estas constantes:
    private final int edad;
    private final String puesto;
    private final boolean admin;

    Empleados(int edad, String puesto, boolean admin) {
        this.edad = edad;
        this.puesto = puesto;
        this.admin = admin;
    }

    //Solo gets porque son todos atributos final
    public int getEdad() {
        return this.edad;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    
}
