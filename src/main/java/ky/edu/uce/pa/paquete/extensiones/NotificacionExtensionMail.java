package ky.edu.uce.pa.paquete.extensiones;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class NotificacionExtensionMail implements NotificacionExtension {

    @Override
    public void enviar(String mensaje, String destinatario) {

        System.out.println("Enviando correo a " + destinatario + " con el mensaje: " + mensaje);
        System.out.println("Correo enviado con exito");

    }

}
