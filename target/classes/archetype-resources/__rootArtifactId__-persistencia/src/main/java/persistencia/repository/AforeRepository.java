/**
 * AforeRepository.java
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
package ${package}.${projectName.toLowerCase()}.persistencia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ${package}.${projectName.toLowerCase()}.persistencia.entity.Afore;

/**
 * Repositorio para la entidad Afore.
 * 
 * @author SDHERNAN
 */
@Repository
public interface AforeRepository extends JpaRepository<Afore, Long> {
    
    /**
     * Busca una Afore por su clave.
     *
     * @param claveAfore la clave de la Afore
     * @return un Optional con la Afore si existe
     */
    Optional<Afore> findByClaveAfore(String claveAfore);
    
    /**
     * Busca todas las Afores activas.
     *
     * @param activo el valor de activo (1 para activo, 0 para inactivo)
     * @return lista de Afores activas
     */
    List<Afore> findByActivo(Integer activo);
    
    /**
     * Busca Afores por tipo de administración.
     *
     * @param tipoAdministracion el tipo de administración
     * @return lista de Afores que coinciden con el tipo de administración
     */
    @Query("SELECT a FROM Afore a WHERE a.tipoAdministracion = :tipoAdm AND a.activo = 1")
    List<Afore> findByTipoAdministracionAndActivo(@Param("tipoAdm") String tipoAdministracion);
}
