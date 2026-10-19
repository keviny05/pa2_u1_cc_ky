package ky.edu.uce.pa.paquete.restaurante;

public class Pedido {
    private final String cliente;
    private final Plato plato;
    private final int cantidad;
    private final String correo;

    public Pedido(String cliente, Plato plato, int cantidad, String correo) {
        if (cliente == null || cliente.isBlank()) throw new IllegalArgumentException("El nombre del cliente es obligatorio.");
        if (plato == null) throw new IllegalArgumentException("Debe seleccionar un plato válido.");
        if (cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        if (correo == null || correo.isBlank() || !correo.contains("@")) throw new IllegalArgumentException("Debe ingresar un correo válido.");
        this.cliente = cliente;
        this.plato = plato;
        this.cantidad = cantidad;
        this.correo = correo;
    }

    public String getCliente() { return cliente; }
    public Plato getPlato() { return plato; }
    public int getCantidad() { return cantidad; }
    public String getCorreo() { return correo; }
    public double getTotal() { return plato.getPrecio() * cantidad; }
}
