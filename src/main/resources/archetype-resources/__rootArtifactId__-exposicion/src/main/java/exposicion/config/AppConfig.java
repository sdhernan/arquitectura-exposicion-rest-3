/**
 * AppConfig.java
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
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import ${package}.servicios.config.ServiceConfig;

/**
 * Clase principal para inicializar la aplicación
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "${package}.exposicion")
@PropertySource("classpath:../propiedades/${rootArtifactId}.properties")
@Import(ServiceConfig.class)
public class AppConfig extends SpringBootServletInitializer {

    /**
     * Método principal para iniciar la aplicación
     * 
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppConfig.class);
    }

    /**
     * Configuración del resolver para subida de archivos
     * 
     * @return CommonsMultipartResolver configurado
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10485760L); // 10MB
        return resolver;
    }
}
