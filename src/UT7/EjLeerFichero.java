package UT7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class EjLeerFichero {
    static Scanner sc = new Scanner(System.in);
    static String path = "src/UT7/archivosEjemplo/archivoCorto.txt";
    public static void main(String[] args) {
        System.out.println("Ejemplos de lecturas de ficheros");
        System.out.println("Elige una opción");

    
        boolean seguir = true;
        while (seguir) {
            System.out.println(dibujarMenu());
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> leerConScanner();
                case 2 -> leerConBufferedReader();
                case 3 -> leerConBufferedReaderYAutocierre();
                case 4 -> leerArchivoConFiles();
                case 5 -> leerArchivoConStream();
                case 6 -> leerArchivoComoString();
                default -> seguir = false;
            }
        }

        sc.close();
    }

    public static String dibujarMenu(){
        String menu = "";
        menu+="1 - Scanner\n" +
        "2 - BufferedReader\n" +
        "3 - BufferedReader y try with resources\n" +
        "4 - Files\n" +
        "5 - Stream\n" + 
        "6 - Como string";

        return menu;
    }

    /**
     * Método para leer un archivo utilizando la clase Scanner.
     * La clase Scanner es útil para leer texto, ya que permite leer el archivo línea por línea.
     * 
     * Se utiliza un bloque try-catch-finally para asegurar que el Scanner se cierre correctamente
     * después de terminar la lectura, evitando posibles fugas de recursos.
     */
    public static void leerConScanner() {
        Scanner sc = null;
        try {
            System.out.println("Leemos el fichero");
            // Crea un objeto Scanner para leer el archivo "archivo.txt"
            sc = new Scanner(new File(path));
            String linea;
            // Lee el archivo línea por línea mientras haya más líneas
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error " + e.getMessage());
        } finally {
            // Asegura que el recurso Scanner se cierre correctamente
            if (sc != null)
                sc.close();
        }
        System.out.println("Lectura finalizada");
    }

    /**
     * Método para leer un archivo utilizando BufferedReader.
     * BufferedReader es una clase más eficiente que Scanner para leer archivos de texto,
     * ya que lee líneas completas en lugar de un carácter a la vez.
     * 
     * Se utiliza un bloque try-catch-finally para manejar las excepciones y cerrar el recurso BufferedReader
     * de forma segura.
     */
    public static void leerConBufferedReader() {
        FileReader fr;
        BufferedReader br = null;
        try {
            System.out.println("Leemos el fichero");
            // Crea un FileReader para abrir el archivo y un BufferedReader para leerlo de manera eficiente
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            // Lee el archivo línea por línea
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        } finally {
            // Asegura que el recurso BufferedReader se cierre correctamente
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Lectura finalizada");
    }

    /**
     * Método para leer un archivo utilizando BufferedReader con autocierre.
     * 
     * Este método utiliza el *try-with-resources*, que garantiza que el un objeto que implementa la interfaz Closeable
     * se cierre automáticamente al final del bloque try, sin necesidad de un bloque finally, deduciendo la posibilidad
     * de error que conlleva cerrar recursos manualmente.
     */
    public static void leerConBufferedReaderYAutocierre() {
        System.out.println("Leemos el fichero");

        // try-with-resources: BufferedReader se cierra automáticamente al finalizar el bloque try
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            // Lee el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Lectura finalizada");
    }

    /**
     * Método para leer un archivo y obtener todas las líneas en una lista utilizando Files.readAllLines().
     * 
     * Files.readAllLines() lee todas las líneas de un archivo y las devuelve en una lista de Strings.
     * Este enfoque es conveniente cuando el archivo no es muy grande, ya que carga todo el contenido en memoria.
     */
    public static void leerArchivoConFiles() {
        try {
            // Lee todas las líneas del archivo en una lista
            List<String> lineas = Files.readAllLines(Path.of(path));
            // Imprime cada línea
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para leer un archivo utilizando Streams de Java 8 (con Files.lines()).
     * 
     * Utiliza un Stream para leer el archivo línea por línea de forma perezosa (lazy),
     * lo que significa que las líneas se leen solo cuando es necesario. Esta es una opción eficiente
     * cuando se manejan archivos grandes, ya que no se cargan todas las líneas en memoria al mismo tiempo.
     */
    public static void leerArchivoConStream() {
        try (Stream<String> lineas = Files.lines(Path.of(path))) {
            // Imprime cada línea del archivo utilizando el Stream
            lineas.forEach(linea -> System.out.println(linea));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para leer un archivo completo como un único String utilizando Files.readString().
     * 
     * Files.readString() lee el archivo completo y lo devuelve como un solo String. 
     * Este método es adecuado para archivos pequeños, ya que carga todo el contenido del archivo en memoria.
     */
    public static void leerArchivoComoString() {
        try {
            // Lee el archivo completo como un solo String
            String contenido = Files.readString(Path.of(path));
            // Imprime el contenido completo del archivo
            System.out.println(contenido);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
