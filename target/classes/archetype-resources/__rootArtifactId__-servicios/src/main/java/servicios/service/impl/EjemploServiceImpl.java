/**
 * EjemploServiceImpl.java
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
package ${package}.${projectName.toLowerCase()}.servicios.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.${projectName.toLowerCase()}.persistencia.entity.Ejemplo;
import ${package}.${projectName.toLowerCase()}.persistencia.repository.EjemploRepository;
import ${package}.${projectName.toLowerCase()}.persistencia.dto.EjemploDTO;
import ${package}.${projectName.toLowerCase()}.servicios.service.EjemploService;

/**
 * Implementación del servicio de Ejemplos
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Service
@Transactional
public class EjemploServiceImpl implements EjemploService {

    @Autowired
    private EjemploRepository ejemploRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<EjemploDTO> obtenerTodos() {
        return ejemploRepository.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<EjemploDTO> obtenerPorId(Long id) {
        return ejemploRepository.findById(id)
                .map(this::convertirADTO);
    }

    @Override
    public EjemploDTO guardar(EjemploDTO ejemploDTO) {
        Ejemplo ejemplo;
        
        if (ejemploDTO.getId() == null) {
            // Nuevo ejemplo
            ejemplo = convertirAEntidad(ejemploDTO);
            ejemplo.setFechaCreacion(LocalDateTime.now());
            if (ejemplo.getActivo() == null) {
                ejemplo.setActivo(true);
            }
        } else {
            // Actualizar ejemplo existente
            ejemplo = ejemploRepository.findById(ejemploDTO.getId())
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el ejemplo con ID: " + ejemploDTO.getId()));
            
            ejemplo.setNombre(ejemploDTO.getNombre());
            ejemplo.setDescripcion(ejemploDTO.getDescripcion());
            if (ejemploDTO.getActivo() != null) {
                ejemplo.setActivo(ejemploDTO.getActivo());
            }
        }
        
        return convertirADTO(ejemploRepository.save(ejemplo));
    }

    @Override
    public void eliminar(Long id) {
        if (ejemploRepository.existsById(id)) {
            ejemploRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró el ejemplo con ID: " + id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<EjemploDTO> buscarPorTexto(String texto) {
        return ejemploRepository.buscarPorTexto(texto).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Convierte una entidad Ejemplo a su DTO correspondiente
     * 
     * @param ejemplo Entidad a convertir
     * @return DTO resultante
     */
    private EjemploDTO convertirADTO(Ejemplo ejemplo) {
        return EjemploDTO.builder()
                .id(ejemplo.getId())
                .nombre(ejemplo.getNombre())
                .descripcion(ejemplo.getDescripcion())
                .fechaCreacion(ejemplo.getFechaCreacion())
                .activo(ejemplo.getActivo())
                .build();
    }
    
    /**
     * Convierte un DTO a su entidad Ejemplo correspondiente
     * 
     * @param ejemploDTO DTO a convertir
     * @return Entidad resultante
     */
    private Ejemplo convertirAEntidad(EjemploDTO ejemploDTO) {
        return Ejemplo.builder()
                .id(ejemploDTO.getId())
                .nombre(ejemploDTO.getNombre())
                .descripcion(ejemploDTO.getDescripcion())
                .fechaCreacion(ejemploDTO.getFechaCreacion())
                .activo(ejemploDTO.getActivo())
                .build();
    }
}
