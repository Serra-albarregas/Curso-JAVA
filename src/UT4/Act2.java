package UT4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Act2 {
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
        menu+="1 - Nombres y edades\n" +
        "2 - Temperaturas\n" +
        "3 - Sumar filas y columnas\n" +
        "4 - Diagonal\n" +
        "5 - Marco";

        return menu;
    }

    public static void ejercicio1(){
        int tam = 50;
        String nombres[] = new String[tam];
        int edades[] = new int[tam];

        boolean continuar = true;
        for (int i = 0; i < tam && continuar; i++) {
            nombres[i] = sc.nextLine();
            if (!nombres[i].equals("*")){
                
                edades[i]=Integer.parseInt(sc.nextLine());
            }
            else {
                continuar=false;
            }
        }

        System.out.println("Los mayores de edad");
        int maxEdad = 0;
        for (int i = 0; i < tam && !nombres[i].equals("*"); i++) {
            if (edades[i]>=18) {
                System.out.println(nombres[i]);
            }
            if (edades[i]>maxEdad){
                maxEdad=edades[i];
            }
        }
        System.out.println("Los más grandes");
        for (int i = 0; i < tam && !nombres[i].equals("*"); i++) {
            if (edades[i]==maxEdad){
                System.out.println(nombres[i]);
            }
        }
    }

    public static void ejercicio2(){
        int tam = 5;
        int[] minimas = new int[tam];
        int[] maximas = new int[tam];
        Random r = new Random();

        for (int i = 0; i < tam; i++) {
            minimas[i] = r.nextInt(10);
            maximas[i] = r.nextInt(20)+10;
        }

        System.out.println(Arrays.toString(minimas));
        System.out.println(Arrays.toString(maximas));
        System.out.println("Elige:");
        System.out.println("1 - Media diaria");
        System.out.println("2 - Días más fríos");
        System.out.println("3 - Buscar máxima");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                for (int i = 0; i < tam; i++) {
                    System.out.println("Media del dia " + i + ": " + ((minimas[i]+maximas[i])/2));
                }
                break;
            case 2:
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < tam; i++) {
                    if (minimas[i]<min) {
                        min=minimas[i];
                    }
                }
                for (int i = 0; i < tam; i++) {
                    if (minimas[i]==min) {
                        System.out.println("Día frio: " + i + " - " + minimas[i] + " grados");
                    }
                }
                break;
            case 3:
                System.out.println("Leemos");
                int maxLeer = Integer.parseInt(sc.nextLine());
                for (int i = 0; i < tam; i++) {
                    if (maximas[i]==maxLeer){
                        System.out.println("Coincide el día: " + i + " - " + maximas[i] + " grados");
                    }
                }
            default:
                break;
        }
    }

    public static void ejercicio3(){
        Random r = new Random();
        int tam = 5;
        int [][] matriz = new int[tam][tam];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = r.nextInt(10);
            }
        }
        System.out.println(Arrays.deepToString(matriz));

        int[] sumaFila=new int[tam];
        int[] sumaCol=new int[tam];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila[i]+=matriz[i][j];
                sumaCol[j]+=matriz[i][j];
            }
        }
        System.out.println(Arrays.toString(sumaFila));
        System.out.println(Arrays.toString(sumaCol));
    }

    public static void ejercicio4(){
        int[][] diagonal = new int[5][5];
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal[i].length; j++) {
                if (i==j){
                    diagonal[i][j]=1;
                }
                else{
                    diagonal[i][j]=0;
                }
            }
        }

        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal[i].length; j++) {
                System.out.print(diagonal[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ejercicio5(){
        int[][] marco = new int[5][15];
        for (int i = 0; i < marco.length; i++) {
            for (int j = 0; j < marco[i].length; j++) {
                if (i==0 || i==marco.length-1 || j==0 || j==marco[i].length-1){
                    marco[i][j]=1;
                }
                else{
                    marco[i][j]=0;
                }
            }
        }

        for (int i = 0; i < marco.length; i++) {
            for (int j = 0; j < marco[i].length; j++) {
                System.out.print(marco[i][j] + " ");
            }
            System.out.println();
        }
    }
}