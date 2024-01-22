package accesodatos;

/* CLASES ABSTRACTAS VD INTERFACES (nuevo tipo)
Las interfaces son parecidas, dado que No tienen una implementacion
Todos sus metodos van a ser abstractos
Todos sus atributos, de haberlos, seran constantes (Finales, Estaticos, Publicos CON_NOMBRES_ASI y valores ya definidos
Cuando utilizar una u otra:
-si la relacion entre clases se da por caracteristicas (Ejemplo FIguraGeometrica y Rectangulo), entonces clases abstractas
-si la relacion se da, NO por caracteristicas, sino por comportamientos, entonces, Interfaces (Ejemplo, conexiones a
BBDD, como MySQL u Oracle, dado que todas tienen metodos como Listar, Eliminar, Actualizar...)  

En sourcePackages ahora es 'new Java Interface' 

En nombre, se antepone una 'I' de Interface: IAccesoDatos

CTRL+E donde esta el cursor, para borrar una linea

Simulo una conexion a BBDD*/
public interface IAccesoDatos {

    /*Al no ser una clase, NO hereda de la clase Object, lo puedo ver con Ctrl+CLick sobre el nombre de la interface
    Pero si puedo tener interfaces hijas que hereden de una interface padre
    Como todos los atributos van a ser constantes, con los tipos que eso implica, solo aclaro el tipo de dato:  */
    int MAX_REGISTRO = 10;

    /*Con ctrl+click encima, veo que efectivamente es public static final
    Y como una interface no tiene constructores, ya tengo que definirle a cada atributo un valor, porque no se cambiaran
    Solo tendra metodos y todos abstractos.*/

    void insertar(); //Idem, ctrl+click veo que es public y abstract, y sin {}

    void listar();

    void actualizar();

    void eliminar();

}
