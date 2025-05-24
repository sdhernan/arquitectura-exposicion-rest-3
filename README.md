# Guía de Uso del Arquetipo arquitectura-exposicion-rest-3

Esta guía proporciona instrucciones detalladas para instalar y utilizar el arquetipo `arquitectura-exposicion-rest-3` para crear nuevos proyectos REST con arquitectura de tres capas. Este arquetipo proporciona una estructura completa para aplicaciones Java 11 con un ejemplo funcional basado en la entidad Afore, incluyendo implementaciones de todas las capas y clases de prueba.

## Índice

1. [Características del Arquetipo](#1-características-del-arquetipo)
2. [Instalación del Arquetipo](#2-instalación-del-arquetipo)
3. [Verificación de la Instalación](#3-verificación-de-la-instalación)
4. [Uso del Arquetipo en Eclipse](#4-uso-del-arquetipo-en-eclipse)
5. [Solución de Problemas Comunes](#5-solución-de-problemas-comunes)
6. [Estructura del Proyecto Generado](#6-estructura-del-proyecto-generado)
7. [Personalización del Proyecto](#7-personalización-del-proyecto)
8. [Pruebas Unitarias](#8-pruebas-unitarias)
9. [Ejecución de la Aplicación](#9-ejecución-de-la-aplicación)

## 1. Características del Arquetipo

El arquetipo `arquitectura-exposicion-rest-3` proporciona una estructura completa para aplicaciones REST con arquitectura de tres capas, utilizando Java 11 y Spring Boot. Las principales características incluyen:

### Estructura Modular

- **Módulo de Persistencia**: Contiene entidades JPA, repositorios y DTOs para la capa de acceso a datos
- **Módulo de Servicios**: Contiene interfaces de servicio y sus implementaciones para la lógica de negocio
- **Módulo de Exposición**: Contiene controladores REST para exponer la API

### Ejemplo Funcional con Afore

El arquetipo incluye un ejemplo completo basado en la entidad Afore, que incluye:

- **Entidad Afore**: Una entidad JPA completa con anotaciones y campos relevantes
- **DTO AforeModel**: Un modelo de datos para transferencia entre capas
- **Repositorio AforeRepository**: Interfaz con métodos para acceder a los datos de Afore
- **Servicio AforeService**: Interfaz de servicio con métodos CRUD y de negocio
- **Implementación AforeServiceImpl**: Implementación completa del servicio
- **Controlador AforeController**: Controlador REST con endpoints para operaciones CRUD

### Clases de Prueba

El arquetipo incluye clases de prueba para cada capa:

- **AforeRepositoryTest**: Prueba unitaria para el repositorio
- **AforeServiceImplTest**: Prueba unitaria para la implementación del servicio
- **AforeControllerTest**: Prueba unitaria para el controlador REST

### Características Adicionales

- **Capitalización Automática**: El arquetipo capitaliza automáticamente la primera letra del nombre del proyecto
- **Independencia de Dependencias Externas**: No depende de bibliotecas como Lombok
- **Implementación Manual de Patrones**: Incluye implementaciones manuales de patrones como Builder
- **Configuración para Java 11**: Configurado específicamente para funcionar con Java 11

## 2. Instalación del Arquetipo

### Requisitos Previos

- Java 11 instalado
- Maven 3.5.4 o superior instalado
- Eclipse IDE con soporte para Maven

### Pasos para la Instalación

1. Ejecuta el archivo `arquetipo-rest-manager.bat` incluido en este directorio:
   - Haz doble clic en el archivo `arquetipo-rest-manager.bat`
   - O abre una ventana de comandos y ejecuta:

     ```batch
     D:\proyectos\arquitectura-exposicion-rest-3\arquetipo-rest-manager.bat
     ```

2. En el menú que aparece, selecciona la opción 1: "Instalar y verificar arquetipo".

3. El script configurará automáticamente las variables de entorno para Java 11 y Maven, y ejecutará los comandos necesarios para instalar el arquetipo en tu repositorio local.

4. Espera a que el proceso de instalación se complete. Verás un mensaje de éxito cuando termine.

## 3. Verificación de la Instalación

El script `arquetipo-rest-manager.bat` incluye una opción para verificar que el arquetipo se ha instalado correctamente:

1. Ejecuta el archivo `arquetipo-rest-manager.bat` si aún no lo has hecho:

   ```batch
   D:\proyectos\arquitectura-exposicion-rest-3\arquetipo-rest-manager.bat
   ```

2. En el menú que aparece, selecciona la opción 1: "Instalar y verificar arquetipo".

3. El script verificará automáticamente:
   - Que el arquetipo esté correctamente instalado en tu repositorio local Maven
   - Que el catálogo de arquetipos exista y contenga el arquetipo
   - Que todas las dependencias necesarias estén disponibles

4. Si hay algún problema, el script intentará resolverlo automáticamente.

## 4. Uso del Arquetipo en Eclipse

### Método 1: Usando el Catálogo de Arquetipos

1. Primero, asegúrate de que Eclipse conozca tu catálogo de arquetipos local:
   - Ve a **Window > Preferences**
   - Navega a **Maven > Archetypes**
   - Haz clic en **Add Local Catalog...**
   - En **Catalog File**, navega hasta `C:\Users\[tu-usuario]\.m2\repository\archetype-catalog.xml`
   - En **Description**, escribe "Arquetipos Locales"
   - Haz clic en **OK** y luego en **Apply and Close**

2. Para crear un nuevo proyecto:
   - Selecciona **File > New > Project...**
   - En el diálogo, selecciona **Maven > Maven Project** y haz clic en **Next**
   - En la pantalla "Select project name and location", asegúrate de que **Create a simple project** NO esté seleccionado y haz clic en **Next**
   - En la pantalla "Select an Archetype", selecciona "Arquetipos Locales" en el desplegable "Catalog"
   - Busca y selecciona el arquetipo `mx.com.procesar.servicios.internos:arquitectura-exposicion-rest-3`
   - Haz clic en **Next**
   - Completa los parámetros del arquetipo:
     - **Group Id**: mx.com.procesar.servicios.internos (o el que desees usar)
     - **Artifact Id**: nombre-de-tu-proyecto (sin espacios, preferiblemente en minúsculas)
     - **Version**: 1.0.0 (o la versión que desees)
     - **Package**: se rellenará automáticamente, pero puedes modificarlo
   - Haz clic en **Finish**

### Método 2: Usando el Script arquetipo-rest-manager.bat

El arquetipo incluye un script que facilita la generación de proyectos desde la línea de comandos:

1. Ejecuta el archivo `arquetipo-rest-manager.bat`:

   ```batch
   D:\proyectos\arquitectura-exposicion-rest-3\arquetipo-rest-manager.bat
   ```

2. En el menú que aparece, selecciona la opción 2: "Generar nuevo proyecto".

3. El script te solicitará la siguiente información:
   - **Nombre del proyecto (artifactId)**: Nombre del proyecto sin espacios (ej. miproyecto)
   - **GroupId**: Identificador del grupo (ej. mx.com.procesar.servicios.internos)
   - **Versión**: Versión inicial del proyecto (ej. 1.0.0)
   - **Nombre del proyecto (projectName)**: Nombre del proyecto con la primera letra en mayúscula (ej. Miproyecto)

4. El script generará automáticamente el proyecto con la estructura completa y te mostrará la ruta donde se ha creado.

5. Luego, puedes importar el proyecto en Eclipse:
   - Selecciona **File > Import...**
   - Selecciona **Maven > Existing Maven Projects**
   - Navega hasta la carpeta donde se generó el proyecto
   - Haz clic en **Finish**

### Método 3: Usando Maven Directamente

Si prefieres usar Maven directamente, puedes ejecutar el siguiente comando:

```batch
mvn archetype:generate -B \
  -DarchetypeGroupId=mx.com.procesar.servicios.internos \
  -DarchetypeArtifactId=arquitectura-exposicion-rest-3 \
  -DarchetypeVersion=1.0.0 \
  -DgroupId=mx.com.procesar.servicios.internos \
  -DartifactId=miproyecto \
  -Dversion=1.0.0 \
  -DprojectName=Miproyecto \
  -DinteractiveMode=false
```

Observa que ahora puedes especificar el parámetro `projectName` para controlar la capitalización del nombre del proyecto.

## 5. Solución de Problemas Comunes

### Problema: "No archetypes available for this catalog"

Si ves este error al intentar crear un nuevo proyecto Maven en Eclipse:

1. Asegúrate de que el catálogo de arquetipos exista:
   - Ejecuta el script `verificar-arquetipo.bat` mencionado anteriormente
   - Verifica que el archivo `archetype-catalog.xml` exista en `C:\Users\[tu-usuario]\.m2\repository\`

2. Actualiza el catálogo de arquetipos:
    - Crea un archivo `generar-catalogo.bat` con el siguiente contenido:
      ```batch
      @echo off
      SET MAVEN_HOME=D:\Tools\01.-Maven\apache-maven-3.5.4
      SET PATH=%MAVEN_HOME%\bin;%PATH%
      
      echo Generando catálogo de arquetipos...
      call mvn archetype:crawl -Dcatalog=C:/Users/%USERNAME%/.m2/repository/archetype-catalog.xml
      
      echo.
      echo Catálogo generado correctamente.
      echo.
      pause
      ```
   - Ejecuta este archivo para generar o actualizar el catálogo de arquetipos

3. Reinicia Eclipse después de actualizar el catálogo.

### Problema: "Non-resolvable parent POM"

Si ves un error como "Non-resolvable parent POM" después de crear el proyecto:

1. Este arquetipo ha sido diseñado para evitar este problema al no depender de un POM padre externo.

2. Si aún así ocurre, verifica que todos los módulos del proyecto se hayan generado correctamente:
   - Debería haber un módulo principal y tres submódulos (persistencia, servicios, exposición)
   - Cada módulo debe tener su propio archivo POM

3. Asegúrate de que las referencias entre módulos sean correctas:
   - El POM principal debe listar los tres submódulos
   - Los POM de los submódulos deben referenciar al POM principal como su padre

## 6. Estructura del Proyecto Generado

El proyecto generado tendrá la siguiente estructura:

```text
mi-proyecto/
│── mi-proyecto-persistencia/
│   │── src/main/java/
│   │   └── mx/com/procesar/servicios/internos/miproyecto/persistencia/
│   │       │── config/
│   │       │   └── PersistenceConfig.java
│   │       │── dto/
│   │       │   └── AforeModel.java
│   │       │── entity/
│   │       │   └── Afore.java
│   │       └── repository/
│   │           └── AforeRepository.java
│   │── src/test/java/
│   │   └── mx/com/procesar/servicios/internos/miproyecto/persistencia/repository/
│   │       └── AforeRepositoryTest.java
│   └── pom.xml
│── mi-proyecto-servicios/
│   │── src/main/java/
│   │   └── mx/com/procesar/servicios/internos/miproyecto/servicios/
│   │       │── config/
│   │       │   └── ServiceConfig.java
│   │       └── service/
│   │           │── AforeService.java
│   │           └── impl/
│   │               └── AforeServiceImpl.java
│   │── src/test/java/
│   │   └── mx/com/procesar/servicios/internos/miproyecto/servicios/service/impl/
│   │       └── AforeServiceImplTest.java
│   └── pom.xml
│── mi-proyecto-exposicion/
│   │── src/main/java/
│   │   └── mx/com/procesar/servicios/internos/miproyecto/exposicion/
│   │       │── config/
│   │       │   │── AppConfig.java
│   │       │   └── OpenApiConfig.java
│   │       │── controller/
│   │       │   └── AforeController.java
│   │       │── dto/
│   │       │   └── ApiErrorDTO.java
│   │       └── exception/
│   │           └── GlobalExceptionHandler.java
│   │── src/main/resources/
│   │   └── application.properties
│   │── src/test/java/
│   │   └── mx/com/procesar/servicios/internos/miproyecto/exposicion/controller/
│   │       └── AforeControllerTest.java
│   └── pom.xml
│── pom.xml
└── README.md
```

## 7. Personalización del Proyecto

El arquetipo proporciona una base sólida con un ejemplo funcional basado en la entidad Afore. A continuación, se presentan algunos ejemplos de cómo personalizar y extender el proyecto generado:

### Ejemplo de Uso del Modelo Afore

El arquetipo incluye un ejemplo completo de la entidad Afore con todas sus capas. Puedes usar este ejemplo como referencia para crear tus propias entidades:

#### Entidad JPA

```java
@Entity
@Table(name = "NSAR_TC_AFORE")
public class Afore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CLAVE", length = 10, nullable = false, unique = true)
    private String clave;
    
    @Column(name = "NOMBRE", length = 100, nullable = false)
    private String nombre;
    
    // Getters, setters, equals, hashCode, toString y Builder
}
```

#### DTO

```java
public class AforeModel {
    private Long id;
    private String clave;
    private String nombre;
    
    // Getters, setters, equals, hashCode, toString y Builder
}
```

#### Repositorio

```java
public interface AforeRepository extends JpaRepository<Afore, Long> {
    Optional<Afore> findByClave(String clave);
    List<Afore> findByNombreContaining(String nombre);
}
```

#### Servicio

```java
public interface AforeService {
    List<AforeModel> obtenerTodasLasAfores();
    Optional<AforeModel> obtenerAforePorId(Long id);
    AforeModel guardarAfore(AforeModel afore);
    void eliminarAfore(Long id);
}
```

#### Implementación del Servicio

```java
@Service
public class AforeServiceImpl implements AforeService {
    private final AforeRepository aforeRepository;
    
    @Autowired
    public AforeServiceImpl(AforeRepository aforeRepository) {
        this.aforeRepository = aforeRepository;
    }
    
    @Override
    public List<AforeModel> obtenerTodasLasAfores() {
        return aforeRepository.findAll().stream()
                .map(this::convertirAModel)
                .collect(Collectors.toList());
    }
    
    // Otros métodos y conversiones entre entidad y DTO
}
```

#### Controlador REST

```java
@RestController
@RequestMapping("/api/afores")
public class AforeController {
    private final AforeService aforeService;
    
    @Autowired
    public AforeController(AforeService aforeService) {
        this.aforeService = aforeService;
    }
    
    @GetMapping
    public ResponseEntity<List<AforeModel>> obtenerTodasLasAfores() {
        return ResponseEntity.ok(aforeService.obtenerTodasLasAfores());
    }
    
    // Otros endpoints para operaciones CRUD
}
```

### Creando Nuevas Entidades

Para crear nuevas entidades siguiendo el mismo patrón:

1. Crea la entidad JPA en el módulo de persistencia
2. Crea el DTO correspondiente en el módulo de persistencia
3. Crea el repositorio en el módulo de persistencia
4. Crea la interfaz de servicio en el módulo de servicios
5. Implementa el servicio en el módulo de servicios
6. Crea el controlador REST en el módulo de exposición
7. Crea las clases de prueba para cada componente

Una vez generado el proyecto, puedes personalizarlo según tus necesidades:

1. **Configuración de la base de datos**:
   - Modifica el archivo `application.properties` en el módulo de exposición para configurar la conexión a tu base de datos

2. **Entidades y repositorios**:
   - Crea tus propias entidades JPA en el paquete `entity` del módulo de persistencia
   - Crea los repositorios correspondientes en el paquete `repository`

3. **Servicios**:
   - Crea DTOs para tus entidades en el paquete `dto` del módulo de servicios
   - Implementa interfaces de servicio en el paquete `service` y sus implementaciones en `service/impl`

4. **API REST**:
   - Crea controladores REST en el paquete `controller` del módulo de exposición
   - Documenta tus endpoints usando las anotaciones de OpenAPI/Swagger

5. **Configuración adicional**:
   - Agrega dependencias adicionales según tus necesidades en los archivos POM correspondientes
   - Configura aspectos como seguridad, caché, etc., según lo requiera tu aplicación

## 8. Pruebas Unitarias

El arquetipo incluye pruebas unitarias para cada capa de la aplicación, utilizando JUnit 5, Mockito y Spring Test:

### Pruebas de Repositorio

```java
@DataJpaTest
public class AforeRepositoryTest {
    @Autowired
    private AforeRepository aforeRepository;
    
    @Test
    public void testFindByClave() {
        // Configuración de datos de prueba
        Afore afore = new Afore();
        afore.setClave("001");
        afore.setNombre("Afore Ejemplo");
        aforeRepository.save(afore);
        
        // Ejecución de la prueba
        Optional<Afore> resultado = aforeRepository.findByClave("001");
        
        // Verificación
        assertTrue(resultado.isPresent());
        assertEquals("Afore Ejemplo", resultado.get().getNombre());
    }
}
```

### Pruebas de Servicio

```java
@ExtendWith(MockitoExtension.class)
public class AforeServiceImplTest {
    @Mock
    private AforeRepository aforeRepository;
    
    @InjectMocks
    private AforeServiceImpl aforeService;
    
    @Test
    public void testObtenerTodasLasAfores() {
        // Configuración
        List<Afore> afores = Arrays.asList(
            createAfore(1L, "001", "Afore Uno"),
            createAfore(2L, "002", "Afore Dos")
        );
        when(aforeRepository.findAll()).thenReturn(afores);
        
        // Ejecución
        List<AforeModel> resultado = aforeService.obtenerTodasLasAfores();
        
        // Verificación
        assertEquals(2, resultado.size());
        assertEquals("001", resultado.get(0).getClave());
    }
}
```

### Pruebas de Controlador

```java
@WebMvcTest(AforeController.class)
public class AforeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private AforeService aforeService;
    
    @Test
    public void testObtenerTodasLasAfores() throws Exception {
        // Configuración
        List<AforeModel> afores = Arrays.asList(
            createAforeModel(1L, "001", "Afore Uno"),
            createAforeModel(2L, "002", "Afore Dos")
        );
        when(aforeService.obtenerTodasLasAfores()).thenReturn(afores);
        
        // Ejecución y verificación
        mockMvc.perform(get("/api/afores"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].clave", is("001")));
    }
}
```

## 9. Ejecución de la Aplicación

Para ejecutar la aplicación generada:

1. **Compilación del proyecto**:

   ```bash
   cd mi-proyecto
   mvn clean install
   ```

2. **Ejecución de la aplicación**:

   ```bash
   cd mi-proyecto-exposicion
   mvn spring-boot:run
   ```

3. **Acceso a la API**:
   - La aplicación estará disponible en `http://localhost:8080`
   - La documentación de la API (Swagger UI) estará disponible en `http://localhost:8080/swagger-ui.html`

4. **Endpoints disponibles**:
   - `GET /api/afores`: Obtener todas las afores
   - `GET /api/afores/{id}`: Obtener una afore por ID
   - `POST /api/afores`: Crear una nueva afore
   - `PUT /api/afores/{id}`: Actualizar una afore existente
   - `DELETE /api/afores/{id}`: Eliminar una afore
