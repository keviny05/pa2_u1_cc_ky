package ky.edu.uce.pa.paquete.descuentos;

public interface CalculadoraDescuento {
    public double calcular(double monto);

    public String getId();

    public double getPorcentaje();
}
