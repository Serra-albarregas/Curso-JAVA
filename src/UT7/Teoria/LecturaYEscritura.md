# Lectura y Escritura de Archivos en Java con FileReader, FileWriter, BufferedReader y BufferedWriter

## Introducción
En Java, para manejar archivos de texto, se pueden usar `FileReader` y `FileWriter`, que permiten leer y escribir archivos de forma sencilla. Sin embargo, estos métodos pueden ser ineficientes cuando se trabaja con archivos grandes, ya que leen y escriben datos carácter por carácter.

Para mejorar el rendimiento, se utilizan `BufferedReader` y `BufferedWriter`, que incorporan un buffer intermedio para procesar múltiples caracteres a la vez, reduciendo el número de accesos al disco y mejorando la eficiencia.

## Lectura de Archivos con BufferedReader
Para leer un archivo de texto línea por línea, usamos `BufferedReader` en combinación con `FileReader`.

### Ejemplo de Lectura:
```java
import java.io.*;

public class LeerArchivo {
    public static void main(String[] args) {
        String rutaArchivo = "archivo.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### Explicación:
- `FileReader` se encarga de leer el archivo carácter por carácter.
- `BufferedReader` añade un buffer intermedio para agrupar los caracteres y minimizar los accesos al disco, favoreciendo la eficiencia.
- Se usa un bucle `while` para leer el archivo línea por línea hasta que `readLine()` devuelva `null`.
- Se imprimen las líneas leídas en consola.

## Escritura de Archivos con BufferedWriter
Para escribir en un archivo de texto, usamos `BufferedWriter` con `FileWriter`.

### Ejemplo de Escritura:
```java
import java.io.*;

public class EscribirArchivo {
    public static void main(String[] args) {
        String rutaArchivo = "archivo.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write("Hola, mundo!\n");
            bw.write("Esta es una prueba de escritura en un archivo usando BufferedWriter.\n");
            bw.write("Fin del archivo.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
### Explicación:
- `FileWriter` escribe el archivo carácter por carácter.
- `BufferedWriter` utiliza un buffer intermedio para agrupar carácteres, minimizando los accesos a disco y favoreciendo la eficiencia.
- Se usa `write()` para escribir líneas en el archivo.
- Como el método `write()` no introduce Se usa `\n` para indicar saltos de línea.

## Escritura en Modo Append
Si queremos agregar contenido al archivo sin sobrescribirlo, usamos `FileWriter` con `true` como segundo argumento:
```java
BufferedWriter bw = new BufferedWriter(new FileWriter("archivo.txt", true));
```
Esto permite agregar nuevas líneas en lugar de reemplazar el contenido anterior.

