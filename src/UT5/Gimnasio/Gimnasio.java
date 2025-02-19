package UT5.Gimnasio;

public class Gimnasio {
    private Material[] materiales;
    private int lleno;
    private int tam;

    public Gimnasio(int tam){
        this.tam = tam;
        materiales = new Material[tam];
        lleno = 0;
    }

    public int getLleno(){
        return this.lleno;
    }

    public boolean addMaterial(Material m){
        if (m != null && lleno<tam){
            materiales[lleno] = m;
            lleno++;
            return true;
        }
        else{
            return false;
        }
    }

    public Material getMaterial(int indice){
        return materiales[indice];
    }

    public Material buscarMaterial(String nombre) throws Exception{
        Material buscar = null;
        for (int i = 0; i < lleno && buscar == null; i++) {
            if (materiales[i].getNombre().toLowerCase().equals(nombre.trim().toLowerCase())) {
                buscar = materiales[i];
            }
        }
        if (buscar != null) return buscar;
        else throw new Exception("Material no encontrado");
    }

    public void cambiarEstado(String nombre) throws Exception{
        Material mat = buscarMaterial(nombre);
        if (mat instanceof Maquina) {
            Maquina maq = (Maquina) mat;
            if (maq.getLibre()){
                maq.ocupar();
            }
            else{
                maq.desocupar();
            }
        }
        else throw new Exception("El material indicado no es una maquina");
    }

    public void simularUso(String nombre) throws Exception{
        Material mat = buscarMaterial(nombre);
        mat.utilizar();
    }

    @Override
    public String toString() {
        String todos = "";
        for (int i = 0; i < lleno; i++) {
            todos += materiales[i] + "\n";
        }
        return todos;
    }
}
