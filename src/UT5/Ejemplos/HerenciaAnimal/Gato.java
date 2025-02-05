package UT5.Ejemplos.HerenciaAnimal;
import java.util.Objects;

public class Gato extends Animal{
    private String colorPelaje;
    private Pelaje pelaje;
    private int independencia;


    public Gato(String nombre, String tipoAlimentacion, int edad, String colorPelaje, Pelaje pelaje, int independencia) {
        super(nombre, tipoAlimentacion, edad);
        this.colorPelaje = colorPelaje;
        this.pelaje = pelaje;
        this.independencia = (independencia>=0&&independencia<=10)?independencia:0;
    }

    public String getColorPelaje() {
        return this.colorPelaje;
    }

    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }

    public Pelaje getPelaje() {
        return this.pelaje;
    }

    public void setPelaje(Pelaje pelaje) {
        this.pelaje = pelaje;
    }

    public int getIndependencia() {
        return this.independencia;
    }

    public void setIndependencia(int independencia) {
        this.independencia = (independencia>=0&&independencia<=10)?independencia:0;
    }

    public void maullar(){
        System.out.println("MIAU");
    }

    @Override
    public String toString() {
        return super.toString() + 
            " colorPelaje='" + getColorPelaje() + "'" +
            ", pelaje='" + getPelaje() + "'" +
            ", independencia='" + getIndependencia() + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Gato)) {
            return false;
        }
        Gato gato = (Gato) o;
        return super.equals(gato) && Objects.equals(colorPelaje, gato.colorPelaje) && Objects.equals(pelaje, gato.pelaje) && independencia == gato.independencia;
    }
}
