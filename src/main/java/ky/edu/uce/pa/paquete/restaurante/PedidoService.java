package     ky.edu.uce.pa.paquete.restaurante;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PedidoService {

    @Inject
    MailService mailService;

    public void realizar(Pedido pedido) {
        System.out.println("\n PEDIDO REGISTRADO ");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Plato: " + pedido.getPlato().getNombre());
        System.out.println("Cantidad: " + pedido.getCantidad());
        System.out.printf("Precio unitario: $%.2f%n", pedido.getPlato().getPrecio());
        System.out.printf("Total: $%.2f%n", pedido.getTotal());
        System.out.println("Estado: En preparacion");

        String asunto = "Confirmacion de pedido - Sabor Express";
        String cuerpo = String.format(
            "Hola %s, recibimos tu pedido de %d unidad(es) de %s. Total: $%.2f. Gracias por elegir Sabor Express.",
            pedido.getCliente(), pedido.getCantidad(), pedido.getPlato().getNombre(), pedido.getTotal());

        mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }
}