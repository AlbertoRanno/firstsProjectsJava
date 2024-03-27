package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /*  Clase principal en los proyectos de Spring, gracias a la anotacion  @SpringBootApplication
        El metodo run, permite correr en el servidor. Y se pasa la clase que quiero que levante,
        y los argumentos.
        RUn y en consola veo en el puerto donde corre => localhost:8080
        
        Un controlador de tipo REST, envia info al navegador, mediante GET.
        Pero podria usar POST, PUT, DELETE (posteriormente)
        
        Spring es un contenedor de clases Java, entonces las clases, deben estar dentro del mismo
        paquete que está la clase con la anotacion @SpringBootApplication
        Si hiciera ctrl + click, en esa anotacion, veria que dentro esta @componentScan, que es el
        que va a buscar las clases que se encuentran dentro de este paquete, sin reconocer las que estan
        por fuera. Pero si las que esten dentro de subpaquetes dentro de este.
        Ej. creo la clase ControladorInicio, del tipo REST
    */
}
