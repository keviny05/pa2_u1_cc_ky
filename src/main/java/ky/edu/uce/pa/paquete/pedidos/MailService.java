package ky.edu.uce.pa.paquete.pedidos;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//Ambitos y contextos
//@ApplicationScoped // su ambito es toda la aplicacion, se crea una sola instancia y se comparte entre todos los componentes que lo inyecten
//@RequestScoped // su ambito es para aplicaciones web, su ambito es una sola peticion request/http, se crea una instancia por cada peticion y se destruye al finalizar la peticion,  se comparte entre todos los componentes que lo inyecten en la misma peticion
@Singleton // su ambito es toda la aplicacion, se crea una sola instancia y se comparte entre todos los componentes que lo inyecten
//@SessionScoped // su ambito es para aplicaciones web, su ambito es una sola sesion del usuario, se crea una instancia por cada sesion y se destruye al finalizar la sesion,  se comparte entre todos los componentes que lo inyecten en la misma sesion
//@Dependent // su ambito es durante la inyeccion de dependencias, se crea una instancia por cada inyeccion y se destruye al finalizar la inyeccion, no se comparte entre componentes
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
