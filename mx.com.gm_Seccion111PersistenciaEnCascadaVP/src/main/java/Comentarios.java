/*
De nuevo, en el curso hicieron proyecto web con Glassfich y JavaEE, y yo hice uno SIN servidor ni capa web

Por lo pronto solo añadire la capa de servicios, la cual no podré probar, hasta Spring. Y lo más importante,
la forma de persistir en cascada. Esto es, guardar un registro, que afecta diferentes tablas a la vez,
por ejemplo, guardad un alumno, indicando desde esa carga, los datos que irán a la planilla de contacto, y 
a la de domicilio.

Para eso, se modifica la forma del OneToMany, en la entidad Alumno, indicando que se tome la forma de Cascada

    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne // Pasa a: @ManyToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne // Pasa a: @ManyToOne(cascade = CascadeType.ALL)
    private Contacto contacto;

Con esto, cuando cargue los objetos que voy a guardar en las tablas, primero tengo que pasar los objetos que
NO tienen relaciones, por ejemplo, contacto y domicilio, y por ultimo, alumno, teniendo cuidado, de, en alumno,
pasar el objeto domicilio, como domicilio, e idem con contacto.

Al hacerlo de esta forma, hibernate, entiende, por el comando de cascada, que primero guarde en la bbdd,
contacto y domicilio, de forma automatica, y genere sus correspondientes IDs , para luego si, guardar estos IDs
en alumno (verlo en => domain => alumno)

*/
