package test;

import java.sql.*;

public class TestMysqlJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // (*1) => ENvolverlo en un try/catch porque puede arrojar excepeciones

            Connection conexion = DriverManager.getConnection(url, "root", "Halgren27!");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.print("Id persona: " + resultado.getInt("idpersona"));
                System.out.print(" | nombre: " + resultado.getString("nombre"));
                System.out.print(" | apellido: " + resultado.getString("apellido"));
                System.out.print(" | email: " + resultado.getString("email"));
                System.out.print(" | telefono: " + resultado.getString("telefono"));
                System.out.println("");
            }

            resultado.close();
            instruccion.close();
            conexion.close();

//        } catch (ClassNotFoundException ex) {     //Al comentar (*1) => ya no se usa esta excepcion
//            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
