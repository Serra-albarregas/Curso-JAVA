package UT5.Ejemplos.InterfacesFormas;

public class MainFormas {
    public static void main(String[] args) {
        //Forma forma1 = new Forma();               // Una interfaz no puede instanciarse
        Forma forma2 = new Circulo();               // Existe el polimorfismo con las interfaces, un tipo Círculo también es tipo Forma
        Circulo forma3 = new Circulo();
        //Circulo forma4 = new Forma();
        Cuadrado forma5 = new Cuadrado();


        forma3.pintar();
        Forma[] formas = new Forma[10];
        formas[0] = forma2;
        formas[1] = forma3;                          // Podemos unificar todos los tipos que implementen una interfaz
        formas[2] = forma5;
    }
}
