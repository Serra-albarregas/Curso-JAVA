package UT4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Act1 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Ejercicios de arrays");
        System.out.println("Elige que ejercicio quieres");

    
        boolean seguir = true;
        while (seguir) {
            System.out.println(dibujarMenu());
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                default -> seguir = false;
            }
        }

        sc.close();
    }

    public static String dibujarMenu(){
        String menu = "";
        menu+="1 - Cuadrado y cubo\n" +
        "2 - Copia inversa\n" +
        "3 - Notas\n" +
        "4 - Límite con negativo\n" +
        "5 - Suma vectores";

        return menu;
    }

    public static void ejercicio1(){
        Random rand = new Random();
        int [] vectorNumeros = new int[10];

        for (int i = 0; i< vectorNumeros.length;i++){
            vectorNumeros[i] = rand.nextInt(10)+1;
        }

        for (int numero : vectorNumeros) {
            System.out.println("Numero "+ numero + " Cuadrado " + Math.pow(numero, 2) + " Cubo " + Math.pow(numero, 3));
        }
    }

    public static void ejercicio2(){
        String [] cadenas = new String[5];

        //Inicializar con valores por teclado
        for (int i = 0; i < cadenas.length; i++) {
            cadenas[i] = sc.nextLine();
            //para probar
            //cadenas[i] = "Palabra " + i;
        }

        //Copiar
        String[] invertido = new String[5];
        for (int i = 0; i < cadenas.length; i++) {
            invertido[i] = cadenas[cadenas.length-1-i];
        }
        /*int j = cadenas.length-1;
        for (int i = 0; i < invertido.length; i++) {
            invertido[i]=cadenas[j];
            j--;
        }*/
        System.out.println(Arrays.toString(cadenas));
        System.out.println(Arrays.toString(invertido));
    }

    public static void ejercicio3(){
        float [] notas = new float[5];

        for (int i = 0; i < notas.length; i++) {
            do{
            notas[i] = Float.parseFloat(sc.nextLine());
            //para probar
            //notas[i] = i+0.5f;
            }while(notas[i]<0 || notas[i]>10);
        }

        float suma = 0;
        float max = Float.MIN_VALUE;    //Tambien vale con un 0
        float min = Float.MAX_VALUE;    //Tambien vale con un 10, porque son notas
        for (int i = 0; i < notas.length; i++) {
            suma+=notas[i];
            if (notas[i]>max){
                max=notas[i];
            }
            if (notas[i]<min){
                min=notas[i];
            }
            System.out.println("Nota : " + notas[i]);
        }
        System.out.println("Media: " + suma/notas.length + " Máxima: " + max + " Mínima: " + min);
    }

    public static void ejercicio4(){
        int []vector = new int[10];
        boolean continuar = true;
        for (int i = 0; i < vector.length && continuar; i++) {
            vector[i] = Integer.parseInt(sc.nextLine());
            if (vector[i]<0) {
                continuar=false;
            }
        }

        for (int i = 0; i < vector.length && vector[i]>=0; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(vector));
    }

    public static void ejercicio4Bis(){
        int []vector = new int[10];
        boolean continuar = true;
        int lleno = 0;
        for (int i = 0; i < vector.length && continuar; i++) {
            int nuevoNum = Integer.parseInt(sc.nextLine());
            if (nuevoNum<0) {
                continuar=false;
            }
            else {
                vector[i] = nuevoNum;
                lleno++;
            }
        }

        for (int i = 0; i < lleno; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(vector));
    }

    public static void ejercicio5(){
        int[] vector1 = new int[5];
        int[] vector2 = new int[5];
        int[] vector3 = new int[5];

        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = Integer.parseInt(sc.nextLine());
            //Para probar
            //vector1[i] = i;
        }

        for (int i = 0; i < vector2.length; i++) {
            vector2[i] = Integer.parseInt(sc.nextLine());
            //Para probar
            //vector2[i] = i;
        }

        for (int i = 0; i < vector3.length; i++) {
            vector3[i] = vector1[i] + vector2[i];
        }

        System.out.println(Arrays.toString(vector1));
        System.out.println(Arrays.toString(vector2));
        System.out.println(Arrays.toString(vector3));
    }
}
