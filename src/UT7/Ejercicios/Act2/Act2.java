package UT7.Ejercicios.Act2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class Act2 {
    static String path = "src/UT7/archivosEjemplo/archivoCorto.txt";
    public static void main(String[] args) {
        ejercicio1();
        ejercicio2();
        ejercicio3();
    }

    public static void ejercicio1(){
        int caracteres = 0;
        int digitos = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linea;
            while ((linea = br.readLine())!=null) {
                System.out.println(linea);
                for (int i = 0; i < linea.length(); i++) {
                    Character character = linea.charAt(i);
                    if (Character.isDigit(character)){
                        digitos++;
                    } else if (Character.isLetter(character)){
                        caracteres++;
                    }
                }
            }
            System.out.println("Numero de dígitos:\t" + digitos);
            System.out.println("Numero de caracteres:\t" + caracteres);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ejercicio2(){
        int vocales = 0;
        int consonantes = 0;
        HashSet<Character> setVocales = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String linea;
            while ((linea = br.readLine())!=null) {
                for (int i = 0; i < linea.length(); i++) {
                    Character character = linea.charAt(i);
                    if (setVocales.contains(character)){
                        vocales++;
                    } else if (Character.isLetter(character)){
                        consonantes++;
                    }
                }
            }
            System.out.println("Numero de consonantes:\t" + consonantes);
            System.out.println("Numero de vocales:\t" + vocales);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ejercicio3(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/UT7/Ejercicios/Act2/Restaurants.csv"))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (palabras[4].startsWith("6")){
                    System.out.println(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
