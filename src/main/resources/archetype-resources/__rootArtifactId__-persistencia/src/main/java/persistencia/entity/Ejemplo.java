/**
 * Ejemplo.java
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
package ${package}.${projectName.toLowerCase()}.persistencia.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad de ejemplo
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
@Entity
@Table(name = "EJEMPLO")
public class Ejemplo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION", length = 500)
    private String descripcion;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "ACTIVO", nullable = false)
    private Boolean activo;
    
    public Ejemplo() {
    }
    
    public Ejemplo(Long id, String nombre, String descripcion, LocalDateTime fechaCreacion, Boolean activo) {
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
        Ejemplo ejemplo = (Ejemplo) o;
        return Objects.equals(id, ejemplo.id) &&
               Objects.equals(nombre, ejemplo.nombre) &&
               Objects.equals(descripcion, ejemplo.descripcion) &&
               Objects.equals(fechaCreacion, ejemplo.fechaCreacion) &&
               Objects.equals(activo, ejemplo.activo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, fechaCreacion, activo);
    }
    
    @Override
    public String toString() {
        return "Ejemplo{" +
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
        
        public Ejemplo build() {
            return new Ejemplo(id, nombre, descripcion, fechaCreacion, activo);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}
