package UT5.Ejemplos.GestorDatos;

import java.util.Arrays;

/**
 * Clase que gestiona una colección de canciones.
 * 
 * @author Pablo Collar Serradilla
 */
class GestorCancion {

    private Cancion[] canciones;
    private int lleno;
    private static final int TAM = 100;

    /**
     * Constructor que inicializa el gestor con un tamaño máximo predeterminado.
     */
    public GestorCancion() {
        canciones = new Cancion[TAM];
        lleno = 0;
    }

    /**
     * Añade una nueva canción al gestor.
     * 
     * @param c la canción a añadir.
     */
    public void nuevaCancion(Cancion c) {
        if (lleno<TAM){
            canciones[lleno] = c;
            lleno++;
        }
    }

    /**
     * Busca el índice de una canción por título.
     * 
     * @param titulo el título de la canción a buscar.
     * @return el índice de la canción, o -1 si no se encuentra.
     */
    private int buscarIndiceCancion(String titulo) {
        int buscar = -1;
        for (int i = 0; i < lleno && buscar == -1; i++) {
            if (canciones[i].getTitulo().equals(titulo)) {
                buscar = i;
            }
        }
        return buscar;
    }

    /**
     * Busca una canción por título.
     * 
     * @param titulo el título de la canción a buscar.
     * @return la canción encontrada, o null si no se encuentra.
     */
    public Cancion buscarCancion(String titulo) {
        Cancion buscar = null;
        int indice = buscarIndiceCancion(titulo);
        if (indice != -1) {
            buscar = canciones[indice];
        }
        return buscar;
    }

    /**
     * Busca canciones por autor.
     * 
     * @param autor el autor de las canciones a buscar.
     * @return un array de canciones del autor.
     */
    public Cancion[] buscarPorAutor(String autor) {
        Cancion[] resultado = new Cancion[TAM];
        int autorLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (canciones[i].getAutor().equals(autor)) {
                resultado[autorLleno] = canciones[i];
                autorLleno++;
            }
        }
        return Arrays.copyOf(resultado, autorLleno);
    }

    /**
     * Busca canciones por género musical.
     * 
     * @param generoMusical el género musical de las canciones a buscar.
     * @return un array de canciones del género.
     */
    public Cancion[] buscarPorGenero(GeneroMusical generoMusical) {
        Cancion[] resultado = new Cancion[TAM];
        int generoLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (canciones[i].getGeneroMusical().equals(generoMusical)) {
                resultado[generoLleno] = canciones[i];
                generoLleno++;
            }
        }
        return Arrays.copyOf(resultado, generoLleno);
    }

    /**
     * Actualiza una canción existente.
     * 
     * @param titulo      el título de la canción a actualizar.
     * @param actualizada la nueva información de la canción.
     * @return true si la canción se actualizó correctamente, false en caso contrario.
     */
    public boolean actualizarCancion(String titulo, Cancion actualizada) {
        int indice = buscarIndiceCancion(titulo);
        if (indice != -1) {
            canciones[indice] = actualizada;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina una canción por título.
     * 
     * @param titulo el título de la canción a eliminar.
     * @return true si la canción se eliminó correctamente, false en caso contrario.
     */
    public boolean eliminarCancion(String titulo) {
        int indice = buscarIndiceCancion(titulo);
        if (indice != -1) {
            for (int i = indice; i < lleno - 1; i++) {
                canciones[i] = canciones[i + 1];
            }
            canciones[--lleno] = null;      //Operador de predecremento -> primero se decrementa la variable lleno y luego se utiliza como índice
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Devuelve las canciones como string
     */
    @Override
    public String toString() {
        String stringCancion = "";
        for (int i = 0; i < lleno; i++) {
            stringCancion += canciones[i].toString() + "\n";
        }
        return stringCancion;
    }
    
    /**
     *  Devuelve un array de canciones como string
     */
    public static String toString(Cancion[] arrayCancion){
        String stringCancion = "";
        for (Cancion cancion : arrayCancion) {
            stringCancion += cancion.toString() + "\n";
        }
        return stringCancion;
    }
  
}