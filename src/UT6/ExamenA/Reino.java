package UT6.ExamenA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Reino implements InterfazReino{
    private HashMap<Integer,Dragon> dragones;

    public Reino(){
        this.dragones = new HashMap<>();
    }

    @Override
    public void insertarDragon(Dragon dragon) {
        dragones.put(dragon.getIdentificador(), dragon);
    }

    @Override
    public Dragon buscarDragon(int identificador) {
        return dragones.get(identificador);
    }

    @Override
    public boolean eliminarDragon(int identificador) {
        return dragones.get(identificador)!=null;
    }

    @Override
    public int getNDragones() {
        return dragones.size();
    }

    @Override
    public void cambiarDormido(int identificador) {
        Dragon dragon = buscarDragon(identificador);
        dragon.setDormido(!dragon.getDormido());
    }

    @Override
    public Map<String, Collection<DragonOro>> DragonesOroDespiertosPorCastillo() {
        HashMap<String, Collection<DragonOro>> oros = new HashMap<>();
        for (Entry<Integer,Dragon> dragon : dragones.entrySet()) {
            if (dragon.getValue() instanceof DragonOro && !dragon.getValue().getDormido()){
                DragonOro dragonOro = (DragonOro) dragon.getValue();
                if (!oros.containsKey(dragonOro.getCastillo())){
                    ArrayList<DragonOro> listaDragones = new ArrayList<>();
                    listaDragones.add(dragonOro);
                    oros.put(dragonOro.getCastillo(), listaDragones);
                } else {
                    oros.get(dragonOro.getCastillo()).add(dragonOro);
                }
            }
        }
        for (Collection<DragonOro> dragonOros : oros.values()) {
            Collections.sort((ArrayList<DragonOro>) dragonOros);
        }

        return oros;
    }

    @Override
    public String preguntaTeoria() {
        return "linkedList";
    }

}
