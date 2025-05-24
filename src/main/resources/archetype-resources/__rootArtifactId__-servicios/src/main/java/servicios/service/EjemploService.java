/**
 * EjemploService.java
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

import ${package}.${projectName.toLowerCase()}.persistencia.dto.EjemploDTO;

/**
 * Interfaz de servicio para operaciones con Ejemplos
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
public interface EjemploService {

    /**
     * Obtiene todos los ejemplos
     * 
     * @return Lista de ejemplos
     */
    List<EjemploDTO> obtenerTodos();
    
    /**
     * Obtiene un ejemplo por su ID
     * 
     * @param id ID del ejemplo
     * @return Ejemplo encontrado o vacío si no existe
     */
    Optional<EjemploDTO> obtenerPorId(Long id);
    
    /**
     * Guarda un nuevo ejemplo o actualiza uno existente
     * 
     * @param ejemploDTO Datos del ejemplo
     * @return Ejemplo guardado con su ID asignado
     */
    EjemploDTO guardar(EjemploDTO ejemploDTO);
    
    /**
     * Elimina un ejemplo por su ID
     * 
     * @param id ID del ejemplo a eliminar
     */
    void eliminar(Long id);
    
    /**
     * Busca ejemplos por texto en nombre o descripción
     * 
     * @param texto Texto a buscar
     * @return Lista de ejemplos que coinciden con el criterio
     */
    List<EjemploDTO> buscarPorTexto(String texto);
}
