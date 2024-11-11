package UT3;

import java.util.Scanner;

public class Simulacro {

    public static void main(String args[]){
        ejercicio2();
        ejercicio3();
    }

    public static void ejercicio2(){
        Scanner sc = new Scanner(System.in);                    //Creamos un scanner para poder leer por teclado
        String frase = sc.nextLine();                           //Leemos un string

        for(int i = 1; i< frase.length(); i+=2){                //Recorremos desde la posición 1 para obtener el primer numero impar, luego incrementamos de 2 en 2 para los siguientes
            if (frase.charAt(i)=='o'){                          //Comprobamos si el char de la iteración es igual a una o. Doble igual, pues no es un String
                System.out.print('0');                        //Pintamos un 0, usamos print en lugar de println para no añadir un intro
            }
            else{                                               //Si la condición anterior (encontrar una o) no se cumple
                System.out.print(frase.charAt(i));              //Pintamos el caracter tal como llega
            }
        }
        System.out.println();                                   //Pintammos un intro, pues no lo hicimos anteriormente
        //sc.close();                                           //Cerramos el scanner. Lo dejo comentado para que el código pueda ejecutar
    }

    public static void ejercicio3(){
        Scanner sc = new Scanner(System.in);                    //Creamos un scanner para poder leer por teclado
        int n = sc.nextInt();                                   //Leemos el número n que nos dirá cuantos numero de la serie de fibonacci mostraremos

        int anterior = 1;                                       //Para la serie, necesitamos variables que almacenen los 2 números anteriores al actual
        int anteAnterior = 1;                                   //Como podemos suponer que n va a ser mayor que 2, ambos pueden comenzar con los primeros dos números de la serie, ambos 1
        int acumulador = 2;                                     //Por el mismo motivo, el acumulador puede comenzar en 2 (suma de los dos anteriores). Luego ira acumulando todos los números de la serie
        System.out.print(anterior + " " + anteAnterior);        //Mostramos los dos primeros números de la serie
        for (int i = 2; i < n; i++) {                           //Entramos en un bucle que comienza en 2, pues ya tenemos dos numeros de la serie, y acaba en n-1 para tener n valores
            int fibonacci = anterior + anteAnterior;            //Calculamos el número correspondiente a la iteración i de la serie de fibonacci, sumando los dos anteriores
            System.out.print(" " + fibonacci);                  //Mostramos el número por pantalla, sin añadir un intro para que toda la serie quede en la misma linea
            anteAnterior = anterior;                            //Cambiamos las variables. Empezamos con anteAnterior, pues no necesitamos su contenido
            anterior = fibonacci;                               //Luego actualizamos anterior. Si lo hubiesemos hecho alrevés, a anteAnterior le habría llegado un valor incorrecto
            acumulador += fibonacci;                            //Actualizamos el acumulador
        }
        System.out.println("\nEl sumatorio de la serie de fibonacci con " + n + " elementos es " + acumulador);

        //sc.close();
    }
}