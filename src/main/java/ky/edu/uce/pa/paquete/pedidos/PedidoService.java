package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped // Delego el control al contenedor ArC de CDI para que gestione el ciclo de vida
//@RequestScoped // Delego el control al contenedor ArC de CDI para que gestione el ciclo de vida
//@Singleton 
public class PedidoService {

    /* 
    @Inject
    private MailService mailService;*/

    /* 
    private MailService mailService;
    //Inyección de dependencias a través del constructor
    @Inject 
    public PedidoService(MailService mailService) {
        this.mailService = mailService;
    }*/

    
    private MailService mailService;

    //Inyección de dependencias a través del setter(Metodo)
    @Inject 
    public void setMailService(MailService mailService) {
        System.out.println("Se inyecta el servicio de correo");
        this.mailService = mailService;
    }

    public void realizar(Pedido pedido) {
        System.out.println("Realizado pedido...");
        System.out.println(" " + pedido.getCliente());
        System.out.println(" " + pedido.getProducto());
        System.out.println(" " + pedido.getTotal());
        System.out.println(" " + pedido.getCorreo());

        String asunto = "Confirmacion de pedido";
        String cuerpo = "Estimado " + pedido.getCliente() + ", su pedido de" +
                pedido.getProducto() + " por un total de $" + pedido.getTotal() +
                " ha salido con exito";

        this.mailService.enviar(pedido.getCorreo(), asunto, cuerpo);
    }


}
