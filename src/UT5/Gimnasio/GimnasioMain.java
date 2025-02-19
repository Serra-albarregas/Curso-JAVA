package UT5.Gimnasio;

import java.time.LocalDate;

public class GimnasioMain {
    public static void main(String[] args) {
        // Crear un gimnasio con capacidad para 5 materiales
        Gimnasio gimnasio = new Gimnasio(5);
        
        // Crear materiales
        Maquina maquina1 = new Maquina(1, "Cinta de correr", LocalDate.of(2022, 5, 10), true);
        Pesa pesa1 = new Pesa(2, "Mancuerna 10kg", LocalDate.of(2021, 3, 15), 10);
        Maquina maquina2 = new Maquina(3, "Bicicleta estática", LocalDate.of(2020, 8, 20), false);
        
        // Agregar materiales al gimnasio
        gimnasio.addMaterial(maquina1);
        gimnasio.addMaterial(pesa1);
        gimnasio.addMaterial(maquina2);
        
        // Imprimir los materiales añadidos
        System.out.println("Materiales en el gimnasio:");
        System.out.println(gimnasio);
        
        // Buscar material
        try {
            Material encontrado = gimnasio.buscarMaterial("Mancuerna 10kg");
            System.out.println("Material encontrado: " + encontrado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Cambiar estado de una máquina
        try {
            gimnasio.cambiarEstado("Cinta de correr");
            System.out.println("Estado cambiado de la máquina 'Cinta de correr'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Cambiar estado de una máquina saltando excepción
        try {
            gimnasio.cambiarEstado("Elíptica");
            System.out.println("Estado cambiado de la máquina 'Elíptica'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Cambiar estado de una máquina saltando excepción
        try {
            gimnasio.cambiarEstado("Mancuerna 10Kg");
            System.out.println("Estado cambiado de la máquina 'Mancuerna 10Kg'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Simular uso de un material
        try {
            gimnasio.simularUso("Bicicleta estática");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Simular uso de un material
        try {
            gimnasio.simularUso("Mancuerna 10Kg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        // Imprimir estado final del gimnasio
        System.out.println("Estado final del gimnasio:");
        System.out.println(gimnasio);
    }
}
