package UT3;

import java.util.Random;
import java.util.Scanner;

public class Act3 {

    public static void main(String[] args) {
        System.out.println("Bienvenido a la ronda 3 de ejercicios de bucles");
        System.out.println("Elige que ejercicio quieres");

        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        while (seguir) {
            switch (sc.nextInt()) {
                case 1 -> ejercicio1();
                case 2 -> ejercicio2();
                case 3 -> ejercicio3();
                case 4 -> ejercicio4();
                case 5 -> ejercicio5();
                default -> seguir = false;
            }
        }
    }

    public static void ejercicio1() {
        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    System.out.println(h + ":" + m + ":" + s);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void ejercicio2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame base y exponente");
        int base = sc.nextInt();
        int exponente = sc.nextInt();
        int potencia = 1;
        for (int i = 0; i < exponente; i++) {
            potencia *= base;
        }
        System.out.println("La potencia es " + potencia);
    }

    public static void ejercicio3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame una frase");
        String frase = sc.nextLine();

        for (int i = 0; i < frase.length(); i++) {
            System.out.println(frase.charAt(i));
        }
    }

    public static void ejercicio4() {
        Scanner sc = new Scanner(System.in);
        int inferior;
        int superior;
        do {
            System.out.println("Dame limite superior e inferior");
            inferior = sc.nextInt();
            superior = sc.nextInt();
        } while (inferior > superior);

        boolean seguimos = true;
        int sumaDentro = 0;
        int contadorFuera = 0;
        boolean enIntervalo = false;
        while (seguimos) {
            int numero = sc.nextInt();
            if (numero == 0) {
                seguimos = false;
            } else {
                if (numero > inferior && numero < superior) {
                    sumaDentro += numero;
                } else if (numero < inferior || numero > superior) {
                    contadorFuera++;
                } else {
                    enIntervalo = true;
                }
            }
        }
        System.out.println("Suma de los numeros en el intervalo " + sumaDentro);
        System.out.println("Cuantos numeros fuera del intervalo " + contadorFuera);
        if (enIntervalo) {
            System.out.println("Se ha introducido un numero que coincide con el intervalo");
        }
    }

    public static void ejercicio5() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int clave = random.nextInt(101);
        boolean seguimos = true;
        int intentos = 9;
        while (seguimos && intentos >= 0) {
            int adivina = sc.nextInt();
            if (adivina == clave) {
                System.out.println("Acertaste");
                seguimos = false;
            } else {
                if (adivina < clave) {
                    System.out.println("La clave es mayor");
                } else {
                    System.out.println("La clave es menor");
                }
                System.out.println("Te quedan " + intentos + " intentos");
            }
            intentos--;
        }
        if (intentos == 0)
            System.out.println("La clave es " + clave);
    }
}