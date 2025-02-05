package UT5.Ejemplos.HerenciaAnimal;

public class Ardilla extends Animal{
    private int numeroNueces;
    private boolean voladora;
    private String arbolFav;
    private int saltosTotales;
    private int IQ;
    public Ardilla(){
        super();
        this.numeroNueces = 0;
        this.voladora = false;
        this.arbolFav = "Secuoya";
        this.saltosTotales = 0;
        this.IQ = 2;
    }

    public Ardilla(String nombre, String tipoAlimentacion, int edad, int numeroNueces, boolean voladora, String arbolFav, int saltosTotales, int IQ){
        super(nombre, tipoAlimentacion, edad);
        this.numeroNueces = numeroNueces;
        this.voladora = voladora;
        this.arbolFav = arbolFav;
        this.saltosTotales = saltosTotales;
        this.IQ = IQ;
    }

    public int getNumeroNueces() {
        return this.numeroNueces;
    }

    public void setNumeroNueces(int numeroNueces) {
        this.numeroNueces = numeroNueces;
    }

    public boolean isVoladora() {
        return this.voladora;
    }

    public boolean getVoladora() {
        return this.voladora;
    }

    public void setVoladora(boolean voladora) {
        this.voladora = voladora;
    }

    public String getArbolFav() {
        return this.arbolFav;
    }

    public void setArbolFav(String arbolFav) {
        this.arbolFav = arbolFav;
    }

    public int getSaltosTotales() {
        return this.saltosTotales;
    }

    public void setSaltosTotales(int saltosTotales) {
        this.saltosTotales = saltosTotales;
    }

    public int getIQ() {
        return this.IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }
    
    public void saludar(){
        System.out.println("HOLA SOY LA ARDILLA" + nombre);
    }



    @Override
    public String toString() {
        return super.toString()+"{" +
            " numeroNueces='" + getNumeroNueces() + "'" +
            ", voladora='" + isVoladora() + "'" +
            ", arbolFav='" + getArbolFav() + "'" +
            ", saltosTotales='" + getSaltosTotales() + "'" +
            ", IQ='" + getIQ() + "'" +
            "}";
    }
    
}
