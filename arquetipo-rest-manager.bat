@echo off
setlocal enabledelayedexpansion

REM Configuración de Java 11
SET JAVA_HOME=D:\Tools\02.- Java\jdk-11.0.24
SET PATH=%JAVA_HOME%\bin;%PATH%

REM Configuración de Maven - Ajusta esta ruta a tu instalación
SET MAVEN_HOME=D:\Tools\01.-Maven\apache-maven-3.5.4
SET PATH=%MAVEN_HOME%\bin;%PATH%

REM Configurar directamente la ruta del repositorio Maven
SET MVN_REPO=D:\Repository

echo Usando Maven en: %MAVEN_HOME%
echo Repositorio Maven en: %MVN_REPO%

REM Verificar que Maven esté disponible
call mvn --version > nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: No se pudo encontrar Maven. Verifica la ruta configurada.
    echo Ruta actual: %MAVEN_HOME%
    pause
    exit /b 1
)

:MENU
cls
echo ===================================================
echo  GESTOR DE ARQUETIPO REST 3 CAPAS v1.0
echo ===================================================
echo.
echo  1. Instalar y verificar arquetipo
echo  2. Generar nuevo proyecto
echo  3. Salir
echo.
set /p OPCION=Seleccione una opcion (1-3): 

if "%OPCION%"=="1" goto INSTALAR
if "%OPCION%"=="2" goto GENERAR
if "%OPCION%"=="3" goto SALIR

echo Opcion invalida. Por favor, seleccione una opcion valida.
pause
goto MENU

:INSTALAR
cls
echo ===================================================
echo  INSTALACION Y VERIFICACION DEL ARQUETIPO
echo ===================================================
echo.
echo [1/3] Instalando el arquetipo en el repositorio local de Maven...
call mvn clean install

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] No se pudo instalar el arquetipo. Verifique la configuracion de Maven.
    echo.
    pause
    goto MENU
) else (
    echo.
    echo [OK] Arquetipo instalado correctamente.
)

echo.
echo [2/3] Verificando instalacion del arquetipo...

REM Usar valores fijos para el arquetipo
set GROUP_ID=mx.com.procesar.servicios.internos
set ARTIFACT_ID=arquitectura-exposicion-rest-3
set VERSION=1.0.0

echo Buscando arquetipo: %GROUP_ID%:%ARTIFACT_ID%:%VERSION%

REM Convertir puntos a barras en el groupId
set GROUP_PATH=%GROUP_ID:.=\%

REM Verificar si existe el JAR del arquetipo
set ARQUETIPO_JAR="%MVN_REPO%\%GROUP_PATH%\%ARTIFACT_ID%\%VERSION%\%ARTIFACT_ID%-%VERSION%.jar"
echo Verificando: %ARQUETIPO_JAR%

if exist %ARQUETIPO_JAR% (
    echo [OK] El arquetipo esta correctamente instalado en el repositorio local.
) else (
    echo [ERROR] El arquetipo NO se encuentra en el repositorio local.
    echo Ruta esperada: %ARQUETIPO_JAR%
    echo.
    pause
    goto MENU
)

echo.
echo [3/3] Verificando catalogo de arquetipos...
if exist "%MVN_REPO%\archetype-catalog.xml" (
    echo [OK] El catalogo de arquetipos existe.
) else (
    echo [AVISO] El catalogo de arquetipos NO existe. Generando...
    call mvn archetype:crawl -Dcatalog=%MVN_REPO%\archetype-catalog.xml
    
    if %ERRORLEVEL% NEQ 0 (
        echo.
        echo [ERROR] No se pudo generar el catalogo de arquetipos.
        echo.
    ) else (
        echo.
        echo [OK] Catalogo de arquetipos generado correctamente.
    )
)

echo.
echo ===================================================
echo  INSTRUCCIONES PARA ECLIPSE
echo ===================================================
echo.
echo Para configurar el catalogo de arquetipos en Eclipse:
echo.
echo 1. En Eclipse, ve a Window ^> Preferences
echo 2. Navega a Maven ^> Archetypes
echo 3. Haz clic en "Add Local Catalog..."
echo 4. En "Catalog File", navega hasta: %MVN_REPO%\archetype-catalog.xml
echo 5. En "Description", escribe "Arquetipos Locales"
echo 6. Haz clic en OK y luego en Apply and Close
echo 7. Reinicia Eclipse
echo.
pause
goto MENU

:GENERAR
cls
echo ===================================================
echo  GENERADOR DE PROYECTOS - ARQUITECTURA REST 3 CAPAS
echo ===================================================
echo.

echo Ingrese el nombre del proyecto (artifactId):
set /p ARTIFACT_ID=

echo.
echo Ingrese el groupId (presione Enter para usar mx.com.procesar.servicios.internos):
set /p GROUP_ID=
if "%GROUP_ID%"=="" set GROUP_ID=mx.com.procesar.servicios.internos

echo.
echo Ingrese la version (presione Enter para usar 1.0.0):
set /p VERSION=
if "%VERSION%"=="" set VERSION=1.0.0

echo.
echo Generando proyecto %ARTIFACT_ID%...
echo.

echo Usando Maven en: %MAVEN_HOME%

call mvn archetype:generate -B ^
  -DarchetypeGroupId=mx.com.procesar.servicios.internos ^
  -DarchetypeArtifactId=arquitectura-exposicion-rest-3 ^
  -DarchetypeVersion=1.0.0 ^
  -DgroupId=%GROUP_ID% ^
  -DartifactId=%ARTIFACT_ID% ^
  -Dversion=%VERSION% ^
  -Dpackage=%GROUP_ID%.%ARTIFACT_ID:.=% ^
  -DinteractiveMode=false

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] No se pudo generar el proyecto. Verifique que el arquetipo este instalado correctamente.
    echo Ejecute la opcion 1 para instalar el arquetipo y luego intente nuevamente.
    echo.
    pause
    goto MENU
)

echo.
echo ===================================================
echo  PROYECTO GENERADO EXITOSAMENTE
echo ===================================================
echo.
echo El proyecto %ARTIFACT_ID% ha sido creado en la carpeta:
echo %CD%\%ARTIFACT_ID%
echo.
echo ESTRUCTURA DEL PROYECTO:
echo - %ARTIFACT_ID% (proyecto principal)
echo   - %ARTIFACT_ID%-persistencia (capa de acceso a datos)
echo   - %ARTIFACT_ID%-servicios (capa de logica de negocio)
echo   - %ARTIFACT_ID%-exposicion (capa de API REST)
echo.
echo PASOS SIGUIENTES:
echo 1. Importar el proyecto en Eclipse:
echo    - File > Import... > Maven > Existing Maven Projects
echo    - Seleccionar la carpeta: %CD%\%ARTIFACT_ID%
echo.
echo 2. Compilar el proyecto:
echo    - Clic derecho en el proyecto > Run As > Maven install
echo.
echo 3. Ejecutar la aplicacion:
echo    - Clic derecho en %ARTIFACT_ID%-exposicion > Run As > Spring Boot App
echo.
echo 4. Acceder a la documentacion de la API:
echo    - http://localhost:8080/%ARTIFACT_ID%/swagger-ui.html
echo.
echo ¿Desea abrir la carpeta del proyecto ahora? (S/N)
set /p OPEN_FOLDER=

if /i "%OPEN_FOLDER%"=="S" (
    start explorer "%CD%\%ARTIFACT_ID%"
)

echo.
pause
goto MENU

:SALIR
echo.
echo Gracias por usar el Gestor de Arquetipo REST 3 Capas.
echo.
exit /b 0
