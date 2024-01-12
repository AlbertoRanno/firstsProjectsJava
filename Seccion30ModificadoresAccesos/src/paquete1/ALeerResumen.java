/* Modificadores de acceso, del menos al mas restrictivo:

*Public permite acceder a Clases, Contructores, Atributos, y Metodos
Es el menos restrictivo. Le sigue 'protected'.

*Protected, permite acceder a Contructores (mediante super), Atributos, y Metodos a sus clases Hijas
 Esten en el mismo paquete o no.
 No va en clases.

*DEfault o Package, Lo que significa es ausencia del modificador
permite acceder a Contructores (mediante super), Atributos, y Metodos a sus clases Hijas, siempre que
esten dentro del mismo paquete

*Private, permite acceder a Contructores, Atributos, y Metodos solo dentro de la misma clase
Fuera del paquete, nada.
Dentro del paquete, a los hijos, pueden acceder al constructor privado, si se usa el artilugio de crear
un constructor publico, dentro de la clase, el cual mediante 'this()' llame al constructor privado. 
Para poder crear este contructor publico, hay que distinguirlo, por lo que se le suele pasar el paramentro
generico: String argumento. ENtonces, en la clase hija, se lo llama, con un argumento dentro de super:
public Clase1PrivateHija() {     super("Publico");  }
La Clase test, debe estar en el mismo paquete, 
Al igual que los hijos, deben usar el constructor publico con argumentos
Se usan los metodos set y get para los atributos
Los metodos privados, no se acceden fuera de la clase
 */
