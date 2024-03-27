package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ControladorInicio {

    //Creo un metodo que envie un string al navegador
    //Pero lo debo asociar a una ruta o path:
    @GetMapping("/") //Al indicar que es get, ya sabe que envia info
    public String inicio() {
        //log.info("ejecutando el controlador rest");
        //log.debug("mas detalle del controlador, gracias a config de properties");
        return "Hola Mundo con Spring Boot 1";
    }

    //Gracias a lombok, puedo utilizar la anotacion @Slf4j, para mandar info a la consola
    //Luego de importar, tendre acceso a la variable "log"
}
