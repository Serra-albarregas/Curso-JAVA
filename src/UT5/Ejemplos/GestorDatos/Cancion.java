package UT5.Ejemplos.GestorDatos;

import java.util.Date;

/**
 * Representa una canción con título, autor, género musical y fecha de salida.
 */
public class Cancion {
    private String titulo;
    private String autor;
    private GeneroMusical generoMusical;
    private Date fechaSalida;

    /**
     * Constructor para crear una nueva canción.
     * 
     * @param titulo        el título de la canción.
     * @param autor         el autor de la canción.
     * @param generoMusical el género musical de la canción.
     * @param fechaSalida   la fecha de lanzamiento de la canción.
     */
    public Cancion(String titulo, String autor, GeneroMusical generoMusical, Date fechaSalida) {
        this.titulo = titulo;
        this.autor = autor;
        this.generoMusical = generoMusical;
        this.fechaSalida = fechaSalida;
    }

    /**
     * Obtiene el título de la canción.
     * 
     * @return el título de la canción.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Establece el título de la canción.
     * 
     * @param titulo el nuevo título de la canción.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor de la canción.
     * 
     * @return el autor de la canción.
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Establece el autor de la canción.
     * 
     * @param autor el nuevo autor de la canción.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene el género musical de la canción.
     * 
     * @return el género musical de la canción.
     */
    public GeneroMusical getGeneroMusical() {
        return this.generoMusical;
    }

    /**
     * Establece el género musical de la canción.
     * 
     * @param generoMusical el nuevo género musical de la canción.
     */
    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    /**
     * Obtiene la fecha de lanzamiento de la canción.
     * 
     * @return la fecha de lanzamiento de la canción.
     */
    public Date getFechaSalida() {
        return this.fechaSalida;
    }

    /**
     * Establece la fecha de lanzamiento de la canción.
     * 
     * @param fechaSalida la nueva fecha de lanzamiento de la canción.
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public String toString() {
        return "{" +
                " titulo='" + getTitulo() + "'" +
                ", autor='" + getAutor() + "'" +
                ", generoMusical='" + getGeneroMusical() + "'" +
                ", fechaSalida='" + getFechaSalida().toString() + "'" +
                "}";
    }
}