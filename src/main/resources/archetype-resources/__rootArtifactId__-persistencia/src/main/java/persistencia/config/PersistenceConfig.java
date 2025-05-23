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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuración de persistencia de la aplicación
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:../propiedades/${rootArtifactId}.properties")
@EnableJpaRepositories(basePackages = "${package}.persistencia.repository")
@EntityScan(basePackages = "${package}.persistencia.entity")
public class PersistenceConfig {
    
    @Value("${jndi.data.source}")
    private String jndiDataSource;
    
    @Value("${paquete.entidades}")
    private String paqueteEntidades;
    
    /**
     * Configura el DataSource usando JNDI
     * 
     * @return DataSource configurado
     * @throws Exception si hay problemas al obtener el DataSource
     */
    @Bean
    public DataSource dataSource() throws Exception {
        return (DataSource) new JndiTemplate().lookup(jndiDataSource);
    }
}
