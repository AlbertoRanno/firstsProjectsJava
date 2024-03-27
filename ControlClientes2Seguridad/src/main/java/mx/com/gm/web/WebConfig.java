package mx.com.gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
//i18n => viene de "internacionalization", y significa que entre i y n hay 18 letras


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }

    /*No entendí... pero estimo que es algo que se utiliza siempre asi... 
    "es", de español, logicamente podria haber sido: en - fr - de (aleman) -... 
    de ser necesario, buscar una lista de language codes para internacionalizacion
    Lo mismo estan establecidos los prefijos para los paises*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        //parametro para cambiar de lenguage:
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    /*Todo esto es necesario para que se pueda cambiar de manera dinamica el lenguage
    Luego, hago 2 copias del archivo messages.properties, dejando el archivo original intacto,
    una renombro a messages_es y la otra a messages_en, y veré que se me arman todas las columnas
    en el original, desde donde puedo manejar mejor los cambios de un lenguage a otro.
    Voy a tener: default language, es-español, en-inglés
    
    Por ultimo, voy a las plantillas reutilizadas (layout), y agrego el selector de idioma*/
}
