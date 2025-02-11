package UT5.Ejemplos.InterfacesFormas;

public class Cuadrado implements Forma{
    private int lado;

    @Override
    public float calcularArea() {
        return lado * lado;
    }

    @Override
    public float calcularPerimetro() {
        return 4*lado;
    }
}
