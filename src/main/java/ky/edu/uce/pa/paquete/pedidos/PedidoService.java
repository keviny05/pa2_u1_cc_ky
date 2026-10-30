package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import ky.edu.uce.pa.paquete.interceptors.Auditoria;
import ky.edu.uce.pa.paquete.interceptors.NotificarSMS;

@ApplicationScoped
public class PedidoService {

    @Auditoria 
    @NotificarSMS
    public String realizar(Pedido pedido) {
        System.out.println("Realizado pedido...");
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Teléfono: " + pedido.getTelefono());
        System.out.println("Pedido realizado con exito");
        return "Pedido realizado con exito";

    }


}
