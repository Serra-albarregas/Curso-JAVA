package UT6.EjemploPracticoHashMap;

import java.util.HashMap;

/**
 * Clase que representa una tienda con productos en su inventario.
 * La tienda tiene un nombre, un inventario de productos y una cantidad de dinero.
 */
public class Tienda {
    private HashMap<Integer, Producto> inventario; // Inventario de productos (mapeado por código)
    private String nombre; // Nombre de la tienda
    private float dinero;  // Dinero disponible en la tienda

    /**
     * Constructor de la tienda.
     *
     * @param nombre Nombre de la tienda.
     */
    public Tienda(String nombre) {
        this.inventario = new HashMap<>();
        this.dinero = 500; // Dinero inicial de la tienda
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo nombre para la tienda.
     *
     * @param nombre Nuevo nombre de la tienda.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la tienda.
     *
     * @return Nombre de la tienda.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Obtiene la cantidad de dinero disponible en la tienda.
     *
     * @return Dinero disponible.
     */
    public float getDinero() {
        return this.dinero;
    }

    /**
     * Inserta un nuevo producto en el inventario.
     *
     * @param p Producto a insertar.
     * @return true si el producto se insertó correctamente, false si ya existía.
     */
    public boolean insertar(Producto p) {
        if (!inventario.containsKey(p.getCodigo())) {
            inventario.put(p.getCodigo(), p);
            return true;
        }
        return false;
    }

    /**
     * Elimina un producto del inventario.
     *
     * @param p Producto a eliminar.
     * @return true si el producto se eliminó, false si no existía.
     */
    public boolean eliminar(Producto p) {
        return inventario.remove(p.getCodigo()) != null;
    }

    /**
     * Obtiene un producto del inventario por su código.
     *
     * @param codigo Código del producto.
     * @return El producto encontrado, o null si no existe.
     */
    public Producto obtener(int codigo) {
        return inventario.get(codigo);
    }

    /**
     * Modifica un producto en el inventario.
     *
     * @param p Producto con los datos actualizados.
     * @return true si el producto se modificó, false si no existía.
     */
    public boolean modificar(Producto p) {
        if (inventario.containsKey(p.getCodigo())) {
            inventario.put(p.getCodigo(), p);
            return true;
        }
        return false;
    }

    /**
     * Vende un producto, reduciendo su stock y aumentando el dinero en la tienda.
     *
     * @param codigo Código del producto a vender.
     */
    public void vender(int codigo) {
        Producto p = inventario.get(codigo);
        if (p != null && p.getStock() > 0) {
            this.dinero += p.vender();
        }
    }

    /**
     * Representación en texto de la tienda.
     *
     * @return Información de la tienda y su inventario.
     */
    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Nombre de la tienda: ").append(nombre)
               .append("\nDinero disponible: ").append(dinero).append("€\n")
               .append("Inventario:\n");

        inventario.forEach((k, v) -> retorno.append(v.toString()).append("\n"));
        
        return retorno.toString();
    }

    /**
     * Método main para probar la clase Tienda.
     */
    public static void main(String[] args) {
        Tienda tienda = new Tienda("Mi Tienda");

        // Crear productos
        Producto p1 = new Producto(101, "Laptop", 1200, 5);
        Producto p2 = new Producto(102, "Smartphone", 800, 3);

        // Insertar productos
        tienda.insertar(p1);
        tienda.insertar(p2);

        // Mostrar estado inicial de la tienda
        System.out.println(tienda);

        // Vender un producto
        tienda.vender(101);

        // Mostrar estado después de la venta
        System.out.println("Después de vender un producto:");
        System.out.println(tienda);
    }
}
