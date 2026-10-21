
package ky.edu.uce.pa.paquete;


import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import ky.edu.uce.pa.paquete.restaurante.Pedido;
import ky.edu.uce.pa.paquete.restaurante.PedidoService;
import ky.edu.uce.pa.paquete.restaurante.Plato;

@QuarkusMain
public class App implements QuarkusApplication {

    @Inject
    PedidoService pedidoService;

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicacion Quarkus...");
        Quarkus.run(App.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        Plato plato = new Plato("Ceviche", "Camaron con limon y cebolla", 8.50);
        Pedido pedido = new Pedido("Juan", plato, 2, "juan@gmail.com");

        pedidoService.realizar(pedido);

        return 0;
    }
}