package ky.edu.uce.pa.paquete.descuentos;

public class Venta {
    private int numero;
    private TipoCliente tipo;
    private double monto;

    public Venta() {

    }

    public Venta(int numero, TipoCliente tipo, double monto) {
        this.numero = numero;
        this.tipo = tipo;
        this.monto = monto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
