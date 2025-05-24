/**
 * ${projectName.substring(0,1).toUpperCase()}${projectName.substring(1)}PersistenceAppContext.java
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
package ${package}.${projectName.toLowerCase()}.persistencia.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.stereotype.Repository;

/**
 * Clase de configuracion de Contexto de Persistencia
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Configuration
@EnableJpaRepositories(includeFilters = @ComponentScan.Filter(value = Repository.class, type = FilterType.ANNOTATION), basePackages = {
        "${package}.${projectName.toLowerCase()}.persistencia.repository" })
public class ${projectName.substring(0,1).toUpperCase()}${projectName.substring(1)}PersistenceAppContext extends PersistenceBaseAppContext {

    /**
     * JNDI de Data Source
     */
    @Value("${jndi.data.source}")
    private String jndiDataSource;

    /*
     * La documentacion de este metodo se encuentra en la clase o interface que lo declara
     * 
     * @see ${package}.persistencia.config.PersistenceBaseAppContext#dataSource()
     */
    @Override
    public DataSource dataSource() {
        final JndiDataSourceLookup jndiLookup = new JndiDataSourceLookup();
        jndiLookup.setResourceRef(true);
        return jndiLookup.getDataSource(jndiDataSource);
    }
}
