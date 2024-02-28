/*
Ciclo de Vida con HIbernate y JPA

Creo clases en el paquete test.ciclovida, para analizar los distintos estados de los objetos, en los distintos metodos:

-En Estado1, veo como al ingresar un nuevo objeto a la bbdd, paso el objeto de estado transitivo, a persistido, a detached

-En Estado2, veo como al listar un objeto, o recuperarlo desde la bbdd, lo puedo hacer iniciando o no una transaccion,
y la diferencia radicaria que cuando esta dentro de una transaccion, lo puedo modificar, por lo tanto esta en estado
Persistido, a diferencia de la otra forma que estaria en estado separado o detached

-En Estado3, (actualizar o modificar), si es necesario estar dentro de una transaccion, porque voy a modificar la bbdd.
Podria utilizar de nuevo persist, pero es buena practica utilizar merge para actualizar. Recupero el objeto, y modifico
con los setters, antes de iniciar la transaccion, pero el cambio se persiste, al iniciarla, y cerrada, vuelvo a detached

-En Estado4, elimino el objeto de la bbdd, lo recupero antes de iniciar la transaccion (detached), inicia => persist 
=> commit => NO vuelve a detached, SINO a transitivo, porque ya no tiene representacion en la BBDD... y va a ser 
desechado por el recolector de basura

*/
