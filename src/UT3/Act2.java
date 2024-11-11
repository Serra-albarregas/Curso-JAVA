package UT3;

import java.util.Scanner;
import java.util.Random;

public class Act2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean funcionando = true;
        do {
            System.out.println("Elige un ejercicio");
            System.out.println("1-EJ 1");
            System.out.println("etc");
            int opcion = sc.nextInt();

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
                case 10 -> ejercicio10();
                default -> funcionando = false;
            }
        } while (funcionando);

    }

    public static void ejercicio1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Este es el ejercicio 1, intruduce numeros y te doy el cuadrado");
        boolean seguimos = true;
        while (seguimos) {
            int numero = sc.nextInt();
            if (numero < 0) {
                seguimos = false;
            } else {
                System.out.println("El cuadrado del " + numero + " es " + Math.pow(numero, 2));
            }
        }
    }

    public static void ejercicio2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Este es el ejercicio 2, intruduce numeros y te doy la media");
        boolean seguimos = true;
        int contador = 0;
        int suma = 0;
        while (seguimos) {
            int numero = sc.nextInt();
            if (numero < 0) {
                seguimos = false;
            } else {
                contador++;
                suma += numero;
            }
        }
        System.out.println("La media es " + suma / contador);
    }

    public static void ejercicio3() {
        for (int i = 100; i > 0; i -= 7) {
            System.out.println(i);
        }
    }

    public static void ejercicio4() {
        int producto = 1;
        for (int i = 1; i < 20; i += 2) {
            producto *= i;
        }
        System.out.println("El producto de los impares es " + producto);
    }

    public static void ejercicio5() {
        Scanner sc = new Scanner(System.in);
        int sumaPos = 0;
        int contPos = 0;
        int sumaNeg = 0;
        int contNeg = 0;
        int contCero = 0;
        for (int i = 0; i < 10; i++) {
            int numero = sc.nextInt();
            if (numero < 0) {
                sumaNeg += numero;
                contNeg++;
            } else if (numero > 0) {
                sumaPos += numero;
                contPos++;
            } else {
                contCero++;
            }
        }
        if (contPos > 0)
            System.out.println(sumaPos / contPos);
        if (contNeg > 0)
            System.out.println(sumaNeg / contNeg);
        System.out.println(contCero);
    }

    public static void ejercicio6() {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
        while (numero < 0 || numero > 10) {
            System.out.println("El numero no es válido, introduce otro");
            numero = sc.nextInt();
        }

        for (int i = 0; i <= 10; i++) {
            System.out.println(numero * i);
        }
    }

    public static void ejercicio7() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sueldoMayor = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sueldo = sc.nextInt();
            if (sueldo > sueldoMayor) {
                sueldoMayor = sueldo;
            }
        }
        System.out.println(sueldoMayor);
    }

    public static void ejercicio8() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int clave = random.nextInt(9999) + 1;
        boolean seguimos = true;
        while (seguimos) {
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
            }
        }
    }

    public static void ejercicio9() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean primo = true;
        if (n<2){
            primo = false;
        }
        for (int i = 2; i < n / 2 && primo; i++) {
            if (n % i == 0) {
                primo = false;
            }
        }
        if (primo) {
            System.out.println("El numero " + n + " es primo");
        } else {
            System.out.println("El numero " + n + " no es primo");
        }
    }

    public static void ejercicio10() {
        Scanner sc = new Scanner(System.in);
        int clave = 4567;
        boolean abierto = false;
        for (int i = 3; i >= 0 && !abierto; i--) {
            int n = sc.nextInt();
            if (n == clave) {
                System.out.println("Has abierto la caja fuerte");
                abierto = true;
            } else {

                if (i == 0) {
                    System.out.println("La caja queda cerrada");
                } else {
                    System.out.println("Has fallado, te quedan " + i + " intentos, introduce otra");
                }
            }
        }
    }
}