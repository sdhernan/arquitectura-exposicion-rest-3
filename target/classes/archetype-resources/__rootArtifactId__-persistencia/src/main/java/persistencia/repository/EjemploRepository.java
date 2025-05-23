/**
 * EjemploRepository.java
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
package ${package}.persistencia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ${package}.persistencia.entity.Ejemplo;

/**
 * Repositorio para la entidad Ejemplo
 * 
 * @author Sistema
 * @version 1.0
 */
@Repository
public interface EjemploRepository extends JpaRepository<Ejemplo, Long> {

    /**
     * Busca un ejemplo por su nombre
     * 
     * @param nombre Nombre a buscar
     * @return Ejemplo encontrado o vacío si no existe
     */
    Optional<Ejemplo> findByNombre(String nombre);
    
    /**
     * Busca ejemplos activos
     * 
     * @return Lista de ejemplos activos
     */
    List<Ejemplo> findByActivoTrue();
    
    /**
     * Busca ejemplos que contengan el texto en su nombre o descripción
     * 
     * @param texto Texto a buscar
     * @return Lista de ejemplos que coinciden con el criterio
     */
    @Query("SELECT e FROM Ejemplo e WHERE UPPER(e.nombre) LIKE UPPER(CONCAT('%', :texto, '%')) OR UPPER(e.descripcion) LIKE UPPER(CONCAT('%', :texto, '%'))")
    List<Ejemplo> buscarPorTexto(@Param("texto") String texto);
}
