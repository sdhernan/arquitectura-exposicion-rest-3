/**
 * EjemploDTO.java
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
package ${package}.${projectName.toLowerCase()}.persistencia.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * DTO para transferencia de datos de Ejemplo
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
public class EjemploDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private Boolean activo;
    
    public EjemploDTO() {
    }
    
    public EjemploDTO(Long id, String nombre, String descripcion, LocalDateTime fechaCreacion, Boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EjemploDTO that = (EjemploDTO) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(nombre, that.nombre) &&
               Objects.equals(descripcion, that.descripcion) &&
               Objects.equals(fechaCreacion, that.fechaCreacion) &&
               Objects.equals(activo, that.activo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, fechaCreacion, activo);
    }
    
    @Override
    public String toString() {
        return "EjemploDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", activo=" + activo +
                '}';
    }
    
    public static class Builder {
        private Long id;
        private String nombre;
        private String descripcion;
        private LocalDateTime fechaCreacion;
        private Boolean activo;
        
        public Builder id(Long id) {
            this.id = id;
            return this;
        }
        
        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }
        
        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        
        public Builder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }
        
        public Builder activo(Boolean activo) {
            this.activo = activo;
            return this;
        }
        
        public EjemploDTO build() {
            return new EjemploDTO(id, nombre, descripcion, fechaCreacion, activo);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}
