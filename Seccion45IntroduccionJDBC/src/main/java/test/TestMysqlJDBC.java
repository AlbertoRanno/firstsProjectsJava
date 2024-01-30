/*
    SQL - SCTRUCTURE QUERY LANGUAGE (Para interactuar con la BBDD)
    DML - DATA MANIPULATION LANGUAGE (Sentencias principales:    
    
ACORDATE SIEMPRE DE LOS WHERE SINO REEMPLAZA O BORRA TODO!!!

    INSERT INTO persona(nombre, apellido, email, telefono) VALUES('Juan', 'Perez', 'jperez@mail.com', '5544332211');
    SELECT * FROM persona WHERE idpersona = 1;
    UPDATE persona SET nombre = 'Juanito', apellido = 'Gomez' WHERE idpersona = 1;
    DELETE FROM persona WHERE idpersona = 7;
    
OJO CON:
    UPDATE persona SET nombre = 'Juanito', apellido = 'Gomez' => SIN EL "WHERE idpersona = 1;" PORQUE CAMBIA TODO
    DELETE FROM persona  => SIN EL "WHERE idpersona = 7;" PORQUE BORRA TODO

Para comunicar un proyecto de Java con una BBDD, se utiliza el API JDBC - JAVA DATABASE CONENECTIVITY

Ahora si se comienza a usar Maven, dado que es una tecnología que se va a utilizar para ayudar a manejar las dependencias,
o librerias, que va a utilizar la app. Y al trabajar con una BBDD se necesitaran librerias para las conexiones a la BBDD
    
ANT no tiene administracion de librerias
    
GRADLE es parecido a Maven, pero Maven es mas maduro
    
Al crear un proyecto con Maven, pide tambien:
    -el Group Id (mx.com.gm.jdbc)
    -la version (1.0)
    -Package (Eliminar y crear despues)
    
Luego, click derecho Clean and Build, y como descarga librerias, fijarse que el Firewall u otros no generen error
    
Tuve el siguiente Problema:
    El proyecto inicialmente estaba configurado para utilizar Java 17, pero la versión de Maven Compiler Plugin en el pom.xml 
    no era compatible con esta versión, lo que causaba un error al intentar compilar el proyecto.

Solución:
    Se ajusto la configuración del pom.xml para reflejar que el proyecto se construirá y ejecutará en Java 11,
    la versión que tengo instalada en el sistema. Se cambiaron las configuraciones de <maven.compiler.source> 
    y <maven.compiler.target> a 11 y también se configuro el plugin maven-compiler-plugin para utilizar Java 11.

Resumen:
    El sistema tenía Java 17 instalado, pero la configuración del proyecto apuntaba a esta versión.
    Ajustamos el pom.xml para que sea compatible con Java 11, que es la versión que tienes instalada según la salida de tu consola.
    Después de los cambios, el proyecto se construyó correctamente sin errores y se instaló en Maven satisfactoriamente.
    Ahora el proyecto está configurado para compilar y ejecutarse en Java 11, y debería funcionar sin problemas
    en tu entorno de desarrollo.
  
Al construirse correctamente, crea un archivo, segun consola:
    /home/cdt/.m2/repository/mx/com/gm/jdbc/Seccion45IntroduccionJDBC/1.0/Seccion45IntroduccionJDBC-1.0.jar
    Este archivo, es el que se puede distribuir en diferentes equipos. El empaquetado.
    
Ahora agrego libreria de MYSQL (u otra BBDD) => Para eso voy a Proyect Files => pom.xml => Este es el archivo de 
    administracion de Maven. Aquí es donde se indican varias caracteristicas del proyecto, incluyendo las
    dependencias que se van a necesitar, en este caso MySQL.
En el pom, se muestran todas las configuraciones, y para cada dependencia que necesita agregar, debo agregar,
    debajo de properties, las siguientes etiquetas:
    ...
     </properties>
    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
        </dependency>
    </dependencies>
    Con Ctrl+Espacio autocierra las etiquetas, y cuando quiero empezar a escribir el contenido dentro de las
    mismas, el ide, puede ir sugiriendo
    
Luego clean and build => Exitoso, sobre la carpeta Dependencies, voy a ver: mysql-connector-java-8.0.23
    Con esto me aseguro de tener descargada la libreria

Recien ahora creo la clase y el paquete:    */
package test;

import java.sql.*;

public class TestMysqlJDBC {

