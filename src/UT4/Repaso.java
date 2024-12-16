package UT4;

import java.util.Arrays;
import java.util.Scanner;

public class Repaso {
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

    public static String dibujarMenu() {
        String menu = "";
        menu += "1 - Calculadora de matrices\n" +
                "2 - Segundo más grande\n" +
                "3 - Ordenar array\n" +
                "4 - Rotar array hacia la derecha";

        return menu;
    }

    public static void ejercicio1(){
        int n = 3;
        int[][] matrizA = {
            {32, 12, 25},
            {26, 54, 32},
            {3, 7 ,8}
        };

        int[][] matrizB = {
            {98, 32, 54},
            {15, 21, 21},
            {78, 14, 56}
        };

     // Suma de matrices
        int[][] suma = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                suma[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        System.out.println("Suma de matrices:");
        imprimirMatriz(suma);

        // Producto escalar
        System.out.print("Ingresa un escalar para multiplicar por la matriz A: ");
        int escalar = Integer.parseInt(sc.nextLine());
        int[][] productoEscalar = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                productoEscalar[i][j] = matrizA[i][j] * escalar;
            }
        }
        System.out.println("Producto escalar de la matriz A:");
        imprimirMatriz(productoEscalar);

        // Producto entre matrices
        int[][] producto = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    producto[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        System.out.println("Producto entre matrices:");
        imprimirMatriz(producto);

        // Matriz traspuesta
        int[][] traspuesta = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                traspuesta[j][i] = matrizA[i][j];
            }
        }
        System.out.println("Matriz traspuesta de A:");
        imprimirMatriz(traspuesta);
    }

    // Método para imprimir una matriz
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.println(Arrays.toString(fila));
        }
    }

    // Ejercicio 2: Segundo valor más grande
    public static void ejercicio2() {
        int[] array = {3, 5, 1, 4, 2};

        int mayor = Integer.MIN_VALUE;
        int segundoMayor = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > mayor) {
                segundoMayor = mayor;
                mayor = num;
            } else if (num > segundoMayor && num < mayor) {
                segundoMayor = num;
            }
        }

        System.out.println("El segundo valor más grande es: " + segundoMayor);
    }

    // Ejercicio 3: Ordenar un array
    public static void ejercicio3() {
        int[] array = {5, 3, 8, 6, 2};

        // Copiar el array
        int[] arrayOrdenado = new int[array.length];

        // Ordenar el array
        for (int i = 0; i < arrayOrdenado.length; i++) {
            int menor = Integer.MAX_VALUE;
            int posMenor=0;
            for (int j = 0; j < arrayOrdenado.length; j++) {
                if (array[j]<menor){
                    menor=array[j];
                    posMenor=j;
                }
            }
            arrayOrdenado[i]=menor;
            array[posMenor]=Integer.MAX_VALUE;
        }

        System.out.println("Array ordenado: " + Arrays.toString(arrayOrdenado));
    }

    // Ejercicio 4: Rotar un array hacia la derecha
    public static void ejercicio4() {
        int[] array = {1, 2, 3, 4, 5};

        // Rotar a la derecha
        int ultimo = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = ultimo;

        System.out.println("Array después de rotar: " + Arrays.toString(array));
    }
}
