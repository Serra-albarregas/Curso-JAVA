package UT5.Persona;

import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private float altura;
    private float peso;
    private String dni;
    private char genero;
    private final static char defaultGenero='H';

    public Persona(){
        nombre = "";
        edad=0;
        altura=0.f;
        peso=0.f;
        dni = generarDNI();
        genero=defaultGenero;
    }

    public Persona(String nombre, int edad, char genero){
        this();
        this.nombre = nombre;
        this.edad=edad;
        this.genero=comprobarGenero(genero);
    }

    public Persona(String nombre, int edad, float altura, float peso, char genero){
        this.nombre=nombre;
        this.edad=edad;
        this.altura=altura;
        this.dni=generarDNI();
        this.peso=peso;
        this.genero=comprobarGenero(genero);
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setEdad(int edad){
        this.edad=edad;
    }

    public float getAltura(){
        return this.altura;
    }

    public void setAltura(float altura){
        this.altura=altura;
    }

    public float getPeso(){
        return this.peso;
    }

    public void setPeso(float peso){
        this.peso=peso;
    }

    public String getDNI(){
        return dni;
    }

    public char getGenero(){
        return genero;
    }

    public void setGenero(char genero){
        this.genero=comprobarGenero(genero);
    }

    public int calcularIMC(){
        float imc = this.peso/(this.altura*this.altura);

        if(imc<20){return -1;}
        else if(imc>=20 && imc<=25){return 0;}
        else {return 1;}
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    private char comprobarGenero(char generoPosible){
        if (generoPosible!= 'H' && generoPosible!= 'M'){
            return defaultGenero;
        }
        else {
            return generoPosible;
        }
    }

    private String generarDNI(){
        Random r = new Random();
        int numero = r.nextInt(100_000_000);
        String DNI=String.format("%08d", numero);
        int letraDNI = numero%23;
        String letras= "TRWAGMYFPDXBNJZSQVHLCK";
        DNI+=letras.charAt(letraDNI);
        return DNI;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", edad='" + getEdad() + "'" +
            ", altura='" + getAltura() + "'" +
            ", peso='" + getPeso() + "'" +
            ", dni='" + getDNI() + "'" +
            ", genero='" + getGenero() + "'" +
            "}";
    }
    
}
