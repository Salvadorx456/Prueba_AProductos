package actualizarproducto;
import java.util.ArrayList;
import java.util.List;


class Producto {
    private int id;
    private String nombre;
    private double precio;
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
public class ActualizarProducto {
    private List<Producto> productos;
    public ActualizarProducto() {
        this.productos = new ArrayList<>();
    }
    public void agregarProducto(Producto producto) {
    productos.add(producto);
}

    public void actualizarProducto(int id, Producto productoActualizado) {
    int indice = encontrarIndicePorId(id);
    if (indice != -1) {
        actualizarProductoEnIndice(indice, productoActualizado);
    } else {
        notificarProductoNoEncontrado(id);
    }
    }

    private int encontrarIndicePorId(int id) {
    for (int i = 0; i < productos.size(); i++) {
        if (productos.get(i).getId() == id) {
            return i;
        }
    }
    return -1;
    }
    // 4) Introducir metodo Objetivo
    private void actualizarProductoEnIndice(int indice, Producto productoActualizado) {
    productos.set(indice, productoActualizado);
    }

    private void notificarProductoNoEncontrado(int id) {
    System.out.println("No se encontró ningún producto con el ID " + id);
    }
    //3) Encapsular Coleccion
    public void imprimirProductos() {
    productos.forEach(System.out::println);
    }
    //5)Eliminacion de COdigo Muuerto o Redudante
    public static void main(String[] args) {
        ActualizarProducto lista = new ActualizarProducto();
        lista.agregarProducto(new Producto(1, "Manzanas", 12.0));
        lista.agregarProducto(new Producto(2, "Naranjas", 6.0));

        System.out.println("Productos antes de la actualización:");
        lista.imprimirProductos();
        Producto productoActualizado = new Producto(1, "Manzanas", 13.0);
        lista.actualizarProducto(1, productoActualizado);
        System.out.println("\nProductos después de la actualización:");
        lista.imprimirProductos();
    }
}
