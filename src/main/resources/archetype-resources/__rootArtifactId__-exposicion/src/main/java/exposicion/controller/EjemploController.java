/**
 * EjemploController.java
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
package ${package}.${projectName.toLowerCase()}.exposicion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ${package}.${projectName.toLowerCase()}.persistencia.dto.EjemploDTO;
import ${package}.${projectName.toLowerCase()}.servicios.service.EjemploService;

/**
 * Controlador REST para operaciones con Ejemplos
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@RestController
@RequestMapping("/api/ejemplos")
public class EjemploController {

    @Autowired
    private EjemploService ejemploService;
    
    /**
     * Obtiene todos los ejemplos
     * 
     * @return Lista de ejemplos
     */
    @GetMapping
    public ResponseEntity<List<EjemploDTO>> obtenerTodos() {
        return ResponseEntity.ok(ejemploService.obtenerTodos());
    }
    
    /**
     * Obtiene un ejemplo por su ID
     * 
     * @param id ID del ejemplo
     * @return Ejemplo encontrado o 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<EjemploDTO> obtenerPorId(@PathVariable Long id) {
        return ejemploService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Crea un nuevo ejemplo
     * 
     * @param ejemploDTO Datos del ejemplo
     * @return Ejemplo creado con su ID asignado
     */
    @PostMapping
    public ResponseEntity<EjemploDTO> crear(@RequestBody EjemploDTO ejemploDTO) {
        ejemploDTO.setId(null); // Aseguramos que sea una creación
        EjemploDTO nuevoEjemplo = ejemploService.guardar(ejemploDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEjemplo);
    }
    
    /**
     * Actualiza un ejemplo existente
     * 
     * @param id ID del ejemplo a actualizar
     * @param ejemploDTO Nuevos datos del ejemplo
     * @return Ejemplo actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<EjemploDTO> actualizar(
            @PathVariable Long id,
            @RequestBody EjemploDTO ejemploDTO) {
        
        if (!ejemploService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        ejemploDTO.setId(id);
        return ResponseEntity.ok(ejemploService.guardar(ejemploDTO));
    }
    
    /**
     * Elimina un ejemplo por su ID
     * 
     * @param id ID del ejemplo a eliminar
     * @return 204 No Content si se eliminó correctamente
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        
        if (!ejemploService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        ejemploService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
    
    /**
     * Busca ejemplos por texto en nombre o descripción
     * 
     * @param texto Texto a buscar
     * @return Lista de ejemplos que coinciden con el criterio
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<EjemploDTO>> buscarPorTexto(@RequestParam String texto) {
        return ResponseEntity.ok(ejemploService.buscarPorTexto(texto));
    }
}
