# Configuración Previa para Crear un Proyecto JavaFX en Visual Studio Code

## 1. Configuración de JAVA_HOME
Para desarrollar en JavaFX, es necesario configurar la variable de entorno `JAVA_HOME` apuntando a la ruta del JDK.

### **Pasos en Windows**
1. Abre el menú de inicio y busca **"Editar las variables de entorno del sistema"**.
2. En la pestaña **Opciones avanzadas**, haz clic en **Variables de entorno**.
3. En la sección **Variables del sistema**, busca `JAVA_HOME`.
   - Si no existe, haz clic en **Nueva** e ingresa:
     - **Nombre de la variable:** `JAVA_HOME`
     - **Valor de la variable:** Ruta al jdk instalado, por lo general es `C:\Program Files\Java\jdkx.xx.x\`
4. Agrega la siguiente entrada en la variable `Path`:
   ```
   %JAVA_HOME%\bin
   ```
5. Guarda y cierra.

---

## 2. Descarga e Instalación de Maven
Maven es una herramienta de gestión y construcción de proyectos Java.

### **Descarga e Instalación**
1. Descarga Maven desde [Apache Maven](https://maven.apache.org/download.cgi).
2. Extrae el archivo en `C:\Program Files\Apache\maven`.
3. Agrega al `Path`:
   ```
   C:\Program Files\Apache\maven\bin
   ```

### **Verificación**
Ejecuta en la terminal:
```sh
mvn -version
```
Debe mostrar la versión instalada de Maven.

---

## 3. Creación de un Proyecto JavaFX
### **Pasos para crear un proyecto JavaFX con Maven**
1. Abre el menú y selecciona mostrar y ejecutar comandos.
2. Selecciona crear proyecto java.
3. Selecciona la opción JavaFX.
4. Selecciona una carpeta para guardar el proyecto.
5. Da valor a los parámetros del proyecto:

#### **Parámetros**
- **`groupId`**: Identificador del grupo del proyecto, se refiere al nombre de la empresa o autor (Ejemplo: `com.ejemplo`).
- **`artifactId`**: Nombre único del proyecto (Ejemplo: `MiJavaFXApp`).
- **`version`**: Versión inicial del proyecto (`1.0-SNAPSHOT`).

Para ejecutar el proyecto, puedes usar el botón `run` o buscar en el explorador:
`MAVEN->nombreProyecto->plugins->javafx->run`.

---

## 4. Descarga e Instalación de SceneBuilder
SceneBuilder permite diseñar interfaces gráficas para JavaFX mediante una interfaz, para evitar la manipulación de los archivos fxml directamente.

### **Pasos de Instalación**
1. Descarga SceneBuilder desde [Gluon SceneBuilder](https://gluonhq.com/products/scene-builder/) o desde [Oracle](https://www.oracle.com/java/technologies/javafxscenebuilder-1x-archive-downloads.html)
2. Instálalo en `C:\Program Files\SceneBuilder`.

Los siguientes pasos son opcionales
3. En Visual Studio Code, instala la extensión `SceneBuilder extension for Visual Studio Code`.
4. En mostrar y ejecutar comandos, busca `Configure SceneBuilder path`.
5. Seleccióna el fichero ejecutable de SceneBuilder en la ruta de instalación.
6. Ahora, puedes abrir los archivos fxml directamente desde Visual Studio Code haciendo click derecho en ellos.
