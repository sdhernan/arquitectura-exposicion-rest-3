/**
 * ServiceConfig.java
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
package ${package}.servicios.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ${package}.persistencia.config.PersistenceConfig;

/**
 * Configuración de servicios de la aplicación
 * 
 * @author Sistema
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = "${package}.servicios")
@Import(PersistenceConfig.class)
public class ServiceConfig {
    // Configuración adicional de servicios
}
