package UT5.InterfacesConocidas;
import java.util.Arrays;
import java.util.Iterator;

public class Plantacion implements Iterable<Planta>{
    Planta[] plantas;
    private int lleno;
    private static final int TAM = 100;

    public Plantacion() {
        plantas = new Planta[TAM];
        lleno = 0;
    }

    public void nuevaPlanta(Planta p) {
        if (lleno<TAM){
            plantas[lleno] = p;
            lleno++;
        }
    }

    public void ordenar(){
        Planta[] plantasAux = Arrays.copyOf(plantas, lleno);
        Arrays.sort(plantasAux);
        plantas = Arrays.copyOf(plantasAux, TAM);
    }

    public Plantacion(Planta[] plantas) {
        this.plantas = plantas;
    }

    public Planta[] getPlantas() {
        return this.plantas;
    }

    public void setPlantas(Planta[] plantas) {
        this.plantas = plantas;
    }

    @Override
    public String toString() {
        String plantas = "";
        for (int i = 0; i < lleno; i++) {
            plantas+=this.plantas[i] + "\n";
        }
        return plantas;
    }

    @Override
    public Iterator<Planta> iterator() {
        return new IteratorPlantacion();
    }

    public class IteratorPlantacion implements Iterator<Planta>{
        protected int posicion;
        public IteratorPlantacion(){
            posicion=0;
        }
        @Override
        public boolean hasNext() {
            if (posicion<lleno) return true;
            else return false;
        }
    
        @Override
        public Planta next() {
            posicion++;
            return plantas[posicion-1];
        }
        
    }
    
    public static void main(String[] args) {
        Plantacion plantacion = new Plantacion();
        plantacion.nuevaPlanta(new Planta("Geranio", 3));
        plantacion.nuevaPlanta(new Planta("Cardo", 1));
        plantacion.nuevaPlanta(new Planta("Enredadera", 10));
        plantacion.nuevaPlanta(new Planta("Helecho", 5));

        System.out.println(plantacion);
        plantacion.ordenar();
        System.out.println(plantacion);

        System.out.println(plantacion.getPlantas()[0].clone() + "\n");

        for (Planta planta : plantacion) {
            System.out.println(planta);
        }
    }
}
