package ky.edu.uce.pa.paquete.descuentos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.UUID;

@ApplicationScoped
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {

    private static final double PORCENTAJE = 0.05;
    private final String id = UUID.randomUUID().toString();

    @Override
    public double calcular(double monto) {
        return monto * PORCENTAJE;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getPorcentaje() {
        return PORCENTAJE * 100;
    }

}
