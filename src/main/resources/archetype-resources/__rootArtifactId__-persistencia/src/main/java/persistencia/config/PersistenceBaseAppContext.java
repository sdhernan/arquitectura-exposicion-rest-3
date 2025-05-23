/**
 * PersistenceBaseAppContext.java
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

import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.dialect.Oracle12cDialect;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Clase Base de Configuracion
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Configuration
public abstract class PersistenceBaseAppContext {

    /**
     * Paquete de entidades a cargar
     */
    @Value("${paquete.entidades}")
    protected String[] paqueteEntidades;

    /**
     * Propiedades de Aplicativo
     */
    @Resource
    protected Properties propiedades;

    /**
     * Declaracion de metodo Bean abstracto para DataSource
     * 
     * @return DataSource configurado
     */
    @Bean
    public abstract DataSource dataSource();

    /**
     * Metodo Bean de Entity Manager Factory
     * 
     * @return EntityManagerFactory configurado
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan(paqueteEntidades);
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.ORACLE);
        vendorAdapter.setDatabasePlatform(Oracle12cDialect.class.getName());
        vendorAdapter.setShowSql(true);
        factory.setJpaVendorAdapter(vendorAdapter);

        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
