package UT3;

import java.util.Scanner;

public class Act4 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido a la ronda 3 de ejercicios de bucles");
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
                case 6 -> ejercicio6();
                case 7 -> ejercicio7();
                default -> seguir = false;
            }
        }

        sc.close();
    }

    public static String dibujarMenu() {
        String menu = "";
        menu += "1 - Comprobar multiplo\n";
        menu += "2 - Temperaturas\n";
        menu += "3 - Espacios entre letras\n";
        menu += "4 - Area y perímetro\n";
        menu += "5 - Login\n";
        menu += "6 - MCD\n";
        menu += "7 - Horas minutos y segundos\n";
        menu += "Otro - Salir";
        return menu;
    }

    public static void ejercicio1() {
        System.out.println("Introduce un numero");
        int numero = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el número para comprobar la divisibilidad");
        int divisiblePor = Integer.parseInt(sc.nextLine());

        if (esMultiplo(numero, divisiblePor)) {
            System.out.println("El número " + numero + " es divisible por " + divisiblePor);
        } else {
            System.out.println("El número " + numero + " no es divisible por " + divisiblePor);
        }
    }

    public static boolean esMultiplo(int numero, int divisiblePor) {
        return numero % divisiblePor == 0;
    }

    public static void ejercicio2() {
        System.out.println("Introduce el número de días a evaluar");
        int dias = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= dias; i++) {
            System.out.println("DIA " + i);
            System.out.println("Introduce la temperatura mínima del día " + i);
            float min = Float.parseFloat(sc.nextLine());
            System.out.println("Introduce la temperatura máxima del día " + i);
            float max = Float.parseFloat(sc.nextLine());
            System.out.println("La temperatura media del día " + i + " es " + mediaTemperaturas(max, min));
        }
    }

    public static float mediaTemperaturas(float max, float min) {
        return (max + min) / 2;
    }

    public static void ejercicio3() {
        System.out.println("Introduce una frase para espaciarla");
        String frase = sc.nextLine();
        System.out.println("La nueva frase es");
        String fraseEspaciada = convertirConEspacio(frase);
        System.out.println(fraseEspaciada + "\nTamaño de la frase: " + fraseEspaciada.length());
    }

    public static String convertirEspaciado(String frase) {
        String espaciada = "";
        for (int i = 0; i < frase.length() - 1; i++) {
            if (frase.charAt(i) != ' ')
                espaciada += frase.charAt(i) + " ";
        }
        espaciada += frase.charAt(frase.length() - 1);
        return espaciada;
    }

    public static String convertirEspacios(String frase){
    
        String resultado = "";
        for (int i = 0; i<frase.length()-1; i++){
            if(frase.charAt(i)!=' '){
                resultado = resultado + frase.charAt(i) + "_";
            }
            
        }
        if (frase.length()>0){
            resultado += frase.charAt(frase.length()-1);
        }
        
        return resultado;
    }


    public static String convertirConEspacio(String frase){

        String cadenaEspacio = "";
        for (int i = 0; i < frase.length()-1; i++){
            if(frase.charAt(i)!=' ' && frase.charAt(i)!=','){
                cadenaEspacio += frase.charAt(i) + "_";
            }  
        }
        if(frase.length()>0)
            cadenaEspacio += frase.charAt(frase.length()-1);

        return cadenaEspacio;
    }

    public static void ejercicio4() {
        System.out.println("Introduce un radio para calcular el área y el perímetro de una circunferencia");
        double radio = Float.parseFloat(sc.nextLine());
        System.out.println("El área del círculo de radio " + radio + " es " + calcularArea(radio));
        System.out.println("El perímetro de la circunferencia de radio " + radio + " es " + calcularPerimetro(radio));
    }

    public static double calcularArea(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    public static double calcularPerimetro(double radio) {
        return Math.PI * radio * 2;
    }

    public static void ejercicio5() {
        boolean loginCorrecto = false;
        for (int i = 2; i >= 0 && !loginCorrecto; i--) {
            System.out.println("Introduce el nombre de usuario");
            String usuario = sc.nextLine();
            System.out.println("Introduce la contraseña");
            String pass = sc.nextLine();
            if (comprobarPass(usuario, pass, i)) {
                loginCorrecto = true;
                System.out.println("Te has logeado correctamente");
            } else {
                System.out.println("Login incorrecto, te quedan " + i + " intentos");
            }
        }
    }

    public static boolean comprobarPass(String usuario, String pass, int intentos) {
        boolean iguales = false;
        if (intentos > 0) {
            iguales = usuario.equals("usuario1") && pass.equals("asdadas");
        }

        return iguales;
    }

    public static void ejercicio6() {
        System.out.println("Introduce el primer numero");
        int n1 = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el segundo numero");
        int n2 = Integer.parseInt(sc.nextLine());

        System.out.println("El mcd de " + n1 + " y " + n2 + " es " + calcularMCD(n1, n2));
    }

    public static int calcularMCD(int n1, int n2) {
        if (n2 > n1) {
            int aux = n2;
            n2 = n1;
            n1 = aux;
        }
        int mcd;

        int dividendo = n1;
        int divisor = n2;
        while (dividendo % divisor != 0) {
            int aux = dividendo;
            dividendo = divisor;
            divisor = aux % divisor;
        }
        mcd = divisor;

        return mcd;
    }

    public static void ejercicio7() {
        System.out.println("Que quieres hacer");
        boolean seguir = true;
        do {
            System.out.println("1 - Calcula segundos totales");
            System.out.println("2 - Calcular horas minutos y segundos");
            System.out.println("Otro - volver");
            int opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Introduce las horas");
                    int h = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce los minutos");
                    int m = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduce los segundos");
                    int s = Integer.parseInt(sc.nextLine());
                    System.out.println("Los segundos totales son " + aSegundos(h, m, s));
                    break;
                case 2:
                    System.out.println("Introdue los segundos");
                    int s2 = Integer.parseInt(sc.nextLine());
                    System.out.println("En horas, minutos y segundos " + aHMS(s2));
                    break;
                default:
                    seguir = false;
            }
        } while (seguir);
    }

    public static int aSegundos(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    public static String aHMS(int s) {
        int h = s / 3600;
        int restoH = s % 3600;
        int m = restoH / 60;
        int seg = restoH % 60;
        return h + ":" + m + ":" + seg;
    }
}