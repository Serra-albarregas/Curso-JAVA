package UT6.Actividad4;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class EjerciciosColecciones {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean funcionando = true;
        do {
            System.out.println("Elige un ejercicio");
            System.out.println("1-EJ 1");
            System.out.println("etc");
            int opcion = pedirNumero(1, 11);

            switch (opcion) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                case 8 -> ejercicio8();
                case 9 -> ejercicio9();
                default -> funcionando = false;
            }
        } while (funcionando);
        sc.close();
    }

    private static void ejercicio1() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }

        System.out.println(lista.toString());

        /**for (Integer integer : lista) {
            if (integer%2==0){
                lista.remove(integer);
            }
        }*/

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i)%2==0){
                lista.remove(i);
            }
        }

        System.out.println(lista);
    }

    private static void ejercicio2() {
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(i);
        }
        System.out.println(lista);

        while (lista.size()>1) {
            lista.set(lista.size()-2, lista.get(lista.size()-2)+lista.remove(lista.size()-1));
            System.out.println(lista);
        }
    }

    private static void ejercicio3() {
        ArrayList<Integer> lista = new ArrayList<>();
        Random r = new Random();

        while (lista.size()<10){
            int numero;
            do {
                numero = r.nextInt(10)+1;
            } while (lista.contains(numero));
            lista.add(numero);
        }
        System.out.println(lista);
    }

    private static void ejercicio3v2() {
        LinkedHashSet<Integer> conjunto = new LinkedHashSet<>();
        Random r = new Random();

        while (conjunto.size()<10){
            int numero;
            do {
                numero = r.nextInt(10)+1;
            } while (conjunto.contains(numero));
            conjunto.add(numero);
        }
        System.out.println(conjunto);
    }

    private static void ejercicio3v3() {
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> numerosPosibles = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            numerosPosibles.add(i);
        }

        while (lista.size()<10) {
            int indice = r.nextInt(numerosPosibles.size());
            lista.add(numerosPosibles.get(indice));
            numerosPosibles.remove(indice);
        }
        System.out.println(lista);
    }

    private static void ejercicio4() {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Laura");
        nombres.add("Luis");
        nombres.add("Sofía");
        nombres.add("Javier");
        nombres.add("Elena");
        nombres.add("Diego");
        nombres.add("Paula");
        nombres.add("Alejandro");
        nombres.add("Lucía");
        nombres.add("Miguel");
        nombres.add("Carmen");
        nombres.add("Pablo");
        nombres.add("Rosa");
        nombres.add("Roberto");
        nombres.add("Isabel");
        nombres.add("Daniel");
        nombres.add("Teresa");
        nombres.add("Jorge");
        nombres.add("Beatriz");
        nombres.add("Fernando");
        nombres.add("Raquel");
        nombres.add("José");
        nombres.add("Patricia");
        nombres.add("David");
        nombres.add("Eva");

        ArrayList<ArrayList<String>> grupos = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 6; i++) {
            grupos.add(new ArrayList<String>());
            for (int j = 0; j < 5; j++) {
                int indice = r.nextInt(nombres.size());
                grupos.get(i).add(nombres.get(indice));
                nombres.remove(indice);
            }
        }
        for (ArrayList<String> grupo : grupos) {
            System.out.println(grupo);
        }
    }

    private static void ejercicio5() {
        HashSet<String> conjunto = new HashSet<>();
        String leido = "";
        do{
            leido = pedirString().toLowerCase();
            if (conjunto.contains(leido)){
                System.out.println("La palabra "+ leido+" ya ha sido leída");
            }
            else{
                conjunto.add(leido);
            }
        }while(!leido.equals("fin"));
    }

    private static void ejercicio6() {
        ArrayList<Integer> bombo = new ArrayList<>();
        ArrayList<TreeSet<Integer>> cartones = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            bombo.add(i);
        }
        for (int i = 0; i < 5; i++) {
            cartones.add(new TreeSet<>());
            for (int j = 0; j < 15; j++) {
                int numero;
                do {
                    numero=r.nextInt(100);
                } while (cartones.get(i).contains(numero));
                cartones.get(i).add(numero);
            }
        }
        for (int i = 0; i < cartones.size(); i++) {
            System.out.println("Carton del jugador "+i+": " + cartones.get(i));
        }

        boolean bingo = false;
        while (!bingo && !bombo.isEmpty()) {
            int indiceBombo = r.nextInt(bombo.size());
            int bola = bombo.get(indiceBombo);
            bombo.remove(indiceBombo);
            System.out.println("Sale la bola " + bola);
            for (int i = 0; i < cartones.size(); i++) {
                if (cartones.get(i).contains(bola)){
                    cartones.get(i).remove(bola);
                    System.out.println("El jugador " + i + " ha tachado el numero " + bola);
                    if (cartones.get(i).isEmpty()){
                        bingo=true;
                        System.out.println("El jugardor " + i + " ha cantado bingo");
                    }
                }
            }
        }

        for (int i = 0; i < cartones.size(); i++) {
            System.out.println("Carton del jugador "+i+": " + cartones.get(i));
        }
    }

    private static void ejercicio7() {
        String frase = pedirString();
        frase=frase.replace(",", "").replace(".", "");
        String[] palabras = frase.split("[ ]+");
        HashMap<String, Integer> conteo = new HashMap<>();
        for (int i = 0; i < palabras.length; i++) {
            if (conteo.containsKey(palabras[i])){
                conteo.put(palabras[i], conteo.get(palabras[i])+1);
            }
            else{
                conteo.put(palabras[i], 1);
            }
        }
        for (Entry<String,Integer> entry: conteo.entrySet()) {
            System.out.println("Palabra: " + entry.getKey() + " | Veces: " + entry.getValue());
        }
    }


    private static void ejercicio8() {
        List<Integer> numeros = List.of(1,5,4,5,1,5,6,1,2,3,1,5,1);
        System.out.println("La suma de los no repetidos es: " + sumarNoRepetidos(numeros));
    }

    public static int sumarNoRepetidos(List<Integer> numeros){
        HashMap<Integer, Integer> conteo = new HashMap<>();
        for (Integer integer : numeros) {
            if (conteo.containsKey(integer)){
                conteo.put(integer,conteo.get(integer)+1);
            }else{
                conteo.put(integer, 1);
            }
        }

        int suma = 0;
        for (Entry<Integer,Integer> entry: conteo.entrySet()) {
            if(entry.getValue()==1){
                suma+=entry.getKey();
            }
        }

        return suma;
    }

    private static void ejercicio9() {
        HashMap<String, Integer> traduccion = new HashMap<>();
        traduccion.put("I", 1);
        traduccion.put("V", 5);
        traduccion.put("X", 10);
        traduccion.put("L", 50);
        traduccion.put("C", 100);
        traduccion.put("D", 500);
        traduccion.put("M", 1000);

        String romano="";
        boolean correcto=false;
        do {
            romano = pedirString().toUpperCase();
            correcto = romano.matches("[IVXLCDM]*");
            if (!correcto) System.out.println("El formato del número romano es incorrecto, intentalo de nuevo");
        } while (!correcto);
        
        ArrayList<String> bloques = new ArrayList<>();
        String bloque="";
        for (int i = 0; i < romano.length(); i++) {
            if (bloque.equals("")){
                bloque+=romano.charAt(i);
            }else if(traduccion.get(String.valueOf(romano.charAt(i)))>traduccion.get(String.valueOf(bloque.charAt(bloque.length()-1)))){
                bloque+=romano.charAt(i);
            }
            else{
                bloques.add(bloque);
                bloque=String.valueOf(romano.charAt(i));
            }
        }
        bloques.add(bloque);
        bloque="";
        System.out.println(bloques);

        int suma=0;
        for (String string : bloques) {
            int resta = traduccion.get(String.valueOf(string.charAt(string.length()-1)));
            for (int i = string.length()-2; i>=0; i--) {
                resta-=traduccion.get(String.valueOf(string.charAt(i)));
            }
            suma+=resta;
        }
        System.out.println("Conversión del numero: " + romano + ": " + suma);
    }

    private static String pedirString() {
        String string = "";
        while (string == "") {
            string = sc.nextLine();
        }
        return string;
    }

    private static int pedirNumero(int min, int max) {
        boolean lecturaCorrecta = false;
        int numero = 0;
        while (!lecturaCorrecta) {
            String numString = sc.nextLine();
            try {
                numero = Integer.parseInt(numString);
                if (numero >= min && numero < max) {
                    lecturaCorrecta = true;
                } else {
                    System.out.println("El número debe estar entre " + min + " y " + max + ", intentalo de nuevo");
                }
            } catch (Exception e) {
                System.out.println("Formato numérico incorrecto. Intentalo de nuevo.");
            }
        }
        return numero;
    }
}
