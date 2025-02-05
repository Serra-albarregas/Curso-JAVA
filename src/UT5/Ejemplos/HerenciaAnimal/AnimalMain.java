package UT5.Ejemplos.HerenciaAnimal;

public class AnimalMain {
    public static void main(String args[]){
        Animal animal1 = new Animal();
        Animal animal2 = new Ardilla();
        Ardilla animal3 = new Ardilla();
        //Ardilla animal4 = new Animal();
        Object animal4 = new Animal();
    
        Ardilla ardillaAux = (Ardilla)animal2;
    
        Animal[] animales=new Animal[3];
        animales[0]=animal1;
        animales[1]=animal2;
        animales[2]=animal3;

        
        for (int i = 0; i < animales.length; i++) {
            System.out.println(animales[i].toString());
            if (animales[i] instanceof Ardilla){
                Ardilla ardilla=(Ardilla)animales[i];
                ardilla.saludar();
            }
        }
    }
}
