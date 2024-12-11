package UT4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Act3 {
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
                default -> seguir = false;
            }
        }

        sc.close();
    }

    public static String dibujarMenu(){
        String menu = "";
        menu+="1 - Aleatorios sin repetir\n" +
        "2 - Kilometros\n" +
        "3 - Sucursales y productos\n" +
        "4 - Quiniela";

        return menu;
    }

    public static void ejercicio1(){
        Random r = new Random();
        int [] aleatorios = new int[10];
        int aleatorio;
        for (int i = 0; i < aleatorios.length; i++) {
            do {
                aleatorio = r.nextInt(10);
            } while (contiene(aleatorios, aleatorio, i));
            aleatorios[i]=aleatorio;
        }
        System.out.println(Arrays.toString(aleatorios));
    }

    public static boolean contiene(int[] array, int buscar, int hasta){
        boolean encontrado = false;
        for (int i = 0; i < hasta && !encontrado; i++) {
            if(array[i]==buscar){
                encontrado=true;
            }
        }
        return encontrado;
    }

    public static void ejercicio2(){
        Random r = new Random();
        String [] nombres = {"Juan" , "Marta", "Pedro", "Luisa", "Marcelo"};
        int[][] kms = new int[nombres.length][7];
        int [] totalKms = new int[nombres.length];

        for (int i = 0; i < kms.length; i++) {
            for (int j = 0; j < kms[i].length; j++) {
                kms[i][j]=r.nextInt(50);
            }
        }

        for (int i = 0; i < kms.length; i++) {
            for (int j = 0; j < kms[i].length; j++) {
                totalKms[i]+=kms[i][j];
            }
        }

        for (int i = 0; i < totalKms.length; i++) {
            System.out.println("El conductor " + nombres[i] + " ha hecho " + totalKms[i] + " kms");
        }

        for (int i = 0; i < kms.length; i++) {
            System.out.print(nombres[i] + ": ");
            for (int j = 0; j < kms[i].length; j++) {
                System.out.print(kms[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ejercicio3(){
        int [] precios = {5, 7, 9, 3, 2};
        int [][] articulos = {
            {5, 10, 8, 4, 3},
            {8,  3, 5, 7, 4},
            {9,  5, 3, 6, 9},
            {12, 9, 3, 2, 4}};

        //Cantidades totales
        for (int i = 0; i < articulos[0].length; i++) {
            int totalProductos=0;
            for (int j = 0; j < articulos.length; j++) {
                totalProductos+=articulos[j][i];
            }
            System.out.println("Cantidad del producto " + i + ": " + totalProductos + " unidades");
        }

        //Total de artículos en la sucursal 2
        int totalS2 = 0;
        for (int i = 0; i < articulos[2].length; i++) {
            totalS2+=articulos[2][i];
        }
        System.out.println("Cantidad de productos en la sucursal 2: " + totalS2 + " unidades");

        //Cantidad del artículo 3 en la sucursal 1
        System.out.println("En la sucursal 1 hay " + articulos[1][3] + " unidades del artículo 3");

        //Recaudación por sucursal
        int[] recaudacion = new int[4];
        for (int i = 0; i < articulos.length; i++) {
            for (int j = 0; j < articulos[i].length; j++) {
                recaudacion[i]+=articulos[i][j]*precios[j];
            }
            System.out.println("La recaudación de la sucursal " + i + " es de " + recaudacion[i] + " euros");
        }

        //Recaudación total
        int recaudacionTotal=0;
        for (int i = 0; i < recaudacion.length; i++) {
            recaudacionTotal+=recaudacion[i];
        }
        System.out.println("La recaudación total de la empresa es: " + recaudacionTotal);

        //Sucursal con mayor recaudación
        int mayor = 0;
        int sucurMayor = 0;
        for (int i = 0; i < recaudacion.length; i++) {
            if (recaudacion[i]>mayor){
                mayor=recaudacion[i];
                sucurMayor=i;
            }
        }
        System.out.println("La sucursal con mayor recaudacion es la " + sucurMayor);
    }

    public static void ejercicio4(){
        String[][] partidos = {
            {"Raimon", "Royal Academy"},
            {"Inazuma Japón", "Fire Dragon"},
            {"Zeus", "Genesis"},
            {"Dark Emperors", "Raimon"},
            {"Unicorn", "Orpheus"},
            {"Big Waves", "Shamshir"},
            {"Kirkwood", "Royal Academy"},
            {"Raimon", "Inazuma Japón"},
            {"Chaos", "Genesis"},
            {"Raimon", "Zeus"},
            {"Fire Dragon", "The Empire"},
            {"Royal Academy", "Zeus"},
            {"Genesis", "Raimon"},
            {"Dark Emperors", "Unicorn"},
            {"Inazuma Japón", "Orpheus"}
        };

        // Array de goles
        int[][] goles = {
            {3, 2},
            {4, 3},
            {2, 5},
            {1, 3},
            {2, 2},
            {1, 4},
            {3, 1},
            {2, 2},
            {5, 3},
            {4, 2},
            {1, 3},
            {0, 5},
            {3, 4},
            {1, 1},
            {3, 2}
        };

        for (int i = 0; i < goles.length; i++) {
            String resultado="";
            if (goles[i][0]>goles[i][1]){
                resultado="1";
            }
            else if (goles[i][0]<goles[i][1]){
                resultado="2";
            }
            else {
                resultado="x";
            }
            System.out.println(partidos[i][0] + " - " + partidos[i][1] + puntitos(partidos[i][0].length()+partidos[i][1].length()) + resultado);
        }
    }

    public static String puntitos(int tam){
        String puntitos = "";
        int size = 30-tam;
        for (int i = 0; i < size; i++) {
            puntitos+=".";
        }
        return puntitos;
    }
}
