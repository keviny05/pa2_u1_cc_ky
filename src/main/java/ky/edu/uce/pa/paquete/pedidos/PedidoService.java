package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@ApplicationScoped // Delego el control al contenedor ArC de CDI para que gestione el ciclo de vida
//@RequestScoped // Delego el control al contenedor ArC de CDI para que gestione el ciclo de vida
//@Singleton 
public class PedidoService {

    @Inject 
    @Named ("mail")
    private Notificacion notificacionCorreo;

    @Inject
    @Named ("sms")
    private Notificacion notificacionSMS;

    public void realizar(Pedido pedido) {
        System.out.println("Realizado pedido...");
        System.out.println(" " + pedido.getCliente());
        System.out.println(" " + pedido.getProducto());
        System.out.println(" " + pedido.getTotal());
        System.out.println(" " + pedido.getCorreo());

        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de" +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha salido con exito";

        //Notificacion de pedido por correo electronico
        this.notificacionCorreo.enviar(pedido.getCorreo(), cuerpo);

        //Notificacion de pedido por SMS
        this.notificacionSMS.enviar(pedido.getTelefono(), cuerpo);

    }


}
