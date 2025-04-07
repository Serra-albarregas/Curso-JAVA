
# Primeros pasos

## Organización de un proyecto en JavaFX
Un proyecto en JavaFX suele tener una gran cantidad de componentes. Lo normal es tener dos secciones diferenciadas, una para el código y otra para los recursos (vistas, imágenes, estilos...).
Un ejemplo de organización de un proyecto es el siguiente:

```
ProyectoJavaFX/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/idgrupo/
│   │   │   │   ├── controladores/          # Controladores de las vistas FXML
│   │   │   │   │   ├── LoginController.java
│   │   │   │   │   ├── DashboardController.java
│   │   │   │   ├── database/
│   │   │   │   │   ├── ProductoDAO.java
│   │   │   │   │   ├── UsuarioDAO.java
│   │   │   │   │   ├── ConexionDB.java     # Si usas SQLite
│   │   │   │   │   ├── script.sql          # Archivo SQL para generar la BD
│   │   │   │   ├── interfaces/             # Interfaces
│   │   │   │   │   ├── Observer.java
│   │   │   │   ├── modelo/                 # Clases del modelo (lógica de negocio)
│   │   │   │   │   ├── Usuario.java
│   │   │   │   │   ├── Producto.java
│   │   │   │   ├── utils/                  # Clases auxiliares/utilitarias
│   │   │   │   │   ├── Utilidades.java
│   │   │   │   │   ├── Validaciones.java
│   │   │   │   ├── App.java
│   │   │   ├── module-info.java
│   │   ├── resources/com/idgrupo/          # Recursos como imágenes y hojas de estilo
│   │   │   ├── css/
│   │   │   │   ├── estilos.css
│   │   │   ├── database/
│   │   │   │   ├── basedatos.db            # Si usas SQLite
│   │   │   │   ├── script.sql              # Archivo SQL para generar la BD
│   │   │   ├── images/
│   │   │   │   ├── logo.png
│   │   │   │   ├── fondo.jpg
│   │   │   ├── vistas/                     # Archivos FXML
│   │   │   │   ├── login.fxml
│   │   │   │   ├── dashboard.fxml
│   │   │   │   ├── modal_producto.fxml
│   │   │   ├── localizacion/               # Archivos de idioma en resources
│   │   │   │   ├── Messages_es.properties
│   │   │   │   ├── Messages_en.properties
│   │   │   │   ├── Messages_fr.properties
│── pom.xml                                 # Si es un proyecto Maven
│── .gitignore
│── README.md
```

## Creación de vistas y controladores

El primer paso será crear los archivos .fxml para las vistas y los controladores asociados. Las vistas se almacenan en los recursos, en una carpeta destinado a ellos y los controladores en la sección de código. Cada vez que se crea una vista, debe crearse un controlador para ella.

## Module-info

El archivo `module-info.java` define un módulo en Java, que es una agrupación de clases e interfaces relacionadas que se exportan a otras partes de la aplicación. En Java 9 y versiones posteriores, el sistema de módulos de Java permite controlar qué paquetes están disponibles para ser utilizados en otros módulos. En el archivo `module-info.java` debe abrir a javafx el paquete que contiene los controladores.

Ejemplo:
```java
module com.idgrupo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.idgrupo to javafx.fxml;
    opens com.idgrupo.controladores to javafx.fxml;

    exports com.idgrupo;
}
```

## Asignación de controlador

Se debe asignar un controlador a una vista. Esto permite que los componentes de la interfaz de usuario (botones, campos de texto, etc.) estén vinculados a métodos en el controlador para gestionar las interacciones del usuario. Para asignar un controlador a un archivo FXML, se utiliza el atributo `fx:controller` dentro del archivo FXML o accede a la sección controller en SceneBuilder que se localiza en la zona inferior izquierda de la interfaz.

Ejemplo:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.StackPane?>
<?import javafx.scene.control.Button?>

<StackPane xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.idgrupo.controllers.MainController">
    <Button text="Click me" onAction="#handleButtonClick"/>
