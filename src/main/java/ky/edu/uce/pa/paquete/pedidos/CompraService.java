package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import ky.edu.uce.pa.paquete.extensiones.NotificacionExtension;

@ApplicationScoped 
public class CompraService {
    
    public void realizar(Compra compra, NotificacionExtension notificacionExtension) {
        System.out.println("Realizado compra...");
        System.out.println(" " + compra.getCliente());
        System.out.println(" " + compra.getProducto());
        System.out.println(" " + compra.getTotal());
        System.out.println(" " + compra.getCorreo());
        System.out.println("Compra realizada con exito");

        //aqui voy a programar el envio de la notificacion
        notificacionExtension.enviar("Su pedido ha sido realizado con exito", compra.getCliente());
        


    }

}
