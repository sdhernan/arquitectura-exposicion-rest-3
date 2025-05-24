# ${projectName}

## 📋 Descripción

Arquitectura de referencia para el desarrollo de aplicaciones REST con Spring Boot, siguiendo principios de arquitectura limpia y separación de responsabilidades. Este proyecto proporciona una estructura base con tres capas principales: persistencia, servicios y exposición.

## 🚀 Características Principales

- ✅ Arquitectura en 3 capas bien definidas
- ✅ Configuración modular con Spring Boot
- ✅ Manejo centralizado de excepciones
- ✅ Validación de datos integrada
- ✅ Pruebas unitarias y de integración
- ✅ Documentación de API con OpenAPI/Swagger
- ✅ Configuración de seguridad básica
- ✅ Logging centralizado

## 🏗️ Estructura del Proyecto

```
${projectName}/
├── ${projectName}-persistencia/     # Capa de persistencia
│   ├── src/
│   │   ├── main/java/persistencia/
│   │   │   ├── config/           # Configuración de persistencia
│   │   │   ├── dto/              # Objetos de transferencia de datos
│   │   │   ├── entity/           # Entidades JPA
│   │   │   └── repository/       # Repositorios JPA
│   │   └── resources/            # Recursos (properties, scripts SQL)
│   └── pom.xml
│
├── ${projectName}-servicios/      # Capa de servicios
│   ├── src/
│   │   ├── main/java/servicios/
│   │   │   ├── config/           # Configuración de servicios
│   │   │   ├── service/           # Interfaces de servicio
│   │   │   └── service/impl/      # Implementaciones de servicios
│   │   └── resources/            # Recursos específicos del servicio
│   └── pom.xml
│
├── ${projectName}-exposicion/     # Capa de exposición (API REST)
│   ├── src/
│   │   ├── main/java/exposicion/
│   │   │   ├── config/           # Configuración de la API
│   │   │   ├── controller/        # Controladores REST
│   │   │   └── exception/        # Manejo de excepciones
│   │   └── resources/            # Configuración de la aplicación
│   └── pom.xml
│
└── pom.xml                      # POM padre
```

## 🛠️ Requisitos Técnicos

- Java 11 o superior
- Maven 3.6+
- Spring Boot 2.7+
- Base de datos Oracle (configurable)
- Git
- IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Inicio Rápido

### 1. Clonar el repositorio
```bash
git clone <repositorio>
cd ${projectName}
```

### 2. Configuración de la base de datos
Editar el archivo `application.properties` con las credenciales de tu base de datos:

```properties
# Configuración de base de datos
spring.datasource.url=jdbc:oracle:thin:@//localhost:1521/ORCLCDB
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

# Configuración de JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### 3. Compilar el proyecto
```bash
mvn clean install
```

### 4. Ejecutar la aplicación
```bash
mvn spring-boot:run -pl ${projectName}-exposicion
```

La aplicación estará disponible en: http://localhost:8080

## 📚 Documentación de la API

La documentación de la API está disponible en:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## 🧪 Pruebas

### Ejecutar pruebas unitarias
```bash
mvn test
```

### Ejecutar pruebas de integración
```bash
mvn verify -Pintegration-test
```

## 🔧 Configuración Adicional

### Variables de entorno

| Variable               | Descripción                         | Valor por defecto |
|-----------------------|-------------------------------------|------------------|
| SERVER_PORT           | Puerto del servidor                 | 8080             |
| SPRING_PROFILES_ACTIVE| Perfil de Spring activo            | dev              |
| DB_URL                | URL de conexión a la base de datos  | -                |
| DB_USERNAME           | Usuario de la base de datos        | -                |
| DB_PASSWORD           | Contraseña de la base de datos     | -                |


### Perfiles de Spring

- **dev**: Desarrollo local
- **test**: Ambiente de pruebas
- **prod**: Producción

## 📦 Dependencias Principales

- **Spring Boot Starter Web**: Para aplicaciones web
- **Spring Data JPA**: Para acceso a datos
- **Spring Security**: Para autenticación y autorización
- **Lombok**: Para reducir código boilerplate
- **MapStruct**: Para mapeo entre entidades y DTOs
- **H2 Database**: Base de datos en memoria para pruebas
- **TestContainers**: Para pruebas de integración

## 🛡️ Seguridad

La aplicación incluye configuración básica de seguridad. Para personalizarla:

1. Modifica `SecurityConfig.java` en el módulo de exposición
2. Configura usuarios y roles en `application-security.properties`

## 🚀 Despliegue

### Generar artefacto ejecutable
```bash
mvn clean package -DskipTests
```

### Ejecutar en producción
```bash
java -jar ${projectName}-exposicion/target/${projectName}-exposicion-${version}.jar \
  --spring.profiles.active=prod
```

## 🤝 Contribución

1. Haz un Fork del proyecto
2. Crea tu rama (`git checkout -b feature/AmazingFeature`)
3. Haz commit de tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Haz push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Ver el archivo `LICENSE` para más detalles.

## ✨ Créditos

- Equipo de Desarrollo de ${projectName}
- Basado en las mejores prácticas de Spring Boot y arquitectura limpia

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
