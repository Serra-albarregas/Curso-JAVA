package UT5.Ejemplos.InterfacesConocidas;
import java.util.Objects;

public class Planta {
    String nombre;
    int altura;

    public Planta(String nombre, int altura) {
        this.nombre = nombre;
        this.altura = altura;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Planta)) {
            return false;
        }
        Planta planta = (Planta) o;
        return Objects.equals(nombre, planta.nombre) && altura == planta.altura;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", altura='" + getAltura() + "'" +
            "}";
    }

}
