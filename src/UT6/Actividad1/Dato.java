package UT6.Actividad1;

import java.util.HashSet;
import java.util.TreeSet;

public class Dato {
    int numero;
    String palabra;

    public Dato(int numero, String palabra) {
        this.numero = numero;
        this.palabra = palabra;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPalabra() {
        return this.palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", palabra='" + getPalabra() + "'" +
            "}";
    }
    

    public static void main(String[] args) {
        TreeSet<Dato> tree = new TreeSet<>();
        tree.add(new Dato(0, "a"));
        tree.add(new Dato(0, "a"));
        tree.add(new Dato(1, "b"));
        tree.add(new Dato(2, "c"));

        for (Dato dato : tree) {
            System.out.println(dato);
        }

        HashSet<Dato> set = new HashSet<>();
        set.add(new Dato(0, "a"));
        set.add(new Dato(0, "a"));
        set.add(new Dato(1, "b"));
        set.add(new Dato(2, "c"));

        for (Dato dato : set) {
            System.out.println(dato.toString());
        }
    }
}
