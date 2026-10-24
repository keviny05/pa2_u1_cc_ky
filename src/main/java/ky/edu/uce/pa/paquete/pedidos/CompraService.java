package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped 
public class CompraService {
    
    @Inject 
    @Named ("mail")
    private Notificacion notificacionCorreo;

    public void realizar(Compra compra) {
        System.out.println("Realizado compra...");
        System.out.println(" " + compra.getCliente());
        System.out.println(" " + compra.getProducto());
        System.out.println(" " + compra.getTotal());
        System.out.println(" " + compra.getCorreo());

        String cuerpo = "Estimado " + compra.getCliente() + ", su compra de " +
                compra.getProducto() + " por un total de $" + compra.getTotal() +
                " ha salido con exito";

        //Notificacion de compra por correo electronico
        this.notificacionCorreo.enviar(compra.getCorreo(), cuerpo);
        this.notificacionCorreo.setCantidad(this.notificacionCorreo.getCantidad() + 1);

        System.out.println("Cantidad de correos enviados: " + this.notificacionCorreo.getCantidad());
        System.out.println("Nombre: " + this.notificacionCorreo.getNombre());

    
    }

}
