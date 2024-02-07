package datos;

import java.util.*;
import domain.PersonaDTO;
import java.sql.SQLException;

public interface PersonaDao {
    
    /*En este proyecto, creo esta interface, para tener una capa de datos correcta.
    Agrego los metodos que se van a utilizar, con los errores que van a arrojar*/
    
    public List<PersonaDTO> seleccionar() throws SQLException;
    
    public int insertar(PersonaDTO persona) throws SQLException;
    
    public int actualizar(PersonaDTO persona) throws SQLException;
    
    public int eliminar(PersonaDTO persona) throws SQLException;
    
    
    
}
