package UT7.Ejemplos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class EjEscribirFichero {

    // Ruta del archivo donde se escribirá el contenido.
    static String path = "src/UT7/archivosEjemplo/archivoEscrito.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ejemplos de lecturas de ficheros");
        System.out.println("Elige una opción");

        boolean seguir = true;
        while (seguir) {
            System.out.println(dibujarMenu());
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> escribriConFileWriter();
                case 2 -> escribirConBufferedWriter();
                case 3 -> escribirConBufferedWriterYAutocierre();
                case 4 -> escribirConBufferdWriterAlFinal();
                case 5 -> escribirConFiles();
                case 6 -> lecturaEscrituraSimultanea();
                default -> seguir = false;
            }
        }

        sc.close();
    }

    public static String dibujarMenu() {
        String menu = "";
        menu += "1 - FileWriter\n" +
                "2 - BufferedWriter\n" +
                "3 - BufferedWriter y try with resources\n" +
                "4 - BufferedWriter y append\n" +
                "5 - Files\n" +
                "6 - Lectura-escritura simultánea";

        return menu;
    }

    /**
     * Escribe en un archivo utilizando FileWriter.
     * FileWriter permite escribir caracteres en un archivo de texto.
     * Sobrescribe el contenido del archivo si este ya existe.
     */
    public static void escribriConFileWriter() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path); // Crea un nuevo archivo o sobrescribe el existente.
            fw.write("Escrito con FileWriter\n");
            for (int i = 0; i < 10; i++) {
                fw.write("Linea " + i + "\n"); // Escribe una línea en el archivo.
            }
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close(); // Es importante cerrar el flujo para liberar recursos.
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Escribe en un archivo utilizando BufferedWriter.
     * BufferedWriter mejora la eficiencia al escribir datos en un archivo mediante
     * un buffer.
     * Sobrescribe el contenido del archivo si ya existe.
     */
    public static void escribirConBufferedWriter() {
        FileWriter fw;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(path); // Abre el archivo para escritura.
            bw = new BufferedWriter(fw); // Usa un buffer para mejorar el rendimiento.
            bw.write("Escrito con BufferdWriter\n");
            for (int i = 0; i < 10; i++) {
                bw.write("Linea " + i + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        } finally {
            if (bw != null)
                try {
                    bw.close(); // Se cierra el BufferedWriter.
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    /**
     * Escribe en un archivo utilizando BufferedWriter con autocierre
     * (try-with-resources).
     * El try-with-resources cierra automáticamente el recurso cuando termina el
     * bloque try.
     */
    public static void escribirConBufferedWriterYAutocierre() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Escrito con BufferdWriter\n");
            for (int i = 0; i < 10; i++) {
                bw.write("Linea " + i + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        }
    }

    /**
     * Escribe al final de un archivo utilizando BufferedWriter en modo append.
     * El segundo parámetro `true` en FileWriter permite agregar contenido sin
     * borrar el existente.
     */
    public static void escribirConBufferdWriterAlFinal() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write("Línea al final del archivo, sin borrarlo\n");
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        }
    }

    /**
     * Escribe en un archivo utilizando la clase Files.
     * `Files.write()` permite escribir directamente en un archivo sin necesidad de
     * `FileWriter`.
     * Se escribe una lista con todas las líneas.
     */
    public static void escribirConFiles() {
        List<String> lineas = List.of("Escrito con Files", "Linea 1", "Linea 2", "Linea 3"); // Lista de líneas a escribir.

        try {
            Files.write(Path.of(path), lineas); // Escribe la lista en el archivo.
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        }

        /**
         * Agrega contenido al final del archivo usando `Files.write()` con
         * StandardOpenOption.APPEND.
         */
        try {
            Files.write(Path.of(path), "Nueva linea al final".getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Error al escribir " + e.getMessage());
        }
    }

    /**
     * Lee un archivo, lo procesa y lo escribe en un segundo archivo.
     * Se escribe un archivo con la primera palabra de cada linea
     */
    public static void lecturaEscrituraSimultanea() {
        try (
            BufferedReader br = new BufferedReader(new FileReader("src/UT7/archivosEjemplo/archivoJava.txt"));  //En el try-with-resources declaramos tanto la lectura como la escritura
            BufferedWriter bw = new BufferedWriter(new FileWriter(path))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {           // Leemos una línea
                String[] palabras = linea.split(" ");     // Separamos sus palabras
                bw.write(palabras[0].toLowerCase() + " ");      // Escribimos la primera palabra de la línea, añadiendo un espacio detrás para formar una frase.
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
