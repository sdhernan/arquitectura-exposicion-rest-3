# ${artifactId}

## Descripción

Proyecto REST con arquitectura de tres capas generado a partir del arquetipo arquitectura-exposicion-rest-3.

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

## Configuración

La configuración principal se encuentra en el archivo `application.properties` dentro del módulo de exposición.
Puede personalizar la configuración según sus necesidades.

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
