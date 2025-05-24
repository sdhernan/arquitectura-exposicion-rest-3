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
echo  2. Salir
echo.
set /p OPCION=Seleccione una opcion (1-2): 

if "%OPCION%"=="1" goto INSTALAR
if "%OPCION%"=="2" goto SALIR

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

:SALIR
echo.
echo Gracias por usar el Gestor de Arquetipo REST 3 Capas.
echo.
exit /b 0
