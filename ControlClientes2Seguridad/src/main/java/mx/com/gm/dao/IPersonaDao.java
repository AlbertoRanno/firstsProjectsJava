package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;


public interface IPersonaDao extends CrudRepository<Persona, Long> {

}

/*Anteriormente, por si lo veo en algún proyecto, se agregaba "@Repository" pero sobre la implementación, es decir,
sobre la clase concreta. Ahora eso se omite, dado que Spring maneja ahora directamente una interface, que viene
con los principales metodos precargados, y que si necesito alguno mas particular lo puedo pasar en el cuerpo de la misma (luego).

Por lo tanto, ahora se hace el extends CrudRepository<>, donde:
- si hago con ctrl + click, veo los metodos que trae por default
- en los <> le paso el tipo de Entidad, que va a manejar, en este caso, Persona, y luego, el tipo de la llave primaria,
que utiliza esa entidad, en este caso, Long
- Por otro lado, con ella, no necesito crear una implementacion, dado que la crea SpringBoot por default

Luego de crearla, necesito inyectarla en el Controlador (es, de momento al menos, quien esta manejando la relacion con la BBDD)

*/
