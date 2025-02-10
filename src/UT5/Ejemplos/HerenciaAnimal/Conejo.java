package UT5.Ejemplos.HerenciaAnimal;

public class Conejo extends Animal {
    private int zanahoriasAlmacenadas;
    private String colorPelo;
    private String tipoOreja;
    private int tamanioOreja;

    public Conejo(){
        super();
        zanahoriasAlmacenadas = 0;
        colorPelo = "Blanco";
        tipoOreja="Caida";
        tamanioOreja = 27;
    }

    public Conejo(String nombre, String tipoAlimentacion, int edad, int zanahoriasAlmacenadas, String colorPelo, String tipoOreja, int tamanioOreja) {
        super(nombre,tipoAlimentacion, edad);
        this.zanahoriasAlmacenadas = zanahoriasAlmacenadas;
        this.colorPelo = colorPelo;
        this.tipoOreja = tipoOreja;
        this.tamanioOreja = tamanioOreja;
    }

    public int getZanahoriasAlmacenadas() {
        return this.zanahoriasAlmacenadas;
    }

    public void setZanahoriasAlmacenadas(int zanahoriasAlmacenadas) {
        this.zanahoriasAlmacenadas = zanahoriasAlmacenadas;
    }

    public String getColorPelo() {
        return this.colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public String getTipoOreja() {
        return this.tipoOreja;
    }

    public void setTipoOreja(String tipoOreja) {
        this.tipoOreja = tipoOreja;
    }

    public int getTamanioOreja() {
        return this.tamanioOreja;
    }

    public void setTamanioOreja(int tamanioOreja) {
        this.tamanioOreja = tamanioOreja;
    }

    public void comerCable(){
        System.out.println("Hola soy " + nombre + " y me gustan los cables ÑOM");
    }

    @Override
    public String toString() {
        return super.toString() + 
            " zanahoriasAlmacenadas='" + getZanahoriasAlmacenadas() + "'" +
            ", colorPelo='" + getColorPelo() + "'" +
            ", tipoOreja='" + getTipoOreja() + "'" +
            ", tamanioOreja='" + getTamanioOreja() + "'";
    }

}
