/*
El objetivo siempre es minizar costos de desarrollo => mas facil => mas rapido => menos costo

La cohesión es la medida en la que un componente de software se dedica a realizar solo la tarea para la cual fue creado,
delegando las tareas complementarias a otros componentes (se busca Alta => muy preciso)

El acoplamiento es la medida en que los cambios de un componente tiende a necesitar  cambios de otros componentes 
(se busca Baja => frente a un cambio, mientras menos archivos tenga que tocar, mejor)

La mezcla de ambas, lleva a un promedio... no puedo hacer 200 archivos, porque luego habría un alto acoplamiento
No puedo hacer solo un archivo, porque habría baja cohesión, y no serían reutilizables sus partes

Hay varios patrones de diseño para seguir estas buenas prácticas.
Por lo gral, tenemos:

Persona => interactua con la página, sería con la capa de presentación

Capa de presentación => con la capa de Servicio (la lógica propia del negocio, no tan tecnica)

La capa de servicio => con la capa de Acceso a Datos (la parte tecnica)

La capa de acceso a datos => con la base de datos, o archivo

Podria haber mas capas intermedias, u omitirse la de servicio... pero no es lo recomendado

Dentro de la presentacion, entre los patrones conocidos estan M-V-C // Front COntroller // DTO (Data Transfer Object)
Dentro de la de servicio, Business Delegate, Service Locator, DTO
Dentro de la de datos, DAO, DTO...

Patrón DTO (Objeto de Transferencia de Datos):

Concepto básico: El DTO es como un mensajero que lleva datos entre diferentes partes de un programa. 
Imagina que necesitas enviar información desde la capa de datos hasta la capa de presentación,
pero no quieres enviar objetos de la base de datos directamente, porque podrían ser demasiado complicados 
o tener más información de la necesaria. Entonces, usas un DTO para recoger solo los datos importantes 
y enviarlos de manera más simple.

Ejemplo en capas:
Capa de Datos: Aquí es donde obtienes los datos de la base de datos. Por ejemplo, tienes una clase UsuarioEntity 
que representa un usuario en la base de datos con muchos campos como nombre, correo electrónico, etc.
Capa de Servicio: Aquí es donde necesitas enviar los datos a la capa de presentación. En lugar de enviar la UsuarioEntity,
creas un DTO llamado UsuarioDTO, que tiene solo los campos necesarios para mostrar en la interfaz de usuario, como nombre 
y correo electrónico.
Capa de Presentación: Finalmente, en la interfaz de usuario, recibes el UsuarioDTO y muestras los datos en pantalla.

Patrón DAO (Objeto de Acceso a Datos):

Concepto básico: El DAO es como un intermediario entre tu código y la base de datos. 
Imagina que necesitas guardar un nuevo usuario en la base de datos. En lugar de escribir el código de acceso 
a la base de datos directamente en tu servicio, usas un DAO para manejar todas las operaciones de acceso a datos.

Diferencia con DTO: Mientras que el DTO se usa para transferir datos entre diferentes partes de la aplicación, 
el DAO se utiliza para manejar todas las operaciones relacionadas con la base de datos, como guardar, recuperar, 
actualizar o eliminar datos.

Ejemplo simplificado: Supongamos que necesitas guardar un nuevo usuario en la base de datos.

En lugar de escribir el código para guardar el usuario directamente en tu servicio, creas un DAO llamado UsuarioDAO.
En el servicio, llamas al método guardar del UsuarioDAO, pasándole el objeto UsuarioDTO que quieres guardar en la base de datos.
Dentro del UsuarioDAO, implementas la lógica para guardar el usuario en la base de datos, utilizando, por ejemplo, sentencias SQL
o métodos de un ORM (mapeador objeto-relacional).

Resumen: Mientras que el DTO se enfoca en los datos que se transfieren entre las capas de una aplicación, 
el DAO se enfoca en las operaciones de acceso a datos en la base de datos.

Ahora voy a reformular la App, mejorando la capa de Datos, es decir, en lugar de acceder directo a PersonaJDBC (ahora,
llamada 'PersonaDaoJDBC', voy a crear una interface PersonaDao. Y esa interface es la que van a usar los demas paquetes, 
por ejemplo el de Test.

Esto sirve para que en cualquier momento se pueda cambiar la tecnologia que implementa la interface de PersonaDao.
Es decir la implementacion podria ser de PersonaDaoJDBC, u otra tecnologia como PersonaDaoJPA

Y la clase Persona, formaliza el patron de diseño DTO (se podria llamar simplemente Persona, en lugar de PersonaDTO)

 */

