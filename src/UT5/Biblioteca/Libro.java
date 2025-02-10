package UT5.Biblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private Date fechaPublicacion;
    private Usuario prestadoA;
    private int vecesPrestado;
    private CategoriaLibro categoriaLibro;

    public static final String RED = "\u001B[31m";
    public static final String WHITE = "\u001B[37m";

    public Libro(String titulo, String autor, String ISBN, Date fechaPublicacion, CategoriaLibro categoriaLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.fechaPublicacion = fechaPublicacion;
        this.prestadoA = null;
        this.vecesPrestado = 0;
        this.categoriaLibro = categoriaLibro;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Usuario getPrestadoA() {
        return this.prestadoA;
    }

    public void setPrestadoA(Usuario prestadoA) {
        this.prestadoA = prestadoA;
    }

    public int getVecesPrestado() {
        return this.vecesPrestado;
    }

    public void incrementarPrestado() {
        this.vecesPrestado++;
    }

    public CategoriaLibro getCategoriaLibro() {
        return this.categoriaLibro;
    }

    public void setCategoriaLibro(CategoriaLibro categoriaLibro) {
        this.categoriaLibro = categoriaLibro;
    }

    public boolean getDisponible(){
        return prestadoA==null;
    }

    public void prestar(Usuario prestadoA){
        setPrestadoA(prestadoA);
        incrementarPrestado();
    }

    public String infoLibro(){
        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
        String color = prestadoA==null?WHITE:RED;
        return color + ISBN + ": " + titulo + " por " + autor + ". Categoria " + categoriaLibro + ". Fecha de publicacion " + formato.format(getFechaPublicacion()) + ". Prestado " + vecesPrestado + " veces"+ WHITE;
    }

    public String infoLibroAdmin(){
        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
        String color = prestadoA==null?WHITE:RED;
        return color + ISBN + ": " + titulo + " por " + autor + ". Categoria " + categoriaLibro + ". Fecha de publicacion " + formato.format(getFechaPublicacion()) + ". Prestado " + vecesPrestado + " veces"+ WHITE + 
        "\n\tPrestado a:" + prestadoA.getNick();
    }

    @Override
    public String toString() {
        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
        return " titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", ISBN='" + getISBN() + "'" +
            ", fechaPublicacion='" + formato.format(getFechaPublicacion()) + "'" +
            ", categoriaLibro='" + getCategoriaLibro() + "'";
    }
}
