package ar.com.gm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //El tipo que voy a usar para Get Post Delete... / Permite que la clase del Run la reconozca
public class ControladorInicio {

    @GetMapping("/") //Indico la ruta
    public String inicio() {
        return "Hola";
    }

}
