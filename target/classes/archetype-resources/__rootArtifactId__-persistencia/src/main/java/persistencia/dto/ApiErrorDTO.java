/**
 * ApiErrorDTO.java
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

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * DTO para representar errores de la API
 * 
 * @author Sadot Nahum Hernandez Moreno
 * @version 1.0
 */
public class ApiErrorDTO {

    private String mensaje;
    private String detalle;
    private int status;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String path;
    
    public ApiErrorDTO() {
    }
    
    public ApiErrorDTO(String mensaje, int status) {
        this.mensaje = mensaje;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
    
    public ApiErrorDTO(String mensaje, String detalle, int status, LocalDateTime timestamp, String path) {
        this.mensaje = mensaje;
        this.detalle = detalle;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
    }
    
    public String getMensaje() {
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiErrorDTO that = (ApiErrorDTO) o;
        return status == that.status &&
               Objects.equals(mensaje, that.mensaje) &&
               Objects.equals(detalle, that.detalle) &&
               Objects.equals(timestamp, that.timestamp) &&
               Objects.equals(path, that.path);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(mensaje, detalle, status, timestamp, path);
    }
    
    @Override
    public String toString() {
        return "ApiErrorDTO{" +
                "mensaje='" + mensaje + '\'' +
                ", detalle='" + detalle + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                ", path='" + path + '\'' +
                '}';
    }
    
    public static class Builder {
        private String mensaje;
        private String detalle;
        private int status;
        private LocalDateTime timestamp;
        private String path;
        
        public Builder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }
        
        public Builder detalle(String detalle) {
            this.detalle = detalle;
            return this;
        }
        
        public Builder status(int status) {
            this.status = status;
            return this;
        }
        
        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        
        public Builder path(String path) {
            this.path = path;
            return this;
        }
        
        public ApiErrorDTO build() {
            return new ApiErrorDTO(mensaje, detalle, status, timestamp, path);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}
