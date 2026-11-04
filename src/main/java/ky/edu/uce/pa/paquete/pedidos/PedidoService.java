package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import ky.edu.uce.pa.paquete.interceptors.Auditoria;

@ApplicationScoped
public class PedidoService {

    @Auditoria 
    public String realizar(Pedido pedido) {
        long tiempoInicio = System.currentTimeMillis();
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
                long tiempoFin = System.currentTimeMillis();
        long tiempoEjecucion = tiempoFin - tiempoInicio;
        System.out.println("Tiempo de ejecución del método realizar: " + tiempoEjecucion + " ms");


        return "Pedido realizado con exito";

    }


}
