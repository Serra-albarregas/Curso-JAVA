package UT5.Ejemplos.HerenciaAnimal;

public class AnimalMain {
    public static void main(String args[]){
        Conejo conejo1 = new Conejo();
        //Animal animal1 = new Animal();
        Animal conejo2 = new Conejo();
        Ardilla ardilla = new Ardilla();
        
        Animal[] animales = new Animal[4];
        animales[0] = conejo1;
        //animales[1] = animal1;
        animales[2] = conejo2;
        animales[3] = ardilla;

        for (int i = 0; i < animales.length; i++) {
            System.out.println(animales[i].toString());
            animales[i].hacerSonido();
            
        }
    }
}