</StackPane>
```
En este ejemplo, el archivo FXML tiene asignado el controlador `MainController`, y el botón dentro de la vista está vinculado al método `handleButtonClick` del controlador.

## Asignación de IDs de nodos

Además de la asignación del controlador, cada nodo (componente de la interfaz de usuario) debe tener un identificador único (ID) para poder referenciarlo. Esto se hace a través del atributo `fx:id` en el archivo FXML o en la sección code que se localiza en SceneBuilder al tener un nodo seleccionado. Esta asignación permite que el controlador interactúe con los nodos de la interfaz, como cambiar su texto, estilos, o registrar eventos.

Ejemplo:
```xml
<Button fx:id="pressButton" text="Press Me"/>
```
Aquí, el botón tiene el `fx:id` asignado como `pressButton`. Esto permite que en el controlador se haga referencia a este botón mediante el ID para manipularlo.

## Creación de atributos en el controlador

Como atributos del controlador de una vista, se deben incluir los nodos que tienen un identificador asignado en la vista, utilizando ese mismo id como nombre para el atributo. El atributo deberá estar acompañado de la etiqueta `@FXML` para completar la vinculación.

Ejemplo:
```java
@FXML
private Button pressButton;
```

En el ejemplo se está creando el atributo `pressButton`, de clase `Button`, que comparte nombre con el id asignado en el archivo fxml para ese mismo nodo.

## Método initialize

El método `initialize()` en JavaFX es parte del ciclo de vida de un controlador FXML y se usa para inicializar la vista una vez que todos los elementos de la interfaz han sido cargados desde el archivo .fxml.

Se ejecuta automáticamente después de que el FXML Loader ha cargado los nodos en la escena, antes de que el usuario pueda interactuar con ellos.

El método initialize se utiliza para:

1. Configurar valores iniciales en etiquetas (Label), botones, listas, etc.
2. Cargar datos desde una base de datos o archivo antes de mostrar la vista.
3. Asignar listener a los eventos.

## Creación de eventos

En JavaFX, los eventos son utilizados para capturar la interacción del usuario (como clics de botón, cambios de texto, etc.). Los eventos pueden ser manejados mediante el uso de lambdas.

Hay dos tipos principales de eventos:

1. Eventos de entrada del usuario (clics, teclas, movimientos del mouse, etc.).
2. Eventos sobre propiedades de nodos (cuando cambia una propiedad de un componente, como el tamaño o el texto de un Label).

El evento de entrada de usuario principal es `onAction`, que se lanza con la interacción común sobre un nodo determinado. Este evento dependerá del tipo de nodo, en un botón se lanzará al pulsarlo mientras que en un campo de texto se lanzará al pulsar la tecla `ENTER`.

Ejemplo de un evento de clic en un botón:
```java
button.setOnAction(event -> {
    System.out.println("Botón presionado");
});
```
En este ejemplo, se utiliza una expresión lambda para manejar el evento `onAction` del botón, imprimiendo un mensaje en la consola cuando el botón es presionado.

Existen además, otros eventos de interacción de usuario que se asignan a la escena, son los eventos de detección de pulsaciones de tecla o botones del mouse.

| Evento | Método en JavaFX	| Descripción |
|-----------|------------|------------|
| Clic del ratón | setOnMouseClicked() | Se activa cuando el usuario hace clic en un nodo. |
| Entrada del ratón | setOnMouseEntered() | Se activa cuando el ratón entra en el nodo. |
| Salida del ratón | setOnMouseExited() | Se activa cuando el ratón sale del nodo. |
| Presionar tecla | setOnKeyPressed() | Se activa cuando se presiona una tecla. |
| Soltar tecla | setOnKeyReleased() | Se activa cuando se suelta una tecla. |
| Movimiento del mouse | setOnMouseMoved() | Se activa cuando el usuario mueve el ratón sobre el nodo. |

Ejemplo de un evento de pulsación de una tecla.
```java
scene.setOnKeyPressed(event -> {
    System.out.println("Tecla presionada: " + event.getCode());
});
```
En el ejemplo, se utiliza el parámetro `event` de la función lambda para acceder al código de la tecla que ha sido pulsada.

Finalmente JavaFX permite detectar cambios en las propiedades de un nodo. Se usa el método addListener() en Properties como `textProperty()`, `widthProperty()`, `selectedProperty()`, etc.

```java
textField.textProperty().addListener((observable, oldValue, newValue) -> {
    System.out.println("Texto cambiado: " + newValue);
});
```

En el ejemplo se accede a la propiedad de texto de un campo de texto y se le asigna un listener para escuchar el evento de un cambio en el campo.