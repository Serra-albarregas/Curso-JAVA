package UT6.ExamenA;


import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        Reino reino = new Reino();
        reino.insertarDragon(new DragonOro("Aurum", "Castillo Dorado"));
        reino.insertarDragon(new DragonOro("Brillante", "Fortaleza Radiante"));
        reino.insertarDragon(new DragonOro("Solara", "Fortaleza Radiante"));
        reino.insertarDragon(new DragonOro("Reluciente", "Castillo Dorado"));
        reino.insertarDragon(new DragonOro("Centella", "Fortaleza Radiante"));

        reino.insertarDragon(new DragonGuerrero("Faucesombra", "Ciudad de Hierro", 120));
        reino.insertarDragon(new DragonGuerrero("Colmillo Carmesí", "Ciudad de Hierro", 150));
        reino.insertarDragon(new DragonGuerrero("Garra Veloz", "Aldea Esmeralda", 100));
        reino.insertarDragon(new DragonGuerrero("Llamarada", "Fortaleza Radiante", 180));
        reino.insertarDragon(new DragonGuerrero("Tempestad", "Aldea Esmeralda", 140));

        System.out.println(reino.buscarDragon(0));
        System.out.println(reino.buscarDragon(1));
        System.out.println(reino.eliminarDragon(5));

        Dragon dragonOro = reino.buscarDragon(0);
        Dragon dragonGuerrero = reino.buscarDragon(reino.getNDragones()-1);
        for (int i = 0; i < 4; i++) {
            try{
                dragonOro.usarAliento();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < 10; i++) {
            try{
                dragonGuerrero.usarAliento();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            dragonGuerrero.setEnergia(100);
        }

        reino.cambiarDormido(1);
        Map<String, Collection<DragonOro>> dragonesOro = reino.DragonesOroDespiertosPorCastillo();
        for (Entry<String, Collection<DragonOro>> dragonesCiudad: dragonesOro.entrySet()) {
            System.out.println("Ciudad: " + dragonesCiudad.getKey());
            for (DragonOro dragonOroCiudad:dragonesCiudad.getValue()) {
                System.out.println(dragonOroCiudad);
            }
        }
    }
}
