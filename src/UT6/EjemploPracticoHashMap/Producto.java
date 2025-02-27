package UT6.EjemploPracticoHashMap;

import java.util.Objects;

/**
 * Clase que representa un producto en un inventario.
 * Cada producto tiene un código único, nombre, precio y stock disponible.
 */
public class Producto {
    private int codigo;   // Código único del producto
    private String nombre; // Nombre del producto
    private float precio;  // Precio del producto
    private int stock;     // Cantidad de unidades disponibles en stock

    /**
     * Constructor para crear un producto con valores iniciales.
     *
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto en formato float.
     * @param stock  Cantidad inicial de stock disponible.
     */
    public Producto(int codigo, String nombre, float precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /**
     * Obtiene el código del producto.
     *
     * @return Código único del producto.
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece un nuevo nombre para el producto.
     *
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public float getPrecio() {
        return this.precio;
    }

    /**
     * Establece un nuevo precio para el producto.
     *
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad de unidades disponibles en stock.
     *
     * @return Cantidad de stock disponible.
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Establece una nueva cantidad de stock disponible.
     *
     * @param stock Nueva cantidad de stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Método para vender una unidad del producto.
     * Disminuye el stock en 1 y devuelve el precio del producto.
     * 
     * @return Precio del producto si hay stock disponible, 0 si no hay stock.
     */
    public float vender() {
        if (this.stock > 0) {
            this.stock--;
            return this.precio;
        }
        return 0;
    }

    /**
     * Verifica si dos productos son iguales basándose en su código, nombre, precio y stock.
     *
     * @param o Objeto a comparar.
     * @return true si los productos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return codigo == producto.codigo &&
               Float.compare(precio, producto.precio) == 0 &&
               stock == producto.stock &&
               Objects.equals(nombre, producto.nombre);
    }

    /**
     * Genera un código hash para el producto basado en sus atributos.
     *
     * @return Valor hash del producto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, stock);
    }

    /**
     * Representación en texto del producto.
     *
     * @return String con la información del producto.
     */
    @Override
    public String toString() {
        return "Producto { " +
                "Código: " + codigo +
                ", Nombre: '" + nombre + '\'' +
                ", Precio: $" + precio +
                ", Stock: " + stock +
                " }";
    }
}
