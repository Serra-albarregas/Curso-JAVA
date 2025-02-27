package UT6;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map.Entry;


public class EjemHashMap {
    public static void main(String[] args) {
        pruebaHashMap();
        //pruebaLinkedHashMap();
        //pruebaTreeMap();
    }

    public static void pruebaHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();

        // Añadir un par clave-valor al mapa
        hashMap.put("clave", "valor");
        hashMap.put("codigo", "variable");
        hashMap.put("contrasena", "contenido");
        hashMap.put("combinacion", "informacion");

        // Obtener un valor a partir de una clave
        System.out.println("El valor almacenado con la clave 'clave' es: " + hashMap.get("clave"));
        System.out.println("El valor almacenado con la clave 'codigo' es: " + hashMap.get("codigo"));

        // Comprobar si una clave está contenida en el mapa
        System.out.println("La clave 'clave' aparece?: " + hashMap.containsKey("clave"));
        System.out.println("La clave 'variable' aparece?: " + hashMap.containsKey("variable"));

        // En los mapas no se admiten claves duplicadas, se cambia lo que haya
        hashMap.put("clave", "otro valor");
        System.out.println("El nuevo valor para 'clave' es " + hashMap.get("clave"));

        // Comprobar si un valor está contenido en el mapa
        System.out.println("El valor 'clave' aparece?: " + hashMap.containsValue("clave"));
        System.out.println("El valor 'variable' aparece?: " + hashMap.containsValue("variable"));

        // Recorrido del mapa
        System.out.println("Recorrido de entradas");
        for (Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " Valor: " + entry.getValue());
        }

        // Recorrido del conjunto de claves
        System.out.println("Recorrido de claves");
        for (String clave : hashMap.keySet()) {
            System.out.println("Clave: " + clave + " Valor: " + hashMap.get(clave));
        }

        // Recorrido del conjunto de valores
        System.out.println("Recorrido de valores");
        for (String valor : hashMap.values()) {
            System.out.println("Valor: " + valor);
        }

        // Recorrido con la función foreach
        System.out.println("Recorrido con la función forEach");
        hashMap.forEach((key,value)->{
            System.out.println("Clave: " + key + " Valor: " + value);
        });
    }

    public static void pruebaLinkedHashMap() {
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();

        // Añadir un par clave-valor al mapa
        linkedMap.put("clave", "valor");
        linkedMap.put("codigo", "variable");
        linkedMap.put("contrasena", "contenido");
        linkedMap.put("combinacion", "informacion");

        // Obtener un valor a partir de una clave
        System.out.println("El valor almacenado con la clave 'clave' es: " + linkedMap.get("clave"));
        System.out.println("El valor almacenado con la clave 'codigo' es: " + linkedMap.get("codigo"));

        // Comprobar si una clave está contenida en el mapa
        System.out.println("La clave 'clave' aparece?: " + linkedMap.containsKey("clave"));
        System.out.println("La clave 'variable' aparece?: " + linkedMap.containsKey("variable"));

        // Comprobar si un valor está contenido en el mapa
        System.out.println("El valor 'clave' aparece?: " + linkedMap.containsValue("clave"));
        System.out.println("El valor 'variable' aparece?: " + linkedMap.containsValue("variable"));

        // Recorrido sobre el mapa, muestra los elementos en orden de insercion
        System.out.println("Recorrido de entradas");
        for (Entry<String, String> entry:linkedMap.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " Valor: " + entry.getValue());
        }
    }

    public static void pruebaTreeMap(){
        TreeMap<String, String> treeMap = new TreeMap<>();
        // Añadir un par clave-valor al mapa
        treeMap.put("clave", "valor");
        treeMap.put("codigo", "variable");
        treeMap.put("contrasena", "contenido");
        treeMap.put("combinacion", "informacion");

        // Obtener un valor a partir de una clave
        System.out.println("El valor almacenado con la clave 'clave' es: " + treeMap.get("clave"));
        System.out.println("El valor almacenado con la clave 'codigo' es: " + treeMap.get("codigo"));

        // Comprobar si una clave está contenida en el mapa
        System.out.println("La clave 'clave' aparece?: " + treeMap.containsKey("clave"));
        System.out.println("La clave 'variable' aparece?: " + treeMap.containsKey("variable"));

        // Comprobar si un valor está contenido en el mapa
        System.out.println("El valor 'clave' aparece?: " + treeMap.containsValue("clave"));
        System.out.println("El valor 'variable' aparece?: " + treeMap.containsValue("variable"));

        // Recorrido sobre el mapa, muestra los elementos en orden de insercion
        System.out.println("Recorrido de entradas");
        for (Entry<String, String> entry:treeMap.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " Valor: " + entry.getValue());
        }
    }
}
