package ky.edu.uce.pa.paquete.restaurante;

public class Plato {
    private final String nombre;
    private final String descripcion;
    private final double precio;

    public Plato(String nombre, String descripcion, double precio) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre es obligatorio.");
        if (precio < 0) throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " - " + descripcion + " - $" + String.format(java.util.Locale.US, "%.2f", precio);
    }
}
