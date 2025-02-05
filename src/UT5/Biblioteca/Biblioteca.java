package UT5.Biblioteca;

public class Biblioteca {
    private GestorLibro existencias;
    private GestorLibro prestados;
    private GestorUsuario usuarios;
    private Usuario sesion;
    private int totalPrestados;
    private static final int TAM = 50;


    public Biblioteca () {
        existencias = new GestorLibro(TAM);
        prestados = new GestorLibro(TAM);
        usuarios = new GestorUsuario(TAM);
        sesion = null;
        totalPrestados = 0;
    }

    public boolean addLibro(Libro l){
        return existencias.addLibro(l);
    }

    public boolean eliminarLibro(String titulo){
        return existencias.eliminarLibro(titulo);
    }

    public boolean eliminarLibroPorISBN(String ISBN){
        return existencias.eliminarLibroPorISBN(ISBN);
    }

    public Libro buscarLibro(String titulo) {
        return existencias.buscarPorTitulo(titulo);
    }

    public Libro buscarLibroPorISBN(String ISBN) {
        return existencias.buscarPorISBN(ISBN);
    }

    public Libro[] buscarLibrosPorAutor(String autor) {
        return existencias.buscarPorAutor(autor);
    }

    public Libro[] buscarLibrosPorCategoria(CategoriaLibro categoria){
        return existencias.buscarPorCategoria(categoria);
    }

    public boolean addUsuario(Usuario u){
        return usuarios.addUsuario(u);
    }

    public boolean inicioSesion(String nick, String pass){
        Usuario u = usuarios.buscarUsuario(nick);
        if (u!=null && u.getPass().equals(pass)){
            sesion = u;
            return true;
        }
        else{
            return false;
        }
    }

    public Usuario getSesion(){
        return this.sesion;
    }

    public String getExistencias(){
        return this.existencias.toString();
    }
}
