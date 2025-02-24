package UT6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class EjemSet {
    public static void main(String[] args) {
        //pruebaHashSet();
        //pruebaLinkedHashSet();
        //pruebaTreeSet();
        operacionesConjuntos();
    }

    public static void pruebaHashSet(){
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(20);
        hashSet.add(30);
        hashSet.add(10);
        //hashSet.get(1);    No se puede obtener un elemento de un set mediante indice

        //Los elementos no se almacenan en orden
        System.out.println("Los elementos no se almacenan en orden");
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }

        //Puede comprobarse si contiene un número
        System.out.println(hashSet.contains(20)?"Contiene el 20":"No contiene el 20");

        //Los sets no permiten duplicados
        hashSet.add(20);
        System.out.println("Mostramos los elementos tras insertar otro 20");
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }

        //Para modificar un elemento en un set hay que eliminarlo y volverlo a añadir
        System.out.println("Modificamos el 20 por un 45");
        if (hashSet.contains(20)){
            hashSet.remove(20);
            hashSet.add(45);
        }
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }

        //Cuidado con las modificaciones en un foreach/iterador
        System.out.println("Modificamos el hashset mientras lo recorremos con un iterador");
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()) {
            int numero = it.next();
            if (numero==45){
                it.remove();            //Sin problema si usamos el iterador
                //hashSet.add(50);      //Excepcion
            }
        }
        for (Integer integer : hashSet) {
            System.out.println(integer);
        }
    }

    public static void pruebaLinkedHashSet(){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(20);
        linkedHashSet.add(30);
        linkedHashSet.add(10);
        //linkedHashSet.get(1);    //No se puede obtener un elemento de un set mediante indice

        //Los elementos se almacenan en orden
        System.out.println("Los elementos se almacenan en orden de llegada");
        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }

        //Como es un set, no admite duplicados
        System.out.println("Insertamos un elemento duplicado");
        linkedHashSet.add(20);
        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }

        //Si eliminamos y añadimos para modificar, el nuevo elemento será el último en el recorrido
        System.out.println("Modificamos el 20 por un 45");
        if (linkedHashSet.contains(20)){
            linkedHashSet.remove(20);
            linkedHashSet.add(45);
        }
        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }
    }

    public static void pruebaTreeSet(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(10);

        //Los elementos se almacenan en el orden indicado por el comparador
        System.out.println("Los elementos se almacenan en orden ascendente");
        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }

    public static void operacionesConjuntos(){
        HashSet<String> hFrutas = new HashSet<>();
        TreeSet<String> tVerduras = new TreeSet<>();

        hFrutas.add("Manzana");
        hFrutas.add("Cereza");
        hFrutas.add("Kiwi");
        hFrutas.add("Tomate");

        tVerduras.add("Zanahoria");
        tVerduras.add("Coliflor");
        tVerduras.add("Tomate");

        //Operación union de conjuntos
        System.out.println("Operación union de conjuntos");
        HashSet<String> frutasClon = new HashSet<>(hFrutas);
        frutasClon.addAll(tVerduras);
        for (String string : frutasClon) {
            System.out.println(string);
        }

        //Operación intersección de conjuntos
        System.out.println("\nOperación intersección de conjuntos");
        frutasClon = new HashSet<>(hFrutas);
        frutasClon.retainAll(tVerduras);
        for (String string : frutasClon) {
            System.out.println(string);
        }

        //Operación diferencia de conjuntos
        System.out.println("\nOperación diferencia de conjuntos");
        frutasClon = new HashSet<>(hFrutas);
        frutasClon.removeAll(tVerduras);
        for (String string : frutasClon) {
            System.out.println(string);
        }
    }
}
