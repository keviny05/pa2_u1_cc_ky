package ky.edu.uce.pa.paquete.pedidos;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

@Singleton // su ambito es toda la aplicacion, se crea una sola instancia y se comparte entre todos los componentes que lo inyecten
@Named("mail") 
public class MailService implements Notificacion {

    private Integer cantidad = 0;
    private String nombre;

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: "+ destino);
        System.out.println("Cuerpo: " + mensaje);
        System.out.println("Correo enviado con exito");
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