    public static void main(String[] args) {
        //1- Para conectar a MySQL  => CADA BBDD TIENE SU PROPIA CADENA DE CONEXION => Buscarla!
        String url = "jdbc:mysql://localhost:3306/test?userSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        /*Cadena de conexion para mysql v.8 => localhost (local), el puerto (default), test (el schema creado)
            Para las ultimas versiones se piden mas parametros de seguridad:
            userSSL=false => indica que no voy a utilizar la conexion segura para utilizar mysql
            & => para utilizar otro parametro
            useTimezone => para indicar que vamos a utilizar una zona horaria
            serverTimezone=UTC => para indicar cual zona horaria
            allowPublicKeyRetrieval=true => esto para poder conectarse de manera exitosa
            
           2- Siguiente parametro: (No necesario en versiones recientes, o locales, aunque quizas si en versiones Web *1)   */
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // (*1) => ENvolverlo en un try/catch porque puede arrojar excepeciones

            //3-Siguiente, utilizo el mismo try/catch. Tipo Connection y tipo DriveManager los Importo, y pide user y password
            Connection conexion = DriverManager.getConnection(url, "root", "Halgren27!");
            //Arroja otro catch, del tipo SQLException

            //4-SIguiente, creo un objeto que va a permitir ejecutar sentencias, sobre la tabla de BBDD
            //Statement es un tipo interface, y del otro lado, dependera de la implementacion a la BBDD que se este utilizando
            Statement instruccion = conexion.createStatement(); //Aca es la impl de mysql, pero es el mismo codigo para todas
            //Una vez instanciado, puedo ejecutar una instruccion, como crear una cadena:
            var sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
            //Ejecuto ahora la instruccion. Para eso uso el tipo interface ResultSet
            ResultSet resultado = instruccion.executeQuery(sql);
            //COmo esta sentencia podria procesar mas de un registro uso un ciclo While
            while (resultado.next()) { //next va a indicar True si todavia quedan elementos a iterar
                System.out.print("Id persona: " + resultado.getInt("idpersona"));
                //Podría indicarle el nombre de la columna, o el indice, pero es mejor el nombre, por si cambian luego de ubicacion!
                //Cambio println a print, para que imprima todo en la misma linea
                System.out.print(" | nombre: " + resultado.getString("nombre"));
                System.out.print(" | apellido: " + resultado.getString("apellido"));
                System.out.print(" | email: " + resultado.getString("email"));
                System.out.print(" | telefono: " + resultado.getString("telefono"));
                System.out.println("");
            }
            /* Falta cerrar cada uno de los objetos abiertos!!!
            OJO => Cerrarlos de manera inversa!
            Original => conexion intruccion resultado => resultado instruccion conexion*/
            resultado.close();
            instruccion.close();
            conexion.close();

//        } catch (ClassNotFoundException ex) {     //Al comentar (*1) => ya no se usa esta excepcion
//            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        /*Este código establece una conexión a una base de datos MySQL y realiza una consulta para recuperar información 
        de la tabla "persona". 
        
                Resumen:

        URL de conexión: Se especifica la ubicación de la base de datos MySQL con detalles como el host, 
                puerto y configuraciones adicionales.

        Establecimiento de conexión: Utiliza DriverManager.getConnection para establecer una conexión
                a la base de datos con el usuario y la contraseña proporcionados.

        Creación de una instrucción: conexion.createStatement() crea una instrucción que se utilizará 
                para ejecutar consultas SQL en la base de datos.

        Consulta SQL: La variable sql contiene la consulta que se ejecutará en la base de datos. 
                En este caso, se seleccionan datos específicos de la tabla "persona".

        Ejecución de la consulta: instruccion.executeQuery(sql) ejecuta la consulta y devuelve 
                un conjunto de resultados.

        Recorrido de resultados: Se utiliza un bucle while (resultado.next()) para iterar sobre los
                resultados y mostrar la información de cada fila.

        Cierre de recursos: Después de utilizar los resultados, la instrucción y
                la conexión se cierran para liberar recursos.
        
        
        EL TEMA CON ESTO, ES QUE UN CODIGO GRANDE, DESPROLIJO Y NO REUTILIZABLE, POR LO QUE EN EL SIGUIENTE PROYECTO,
        VOY A DISTRIBUIR, Y HACER MAS VERSATIL TODO EL CONTENIDO DE ESTA CLASE*/

    }
}
