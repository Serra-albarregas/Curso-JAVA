package UT5.Ejemplos.HerenciaAnimal;
import java.util.Objects;

public class Perro extends Animal{
    private TamanioPerro tamanio;
    private String raza;
    private int energia;
    private Pelaje pelaje;

    public Perro(String nombre, String tipoAlimentacion, int edad, TamanioPerro tamanio, String raza, int energia, Pelaje pelaje) {
        super(nombre, tipoAlimentacion, edad);
        this.tamanio = tamanio;
        this.raza = raza;
        this.energia = (energia>=0&&energia<=10)?energia:0;
        this.pelaje = pelaje;
    }

    public TamanioPerro getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(TamanioPerro tamanio) {
        this.tamanio = tamanio;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        this.energia = (energia>=0&&energia<=10)?energia:0;
    }

    public Pelaje getPelaje() {
        return this.pelaje;
    }

    public void setPelaje(Pelaje pelaje) {
        this.pelaje = pelaje;
    }

    public void ladrar(){
        System.out.println("GUAU");
    }


    @Override
    public String toString() {
        return super.toString() + 
            " tamanio='" + getTamanio() + "'" +
            ", raza='" + getRaza() + "'" +
            ", energia='" + getEnergia() + "'" +
            ", pelaje='" + getPelaje() + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Perro)) {
            return false;
        }
        Perro perro = (Perro) o;
        return super.equals(perro) && Objects.equals(tamanio, perro.tamanio) && Objects.equals(raza, perro.raza) && energia == perro.energia && Objects.equals(pelaje, perro.pelaje);
    }
}
