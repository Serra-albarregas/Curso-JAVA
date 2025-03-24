package UT7.Ejercicios;

import java.io.File;
import java.io.IOException;
//import java.util.Scanner;

public class Act1 {
    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
    }

    /**
     * Método que verifica la existencia de un archivo o directorio en la ruta especificada.
     * Si el archivo no existe y tiene extensión .txt, se crea un nuevo archivo.
     * Si no tiene esa extensión, se crea un directorio.
     * Si el archivo o directorio ya existe, se elimina.
     */
    public static void ejercicio1(){
        String path = "src/UT7/archivosEjemplo/act1Ej1.txt"; // Ruta del archivo o directorio
        File file = new File(path);
        
        if (!file.exists()){ // Si el archivo/directorio no existe
            if (path.endsWith(".txt")){ // Si la ruta termina en .txt, se crea un archivo
                try {
                    file.createNewFile(); // Crea el archivo
                } catch (IOException e) {
                    e.printStackTrace(); // Muestra un error si no se puede crear el archivo
                }
            } else {
                file.mkdir(); // Si no es un archivo .txt, se crea un directorio
            }
        } else {
            file.delete(); // Si el archivo/directorio ya existe, se elimina
        }
    }

    /**
     * Método que solicita la ruta de un directorio y muestra información de los archivos dentro de él.
     * Por cada archivo en el directorio, muestra su nombre, tamaño y permisos de lectura y escritura.
     */
    public static void ejercicio2(){
        // Scanner sc = new Scanner(System.in); // Entrada de usuario (comentado para pruebas automáticas)
        System.out.println("Introduce la ruta de un archivo");
        // String path = sc.nextLine(); // Obtiene la ruta del usuario (comentado)
        String path = "src/UT7/archivosEjemplo"; // Ruta predefinida para pruebas
        
        File directory = new File(path);
        
        if (directory.exists() && directory.isDirectory()) { // Verifica si la ruta es un directorio válido
            for (File file : directory.listFiles()) { // Itera sobre los archivos en el directorio
                System.out.println(file.getName() + " -> Tamaño: " + file.length() + 
                                   ", Permisos: " + ((file.canRead()) ? "R" : "") + 
                                                 ((file.canWrite()) ? "W" : "")); // Muestra información del archivo
            }
        }
    }
}
