package UT7;

import java.io.File;
import java.io.IOException;

public class EjFicheroYDirectorio {
    public static void main(String[] args) {
        pruebaCrearFichero();
        pruebaCrearDirectorio();
        pruebaLeerDatos();
    }

    public static void pruebaInstanciarFile() {
        File fichero1 = new File("C:/Ficheros/prueba1.txt"); // Ruta absoluta
        File fichero2 = new File("Ficheros/prueba2.txt"); // Ruta relativa de un fichero
        File fichero3 = new File("Ficheros/directorio"); // Ruta relativa de un directorio

        System.out.println(fichero1.isFile());
        System.out.println(fichero2.isFile());
        System.out.println(fichero3.isDirectory());
    }

    public static void pruebaCrearFichero() {
        File fichero = new File("src/UT7/fichero.txt");
        if (!fichero.exists()) {
            try {
                fichero.createNewFile();
                System.out.println("Fichero creado en " + fichero.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El fichero ya existe");
        }
    }

    public static void pruebaCrearDirectorio() {
        File fichero = new File("src/UT7/directorio");
        if (!fichero.exists()) {
            fichero.mkdir();
            System.out.println("Directorio creado en " + fichero.getAbsolutePath());
        } else {
            System.out.println("El directorio ya existe");
        }
    }

    public static void pruebaLeerDatos() {
        File fichero = new File("src/UT7/fichero.txt");
        System.out.println("Datos del fichero");
        if (fichero.exists()) {
            System.out.println(fichero.getName());
            System.out.println(fichero.getAbsolutePath());
            System.out.println(fichero.getParent());
            System.out.println(fichero.getPath());
            System.out.println(fichero.canRead());
            System.out.println(fichero.canWrite());
            System.out.println(fichero.length());
        }
    }
}
