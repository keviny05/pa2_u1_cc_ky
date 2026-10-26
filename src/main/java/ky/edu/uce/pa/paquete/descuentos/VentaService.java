package ky.edu.uce.pa.paquete.descuentos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.UUID;

@ApplicationScoped 
public class VentaService {

    private final String id = UUID.randomUUID().toString();
    private final CalculadoraDescuento descuentoRegular;
    private final CalculadoraDescuento descuentoVip;

    @Inject
    private Auditoria auditoria;

    @Inject
    public VentaService(@Named("regular") CalculadoraDescuento descuentoRegular,
                        @Named("vip") CalculadoraDescuento descuentoVip) {
        this.descuentoRegular = descuentoRegular;
        this.descuentoVip = descuentoVip;
    }

    public void realizar(Venta venta) {
        int numero = venta.getNumero();
        TipoCliente tipo = venta.getTipo();
        double monto = venta.getMonto();

        System.out.println("Realizando venta " + numero);

        CalculadoraDescuento calculadora = (tipo == TipoCliente.VIP) ? this.descuentoVip : this.descuentoRegular;

        double descuento = calculadora.calcular(monto);
        double total = monto - descuento;

        System.out.println(" Tipo: " + tipo);
        System.out.println(" Monto: $" + String.format(java.util.Locale.US, "%.2f", monto));
        System.out.println(" Descuento: " + (int) calculadora.getPorcentaje() + "% = $" + String.format(java.util.Locale.US, "%.2f", descuento));
        System.out.println(" Total: $" + String.format(java.util.Locale.US, "%.2f", total));

        this.auditoria.registrar("Venta " + numero + " " + tipo
                + " | VentaService=" + this.id.substring(0, 8)
                + " | Calculadora=" + calculadora.getId().substring(0, 8));

        System.out.println();
    }

    public String getId() {
        return id;
    }

    public String getIdAuditoria() {
        return auditoria.getId();
    }
}
