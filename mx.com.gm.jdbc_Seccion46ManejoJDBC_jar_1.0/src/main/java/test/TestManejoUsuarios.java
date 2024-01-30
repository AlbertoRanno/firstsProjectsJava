package test;

import datos.*;
import domain.Usuario;
import java.util.*;

public class TestManejoUsuarios {

    public static void main(String[] args) {
        //Usare los metodos definidos en usuarioDAO    
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
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
        List<Usuario> usuarios = usuarioDao.seleccionar();
        for (Usuario usuario : usuarios) {
            System.out.println("usuario = " + usuario);
        }
    }

}
