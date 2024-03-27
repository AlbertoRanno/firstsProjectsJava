package mx.com.gm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller//@RestController //=> Paso a controlodor Spring MVC
//La configuracion de ambos controladores es similar, salvo que en lugar de enviar una cadena, 
//ahora va regresar el nombre de la pagina que se va a desplegar en el navegador (*)
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;
    
    //Creo un metodo que envie un string al navegador
    //Pero lo debo asociar a una ruta o path:
    @GetMapping("/") //Al indicar que es get, ya sabe que envia info
    public String inicio(Model model) {
        //log.info("ejecutando el controlador rest");
        //log.debug("mas detalle del controlador, gracias a config de properties");
        //return "Hola Mundo con Spring Boot 121"; (*)
        var mensaje = "Hola Mundo con Thymeleaf 2222";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("mensajeAppProperties", saludo);
        return "index"; //creo un archivo llamado index.html
    }

    //Gracias a lombok, puedo utilizar la anotacion @Slf4j, para mandar info a la consola
    //Luego de importar, tendre acceso a la variable "log"
}
