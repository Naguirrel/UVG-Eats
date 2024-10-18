public class Pedido {
    private String descripcion;
    private double precio;

    public Pedido(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Pedido: " + descripcion + " - Precio: $" + precio;
    }
}