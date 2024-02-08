package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource; //Importo la libreria que agregue al POM

//objetivo => establecer una conexión a una base de datos MySQL utilizando JDBC y Apache Commons DBCP2 para 
//la gestión del pool de conexiones. Se mejoró con una 2da versión, más eficiente que es la que quedó activa:
public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Halgren27!";
    
    private static BasicDataSource dataSource;//(*1)

    
    public static DataSource getDataSource() {
        /* Luego de haber instalado la dependencia, creo un nuevo objeto para manejar el pool de conexiones.
        Version1: se crea un nuevo objeto BasicDataSource cada vez que se llama al método getDataSource(). 
        Esto significa que se crea un nuevo pool de conexiones cada vez que se solicita una conexión a la base de datos.
        Lo cual no está copado, por eso, esta version se comentó:   */
        /*
        BasicDataSource ds = new BasicDataSource();
        //Con esto cree el objeto del pool de conexiones, ahora le paso los valores de la conexion:
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASSWORD);
        //DEFINO EL TAMAÑO INICIAL DEL POOL DE CONEXIONES:
        ds.setInitialSize(5);
        //Cuidado con la cantidad por default! dado que consume demasiado recursos y podria bloquear la app
        return ds;
        */
        
        /* En esta version, se utiliza una variable estática dataSource para almacenar el objeto BasicDataSource (*1). 
        Este objeto se crea solo una vez cuando se llama por primera vez al método getDataSource(). 
        Las siguientes llamadas a getDataSource() devolverán la misma instancia de dataSource, 
        evitando la creación repetida de pools de conexiones.*/
         if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(5);
        }
        return dataSource;
        /* Otra diferencia es que en la V1, La configuración del pool de conexiones se realiza directamente
        dentro del método getDataSource(), estableciendo el tamaño inicial del pool.
        Y en esta, La configuración del pool de conexiones se realiza dentro del bloque if (dataSource == null),
        lo que significa que la configuración solo se realiza cuando el objeto dataSource es nulo. 
        Esto garantiza que la configuración del pool de conexiones solo se realice una vez, incluso si se llama
        varias veces al método getDataSource().
        
        Conclusion, la version 2, proporciona una mejor gestión de recursos y rendimiento, lo que podría conducir 
        a una aplicación más eficiente y robusta en términos de conexión a la base de datos.*/
    }

    //AHora en lugar de usar DriverManager, que era para un sola conexion, uso getDataSource
    public static Connection getConnection() throws SQLException {
        //return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        //Pasa a:
        return getDataSource().getConnection(); //Como ya está configurado, no necesito pasar de nuevo los valores
        //Con estos cambios ya es suficiente, y puedo probar la app
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}

