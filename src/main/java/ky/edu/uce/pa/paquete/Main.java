package ky.edu.uce.pa.paquete;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ky.edu.uce.pa.paquete.pedidos.Compra;
import ky.edu.uce.pa.paquete.pedidos.CompraService;
import ky.edu.uce.pa.paquete.pedidos.Pedido;
import ky.edu.uce.pa.paquete.pedidos.PedidoService;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    @Inject
    private CompraService compraService;

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicacion Quarkus...");
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Aplicacion Quarkus corriendo...");

        Pedido pedido = new Pedido(
            "Juan",
            "laptop",
            15000.0,
            "juan@gmail.com"
        );
        pedido.setTelefono("1234567890");

        pedidoService.realizar(pedido);

        Compra compra = new Compra(
            "Maria",
            "smartphone",
            8000.0,
            "maria@gmail.com"
        );
        compra.setTelefono("0987654321");
        this.compraService.realizar(compra);

        return 0;
    }
}