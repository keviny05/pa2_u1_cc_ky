package ky.edu.uce.pa.paquete.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton
@Named("sms")
public class SMSService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando SMS a: "+ destino);
        System.out.println("Cuerpo: " + mensaje);
        System.out.println("SMS enviado con exito");
    }

    @Override
    public Integer getCantidad() {
        return null;
    }

    @Override
    public void setCantidad(Integer cantidad) {
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public void setNombre(String nombre) {}

}
