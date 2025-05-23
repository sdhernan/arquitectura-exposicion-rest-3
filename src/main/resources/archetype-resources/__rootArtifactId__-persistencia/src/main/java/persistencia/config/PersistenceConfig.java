/**
 * PersistenceConfig.java
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
package ${package}.persistencia.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuración de persistencia de la aplicación
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "${package}.persistencia.repository")
@EntityScan(basePackages = "${package}.persistencia.entity")
public class PersistenceConfig {
    // Configuración adicional de persistencia
}
