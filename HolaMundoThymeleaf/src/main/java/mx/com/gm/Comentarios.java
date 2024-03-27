/*
Spring => Originalmente agilizaba JavaEE, pero ya es mucho más e independiente.
Spring Boot, permite hacer las apps de manera más rápida.
Spring Cloud, permite hacer apps en la nube…

Spring Boot => 2 stacks posibles,el que me va a interesar es:
Servlet Stack => Aplicaciones del tipo (Spring) MVC, tipo Rest, (para comunicarse con React o Angular), utiliza el API de los servlet,
y usa además JDBC, JPA, y puede comunicarse a BBDD relacionales o no relacionales.
El otro Stack, es reactive, el cual toma ventaja de los procesadores de varios núcleos, para manejar gran cantidad de conexiones
simultáneas.

Al usar Spring Boot:
-Todas las configuraciones son más sencillas, ya no se usan XML, u otros tipos.
-Inicio enseguida con Spring Initializr
-Puedo construir REST Api, websocket, web, tasks, de manera rápida
-Simplifica la seguridad
-Soporte para SQL y NoSQL
-Tiene embebido servidores como Tomcat
-Trae LiveReload, para que se actualice de manera automática la aplicación
-Al utilizar el sistema de administración de librerías de Maven ( o Gradle) puedo utilizar cualquier IDE, 
de hecho tiene uno propio como Spring Tool Suite, pero voy a seguir con NetBeans

Para iniciar un proyecto de Spring, tengo 2 formas:
-Ir a la página, y configurar todo desde allí: https://start.spring.io/ , luego, generar, y baja el proyecto en un .zip. 
Descomprimo. Voy a netbeans, file, open project, busco la ruta, señalo y open project
-Desde netbeans, para el cual tengo que bajar un plugin estable para mi version de netbeans:
https://plugins.netbeans.apache.org/catalogue/?id=4
luego desde el IDE, tools, plugins, downloaded, seleccionar, e instalar siguiendo los pasos. 
Se reinicia => new project, java with maven, Spring Boot Initializr project. Completo todo lo de configuración que aparece debajo:

Configuración de un proyecto:
Al crearlo, puedo elegir Maven o Gradle para administrar las librerías
El lenguaje de programación: Java, Kotlin, Groovy
La versión de Spring Boot, elegir la estable, no las Snapshot
Grupo: mx.com.gm
Artefacto: HolaSpring
Descripción: …
Paquete: (=grupo)
Tipo de Paquete (Jar o War): Ya no se usan las War, sino que con las Jar es suficiente
Versión de Java

Dependencias:
Diferencia entre Spring y Spring Boot, es que el último ya permite agregar librerías fácilmente, con tildar sus checkboxes, 
ya se configuran.

*DevTools
-Spring Boot DevTools: reinicia más fácilmente las páginas en el navegador, y permite utilizar LiveReload, para ni siquiera 
tener que actualizar el navegador.
-Lombok: por medio de anotaciones, permite reducir mucho código, por ejemplo los métodos getters and setters, 
constructores, hashCode, el manejo de log4j de forma automática
*Web
-Spring Web: permite crear apps del tipo REST, y también permite del tipo Spring MVC, con el servidor embebido de Tomcat

*Template
-Thymeleaf: permite agregar de forma más simple páginas webs a las aplicaciones (reemplaza los JSP y permite usar
algo parecido a lo que viste en el curso anterior: HTML con info dinámica ).
Nota: tener en cuenta que solo es una de las tecnologías de presentación que puede usar Spring, dado que es tan 
robusto que puede usar PDFs, Excels, Html, etc

*Seguridad
-(más adelante)

*Luego
(Spring data JPA, drivers de MySQL, o Mongo

Estructura de los proyectos:
Incluyendo:
- pom.xml => dependencias
- mvnw.cmd => desplegar la app, incluso sin tener instalado maven
- src => 
=>main => java (clases => mx.com.gm=> clase) y resources (configuración: static (para img, videos, JS y CSS) 
templates (archivos creados con thymeleaf ) y el archivo application.properties (para modificar las configuraciones
de Spring, Spring Boot, configuraciones a las BBDD, el manejo de logging. cambiar el puerto del servidor embebido de Tomcat, etc)
=>test

He intentado varias veces el clean and build, y daba error, siguiendo tutoriales, y a chatgpt, logré solucionarlo,
este es un resumen de chatgpt:

resumen de lo que hemos hecho y cómo abordamos el problema:

Problema Inicial: Al intentar compilar el proyecto HolaSpring, se encontró un error relacionado con la resolución del POM 
padre de Spring Boot. El error original indicaba que Maven no podía resolver 
el POM de org.springframework.boot:spring-boot-starter-parent:pom:3.1.9.RELEASE.

Primera Solución Propuesta: Se creó un archivo settings.xml personalizado para Maven, en el que se agregaron espejos 
de Maven para evitar problemas de acceso a ciertos repositorios.

Segundo Problema Encontrado: Después de aplicar el nuevo settings.xml, se encontró un nuevo error que indicaba que Maven
no podía encontrar el POM de Spring Boot en el repositorio central de Maven.

Segunda Solución Propuesta: Se cambió la versión de Java utilizada en el proyecto a Java 11, ya que la versión original
era Java 17, lo que causaba un error de compilación debido al "invalid target release: 17". Esto se solucionó 
configurando el proyecto para usar Java 11.

Resultado Final: Después de ajustar la versión de Java y aplicar el archivo settings.xml modificado, el proyecto se
compiló y construyó con éxito, como se confirmó por el mensaje "BUILD SUCCESS" al final de la salida de Maven.

En resumen, el problema inicial se resolvió ajustando la configuración de Maven para permitir la resolución 
de dependencias, y posteriormente, se solucionó un problema adicional cambiando la versión de Java utilizada en el proyecto.

HE GUARDADO EL SETTINGS Y EL REPOSITORY CON LOS CUALES EL PROYECTO DE INTRA FUNCIONABA, LUEGO REEMPLAZARLOS.
DE HECHO, EL PROBLEMA SE SOLUCIONO, CAMBIANDO EL POM, QUIZÁS PUEDA VOLVER A PONER ESOS ORIGINALES, Y FUNCIONE TODO OK.

BUILD SUCCES => Sigo…

No funcionan bien las dependencias, 


Clase controladorINicio:

package mx.com.gm;

// Para que Spring reconozca esta clase le agrego la anotacion: @RestController
// Para que la reconozca como un componente, y la sume al contenedor de Spring
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
        //log                //.info("ejecutando el controlador rest");
        return "Hola Mundo con Spring 33sdf3";
    }

    //Gracias a lombok, puedo utilizar la anotacion @Slf4j, para mandar info a la consola
    //Luego de importar, tendre acceso a la variable "log"
}

—--------------------------------

package mx.com.gm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HolaSpringApplication.class, args);
	}

        /*Clase principal en los proyectos de Spring, gracias a la anotacion  @SpringBootApplication
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
        
}




POM

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>mx.com.gm</groupId>
    <artifactId>HolaSpring</artifactId>
    <version>1.0</version>
    <name>HolaSpring</name>
    <description>HolaMundo con Spring</description>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <image>
                        <builder>paketobuildpacks/builder-jammy-base:latest</builder>
                    </image>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>



con:
 sudo update-alternatives --config java
pase de java 11, a java 17…

 










<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.4</version>
        
    </parent>

    <groupId>mx.com.gm</groupId>
    <artifactId>HolaMundoThymeleaf</artifactId>
    <version>1.0</version>
    <name>HolaMundoThymeleaf</name>
    <description>HolaMundo con Spring</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <image>
                        <builder>paketobuildpacks/builder-jammy-base:latest</builder>
                    </image>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>










<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.4</version>
    </parent>

    <groupId>mx.com.gm</groupId>
    <artifactId>HolaMundoThymeleaf</artifactId>
    <version>1.0</version>
    <name>HolaMundoThymeleaf</name>
    <description>HolaMundo con Spring</description>
    <properties>
        <java.version>11</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>*/

