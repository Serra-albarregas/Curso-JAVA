package UT5.Gimnasio;

import java.time.LocalDate;

public class Maquina extends Material implements Ocupable {
    private boolean libre;

    public Maquina(int identificador, String nombre, LocalDate fabricacion, boolean libre) {
        super(identificador, nombre, fabricacion);
        this.libre = libre;
    }

    public boolean isLibre() {
        return this.libre;
    }

    public boolean getLibre() {
        return this.libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    @Override
    public void ocupar() throws Exception{
        if (libre) {
            libre = false;
        }
        else {
            throw new Exception("La maquina está ocupada");
        }
    }

    @Override
    public void desocupar() throws Exception{
        if (!libre) {
            libre = true;
        }
        else {
            throw new Exception("La maquina ya está libre");
        }
    }

    @Override
    public String toString() {
        return super.toString() +
            " libre='" + isLibre() + "'";
    }


}
