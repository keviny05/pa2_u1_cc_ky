package ky.edu.uce.pa.paquete;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ky.edu.uce.pa.paquete.extensiones.NotificacionExtensionMail;
import ky.edu.uce.pa.paquete.extensiones.NotificacionExtensionSMS;
import ky.edu.uce.pa.paquete.extensiones.NotificacionExtensionWhatsApp;
import ky.edu.uce.pa.paquete.pedidos.Compra;
import ky.edu.uce.pa.paquete.pedidos.CompraService;
import ky.edu.uce.pa.paquete.pedidos.Pedido;
import ky.edu.uce.pa.paquete.pedidos.PedidoService;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private CompraService compraService;

    @Inject 
    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject 
    private NotificacionExtensionSMS notificacionExtensionSMS;

    @Inject 
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;


    public static void main(String[] args) {
        System.out.println("Iniciando la aplicacion Quarkus...");
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Aplicacion Quarkus corriendo...");

        Compra compra = new Compra( "Juan Perez", "Computadora", 100.0, "juan@gmail.com");
        compraService.realizar(compra, notificacionExtensionMail);

        Compra compra1 = new Compra( "Maria Lopez", "Celular", 200.0, "maria@gmail.com");
        compraService.realizar(compra1, notificacionExtensionSMS);

        Compra compra2 = new Compra( "Pedro Gonzalez", "Tablet", 300.0, "pedro@gmail.com");
        compraService.realizar(compra2, notificacionExtensionWhatsApp);

        return 0;
    }
}