package ky.edu.uce.pa.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class NotificacionExtensionSMS implements NotificacionExtension {

    @Override
    public void enviar(String mensaje, String destinatario) {

        System.out.println("Enviando SMS a " + destinatario + " con el mensaje: " + mensaje);
        System.out.println("SMS enviado con exito");

    }

}
