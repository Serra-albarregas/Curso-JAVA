package UT6.ExamenA;

import java.util.Random;

public class DragonGuerrero extends Dragon{
    private int potencia;
    private boolean cansado;

    public DragonGuerrero(String nombre, String ciudad, int potencia){
        super(nombre, ciudad);
        this.potencia = potencia;
        this.cansado=false;
    }

    public int getPotencia() {
        return this.potencia;
    }

    public void setPotencia(int potencia) {
        if (potencia<0) potencia = 0;
        else this.potencia = potencia;
    }

    public boolean isCansado() {
        return this.cansado;
    }

    public boolean getCansado() {
        return this.cansado;
    }

    public void setCansado(boolean cansado) {
        this.cansado = cansado;
    }

    @Override
    public String toString() {
        return super.toString() +
            " potencia='" + getPotencia() + "'" +
            ", cansado='" + isCansado() + "'";
    }

    @Override
    public void usarAliento() throws Exception {
        if (cansado){
            throw new Exception("El dragon está cansado");
        }
        else{
            super.usarAliento();
            if (new Random().nextInt(100)+potencia*0.1>20){
                cansado=true;
            }
        }
    }
}
