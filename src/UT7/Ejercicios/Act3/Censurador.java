package UT7.Ejercicios.Act3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Censurador {
    private File file;
    private File output;
    private File tabuFile;
    private HashSet<String> tabu;
    private HashMap<String, Integer> jugadores;

    private String jugadorActual;

    public Censurador(String path, String tabuFile){
        this.file = new File(path);
        this.output = new File(file.getParent()+"/output_"+file.getName());
        this.tabuFile = new File(tabuFile);
        this.tabu = new HashSet<>();
        this.jugadores = new HashMap<>();
        cargarArchivoTabu();
    }

    public void censurar(){
        try (BufferedReader br = new BufferedReader(new FileReader(file));
            BufferedWriter bw = new BufferedWriter(new FileWriter(output))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                jugadorActual = palabras[1];
                if (!jugadores.containsKey(jugadorActual)) jugadores.put(jugadorActual, 0);

                bw.write(palabras[0] + " " + palabras[1] + " " + palabras[2] + " ");
                for (int i = 3; i < palabras.length-1; i++) {
                    bw.write(procesarPalabra(palabras[i])+ " ");
                }
                bw.write(procesarPalabra(palabras[palabras.length-1]) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String procesarPalabra(String palabra){
        String limpia = limpiarPalabra(palabra);
        if (tabu.contains(limpia)){
            jugadores.put(jugadorActual, jugadores.get(jugadorActual)+1);
            return censurarPalabra(palabra);
        }
        
        else return palabra;
    }

    public String limpiarPalabra(String palabra){
        return palabra.replaceAll("[.,:;!?()\"'\\-–—¿¡\\[\\]{}]", "").toLowerCase();
    }

    public String censurarPalabra(String palabra){
        return palabra.replaceAll("(?<=[a-zA-ZáéíóúÁÉÍÓÚüÜ])[a-zA-ZáéíóúÁÉÍÓÚüÜ](?=[a-zA-ZáéíóúÁÉÍÓÚüÜ])", "*");
    }

    public void cargarArchivoTabu(){
        try(BufferedReader br = new BufferedReader(new FileReader(tabuFile))){
            String linea;
            while((linea=br.readLine())!=null) {
                tabu.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarInstultos(){
        for (String string : tabu) {
            System.out.println(string);
        }
    }

    public void mostrarJugadores(){
        for (Entry<String,Integer> entry : jugadores.entrySet()) {
            System.out.println("Jugador: "+ entry.getKey() + "\tInsultos: " + entry.getValue() + "\t" + (entry.getValue()>=5?"Baneado":""));
        }
    }

    public static void main(String[] args) {
        Censurador censurador = new Censurador("src/UT7/Ejercicios/Act3/chat-toxico-lol.txt", "src/UT7/Ejercicios/Act3/tabu.txt");
        censurador.censurar();
        censurador.mostrarJugadores();;
    }
}
