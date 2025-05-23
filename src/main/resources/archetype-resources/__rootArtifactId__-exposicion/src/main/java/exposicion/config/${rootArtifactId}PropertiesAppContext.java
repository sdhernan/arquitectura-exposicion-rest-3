/**
 * ${rootArtifactId}PropertiesAppContext.java
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

import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

/**
 * Clase para cargar el place holder y el properties.
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Configuration
public class ${rootArtifactId}PropertiesAppContext {

    /**
     * Nombre de variable de JVM para Propiedades
     */
    private static final String VARIABLE_PROPIEDADES = "mx.com.procesar.configuracion.properties";

    /**
     * Carpeta de propieades con archivo
     */
    private static final String CARPETA_PROPIEDADES = "/propiedades/${rootArtifactId}.properties";

    /**
     * Nombre del archivo de log4j que se tiene que cargar
     */
    private static final String NOMBRE_ARCHIVO_LOG4J2 = "/propiedades/log4j2/${rootArtifactId}-log4j2.xml";

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(${rootArtifactId}PropertiesAppContext.class);

    /**
     * Metodo para cargar el archivo de propiedades
     * 
     * @return PropertySourcesPlaceholderConfigurer
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        String rutaPropiedades = System.getProperty(VARIABLE_PROPIEDADES);
        if (rutaPropiedades != null) {
            LOGGER.info("Cargando propiedades de: {}", rutaPropiedades);
            configurer.setLocation(new FileSystemResource(rutaPropiedades));
        } else {
            LOGGER.info("Cargando propiedades de: {}", CARPETA_PROPIEDADES);
            configurer.setLocation(new FileSystemResource(CARPETA_PROPIEDADES));
        }
        return configurer;
    }

    /**
     * Metodo para cargar las propiedades
     * 
     * @return PropertiesFactoryBean
     */
    @Bean
    public PropertiesFactoryBean propiedades() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String rutaPropiedades = System.getProperty(VARIABLE_PROPIEDADES);
        if (rutaPropiedades != null) {
            bean.setLocation(new FileSystemResource(rutaPropiedades));
        } else {
            bean.setLocation(new FileSystemResource(CARPETA_PROPIEDADES));
        }
        return bean;
    }

    /**
     * Metodo para cargar la configuracion de log4j2
     */
    @Bean
    public void configurarLog4j2() {
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        String rutaLog4j2 = NOMBRE_ARCHIVO_LOG4J2;
        LOGGER.info("Cargando configuracion de log4j2 de: {}", rutaLog4j2);
        context.setConfigLocation(Paths.get(rutaLog4j2).toUri());
    }
}
