package UT6.Actividad2;
import java.util.Objects;

public class JugadorBasket implements Comparable<JugadorBasket>, Cloneable{
    private String nombre;
    private String apellido;
    private int dorsal;
    private int puntosMarcados;
    private float altura;
    private String equipo;
    private PosicionBasket posicion;


    public JugadorBasket() {
    }

    public JugadorBasket(String nombre, String apellido, int dorsal, int puntosMarcados, float altura, String equipo, PosicionBasket posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dorsal = dorsal;
        this.puntosMarcados = puntosMarcados;
        this.altura = altura;
        this.equipo = equipo;
        this.posicion = posicion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDorsal() {
        return this.dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getPuntosMarcados() {
        return this.puntosMarcados;
    }

    public void setPuntosMarcados(int puntosMarcados) {
        this.puntosMarcados = puntosMarcados;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getEquipo() {
        return this.equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public PosicionBasket getPosicion() {
        return this.posicion;
    }

    public void setPosicion(PosicionBasket posicion) {
        this.posicion = posicion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof JugadorBasket)) {
            return false;
        }
        JugadorBasket jugadorBasket = (JugadorBasket) o;
        return Objects.equals(nombre, jugadorBasket.nombre) && Objects.equals(apellido, jugadorBasket.apellido) && dorsal == jugadorBasket.dorsal && puntosMarcados == jugadorBasket.puntosMarcados && altura == jugadorBasket.altura && Objects.equals(equipo, jugadorBasket.equipo) && Objects.equals(posicion, jugadorBasket.posicion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, dorsal, puntosMarcados, altura, equipo, posicion);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", apellido='" + getApellido() + "'" +
            ", dorsal='" + getDorsal() + "'" +
            ", puntosMarcados='" + getPuntosMarcados() + "'" +
            ", altura='" + getAltura() + "'" +
            ", equipo='" + getEquipo() + "'" +
            ", posicion='" + getPosicion() + "'" +
            "}";
    }

    @Override
    public int compareTo(JugadorBasket o) {
        return this.apellido.equals(o.getApellido())?this.apellido.compareTo(o.getApellido()):this.nombre.compareTo(o.getNombre());
    }
    
    @Override
    protected JugadorBasket clone()  {
        return new JugadorBasket(nombre, apellido, dorsal, puntosMarcados, altura, equipo, posicion);
    }
}
