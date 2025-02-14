package UT5.Ejemplos.InterfacesFormas;

//Al contrario que en la herencia, se permite implementar múltiples interfaces
public class Circulo implements Forma, Dibujo{
    private int radio;
    private String color;

    //Es obligatorio implementar las funciones definidas en las interfaces
    @Override
    public float calcularArea() {
        return (float) Math.PI * radio * radio;
    }

    @Override
    public float calcularPerimetro() {
        return (float) Math.PI * 2 * radio;
    }

    @Override
    public void darColor(String color) {
        if (color.equals("")){
            this.color = Dibujo.colorDefault;
        }
        else{
            this.color = color;
        }
    }

    // Podemos sobreescribir los métodos por defecto de la interfaz, aunque no es obligatorio
    @Override
    public void pintar(){
        System.out.println("Pinta desde circulo de color " + color);
    }
    
}
