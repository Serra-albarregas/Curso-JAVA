package UT7;

import java.io.File;
import java.io.IOException;

public class EjFicheroYDirectorio {
    public static void main(String[] args) {
        pruebaCrearFichero();    // Crea un archivo si no existe
        pruebaCrearDirectorio(); // Crea un directorio si no existe
        pruebaLeerDatos();       // Lee y muestra información sobre un archivo
    }

    /**
     * Método para instanciar objetos de tipo File con rutas absolutas y relativas,
     * y realizar comprobaciones sobre si son archivos o directorios.
     * 
     * La clase `File` es utilizada para representar el sistema de archivos, 
     * ya sea un archivo o un directorio. En este caso, el método crea tres objetos `File`
     * y utiliza los métodos `isFile()` y `isDirectory()` para verificar si son archivos
     * o directorios respectivamente.
     */
    public static void pruebaInstanciarFile() {
        // Instanciación de objetos File con rutas absolutas y relativas
        File fichero1 = new File("C:/Ficheros/prueba1.txt"); // Ruta absoluta
        File fichero2 = new File("Ficheros/prueba2.txt");    // Ruta relativa de un fichero
        File fichero3 = new File("Ficheros/directorio");     // Ruta relativa de un directorio

        // Comprobación de si los objetos representados son archivos o directorios
        System.out.println(fichero1.isFile()); // Devuelve true si es un archivo
        System.out.println(fichero2.isFile()); // Devuelve true si es un archivo
        System.out.println(fichero3.isDirectory()); // Devuelve true si es un directorio
    }

    /**
     * Método para crear un archivo si no existe previamente.
     * 
     * Utiliza la clase `File` para representar el archivo y el método `createNewFile()`
     * para intentar crear el archivo en el sistema. Si el archivo ya existe, 
     * se muestra un mensaje indicando que el archivo ya está presente.
     */
    public static void pruebaCrearFichero() {
        // Instancia el objeto File que representa el archivo "fichero.txt"
        File fichero = new File("src/UT7/fichero.txt");
        
        // Verifica si el archivo ya existe, si no, lo crea
        if (!fichero.exists()) {
            try {
                // Crea el archivo si no existe
                fichero.createNewFile();
                System.out.println("Fichero creado en " + fichero.getAbsolutePath());
            } catch (IOException e) {
                // Manejo de excepciones en caso de error al crear el archivo
                e.printStackTrace();
            }
        } else {
            // El archivo ya existe
            System.out.println("El fichero ya existe");
        }
    }

    /**
     * Método para crear un directorio si no existe previamente.
     * 
     * Utiliza la clase `File` para representar el directorio y el método `mkdir()`
     * para intentar crear el directorio en el sistema. Si el directorio ya existe, 
     * se muestra un mensaje indicando que el directorio ya está presente.
     */
    public static void pruebaCrearDirectorio() {
        // Instancia el objeto File que representa el directorio "directorio"
        File fichero = new File("src/UT7/directorio");
        
        // Verifica si el directorio ya existe, si no, lo crea
        if (!fichero.exists()) {
            fichero.mkdir(); // Crea el directorio
            System.out.println("Directorio creado en " + fichero.getAbsolutePath());
        } else {
            // El directorio ya existe
            System.out.println("El directorio ya existe");
        }
    }

    /**
     * Método para leer y mostrar información de un archivo.
     * 
     * Utiliza los métodos de la clase `File` para obtener información sobre el archivo,
     * como su nombre, ruta, permisos de lectura y escritura, tamaño, etc. 
     * Este método solo muestra la información si el archivo existe.
     */
    public static void pruebaLeerDatos() {
        // Instancia el objeto File que representa el archivo "fichero.txt"
        File fichero = new File("src/UT7/fichero.txt");
        
        // Muestra la información del archivo si existe
        System.out.println("Datos del fichero");
        if (fichero.exists()) {
            System.out.println("Nombre del archivo: " + fichero.getName()); // Nombre del archivo
            System.out.println("Ruta absoluta: " + fichero.getAbsolutePath()); // Ruta completa del archivo
            System.out.println("Ruta del directorio: " + fichero.getParent()); // Ruta del directorio contenedor
            System.out.println("Ruta relativa: " + fichero.getPath()); // Ruta relativa
            System.out.println("¿Se puede leer?: " + fichero.canRead()); // Permiso de lectura
            System.out.println("¿Se puede escribir?: " + fichero.canWrite()); // Permiso de escritura
            System.out.println("Tamaño del archivo: " + fichero.length() + " bytes"); // Tamaño en bytes
        }
    }
}
