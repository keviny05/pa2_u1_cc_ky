package     ky.edu.uce.pa.paquete.restaurante;

import java.util.Locale;

public class PedidoService {
    private final MailService mailService;

    public PedidoService() { this.mailService = new MailService(); }

    public void realizar(Pedido pedido) {
        System.out.println("\n===== PEDIDO REGISTRADO =====");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Plato: " + pedido.getPlato().getNombre());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.printf(Locale.US, "Precio unitario: $%.2f%n", pedido.getPlato().getPrecio());
        System.out.printf(Locale.US, "Total: $%.2f%n", pedido.getTotal());
        System.out.println("Estado: En preparacion");

        String asunto = "Confirmacion de pedido - Sabor Express";
        String cuerpo = String.format(Locale.US,
            "Hola %s, recibimos tu pedido de %d unidad(es) de %s. Total: $%.2f. Gracias por elegir Sabor Express.",
            pedido.getCliente(), pedido.getCantidad(), pedido.getPlato().getNombre(), pedido.getTotal());
        mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }
}
