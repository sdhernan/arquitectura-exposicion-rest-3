/**
 * ${projectName.substring(0,1).toUpperCase()}${projectName.substring(1)}PropertiesAppContext.java
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
package ${package}.${projectName.toLowerCase()}.exposicion.config;

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
public class ${projectName.substring(0,1).toUpperCase()}${projectName.substring(1)}PropertiesAppContext {

    /**
     * Nombre de variable de JVM para Propiedades
     */
    private static final String VARIABLE_PROPIEDADES = "mx.com.procesar.configuracion.properties";

    /**
     * Carpeta de propieades con archivo
     */
    private static final String CARPETA_PROPIEDADES = "/propiedades/${projectName.toLowerCase()}.properties";

    /**
     * Nombre del archivo de log4j que se tiene que cargar
     */
    private static final String NOMBRE_ARCHIVO_LOG4J2 = "/propiedades/log4j2/${projectName.toLowerCase()}-log4j2.xml";

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(${projectName.substring(0,1).toUpperCase()}${projectName.substring(1)}PropertiesAppContext.class);

    /**
	 * Metodo Bean para poder utilizar los Placeholders en carga de valores de
	 * propiedades
	 * 
	 * @author Edgar Alberto Pï¿½rez Villegas (eaperezv)
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
		String rutaPropiedades = System.getProperty(VARIABLE_PROPIEDADES);
		PropertySourcesPlaceholderConfigurer bean = new PropertySourcesPlaceholderConfigurer();
		bean.setLocation(new FileSystemResource(rutaPropiedades.concat(CARPETA_PROPIEDADES)));

		return bean;
	}

	/**
	 * Bean para Log4j2
	 * 
	 * @author Sadot Nahum Hernandez Moreno
	 */
	@Bean
	public void log4j2() {
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		StringBuilder rutaLog4JConfig = new StringBuilder();
		rutaLog4JConfig.append(System.getProperty(VARIABLE_PROPIEDADES)).append(NOMBRE_ARCHIVO_LOG4J2);
		context.setConfigLocation(Paths.get(rutaLog4JConfig.toString()).toUri());
		context.reconfigure();
		LOGGER.info("Reconfiguracion de Log4j2 activa");
	}

	/**
	 * Metodo Bean para carga de propiedades externalizadas
	 * 
	 * @author Sadot Nahum Hernandez Moreno
	 * @return
	 */
	@Bean
	public PropertiesFactoryBean propiedades() {
		String rutaPropiedades = System.getProperty(VARIABLE_PROPIEDADES);
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new FileSystemResource(rutaPropiedades.concat(CARPETA_PROPIEDADES)));

		return bean;
	}
}
