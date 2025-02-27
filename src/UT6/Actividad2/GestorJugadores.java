package UT6.Actividad2;

import java.util.ArrayList;

public class GestorJugadores implements Cloneable{
    private ArrayList<JugadorBasket> jugadores;

    public GestorJugadores(){
        jugadores = new ArrayList<>();
    }

    private int buscarIndice(int dorsal) {
        int buscar = -1;
        for (int i = 0; i < jugadores.size() && buscar==-1; i++) {
            if (jugadores.get(i).getDorsal()==dorsal) {
                buscar = i;
            }
        }
        return buscar;
    }

    private int buscarIndice(String nombre) {
        int buscar = -1;
        for (int i = 0; i < jugadores.size() && buscar==-1; i++) {
            if (jugadores.get(i).getNombre().equals(nombre)) {
                buscar = i;
            }
        }
        return buscar;
    }

    public void insertarJugador(JugadorBasket j){
        jugadores.add(j);
    }

    public JugadorBasket buscar(int dorsal) {
        int indice = buscarIndice(dorsal);
        return (indice != -1) ? jugadores.get(indice) : null;
    }

    public JugadorBasket buscar(String nombre) {
        int indice = buscarIndice(nombre);
        return (indice != -1) ? jugadores.get(indice) : null;
    }

    public boolean modificar(int dorsal, JugadorBasket newj) {
        int indice = buscarIndice(dorsal);
        if (indice != -1) {
            jugadores.set(indice, newj);
            return true;
        }
        return false;
    }

    public boolean eliminar(int dorsal) {
        int indice = buscarIndice(dorsal);
        if (indice != -1) {
            jugadores.remove(indice);
            return true;
        }
        return false;
    }

    public void ordenar(){
        jugadores.sort(null);
    }

    public GestorJugadores clone(){
        GestorJugadores clon = new GestorJugadores();
        for (JugadorBasket jugadorBasket : jugadores) {
            clon.insertarJugador(jugadorBasket.clone());
        }
        return clon;
    }

    public static void main(String[] args) {
        // Crear gestor de jugadores
        GestorJugadores gestor = new GestorJugadores();

        // Crear jugadores
        JugadorBasket j1 = new JugadorBasket("Michael", "Jordan", 23, 32292, 1.98f, "Chicago Bulls", PosicionBasket.ESCOLTA);
        JugadorBasket j2 = new JugadorBasket("Kobe", "Bryant", 24, 33643, 1.98f, "Los Angeles Lakers", PosicionBasket.ESCOLTA);
        JugadorBasket j3 = new JugadorBasket("Stephen", "Curry", 30, 21000, 1.88f, "Golden State Warriors", PosicionBasket.BASE);

        // Insertar jugadores
        gestor.insertarJugador(j1);
        gestor.insertarJugador(j2);
        gestor.insertarJugador(j3);

        // Buscar por dorsal
        System.out.println("Buscando jugador con dorsal 24:");
        JugadorBasket encontrado = gestor.buscar(24);
        System.out.println(encontrado != null ? encontrado.getNombre() + " " + encontrado.getApellido() : "No encontrado");

        // Buscar por nombre
        System.out.println("Buscando jugador llamado 'Stephen Curry':");
        encontrado = gestor.buscar("Stephen");
        System.out.println(encontrado != null ? "Dorsal: " + encontrado.getDorsal() + ", Equipo: " + encontrado.getEquipo() : "No encontrado");

        // Modificar un jugador
        System.out.println("Modificando el jugador con dorsal 30...");
        boolean modificado = gestor.modificar(30, new JugadorBasket("Stephen", "Curry", 30, 22000, 1.88f, "Golden State Warriors", PosicionBasket.BASE));
        System.out.println(modificado ? "Modificado con éxito" : "No se encontró el jugador");

        // Eliminar un jugador
        System.out.println("Eliminando jugador con dorsal 23...");
        boolean eliminado = gestor.eliminar(23);
        System.out.println(eliminado ? "Eliminado con éxito" : "No se encontró el jugador");

        // Ordenar jugadores por dorsal
        System.out.println("Ordenando jugadores...");
        gestor.ordenar();

        // Mostrar todos los jugadores
        System.out.println("Lista de jugadores después de ordenar:");
        for (JugadorBasket j : gestor.clone().jugadores) {
            System.out.println(j.getDorsal() + " - " + j.getNombre() + " " + j.getApellido() + " - " + j.getEquipo());
        }

        // Clonando gestor
        System.out.println("Clonando gestor...");
        GestorJugadores clon = gestor.clone();
        System.out.println("Gestor clonado con éxito.");
    }
}
