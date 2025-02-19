package UT5.Gimnasio;

import java.time.LocalDate;

public class Pesa extends Material{
    private int peso;


    public Pesa(int identificador, String nombre, LocalDate fabricacion, int peso) {
        super(identificador, nombre, fabricacion);
        this.peso = peso;
    }
    

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public void utilizar() {
        System.out.println(nombre + " utilizandose. Pesa " + peso);
    }

    @Override
    public String toString() {
        return super.toString() +
            " peso='" + getPeso() + "'";
    }

}
