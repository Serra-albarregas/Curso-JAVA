package UT4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Act4 {
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
        menu += "1 - Suma por filas y columnas\n" +
                "2 - Buscar acabados en\n" +
                "3 - Añadir en 0\n" +
                "4 - Anterior mas siguiente";

        return menu;
    }

    /**
     * Escribe un programa que genere al azar 20 números enteros comprendidos entre
     * 0 y 9. Estos números se deben introducir en una matriz de 4 filas por 5
     * columnas. La matriz tendrá una fila y una columna mas, donde se almacenarán
     * los valores de las sumas parciales por filas y columnas. La celda de la
     * posición inferior derecha almacenará la suma total.
     */
    public static void ejercicio1() {
        int fTam = 5;
        int cTam = 6;
        int[][] matriz = new int[fTam][cTam];
        Random r = new Random();

        for (int i = 0; i < fTam - 1; i++) {
            for (int j = 0; j < cTam - 1; j++) {
                matriz[i][j] = r.nextInt(10);
            }
        }

        for (int i = 0; i < fTam - 1; i++) {
            for (int j = 0; j < cTam - 1; j++) {
                matriz[i][cTam - 1] += matriz[i][j];
                matriz[fTam - 1][j] += matriz[i][j];
                matriz[fTam - 1][cTam - 1] += matriz[i][j];
            }
        }

        pintarMatriz(matriz);
    }

    /**
     * Crea un array de números de un tamaño pasado por teclado, el array contendrá
     * números aleatorios entre 1 y 300 y mostrar aquellos números que acaben en un
     * dígito que nosotros le indiquemos por teclado (debes controlar que se
     * introduce un numero correcto), estos deben guardarse en un nuevo array.
     * 
     * Por ejemplo, en un array de 10 posiciones e indicamos mostrar los números
     * acabados en 5, podría salir 155, 25, etc.
     */
    public static void ejercicio2() {
        Random r = new Random();
        System.out.println("Introduce el tamaño del array");
        int tam = Integer.parseInt(sc.nextLine());
        int[] array = new int[tam];


        //Crear el array
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(300) + 1;
        }
        System.out.println(Arrays.toString(array));
        
        //Pedir un número en un formato adecuado
        String cString;
        char cifra;
        do {
            System.out.println("Introduce la última cifra para buscar números");
            cString = sc.nextLine();
            cifra = cString.charAt(0);
        } while (cString.length() != 1 && cifra<48 && cifra>57);

        //Buscar los números que acaban en la cifra dada
        int[] resultado = new int[tam];
        System.out.println("Números que acaban en " + cifra + ":");
        for (int i = 0; i<array.length; i++) {
            int numero = array[i];
            String nString = numero + "";
            if (nString.charAt(nString.length() - 1)==cifra) {
                resultado[i] = numero;
            }
        }

        //Mostrar por pantalla
        for (int numero : resultado) {
            if (numero!=0){
                System.out.print(numero+" ");
            }
        }
        System.out.println();
    }

    /**
     * Crea un array de 100 elementos, inicialmente vacío. El programa pedirá al
     * usuario que introduzca números por teclado. Cada nuevo número introducido
     * ocupará la posición 0 del array, obligando a todo el contenido a desplazarse
     * una posición a la derecha. Cuando el usuario introduzca el número 0, el
     * programa finalizará mostrando el contenido útil del array.
     */
    public static void ejercicio3() {
        int[] array = new int[100];
        int tam=0;
        System.out.println("Introduce un número para el array");
        int numero = Integer.parseInt(sc.nextLine());
        while(numero!=0&&tam<array.length) {
            for (int i = tam; i > 0; i--) {
                array[i]=array[i-1];
            }
            System.out.println("Introduce otro numero");
            array[0]=numero;
            tam++;
            numero = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < tam; i++) {
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }

    /**
     * Crea una array de 150 números aleatorios comprendidos entre 5 y 10. El
     * programa pedirá por teclado un número de iteraciones. En cada iteración, el
     * array almacenará en una celda el valor contenido en la celda anterior mas el
     * contenido en la celda siguiente.
     */
    public static void ejercicio4() {
        Random r = new Random();
        int tam = 5;
        int[] array = new int[tam];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(5)+5;
        }
        System.out.println(Arrays.toString(array));

        System.out.println("Introduce el numero de iteraciones");
        int it = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < it; i++) {
            int[] arrAux = new int[tam];
            arrAux[0]=array[1];
            for (int j = 1; j < tam-1; j++) {
                arrAux[j]=array[j-1]+array[j+1];
            }
            arrAux[tam-1]=array[tam-2];
            array=arrAux;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void pintarMatriz(String matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void pintarMatriz(int matriz[][]){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}