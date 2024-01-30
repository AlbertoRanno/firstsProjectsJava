/*De la clase TestMyqlJDBC, aplico las buenas practicas => reparto responsabiliades => hago un codigo reutilizable 
Todo esto va a formar parte de la capa de datos (<= Negocio <= Presentacion)    */
package datos;

import java.sql.*;

public class Conexion { //OJO! No llamarla en ingles, xq ya existe con ese nombre, y dara error!

    //Los valores de url, user y password, los paso como constantes de la clase:
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Halgren27!";

    //Creo el metodo publico para conectarme, static para que no se necesite instanciar, y devuelve un objeto del tipo Connection:
    public static Connection getConnection() throws SQLException {
        /* Como esto puede arrojar una excepcion, o manejo en esta instancia el try/catch, o lo propago al metodo 
        que lo llamo como throws. Lo ultimo es preferible.      */
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    /*Siendo esta clase la encargada de las conexiones, voy a crear los metodos para cerrar cada uno de los objetos
    y liberar recursos. Para eso creo el metodo close, el cual va a estar sobrecargado, es decir, puede recibir
    distintos parametros dependiendo de que tiene que cerrar.
    Estos metodos tambien podran recibir excepciones, por lo que las propago a los metodos que los llamaron
     */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

//    public static void close(Statement stmt) throws SQLException{
//        stmt.close();
//    }
    //Los objectos de Statement, tienen una interface: PreparedStatement, por lo que seria una buena practica aplicar la misma.
    //Dado que tiene una mejor performance  :
    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }

    /*Esta clase, se puede utilizar en diferenctes proyectos, a diferencia de la parte de la conexion 
    del codigo de la clase TestMyqlJDBC */
}
