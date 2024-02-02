package datos;

/*      Transacciones:
Una transacción es un conjunto de instrucciones agrupadas en un bloque de ejecucion

la idea es de analizar, que si algunas de estas instrucciones falla, se puede hacer roll back, y no modificar la BBDD
Pero que si todas se dan de manera correcta, ahí se modifica la BBDD haciendo un commit

-Para lograr esto, lo primero es poner el autocommit en false, para que no haga un commit hasta asegurarnos de que todo esté ok
(ojo por default, autocommit viene en true)
-En caso de que no haya errores se hace el commit 
-En caso de que haya error, se hace rollback, es decir, se revierten los cambios realizados por el bloque de ejecucion

Obs! SI cerramos la conexion JDBC se hace un commit, incluso si se deshabilito la propiedad autocommit   */

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaJDBC {

    private Connection conexionTransaccional; //(*1) Se recibe un objeto desde fuera de esta clase => Constructor:

    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";

    public PersonaJDBC() {
    }

    public PersonaJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
        /*-Inicializo la misma conexion hacia la BBDD, 
        -la unica diferencia es que esta conexion no se va a cerrar al ejecutar alguno de estos metodos
        -sino que se mantendra abierta, y se manejara desde fuera de la clase
        -La clase externa es la que va a decidir cuando se hace commit o rollback de toda la transaccion
        -Aplico condicionales ternarios en cada metodo, para que registren, si ya hay una conexion transaccional,
        prima esa, y no crea una nueva conexion. Si no la hay, si la crea (*2) y luego la cierra (*3).
         */
    }


    /*Este proyecto es copia de la seccion 46 - sin Transacciones
    Ahora lo que sucede es lo siguiente, dado que una transaccion, ejecuta, varias sentencias,
    por ejemplo, un insercion, una modificacion y un delete, necesita que la conexion, sea una sola
    Y no, como era hasta ahora, una conexcion por metodo, que en cada metodo, abria y cerraba
    Entonces, hay que modificar cada metodo, aclarando el condicional, de que si hay una conexion general,
    priorice esa. Y para eso, es necesario extraer de esta clase, el manejo de la conexion => creo el atributo conexion (*1)    */
    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection(); //(*2)
            stmt = conn.prepareCall(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
            /*Si cada metodo procesa la excpecion, no se llega al error del rollback => acá que reporten, y
            que salte el error en testManejoPersonas*/

//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexionTransaccional == null) { //(*3) => si no hay conexion transaccional, es que se creo una nueva...
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int actualizar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int eliminar(Persona persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }
}
