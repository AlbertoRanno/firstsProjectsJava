package test;

import datos.*;
import domain.UsuarioDTO;
import java.sql.*;
import java.util.List;

public class TestManejoUsuarios {

    public static void main(String[] args) {

        //Creo el objeto conexion para transacciones
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            //Seteo el autocommit en false
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //Creo el objeto para acceder a los metodos y le paso la nueva conexion
            //Pero usando la interface
            UsuarioDao usuarioDao = new UsuarioDaoJDBC(conexion);

            //Armo el bloque de sentencias:
            //En este caso solo un select para probar
            List<UsuarioDTO> usuarios = usuarioDao.seleccionar();
            /*Recordar siempre la logica de todo esto:
             -al utilizar 'usuarioDao.seleccionar();' la variable, pertenece al tipo interface
             -si el dia de mañana, cambio a otra implementacion, en  'new UsuarioDaoJDBC(conexion);' 
             -el resto del codigo no cambia => Estas son las buenas practicas!*/
            
            for(UsuarioDTO usuario: usuarios){
                System.out.println("Persona DTO= " + usuario);
            }
            
            
            
            conexion.commit();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Algo salió mal, entrando al roleback");

            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        }

    }

}
