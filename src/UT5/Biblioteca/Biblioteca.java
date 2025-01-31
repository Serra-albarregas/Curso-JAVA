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
}
