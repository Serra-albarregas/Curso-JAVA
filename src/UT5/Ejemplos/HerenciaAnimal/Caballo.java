package UT5.Ejemplos.HerenciaAnimal;

public class Caballo extends Animal{
    private int altura;
    private int velocidad;

    public Caballo(String nombre, String tipoAlimentacion, int edad, int altura, int velocidad) {
        super(nombre, tipoAlimentacion, edad);
        this.altura = altura;
        this.velocidad = velocidad;
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void relinchar(){
        System.out.println("HIII");
    }

    @Override
    public void hacerSonido(){
        relinchar();
    }

    public int correr(int distancia){
        return distancia/velocidad;
    }

    @Override
    public String toString() {
        return super.toString() +
            " altura='" + getAltura() + "'" +
            ", velocidad='" + getVelocidad() + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Caballo)) {
            return false;
        }
        Caballo caballo = (Caballo) o;
        return super.equals(caballo) && altura == caballo.altura && velocidad == caballo.velocidad;
    }
}
