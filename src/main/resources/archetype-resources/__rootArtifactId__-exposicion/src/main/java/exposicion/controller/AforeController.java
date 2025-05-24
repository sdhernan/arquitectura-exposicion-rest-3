/**
 * AforeController.java
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
import java.util.Optional;

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
import org.springframework.http.MediaType;

import ${package}.${projectName.toLowerCase()}.persistencia.dto.AforeModel;
import ${package}.${projectName.toLowerCase()}.persistencia.dto.ApiErrorDTO;
import ${package}.${projectName.toLowerCase()}.servicios.service.AforeService;

/**
 * Controlador REST para operaciones relacionadas con Afores.
 * 
 * @author SDHERNAN
 */
@RestController
@RequestMapping("/api/afores")
public class AforeController {

    @Autowired
    private AforeService aforeService;

    /**
     * Obtiene todas las Afores.
     *
     * @return lista de todas las Afores
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AforeModel>> obtenerTodasLasAfores() {
        List<AforeModel> afores = aforeService.obtenerTodasLasAfores();
        return ResponseEntity.ok(afores);
    }

    /**
     * Obtiene una Afore por su ID.
     *
     * @param id el ID de la Afore
     * @return la Afore si existe, o un error 404 si no existe
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerAforePorId(@PathVariable Long id) {
        Optional<AforeModel> afore = aforeService.obtenerAforePorId(id);
        if (afore.isPresent()) {
            return ResponseEntity.ok(afore.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiErrorDTO("No se encontró la Afore con ID: " + id, HttpStatus.NOT_FOUND.value()));
        }
    }

    /**
     * Obtiene una Afore por su clave.
     *
     * @param clave la clave de la Afore
     * @return la Afore si existe, o un error 404 si no existe
     */
    @GetMapping(value = "/clave/{clave}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerAforePorClave(@PathVariable String clave) {
        Optional<AforeModel> afore = aforeService.obtenerAforePorClave(clave);
        if (afore.isPresent()) {
            return ResponseEntity.ok(afore.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiErrorDTO("No se encontró la Afore con clave: " + clave, HttpStatus.NOT_FOUND.value()));
        }
    }

    /**
     * Obtiene todas las Afores activas.
     *
     * @return lista de Afores activas
     */
    @GetMapping(value = "/activas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AforeModel>> obtenerAforesActivas() {
        List<AforeModel> afores = aforeService.obtenerAforesActivas();
        return ResponseEntity.ok(afores);
    }

    /**
     * Obtiene Afores por tipo de administración.
     *
     * @param tipo el tipo de administración
     * @return lista de Afores que coinciden con el tipo de administración
     */
    @GetMapping("/tipo")
    public ResponseEntity<List<AforeModel>> obtenerAforesPorTipoAdministracion(@RequestParam String tipo) {
        List<AforeModel> afores = aforeService.obtenerAforesPorTipoAdministracion(tipo);
        return ResponseEntity.ok(afores);
    }

    /**
     * Crea una nueva Afore.
     *
     * @param afore la Afore a crear
     * @return la Afore creada
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AforeModel> crearAfore(@RequestBody AforeModel afore) {
        AforeModel nuevaAfore = aforeService.guardarAfore(afore);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAfore);
    }

    /**
     * Actualiza una Afore existente.
     *
     * @param id el ID de la Afore a actualizar
     * @param afore los nuevos datos de la Afore
     * @return la Afore actualizada, o un error 404 si no existe
     */
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> actualizarAfore(@PathVariable Long id, @RequestBody AforeModel afore) {
        Optional<AforeModel> aforeActualizada = aforeService.actualizarAfore(id, afore);
        if (aforeActualizada.isPresent()) {
            return ResponseEntity.ok(aforeActualizada.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiErrorDTO("No se encontró la Afore con ID: " + id, HttpStatus.NOT_FOUND.value()));
        }
    }

    /**
     * Elimina una Afore por su ID.
     *
     * @param id el ID de la Afore a eliminar
     * @return respuesta sin contenido si se eliminó correctamente, o un error 404 si no existe
     */
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminarAfore(@PathVariable Long id) {
        boolean eliminado = aforeService.eliminarAfore(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiErrorDTO("No se encontró la Afore con ID: " + id, HttpStatus.NOT_FOUND.value()));
        }
    }
}
