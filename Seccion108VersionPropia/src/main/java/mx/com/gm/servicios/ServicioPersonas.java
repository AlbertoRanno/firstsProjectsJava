package mx.com.gm.servicios;

//Esta clase se utiliza en Spring, para convertirla en clases Transaccionales
import java.util.List;
import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {

    /*variables
    defino como variable mi clase PersonaDao, para poder instanciarla y usar asi sus metodos (no estaticos)
    Al definirla como variable, hare que se inicialice, es decir, que se instancie, es decir, que se cree un objeto,
    al momento que se use el constructor de esta clase. Uso un constructor vacío, para que independientemente
    del objeto que se cree, se instancie la clase PersonaDao, y me permite establecer la conexion con la BBDD   */
    private PersonaDao personaDao;

    //constructor
    public ServicioPersonas() {
        this.personaDao = new PersonaDao();
    }

    //metodos
    //va a devolver un listado de personas (mi endpoint!)
    public List<Persona> listarPersonas() {
        /*  return this.personaDao.listar();
        a priori, este metodo es del tipo void, lo voy a modificar, para que en lugar de imprimirlo, me envie
        el listado de objetos */
        return this.personaDao.listar();

    }

    /*En el curso, dejan aca, y desarrollan la capa web, lo cual me pidieron omitir, por lo que voy a ver si 
    puedo completar los otros metodos de los endpoints
    
    un resumen hasta este punto:

    Maven Configuración:
    He configurado un proyecto Maven con dependencias como Hibernate y MySQL connector para la gestión de bases de datos.
    También has definido la versión de Java a utilizar y el punto de entrada de la aplicación.

    Configuración de Persistencia con Hibernate:
    He configurado el archivo persistence.xml para la unidad de persistencia usando Hibernate.
    Esta configuración incluye los detalles de la conexión a la base de datos, como la URL, el usuario y la contraseña.

    Clase Persona:
    He creado una clase Persona que representa una entidad en la base de datos.
    Esta clase incluye anotaciones JPA para mapear la clase a una tabla en la base de datos.
    He definido atributos como idPersona, nombre, apellido, email y telefono, junto con sus respectivos getters y setters.
    
    Clase PersonaDao:
    He implementado la clase PersonaDao, que sigue el patrón DAO para acceder y manipular datos relacionados con la 
    entidad Persona.
    La clase PersonaDao utiliza EntityManager y EntityManagerFactory para interactuar con la base de datos.
    Incluye métodos para listar, insertar, modificar, buscar por ID y eliminar personas en la base de datos.
    
    Prueba en la clase OperacionesHibernateJPA:
    He creado una clase de prueba OperacionesHibernateJPA para probar los métodos definidos en PersonaDao.
    En esta clase, he instanciado PersonaDao y probado los métodos de inserción, modificación, búsqueda por ID
    y eliminación de personas.

    Es suficiente esta clase de servicio, con el resto de los metodos, para que trabajen desde el Front?
    Sí, en principio, la clase ServicioPersonas junto con los métodos completados en PersonaDao proporcionan 
    una capa de servicio que podría ser utilizada por el equipo de front-end para desarrollar la interfaz de 
    usuario (UI). Aquí hay algunas consideraciones:

    Capa de Servicio (ServicioPersonas):
    La clase ServicioPersonas proporciona una interfaz para interactuar con los datos de las personas.
    Si completas los métodos restantes en PersonaDao (como ingresar, eliminar, etc.), tendrás una funcionalidad 
    completa para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos relacionada 
    con las personas.
    
    Interacción con el Frontend:
    Una vez que tengas los métodos necesarios en ServicioPersonas, el equipo de front-end puede utilizar
    esta capa de servicio para realizar solicitudes al backend y obtener los datos necesarios.
    Por ejemplo, el método listarPersonas() en ServicioPersonas devuelve una lista de personas.
    El equipo de front-end puede consumir este método para obtener la lista de personas y mostrarla
    en la interfaz de usuario.
    
    Formato de Respuesta:
    Es importante definir claramente el formato en el que se devolverán los datos al front-end. 
    Puedes optar por devolver los datos en formato JSON, por ejemplo, para que el equipo de front-end 
    pueda procesarlos fácilmente.
    
    Documentación y Comunicación:
    Asegúrate de documentar claramente la API proporcionada por la capa de servicio (ServicioPersonas).
    Esto ayudará al equipo de front-end a comprender cómo interactuar con el backend.
    La comunicación efectiva entre los equipos de desarrollo backend y frontend también es fundamental 
    para garantizar que las necesidades y expectativas de ambos equipos se cumplan de manera adecuada.
    
    En resumen, sí, la clase ServicioPersonas junto con los métodos completados en PersonaDao proporcionan
    una base sólida para el desarrollo del frontend. Sin embargo, la comunicación y la colaboración
    entre los equipos de desarrollo backend y frontend son clave para el éxito del proyecto.

    COMPLETAR LOS METODOS => JSON => POSTMAN */
}
