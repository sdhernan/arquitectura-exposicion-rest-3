# ${artifactId}

## Descripción
Proyecto REST con arquitectura de tres capas generado a partir del arquetipo arquitectura-exposicion-rest-3.

## Estructura del Proyecto
El proyecto está organizado en tres módulos principales:

1. **${artifactId}-persistencia**: Módulo para la capa de persistencia de datos
   - Entidades JPA
   - Repositorios
   - Configuración de persistencia

2. **${artifactId}-servicios**: Módulo para la capa de servicios de negocio
   - Servicios
   - DTOs
   - Lógica de negocio

3. **${artifactId}-exposicion**: Módulo para la capa de exposición (API REST)
   - Controladores REST
   - Configuración de Spring MVC
   - Documentación OpenAPI/Swagger

## Requisitos
- Java 11
- Maven 3.6+
- Spring Boot 2.7+
- Base de datos Oracle (configurable)

## Compilación
Para compilar el proyecto, ejecute:
```
mvn clean install
```

## Ejecución
Para ejecutar la aplicación, puede utilizar el plugin de Spring Boot:
```
cd ${artifactId}-exposicion
mvn spring-boot:run
```

## Documentación de la API
La documentación de la API REST está disponible a través de Swagger UI:
```
http://localhost:8080/${artifactId}/swagger-ui.html
```

## Configuración
La configuración principal se encuentra en el archivo `application.properties` dentro del módulo de exposición.
Puede personalizar la configuración según sus necesidades.

## Licencia
Copyright (c) ${year} Procesar S A de C V. Todos los derechos reservados.
