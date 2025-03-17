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
    public static void main(String[] args) {

    }

    public static void leerConScanner() {
        Scanner sc = null;
        try {
            System.out.println("Leemos el fichero");
            sc = new Scanner(new File("archivo.txt"));
            String linea;
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error " + e.getMessage());
        } finally {
            if (sc != null)
                sc.close();
        }
        System.out.println("Lectura finalizada");
    }

    public static void leerConBufferedReader() {
        FileReader fr;
        BufferedReader br = null;
        try {
            System.out.println("Leemos el fichero");
            fr = new FileReader("archivo.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        System.out.println("Lectura finalizada");
    }

    public static void leerConBufferedReaderYAutocierre() {
        System.out.println("Leemos el fichero");

        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Lectura finalizada");
    }

    public static void leerArchivoConFiles() {
        try {
            List<String> lineas = Files.readAllLines(Path.of("archivo.txt"));
            lineas.forEach(System.out::println);  // Imprime cada línea
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void leerArchivoConStream() {
        try (Stream<String> lineas = Files.lines(Path.of("archivo.txt"))) {
            lineas.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void leerArchivoComoString() {
        try {
            String contenido = Files.readString(Path.of("archivo.txt"));
            System.out.println(contenido);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
