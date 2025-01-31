package UT5.Persona;

public class PersonaApp {
    public static void main(String[] args) {
        Persona p1 = new Persona("Alfonso", 89, 0.15f, 120, 'H');
        Persona p2 = new Persona("Rigoberto", 42, 'H');
        Persona p3 = new Persona();
        p3.setNombre("ª");
        p3.setEdad(30);
        p3.setAltura(1.75f);
        p3.setPeso(70);
        p3.setGenero('M');

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        System.out.println(p1.calcularIMC() + " " + p1.esMayorDeEdad());

        switch (p1.calcularIMC()) {
            case -1:
                System.out.println("primer caso");
                break;
            case 0:
                System.out.println("Segundo caso");
                break;
            case 1:
                System.out.println("Tercer caso");
                break;
            default:
                break;
        }
    }
}
