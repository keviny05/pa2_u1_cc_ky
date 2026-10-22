package ky.edu.uce.pa.paquete.pedidos;

import io.quarkus.arc.Unremovable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

//@ApplicationScoped //Delego el control al contenedor ArC de CDI para que gestione el ciclo de vida de la clase
//@RequestScoped
@Singleton
@Named("mail") 
public class MailService implements Notificacion {

    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("Enviando correo a: "+ destino);
        System.out.println("Cuerpo: " + mensaje);
        System.out.println("Correo enviado con exito");
    }

}
