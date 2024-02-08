package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;

public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            //Uso la interface, y digo que implementacion quiero usar en este caso
            //INterface = Implementacion especifica
            PersonaDao personaDao = new PersonaDaoJDBC(conexion);
            
            List<PersonaDTO> personas = personaDao.seleccionar();
            
            for(PersonaDTO persona: personas){
                System.out.println("Persona DTO= " + persona);
            }

            conexion.commit(); //No hace falta el commit para un select, pero quedo generico el codigo
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out); 
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        }

    }

}
