package ky.edu.uce.pa.paquete.pedidos;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import ky.edu.uce.pa.paquete.interceptors.Auditoria;
import ky.edu.uce.pa.paquete.interceptors.EnviarMail;
import ky.edu.uce.pa.paquete.interceptors.EnviarSMS;
import ky.edu.uce.pa.paquete.interceptors.MedirTiempo;
import ky.edu.uce.pa.paquete.interceptors.TiempoDeInicio;

@ApplicationScoped
public class PedidoService {

    @Auditoria 
    @MedirTiempo
    @EnviarSMS 
    @EnviarMail 
    @TiempoDeInicio 
    public String realizar(Pedido pedido) {
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
