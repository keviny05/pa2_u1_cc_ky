package ky.edu.uce.pa.paquete.restaurante;

public class Pedido {
    private final String cliente;
    private final Plato plato;
    private final int cantidad;
    private final String correo;

    public Pedido(String cliente, Plato plato, int cantidad, String correo) {
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
