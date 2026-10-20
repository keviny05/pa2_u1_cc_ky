package   ky.edu.uce.pa.paquete.restaurante;

public class MailService {
    public void enviar(String correo, String asunto, String cuerpo) {
        System.out.println("\n--- CONFIRMACION DE CORREO ---");
        System.out.println("Destinatario: " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + cuerpo);
    }
}
