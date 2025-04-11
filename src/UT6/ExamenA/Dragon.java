package UT6.ExamenA;

public abstract class Dragon implements InterfazDragon{
    private static int ultimoId = 0;
    private int identificador;
    private String nombre;
    private String castillo;
    private boolean dormido;
    private int energia;

    public Dragon(String nombre, String castillo){
        identificador = ultimoId++;
        this.nombre=nombre;
        this.castillo=castillo;
        this.dormido=false;
        this.energia = 80;
    }

    public int getIdentificador() {
        return this.identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCastillo() {
        return this.castillo;
    }

    public void setCastillo(String castillo) {
        this.castillo = castillo;
    }

    public boolean isDormido() {
        return this.dormido;
    }

    public boolean getDormido() {
        return this.dormido;
    }

    public void setDormido(boolean dormido) {
        this.dormido = dormido;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void setEnergia(int energia) {
        if (energia > 0 && energia < 100) this.energia = 0;
        else this.energia = energia;
    }

    @Override
    public String toString() {
        return 
            " identificador='" + getIdentificador() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", castillo='" + getCastillo() + "'" +
            ", dormido='" + isDormido() + "'" +
            ", energia='" + getEnergia() + "'";
    }

    @Override
    public void usarAliento() throws Exception {
        if (energia>20){
            System.out.println("Usando aliento");
            energia-=20;
        }
        else{
            throw new Exception("No hay suficiente energía");
        }
    }

}
