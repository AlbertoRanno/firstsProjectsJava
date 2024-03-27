package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.IPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*Para que Spring pueda reconocer esta clase como
una clase de servicio: @Service 
Sin esta, no voy a poder inyectar esta implementacion,
dentro del controlador de Spring. Gracias a que la
considera otra vez, como otro componente.   */
@Service
public class PersonaServiceImpl implements IPersonaService {

    /*Importante: dentro de la capa servicio, se maneja el concepto
    de Transacciones. Es decir, manejar la posibilidad de hacer commit,
    si todo fue bien, o un rollback, en caso contrario. Y eso, se maneja
    distinto en cada uno de los metodos. Dado que algunos son de solo 
    lectura, y no van a introducir cambios en la base de datos.
    
    Al estar trabajando con las clases de servicio, podria estar
    utilizando varios objetos de tipo DAO, desde una misma clase.
    Por lo que podria estar realizando varias operaciones, sobre 
    distinas tablas de la base de datos, por lo que estos metodos,
    debo marcarlos como transaccionales. Ya que en caso de error, 
    puede hacer un rollback, y no introducir ningun error a las tablas*/
    //Defino una instancia de PersonaDao, para poder usar
    //sus metodos de conexion. La inyecto igual que en el controlador
    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true) //Solo leo, no modifico info
    public List<Persona> listarPersonas() {
        /*original: return personaDao.findAll();
        pero findAll es un tipo object, entonces le acepto la
        sugerencia del Cast al IDE, para hacerlo una lista  */
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional //No aclaro nada, porque si modifico info
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        /*Hay varias opciones, pero en este caso estoy regresando
        el valor de null, en caso de que no encuentre a la persona.
        podria, el valor de lo encontrado con get, o una excepcion, 
        con el orElseThrow */
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
    /* Luego de terminar la implementacion de la capa de servicio,
    vuelvo al controlador, para modficarlo, a que conecte desde aqui.
    Y no desde DAO. Para seguir las buenas practicas, de bajo
    acomplamiento.*/

}
