package UT5.Gimnasio;

import java.time.LocalDate;

public class Material implements Utilizable {
    protected int identificador;
    protected String nombre;
    protected LocalDate fabricacion;


    public Material(int identificador, String nombre, LocalDate fabricacion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fabricacion = fabricacion;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFabricacion() {
        return this.fabricacion;
    }

    public void setFabricacion(LocalDate fabricacion) {
        this.fabricacion = fabricacion;
    }
    
    @Override
    public void utilizar() {
        System.out.println(nombre + " utilizandose");
    }

    @Override
    public String toString() {
        return
            " identificador='" + getIdentificador() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", fabricacion='" + getFabricacion() + "'";
    }


}
