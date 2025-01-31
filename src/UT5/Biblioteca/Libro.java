package UT5.Biblioteca;

import java.util.Date;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private Date fechaPublicacion;
    private Usuario prestadoA;
    private int vecesPrestado;
    private CategoriaLibro categoriaLibro;

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

    @Override
    public String toString() {
        return "{" +
            " titulo='" + getTitulo() + "'" +
            ", autor='" + getAutor() + "'" +
            ", ISBN='" + getISBN() + "'" +
            ", fechaPublicacion='" + getFechaPublicacion() + "'" +
            ", prestadoA='" + getPrestadoA() + "'" +
            ", vecesPrestado='" + getVecesPrestado() + "'" +
            ", categoriaLibro='" + getCategoriaLibro() + "'" +
            "}";
    }
 
    
}
