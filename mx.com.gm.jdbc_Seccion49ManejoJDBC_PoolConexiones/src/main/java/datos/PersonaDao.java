package datos;

import java.util.*;
import domain.PersonaDTO;
import java.sql.SQLException;

public interface PersonaDao {
    
    public List<PersonaDTO> seleccionar() throws SQLException;
    
    public int insertar(PersonaDTO persona) throws SQLException;
    
    public int actualizar(PersonaDTO persona) throws SQLException;
    
    public int eliminar(PersonaDTO persona) throws SQLException;
    
    
    
}
