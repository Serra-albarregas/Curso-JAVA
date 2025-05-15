package UT6.ExamenA;

import java.util.Collection;
import java.util.Map;

public interface InterfazReino {

    /**
     * Inserta un Dragon en la colección elegida para el reino
     * @param dragon
     */
    public void insertarDragon(Dragon dragon);

    /**
     * Busca un Dragon en la coleccion elegida a partir de su identificador
     * @param identificador El identificador del Dragon
     * @return El Dragon cuyo identificador coincide con el proporcionado
     */
    public Dragon buscarDragon(int identificador);

    /**
     * Elimina un Dragon de la coleccion elegida, encontrándolo mediante su identificador
     * @param identificador El identificador del Dragon
     * @return True si se ha eliminado el Dragon, false en caso contrario
     */
    public boolean eliminarDragon(int identificador);

    /**
     * Devuelve el número de Dragones del reino
     * @return El número de Dragones del reino
     */
    public int getNDragones();

    /**
     * Busca un Dragon y cambia su estado a despierto si está dormido o a dormido si está despierto
     * @param identificador El identificador del Dragon
     */
    public void cambiarDormido(int identificador);

    /**
     * Devuelve un mapa que permita obtener una colección de dragones a partir del nombre de un castillo.
     * Solo se deberán añadir los dragones de oro que estén despiertos.
     * La colección elegida para los dragones de cada castillo debe permitir el acceso por índice a los
     * elementos en cualquier posición.
     * Los grupos de dragones deben estar ordenados por cantidad de oro
     * @return
     */
    public Map<String,Collection<DragonOro>> DragonesOroDespiertosPorCastillo();

    /**
     * Devuelve un String que resuelva la siguiente pregunta de teoría:
     * ¿Qué colección utilizaríamos si quisiesemos crear una pila de Dragones, donde
     * donde realizamos las inserciones y las lecturas de la primera posición de la estructura?
     * @return Un String, la solución a la pregunta de teoría
     */
    public String preguntaTeoria();
}
