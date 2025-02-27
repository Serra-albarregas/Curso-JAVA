package UT6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class EjemList {
    public static void main(String[] args) {
        //comparativaListas();
        pruebaRendimiento();
        //pruebaQueue();
    }

    public static void comparativaListas(){
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();

        // Añadir elementos al final de la lista
        // En LinkedList, añadir un elemento al final es inmediato
        // En ArrayList, añadir un elemento al final es inmediato, salvo en los casos en los que hay que reestructurar el array
        list.add(20);
        list.add(60);
        list.add(10);
        list.add(40);
        array.add(20);
        array.add(60);
        array.add(10);
        array.add(40);

        // Acceso a elementos
        // En LinkedList, el acceso requiere recorrer la lista desde el inicio o el final.
        // En ArrayList, el acceso es directo a través del índice, lo que lo hace más rápido.
        System.out.println("LinkedList get: " + list.get(1));
        System.out.println("ArrayList get: " + array.get(1));

        // Comprobación de existencia de un elemento
        // Ambos utilizan la búsqueda lineal en la mayoría de los casos,
        // pero el recorrido en ArrayList es más rápido al estar los elementos contiguos en memoria.
        System.out.println("LinkedList contains 20: " + list.contains(20));
        System.out.println("ArrayList contains 20: " + array.contains(20));

        // Eliminación de elementos
        // En LinkedList, eliminar el primer o último elemento es más eficiente (O(1)),
        // pero eliminar en el medio requiere recorrer la lista (O(n)).
        // En ArrayList, eliminar es costoso (O(n)) ya que requiere mover elementos.
        list.remove(1);
        array.remove(1);
        System.out.println("LinkedList después de eliminar índice 1: " + list);
        System.out.println("ArrayList después de eliminar índice 1: " + array);

        // Inserción de elementos en una posición específica
        // En LinkedList, insertar en cualquier posición es más eficiente (O(1)) si se tiene el nodo, si no se tiene hay que recorrer la lista hasta encontrarlo (O(n))
        // En ArrayList, insertar requiere mover elementos, lo que es costoso (O(n)).
        list.add(1, 50);
        array.add(1, 50);
        System.out.println("LinkedList después de insertar en índice 1: " + list);
        System.out.println("ArrayList después de insertar en índice 1: " + array);

        // Modificación de elementos en una posición específica
        // En LinkedList, se debe recorrer la lista hasta encontrar el índice, lo que es algo costoso (O(n)).
        // En ArrayList, el acceso a un índice es inmediato (O(1)).
        list.set(2,100);
        array.set(2, 100);
        System.out.println("LinkedList después de modificar en índice 2: " + list);
        System.out.println("ArrayList después de modificar en índice 2: " + array);

        // Búsqueda del elemento a partir de un índice
        // Tanto en LinkedList como en ArrayList se debe recorrer la lista para hacer la búsqueda, una operación costosa (O(n))
        System.out.println("Índice del elemento '40' en LinkedList: " + list.indexOf(40));
        System.out.println("Índice del elemento '40' en ArrayList: " + array.indexOf(40));
    }

    public static void pruebaRendimiento(){
        final int ELEMENTS = 500_000; // Número de elementos a agregar

        // Prueba con ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            arrayList.add(i); // Añadir al final
        }
        long endTime = System.nanoTime();
        System.out.println("Tiempo de add() en ArrayList (final): " + (endTime - startTime) / 1_000_000 + " ms");

        // Prueba con LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            linkedList.add(i); // Añadir al final
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de add() en LinkedList (final): " + (endTime - startTime) / 1_000_000 + " ms");

        // Prueba de add() al inicio
        arrayList.clear();
        linkedList.clear();

        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            arrayList.add(0, i); // Añadir al inicio
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de add() en ArrayList (inicio): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            linkedList.addFirst(i); // Añadir al inicio
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de add() en LinkedList (inicio): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            arrayList.get(i); // Obtener elemento
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de get() en ArrayList: " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            linkedList.get(i); // Obtener elemento
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de get() en LinkedList (inicio): " + (endTime - startTime) / 1_000_000 + " ms");

        startTime = System.nanoTime();
        for (Integer integer : linkedList) {
            integer++;
        }
        endTime = System.nanoTime();
        System.out.println("Tiempo de iterador en LinkedList: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void pruebaQueue(){
        Queue<Integer> queue = new LinkedList<>();

        // Añadir elementos a la cola
        queue.offer(10); // Agrega al final de la cola
        queue.offer(20);
        queue.offer(30);
        System.out.println("Cola después de offer(): " + queue);

        // Obtener el primer elemento sin eliminarlo
        System.out.println("Elemento en el frente (peek()): " + queue.peek());

        // Remover el primer elemento
        System.out.println("Elemento eliminado (poll()): " + queue.poll());
        System.out.println("Cola después de poll(): " + queue);

        // Uso de remove() para eliminar el primer elemento (arroja excepción si está vacía)
        System.out.println("Elemento eliminado (remove()): " + queue.remove());
        System.out.println("Cola después de remove(): " + queue);

        // Comprobar si la cola está vacía
        System.out.println("¿Cola vacía? " + queue.isEmpty());
    }
}
