
# Explicación de conceptos en JavaFX

## Asignación de controlador

En JavaFX, se puede asignar un controlador a una vista definida por un archivo FXML. Esto permite que los componentes de la interfaz de usuario (botones, campos de texto, etc.) estén vinculados a métodos en el controlador para gestionar las interacciones del usuario. Para asignar un controlador a un archivo FXML, se utiliza el atributo `fx:controller` dentro del archivo FXML.

Ejemplo:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import javafx.scene.layout.StackPane?>
<?import javafx.scene.control.Button?>

<StackPane xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.serra.controllers.MainController">
    <Button text="Click me" onAction="#handleButtonClick"/>
</StackPane>
```
En este ejemplo, el archivo FXML tiene asignado el controlador `MainController`, y el botón dentro de la vista está vinculado al método `handleButtonClick` del controlador.

## Asignación de IDs de nodos

En JavaFX, cada nodo (componente de la interfaz de usuario) puede tener un identificador único (ID) para poder referenciarlo desde el controlador. Esto se hace a través del atributo `fx:id` en el archivo FXML. Esta asignación permite que el controlador interactúe con los nodos de la interfaz, como cambiar su texto, estilos, o registrar eventos.

Ejemplo:
```xml
<Button fx:id="pressButton" text="Press Me"/>
```
Aquí, el botón tiene el `fx:id` asignado como `pressButton`. Esto permite que en el controlador se haga referencia a este botón mediante el ID para manipularlo.

## Module-info

El archivo `module-info.java` define un módulo en Java, que es una agrupación de clases e interfaces relacionadas que se exportan a otras partes de la aplicación. En Java 9 y versiones posteriores, el sistema de módulos de Java permite controlar qué paquetes están disponibles para ser utilizados en otros módulos.

Ejemplo:
```java
module com.serra {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.serra.controllers;
    opens com.serra to javafx.fxml;
}
```
En este ejemplo, el módulo `com.serra` requiere los módulos `javafx.controls` y `javafx.fxml`, exporta el paquete `com.serra.controllers` y abre el paquete `com.serra` al módulo `javafx.fxml`.

## Método init

El método `init` es un patrón común en muchas clases para inicializar configuraciones y recursos antes de que el objeto sea utilizado. En el contexto de JavaFX, se puede usar el método `init` para realizar configuraciones iniciales de la ventana o los recursos antes de que la interfaz de usuario sea mostrada.

Ejemplo:
```java
public void init(Stage stage, String styles) {
    this.stage = stage;
    this.styles = App.class.getResource("styles/" + styles + ".css");
}
```
En este ejemplo, el método `init` inicializa el `Stage` (ventana principal) y la ruta a la hoja de estilo CSS.

## Creación de eventos y eventos con los parámetros

En JavaFX, los eventos son utilizados para capturar la interacción del usuario (como clics de botón, cambios de texto, etc.). Los eventos pueden ser manejados utilizando `EventHandler` o mediante el uso de lambdas.

Ejemplo de un evento de clic en un botón:
```java
button.setOnAction(event -> {
    System.out.println("Botón presionado");
});
```
En este ejemplo, se utiliza una expresión lambda para manejar el evento `onAction` del botón, imprimiendo un mensaje en la consola cuando el botón es presionado.

Los eventos también pueden tener parámetros, como el objeto que los genera (por ejemplo, el botón que fue presionado). Este objeto puede ser utilizado para realizar acciones específicas, como cambiar el texto de un campo o mostrar una alerta.

## Carga de páginas y SceneManager

En una aplicación JavaFX, se puede cargar y cambiar entre diferentes vistas utilizando el `SceneManager`. Esta clase es responsable de gestionar las escenas de la aplicación, almacenarlas y cambiarlas cuando es necesario.

El `SceneManager` puede cargar una escena a partir de un archivo FXML y aplicarle una hoja de estilo CSS.

Ejemplo:
```java
public void setScene(SceneID sceneID, String fxml, int width, int height) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("views/" + fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(styles.toExternalForm());
        scenes.put(sceneID, scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```
En este ejemplo, el método `setScene` carga una vista desde un archivo FXML, crea una nueva `Scene`, le aplica una hoja de estilo y la almacena en un mapa de escenas, lo que permite cambiar entre ellas utilizando su identificador único.

