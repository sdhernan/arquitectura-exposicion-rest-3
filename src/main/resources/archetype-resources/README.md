# ${artifactId}

## Descripción

Proyecto REST con arquitectura de tres capas generado a partir del arquetipo arquitectura-exposicion-rest-3. Este proyecto incluye un ejemplo funcional basado en la entidad Afore, con implementaciones completas en todas las capas de la arquitectura.

## Uso del Arquetipo

Este proyecto fue generado utilizando el arquetipo `arquitectura-exposicion-rest-3`. Para generar un nuevo proyecto usando este arquetipo, ejecute el siguiente comando:

```bash
mvn archetype:generate \
  -DarchetypeGroupId=procesar \
  -DarchetypeArtifactId=arquitectura-exposicion-rest-3 \
  -DarchetypeVersion=1.0.0 \
  -DgroupId=procesar \
  -DartifactId=mi-proyecto \
  -Dversion=1.0.0 \
  -DcategoriaPOMPadre=servicios \
  -DlineaNegocio=retiros \
  -DnombreBranch=ApiBanamex
```

También puede utilizar el script `arquetipo-rest-manager.bat` incluido en el arquetipo para una instalación guiada.

## Estructura del Proyecto

El proyecto está organizado en tres módulos principales:

1. **${artifactId}-persistencia**: Módulo para la capa de persistencia de datos
   - Entidades JPA (ejemplo: `Afore.java`)
   - DTOs (ejemplo: `AforeModel.java`)
   - Repositorios (ejemplo: `AforeRepository.java`)
   - Configuración de persistencia

2. **${artifactId}-servicios**: Módulo para la capa de servicios de negocio
   - Interfaces de servicio (ejemplo: `AforeService.java`)
   - Implementaciones de servicio (ejemplo: `AforeServiceImpl.java`)
   - Lógica de negocio

3. **${artifactId}-exposicion**: Módulo para la capa de exposición (API REST)
   - Controladores REST (ejemplo: `AforeController.java`)
   - Configuración de Spring MVC
   - Manejo de excepciones

## Requisitos

- Java 11
- Maven 3.6+
- Spring Boot 2.7+
- Base de datos Oracle (configurable)

## Compilación

Para compilar el proyecto, ejecute:

```bash
mvn clean install
```

Si experimenta problemas con SSL al descargar dependencias, utilice el siguiente comando:

```bash
mvn -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true clean package
```

## Ejecución

Para ejecutar la aplicación, puede utilizar el plugin de Spring Boot:

```bash
cd ${artifactId}-exposicion
mvn spring-boot:run
```

## Documentación de la API

La documentación de la API REST está disponible a través de Swagger UI:

```bash
http://localhost:8080/${artifactId}/swagger-ui.html
```

## Ejemplo Funcional: Afore

El proyecto incluye un ejemplo completo basado en la entidad Afore:

- **Entidad**: `Afore.java` - Entidad JPA con anotaciones y campos relevantes
- **DTO**: `AforeModel.java` - Modelo de datos para transferencia entre capas
- **Repositorio**: `AforeRepository.java` - Interfaz con métodos para acceder a los datos
- **Servicio**: `AforeService.java` - Interfaz con definición de operaciones
- **Implementación**: `AforeServiceImpl.java` - Implementación de la lógica de negocio
- **Controlador**: `AforeController.java` - Controlador REST con endpoints CRUD
- **Pruebas**: Clases de prueba para cada componente

Este ejemplo puede servir como base para implementar sus propias entidades y funcionalidades.

## Configuración

La configuración principal se encuentra en los archivos `application.properties` de cada módulo. Puede personalizar estas configuraciones según sus necesidades.

## Autor

Sadot Nahum Hernandez Moreno

## Documentación Adicional

Este proyecto incluye los siguientes documentos importantes:

- [CHANGELOG.md](./CHANGELOG.md) - Registro de cambios del proyecto
- [CODE_OF_CONDUCT.md](./CODE_OF_CONDUCT.md) - Código de conducta para contribuyentes
- [SECURITY.md](./SECURITY.md) - Política de seguridad y reporte de vulnerabilidades
- [LICENSE](./LICENSE) - Licencia Apache 2.0 que gobierna el uso de este software

## Licencia

Copyright (c) ${year} Procesar S A de C V. Todos los derechos reservados.

Este proyecto está licenciado bajo la Licencia Apache 2.0 - consulte el archivo [LICENSE](./LICENSE) para más detalles.
