package UT6.EjemploPracticoHashMap.Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import UT6.EjemploPracticoHashMap.Producto;
import UT6.EjemploPracticoHashMap.Tienda;

/**
 * Clase de pruebas para Tienda con JUnit 5.
 */
public class TiendaTest {
    private Tienda tienda;
    private Producto p1, p2;

    @Before
    public void setUp() {
        tienda = new Tienda("Test Store");
        p1 = new Producto(101, "Laptop", 1200, 5);
        p2 = new Producto(102, "Smartphone", 800, 3);
        tienda.insertar(p1);
        tienda.insertar(p2);
    }

    @Test
    public void testInsertar() {
        Producto p3 = new Producto(103, "Tablet", 600, 2);
        assertTrue(tienda.insertar(p3));
        assertFalse(tienda.insertar(p3)); // No debería permitir duplicados
    }

    @Test
    public void testEliminar() {
        assertTrue(tienda.eliminar(p1));
        assertFalse(tienda.eliminar(p1)); // No debería existir después de eliminarlo
    }

    @Test
    public void testObtener() {
        assertEquals(p1, tienda.obtener(101));
        assertNull(tienda.obtener(999)); // Producto inexistente
    }

    @Test
    public void testModificar() {
        Producto pModificado = new Producto(101, "Laptop Gaming", 1500, 4);
        assertTrue(tienda.modificar(pModificado));
        assertEquals("Laptop Gaming", tienda.obtener(101).getNombre());
    }

    @Test
    public void testVender() {
        float dineroAntes = tienda.getDinero();
        tienda.vender(101);
        assertEquals(dineroAntes + 1200, tienda.getDinero(),0.1);
        assertEquals(4, tienda.obtener(101).getStock());
    }
}
