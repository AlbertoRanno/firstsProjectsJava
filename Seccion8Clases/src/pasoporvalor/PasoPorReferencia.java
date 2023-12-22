package pasoporvalor;

public class PasoPorReferencia {

    public static void main(String[] args) {
        // Al trabajar con objetos, la referencia al objeto se pasa por valor.
        // Los cambios realizados en el objeto dentro del método son visibles fuera de él.
        Usuario usuario = new Usuario("John Doe");
        actualizarUsuario(usuario);

        // El objeto Usuario conserva los cambios realizados en el método.
        System.out.println("Nuevo nombre de usuario: " + usuario.getNombre());
    }

    public static void actualizarUsuario(Usuario usuario) {
        // Se recibe la referencia al objeto Usuario por valor.
        // Los cambios realizados en el objeto afectan al objeto original fuera del método.
        usuario.setNombre(usuario.getNombre() + " Jr.");
        System.out.println("Nuevo nombre de usuario dentro del método: " + usuario.getNombre());
    }
}

class Usuario {

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
