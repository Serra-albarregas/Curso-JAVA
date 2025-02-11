package UT5.Ejemplos.InterfacesFormas;

public interface Dibujo {
    // Las interfaces no pueden tener atributos (no deberían, al menos), pero si constantes
    public static final String colorDefault = "Blanco";

    // Las interfaces definen las cabeceras de los métodos que las clases deberán implementar obligatoriamente
    public void darColor(String color);

    // Desde Java 8, se permite añadir métodos predeterminados (default), que no son obligatorios de implementar en las clases
    public default void pintar(){
        System.out.println("Pinta");
    }
}
