package mx.com.gm.serivicio;

import java.util.List;
import mx.com.gm.dao.AlumnoDao;
import mx.com.gm.domain.Alumno;

public class ServicioAlumno {
    //Capa de servicio, apuntando en el futuro, utilizar con SpringBoot / Postman

    /*Instancia ALumnoDao, para usar sus metodos de conexion
    y lo paso como atributo privado para encapsualarlo y que solo se pueda usar desde esta clase */
    private AlumnoDao alumnoDao = new AlumnoDao();

    public List<Alumno> listarAlumnos() {
        return alumnoDao.listar();
    }

    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            /*Si idAlumno, era int, no aceptaba la comparacion
            Si alumno, existe, pero no tiene ID => INSERT*/
            alumnoDao.insertar(alumno);
        } else { //Si ya tiene ID => UPDATE
            alumnoDao.actualizar(alumno);
        }
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnoDao.eliminar(alumno);
    }

    public Alumno encontrarAlumno(Alumno alumno) {
        return alumnoDao.buscarPorId(alumno);
    }
}
