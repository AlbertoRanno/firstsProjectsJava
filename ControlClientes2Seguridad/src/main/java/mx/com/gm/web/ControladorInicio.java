package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.servicio.IPersonaService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    /* Luego de terminar la implementacion de la capa de servicio,
    inyecto esa, y me libero de la dependencia de la capa de datos.
    //Inyecto la interface PersonaDao, para poder trabajar con sus metodos:
    @Autowired //Similar al Inject de Java EE
    private IPersonaDao personaDao;
     
    Importante: Notar que inyecto la interface, y es Spring, quien en 
    automatico, va a buscar la implementacion que se haya marcado con 
    @Service (PersonaServiceImpl).
    Si luego quisiera cambiar la implementacion, no hay problema, podria
    cambiarla, y aqui, en el controlador no tendria que tocar nada.
    Dado que estaria desacoplando cada una de las capas
    tanto en el controlador, donde inyecto la capa de Servicio, y en la
    capa de servicio, desacoplo la capa de datos, haciendo exactamente lo 
    mismo con la interfaz IPersonaDao, donde Spring en automatico, 
    va a crear una implementacion de esa interfaz de personaDao (por eso,
    en ese caso no fue necesario, ni crear ni inyectar, una clase completa
    de PersonaDao, todo fue automatico al extender de CrudRepository
     */
    @Autowired
    private IPersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ejecutando el controlador Spring MVC");
        //Recupero los objetos del tipo persona, ahora desde la bbdd, gracias IPersonaDao:
        //var personas = personaDao.findAll();
        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas); //Ahora mando desde la base de datos => Limpio el index
        return "index";
    }

    /*Voy a crear un nuevo objeto del tipo Persona, lo puedo hacer dentro
    del metodo, o decirle a Spring que lo haga, pasando el objeto como parametro
    Entonces, Spring va a buscar dicho objeto en su fábrica, si no lo encuentra, 
    va a crear uno nuevo*/
    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        //El siguiente paso es redirigir hacia la vista
        return "modificar"; //se llama asi, porque va a hacer ambas cosas
        //Agrego en templates la vista de modificar
    }

    /*Validaciones: Primero las anotaciones en la clase de entidad,
    Luego los span preguntando si hay msj, y mostrandolos en ese caso,
    Por ultimo, el controlador, con sus anotaciones, y compartiendo el error a la vista
    Con @Valid, le antepongo al obj Persona que se va a validar ese objeto, y en caso
    de haber error, paso como 2do parametro, los mismos. Estos dos, valid y el error, 
    SIEMPRE van juntos*/
    
    @PostMapping("/guardar") //debe ser igual a la que manda el form
    public String guardar(@Valid Persona persona, Errors errores) {
        if (errores.hasErrors()) {
            return "modificar";
        }
        /* De nuevo al pasarlo como parametro, Spring busca el objeto en el
        lo recupera y lo inyecta. En agregar, como era la primera vez, entonces
        creaba un nuevo objeto. Pero ahora si este objeto ya se encuentra
        en memoria, va a guardar la nueva instancia que este en memoria, con
        cada uno de los valores que se han cargado en el formulario */
        personaService.guardar(persona); //Inserta en la BBDD
        log.info("Persona guardada exitosamente: {}", persona);
        //Redirecciono:
        return "redirect:/";
    }

    /*Puedo chequear en la bbdd que se grabo correctamente.
    Importante: puedo correr el siguiente comando en la base de datos,
    para que corra de nuevo y reasigne los IDs, mediante:    
    ALTER TABLE table_name AUTO_INCREMENT = 1;    
    ALTER TABLE persona AUTO_INCREMENT = 1*/
 /*Por ser un simple link es GET, y la ruta es la del metodo que implementa,
    y el idPersona, es entre llaves que Spring asocie el id correspondiente.*/
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        /*Al definir un objeto del tipo Persona, Spring lo va a buscar, y si existe,
        lo va inyectar, y ademas, va a hacer la asociacion, con el parametro de la ruta, 
        es decir con el idPersona. Por ende no es necesario inicializar el objeto,
        ni hacer los sets, ya que lo hará automático Spring.
        Y recibe la variable de modelo para poderla compartir a la vista.
        Mediante personaService, pasandole el obj persona, el cual tiene el id, lo busco.
        Y lo asigno de nuevo a la misma variable persona para no tener que crear otra:  */
        persona = personaService.encontrarPersona(persona);
        /*Y así comparto este objeto encontrado a la vista (por ahora con los valores que tenía...)
        Nota, la vista de modiciar y crear es la misma, dado que, si el objeto es nuevo, los
        campos estarán vacíos, y sino, se completara gracias a este objeto persona*/
        model.addAttribute("persona", persona);
        return "modificar";
        /*IMPORTANTE, si a esta altura, guardo desde la pantalla de editar, lo que sucede es que 
        se crea un nuevo registro, dado que en ningun momento en el html de modificar estoy teniendo en
        cuenta a los IDs. Se guardaba sin ID (porque se encargaba la BBDD), pero entonces, a esta altura,
        JPA y hibernate, lo consideran un nuevo objeto, ya que no está establecido el valor del ID. 
        Para evitarlo, dentro del formulario debo aclarar el valor del ID persona, si es que existe,
        y para eso, la forma mas simple es utilizar un campo oculto.
         */
    }

    //De nuevo, como es un link, se usa get:
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }

    // Otra forma, con Query Parameters
    @GetMapping("/eliminar2")
    public String eliminar2(Persona persona) {
        personaService.eliminar(persona);
        return "redirect:/";
    }

}
/*
package mx.com.gm.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Para que Spring reconozca esta clase le agrego la anotacion: @RestController
// Para que la reconozca como un componente, y la sume al contenedor de Spring
@Controller //RestController
//Gracias a lombok, puedo utilizar la anotacion @Slf4j, para mandar info a la consola
//Luego de importar, tendre acceso a la variable "log"
@Slf4j
public class ControladorInicio {
    
    //Para acceder al msj desde el application properties, el index.saludo:
    //@Value("${index.saludo}")
    //public String saludo;
    //Luego la comparto a la vista
    //Comento todo lo relacionado a compartir el msj desde el app.properties, para comenzar con BBDD

    //Creo un metodo que envie un string al navegador
    //Pero lo debo asociar a una ruta o path:
    @GetMapping("/") //Al indicar que es get, ya sabe que envia info
    public String inicio(Model model) { //En lugar de usar el request y response, se usa la clase model (*1)
        //var mensaje = "Mensaje desde variable, gracias a Model"; //Invento la variable, para pasarla a la vista
        //Comento todo lo relacionado a la variable mensaje, para comenzar con BBDD
        
        //IDEM, al iniciar BBDD, las personas vendran desde la misma, las comento:
        //Creo variable de persona, considerando la clase Persona, para poder compartirla con la vista
//        var persona = new Persona();
//        persona.setNombre("Alberto");
//        persona.setApellido("Ranno");
//        persona.setEmail("aranno@mail.com");
//        persona.setTelefono("44223366");
//        
//        var persona2 = new Persona();
//        persona2.setNombre("Mariana");
//        persona2.setApellido("Taboada");
//        persona2.setEmail("mTaboada@mail.com");
//        persona2.setTelefono("44323366");
//        
//        var persona3 = new Persona();
//        persona3.setNombre("Joaquin");
//        persona3.setApellido("Perez");
//        persona3.setEmail("jperez@mail.com");
//        persona3.setTelefono("44123366");        
//        
//        //Armo un listado con las personas:
//        List<Persona> personas = new ArrayList();
//        personas.add(persona);
//        personas.add(persona2);
//        personas.add(persona3);
//        
//        //Otra forma de crear la lista:
//        var personas2 = Arrays.asList(persona, persona2);
//        
//        //Ejemplo de Lista Vacía para el condicional de index (reemplazar "personas" por "personas3" en el index)
//        var personas3 = new ArrayList(); 
        
       log.info("ejecutando el controlador Spring MVC"); //Se envia al refrescar el navegador
       //log.debug("más detalle del controlador"); //Ver en app.properties si esta activo el modo debug
       // return "Hola Mundo con Spring";
       //(*1) que se instancia de forma automatica para poder usar sus metodos, y pasar variables a la vista
       //model.addAttribute("mensaje", mensaje);//Comparto (llave, valor) => es un mapa
       //model.addAttribute("saludo", saludo);
       //model.addAttribute("persona", persona);
       
       //EN LIMPIO, SOLO QUEDARIA EL DE COMPARTIR EL LISTADO PERSONAS, PERO ESE LO TENGO QUE TRAER DE LA BBDD, ASI QUE LO COMENTO
       
       //model.addAttribute("personas", personas);
       return "index"; //Thymeleaf => Página
    }
}

 */
