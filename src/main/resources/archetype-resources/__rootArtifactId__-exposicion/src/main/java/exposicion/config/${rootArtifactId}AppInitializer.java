/**
 * ${rootArtifactId}AppInitializer.java
 * Fecha de creacion: ${date}
 *
 * Copyright (c) ${year} Procesar S A de C V. 
 * Todos los derechos reservados.
 *
 * Este software es informacion confidencial, propiedad del
 * Procesar S A de C V. Esta informacion confidencial
 * no debera ser divulgada y solo se podra utilizar de acuerdo
 * a los terminos que determine la propia empresa.
 */
package ${package}.exposicion.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ${package}.persistencia.config.${rootArtifactId}PersistenceAppContext;
import ${package}.servicios.config.${rootArtifactId}ServiceAppContext;

/**
 * Initializer de aplicativo web
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Import({ ${rootArtifactId}PropertiesAppContext.class, ${rootArtifactId}PersistenceAppContext.class, ${rootArtifactId}ServiceAppContext.class })
@ComponentScan(includeFilters = { 
    @Filter(type = FilterType.ANNOTATION, value = RestController.class),
    @Filter(type = FilterType.ANNOTATION, value = Component.class) 
}, basePackages = { "${package}.exposicion" })
@SpringBootApplication
@EnableAsync
public class ${rootArtifactId}AppInitializer extends SpringBootServletInitializer implements WebMvcConfigurer {

    /**
     * Método principal para iniciar la aplicación
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(${rootArtifactId}AppInitializer.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(${rootArtifactId}AppInitializer.class);
    }

    /**
     * Configuración del ViewResolver para vistas JSP
     * 
     * @return ViewResolver configurado
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Configuración para manejo de archivos multipart
     * 
     * @return CommonsMultipartResolver configurado
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10485760);
        resolver.setMaxInMemorySize(4096);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
