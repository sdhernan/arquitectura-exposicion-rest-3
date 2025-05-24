/**
 * AforeServiceImpl.java
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${package}.${projectName.toLowerCase()}.persistencia.dto.AforeModel;
import ${package}.${projectName.toLowerCase()}.persistencia.entity.Afore;
import ${package}.${projectName.toLowerCase()}.persistencia.repository.AforeRepository;
import ${package}.${projectName.toLowerCase()}.servicios.service.AforeService;

/**
 * Implementación del servicio de Afore.
 * 
 * @author SDHERNAN
 */
@Service
public class AforeServiceImpl implements AforeService {

    @Autowired
    private AforeRepository aforeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AforeModel> obtenerTodasLasAfores() {
        return aforeRepository.findAll().stream()
                .map(this::convertirAModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AforeModel> obtenerAforePorId(Long id) {
        return aforeRepository.findById(id)
                .map(this::convertirAModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AforeModel> obtenerAforePorClave(String claveAfore) {
        return aforeRepository.findByClaveAfore(claveAfore)
                .map(this::convertirAModel);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AforeModel> obtenerAforesActivas() {
        return aforeRepository.findByActivo(1).stream()
                .map(this::convertirAModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<AforeModel> obtenerAforesPorTipoAdministracion(String tipoAdministracion) {
        return aforeRepository.findByTipoAdministracionAndActivo(tipoAdministracion).stream()
                .map(this::convertirAModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AforeModel guardarAfore(AforeModel aforeModel) {
        Afore afore = convertirAEntity(aforeModel);
        afore = aforeRepository.save(afore);
        return convertirAModel(afore);
    }

    @Override
    @Transactional
    public Optional<AforeModel> actualizarAfore(Long id, AforeModel aforeModel) {
        if (!aforeRepository.existsById(id)) {
            return Optional.empty();
        }
        
        aforeModel.setId(id);
        Afore afore = convertirAEntity(aforeModel);
        afore = aforeRepository.save(afore);
        return Optional.of(convertirAModel(afore));
    }

    @Override
    @Transactional
    public boolean eliminarAfore(Long id) {
        if (!aforeRepository.existsById(id)) {
            return false;
        }
        
        aforeRepository.deleteById(id);
        return true;
    }
    
    /**
     * Convierte una entidad Afore a un modelo AforeModel.
     *
     * @param afore la entidad Afore
     * @return el modelo AforeModel
     */
    private AforeModel convertirAModel(Afore afore) {
        AforeModel model = new AforeModel();
        model.setId(afore.getId());
        model.setActivo(afore.getActivo());
        model.setClaveAfore(afore.getClaveAfore());
        model.setDescripcionAfore(afore.getDescripcionAfore());
        model.setFechaControl(afore.getFechaControl());
        model.setUsuarioModificador(afore.getUsuarioModificador());
        model.setTelefonoAfore(afore.getTelefonoAfore());
        model.setTipoAdministracion(afore.getTipoAdministracion());
        return model;
    }
    
    /**
     * Convierte un modelo AforeModel a una entidad Afore.
     *
     * @param model el modelo AforeModel
     * @return la entidad Afore
     */
    private Afore convertirAEntity(AforeModel model) {
        Afore afore = new Afore();
        afore.setId(model.getId());
        afore.setActivo(model.getActivo());
        afore.setClaveAfore(model.getClaveAfore());
        afore.setDescripcionAfore(model.getDescripcionAfore());
        afore.setFechaControl(model.getFechaControl());
        afore.setUsuarioModificador(model.getUsuarioModificador());
        afore.setTelefonoAfore(model.getTelefonoAfore());
        afore.setTipoAdministracion(model.getTipoAdministracion());
        return afore;
    }
}
