package UT5.Ejemplos.HerenciaAnimal;
import java.util.Objects;

public abstract class Animal {

    protected String nombre,tipoAlimentacion;
    protected int edad;

    public Animal(){
        this.nombre="";
        this.tipoAlimentacion="";
        this.edad=0;
    }

    public Animal(String nombre,String tipo_alimentacion,int edad){
        this.nombre = nombre;
        this.tipoAlimentacion = tipo_alimentacion;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipo_alimentacion) {
        this.tipoAlimentacion = tipo_alimentacion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void hacerSonido(){
        System.out.println("Soy generico");
    }

    @Override
    public String toString() {
        return " nombre='" + getNombre() + "'" +
            ", tipo_alimentacion='" + getTipoAlimentacion() + "'" +
            ", edad='" + getEdad() + "'";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return Objects.equals(nombre, animal.nombre) && Objects.equals(tipoAlimentacion, animal.tipoAlimentacion) && edad == animal.edad;
    }
}
