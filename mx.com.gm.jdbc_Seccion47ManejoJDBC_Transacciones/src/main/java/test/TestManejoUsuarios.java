package test;

import datos.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoUsuarios {

    public static void main(String[] args) {

        //Usare los metodos definidos en usuarioDAO
//        UsuarioJDBC usuarioDao = new UsuarioJDBC();
//INSERTAR
//        Usuario usuarioNuevo = new Usuario("MartaRanno", "DOncellaDeHierro");
//        usuarioDao.insertar(usuarioNuevo);
//ACTUALIZAR
//        Usuario usuarioModificado = new Usuario(2, "MariaRanno", "DoncellaDeHierro");
//        usuarioDao.actualizar(usuarioModificado);
//ELIMINAR
//        Usuario usuarioEliminado = new Usuario(2);
//        usuarioDao.eliminar(usuarioEliminado);
//LISTAR
//        List<Usuario> usuarios = usuarioDao.seleccionar();
//        for (Usuario usuario : usuarios) {
//            System.out.println("usuario = " + usuario);
//        }


//Creo el objeto conexion para transacciones
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            //Seteo el autocommit en false
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //Creo el objeto para acceder a los metodos y le paso la nueva conexion
            UsuarioJDBC usuario = new UsuarioJDBC(conexion);

            //Armo el bloque de sentencias:
            Usuario actualizoUsuario = new Usuario(1, "Bolrag", "bolrag25");
            usuario.actualizar(actualizoUsuario);

            Usuario nuevoUsuario = new Usuario("Dolbare", "Halgren72");
            usuario.insertar(nuevoUsuario);

            //Si todo va bien, que guarde los cambios
            conexion.commit();

        } catch (SQLException ex) {
            //Sino, roleback
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
