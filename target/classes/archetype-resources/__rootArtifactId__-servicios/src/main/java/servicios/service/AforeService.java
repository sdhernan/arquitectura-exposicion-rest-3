/**
 * AforeService.java
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
package ${package}.${projectName.toLowerCase()}.servicios.service;

import java.util.List;
import java.util.Optional;

import ${package}.${projectName.toLowerCase()}.persistencia.dto.AforeModel;

/**
 * Interfaz para el servicio de Afore.
 * 
 * @author SDHERNAN
 */
public interface AforeService {
    
    /**
     * Obtiene todas las Afores.
     *
     * @return lista de todas las Afores
     */
    List<AforeModel> obtenerTodasLasAfores();
    
    /**
     * Obtiene una Afore por su ID.
     *
     * @param id el ID de la Afore
     * @return un Optional con la Afore si existe
     */
    Optional<AforeModel> obtenerAforePorId(Long id);
    
    /**
     * Obtiene una Afore por su clave.
     *
     * @param claveAfore la clave de la Afore
     * @return un Optional con la Afore si existe
     */
    Optional<AforeModel> obtenerAforePorClave(String claveAfore);
    
    /**
     * Obtiene todas las Afores activas.
     *
     * @return lista de Afores activas
     */
    List<AforeModel> obtenerAforesActivas();
    
    /**
     * Obtiene Afores por tipo de administración.
     *
     * @param tipoAdministracion el tipo de administración
     * @return lista de Afores que coinciden con el tipo de administración
     */
    List<AforeModel> obtenerAforesPorTipoAdministracion(String tipoAdministracion);
    
    /**
     * Guarda una Afore.
     *
     * @param afore la Afore a guardar
     * @return la Afore guardada
     */
    AforeModel guardarAfore(AforeModel afore);
    
    /**
     * Actualiza una Afore existente.
     *
     * @param id el ID de la Afore a actualizar
     * @param afore los nuevos datos de la Afore
     * @return la Afore actualizada
     */
    Optional<AforeModel> actualizarAfore(Long id, AforeModel afore);
    
    /**
     * Elimina una Afore por su ID.
     *
     * @param id el ID de la Afore a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     */
    boolean eliminarAfore(Long id);
}
