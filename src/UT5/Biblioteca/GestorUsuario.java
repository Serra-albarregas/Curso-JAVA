package UT5.Biblioteca;

import java.util.Arrays;

public class GestorUsuario {
    private Usuario[] usuarios;
    private int lleno;
    private int tam;

    public GestorUsuario(int tam){
        this.tam = tam;
        usuarios = new Usuario[tam];
        lleno = 0;
    }

    public boolean addUsuario(Usuario u){
        if (u!=null && lleno<tam){
            usuarios[lleno] = u;
            lleno++;
            return true;
        }
        else{
            return false;
        }
    }

    private int buscarIndiceUsuario(String nick){
        int buscar = -1;
        for (int i = 0; i < lleno && buscar == -1; i++) {
            if (usuarios[i].getNick().equals(nick)) {
                buscar = i;
            }
        }
        return buscar;
    }

    public Usuario buscarUsuario(String nick){
        Usuario buscar = null;
        int indice = buscarIndiceUsuario(nick);
        if (indice != -1) {
            buscar = usuarios[indice];
        }
        return buscar;
    }

    public Usuario[] buscarPorRol(boolean esAdmin) {
        Usuario[] resultado = new Usuario[tam];
        int usuarioLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (usuarios[i].getEsAdmin() == esAdmin){
                resultado[usuarioLleno] = usuarios[i];
                usuarioLleno++;
            }
        }
        return Arrays.copyOf(resultado, usuarioLleno);
    }

    public boolean actualizarUsuario(String nick, Usuario actualizado) {
        int indice = buscarIndiceUsuario(nick);
        if (indice != -1) {
            usuarios[indice] = actualizado;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean eliminarUsuario(String nick) {
        int indice = buscarIndiceUsuario(nick);
        if (indice!=-1) {
            for (int i = indice; i < lleno - 1; i++) {
                usuarios[i] = usuarios[i+1];
            }
            usuarios[--lleno] = null;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String stringUsuario = "";
        for (int i = 0; i < lleno; i++) {
            stringUsuario += usuarios[i].toString() + "\n";
        }
        return stringUsuario;
    }
}
