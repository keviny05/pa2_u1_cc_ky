package ky.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import ky.edu.uce.pa.paquete.descuentos.Auditoria;
import ky.edu.uce.pa.paquete.descuentos.TipoCliente;
import ky.edu.uce.pa.paquete.descuentos.Venta;
import ky.edu.uce.pa.paquete.descuentos.VentaService;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private VentaService ventaService;

    @Inject
    private Auditoria auditoriaMain;
    public static void main(String[] args) {
        System.out.println("Iniciando la aplicacion Quarkus...");
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Aplicacion Quarkus corriendo...");

        Venta venta1 = new Venta(1, TipoCliente.REGULAR, 100.0);
        Venta venta2 = new Venta(2, TipoCliente.VIP, 200.0);
        Venta venta3 = new Venta(3, TipoCliente.REGULAR, 300.0);
        Venta venta4 = new Venta(4, TipoCliente.VIP, 500.0);

        this.ventaService.realizar(venta1);
        this.ventaService.realizar(venta2);
        this.ventaService.realizar(venta3);
        this.ventaService.realizar(venta4);

        System.out.println("=== Observacion de scopes ===");
        System.out.println("VentaService:                     " + this.ventaService.getId().substring(0, 8));
        System.out.println("Auditoria inyectada en Main:      " + this.auditoriaMain.getId().substring(0, 8));
        System.out.println("Auditoria inyectada en Venta:     " + this.ventaService.getIdAuditoria().substring(0, 8));
    
        return 0;
    }
}
