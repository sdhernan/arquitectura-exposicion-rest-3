/**
 * ${rootArtifactId}ServiceAppContext.java
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

import javax.persistence.EntityManagerFactory;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ${package}.persistencia.config.${rootArtifactId}PersistenceAppContext;

/**
 * Clase de Contexto de Spring para Servicios
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Configuration
@ComponentScan(includeFilters = { 
    @Filter(type = FilterType.ANNOTATION, value = Service.class),
    @Filter(type = FilterType.ANNOTATION, value = Component.class) 
}, basePackages = { "${package}.servicios.service.impl" })
@EnableTransactionManagement
@EnableCaching
@Import(${rootArtifactId}PersistenceAppContext.class)
public class ${rootArtifactId}ServiceAppContext {

    /**
     * Metodo Bean de Transaction Manager
     * 
     * @param entityManagerFactory Factory de Entity Manager
     * @return Transaction Manager configurado
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
