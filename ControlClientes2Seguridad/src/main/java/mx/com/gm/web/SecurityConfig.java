package mx.com.gm.web;
/*
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration //Necesaria para configs
@EnableWebSecurityConfigurerAdapter() //Para habilitar la seguridad web
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
public class SecurityConfig{
    /*Sobreescribo 2 metodos: 
    -El metodo de configure, que recibe un objeto del tipo autenticationManagerBuilder. Para agregar mas usuarios, y personalizar
    los usuarios a utilizar para hacer login en la app
    -El otro metodo, tambien configure, pero recibe un parametro de http security, y este se va a utilizar para restringir
    las urls de la app. Depende el usuario, las paginas que pueden entrar, acorde a su rol asignado
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //Con este metodo desactivo el usuario por default, y agrego usuarios creados en memoria (y luego tabla de bbdd)
    auth.inMemoryAuthentication()
            .withUser("admin")
               .password("{noop}123")//luego lo codificare para la bbdd => aca la notacion es para que no se encripte
               .roles("ADMIN","USER")//Spring le agrega ROLE_
            .and()
            .withUser("user")
                .password("{noop}123")
                .roles("USER")
            ;
    }
}*/