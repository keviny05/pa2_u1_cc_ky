package ky.edu.uce.pa.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class NotificacionExtensionWhatsApp  implements NotificacionExtension {

    @Override
    public void enviar(String mensaje, String destinatario) {

        System.out.println("Enviando WhatsApp a " + destinatario + " con el mensaje: " + mensaje);
        System.out.println("WhatsApp enviado con exito");

    }

}
