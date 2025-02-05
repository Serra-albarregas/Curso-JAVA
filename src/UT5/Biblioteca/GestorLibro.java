package UT5.Biblioteca;

import java.util.Arrays;

public class GestorLibro {
    private Libro[] libros;
    private int lleno;
    private int tam;

    public GestorLibro(int tam){
        this.tam = tam;
        libros = new Libro[tam];
        lleno = 0;
    }

    public boolean addLibro(Libro l){
        if (l != null && lleno<tam){
            libros[lleno] = l;
            lleno++;
            return true;
        }
        else{
            return false;
        }
    }

    public int buscarIndiceLibro(String titulo){
        int buscar = -1;
        for (int i = 0; i < lleno && buscar == -1; i++) {
            if (libros[i].getTitulo().toLowerCase().equals(titulo.toLowerCase())) {
                buscar = i;
            }
        }
        return buscar;
    }

    public int buscarIndiceLibroPorISBN(String ISBN){
        int buscar = -1;
        for (int i = 0; i < lleno && buscar == -1; i++) {
            if (libros[i].getISBN().equals(ISBN)) {
                buscar = i;
            }
        }
        return buscar;
    }

    public Libro buscarPorTitulo(String titulo){
        Libro buscar = null;
        int indice = buscarIndiceLibro(titulo);
        if (indice != -1) {
            buscar = libros[indice];
        }
        return buscar;
    }

    public Libro buscarPorISBN(String ISBN){
        Libro buscar = null;
        int indice = buscarIndiceLibroPorISBN(ISBN);
        if (indice != -1) {
            buscar = libros[indice];
        }
        return buscar;
    }

    public Libro[] buscarPorAutor(String autor) {
        Libro[] resultado = new Libro[tam];
        int libroLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (libros[i].getAutor().toLowerCase().equals(autor.toLowerCase())){
                resultado[libroLleno] = libros[i];
                libroLleno++;
            }
        }
        return Arrays.copyOf(resultado, libroLleno);
    }

    public Libro[] buscarPorCategoria(CategoriaLibro categoriaLibro){
        Libro[] resultado = new Libro[tam];
        int libroLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (libros[i].getCategoriaLibro().equals(categoriaLibro)){
                resultado[libroLleno] = libros[i];
                libroLleno++;
            }
        }
        return Arrays.copyOf(resultado, libroLleno);
    }

    public boolean actualizarLibro(String titulo, Libro actualizado) {
        int indice = buscarIndiceLibro(titulo);
        if (indice != -1) {
            libros[indice] = actualizado;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean actualizarLibroPorISBN(String ISBN, Libro actualizado) {
        int indice = buscarIndiceLibroPorISBN(ISBN);
        if (indice != -1) {
            libros[indice] = actualizado;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean eliminarLibro(String titulo) {
        int indice = buscarIndiceLibro(titulo);
        if (indice!=-1) {
            for (int i = indice; i < lleno - 1; i++) {
                libros[i] = libros[i+1];
            }
            libros[--lleno] = null;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean eliminarLibroPorISBN(String ISBN) {
        int indice = buscarIndiceLibroPorISBN(ISBN);
        if (indice!=-1) {
            for (int i = indice; i < lleno - 1; i++) {
                libros[i] = libros[i+1];
            }
            libros[--lleno] = null;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String stringLibro = "";
        for (int i = 0; i < lleno; i++) {
            stringLibro += libros[i].toString() + "\n";
        }
        return stringLibro;
    }

    public static String toString(Libro[] libros) {
        String stringLibro = "";
        for (int i = 0; i < libros.length; i++) {
            stringLibro += libros[i].toString() + "\n";
        }
        return stringLibro;
    }
}
