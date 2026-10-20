package   ky.edu.uce.pa.paquete.restaurante;

public class MailService {
    // Simula el envío; no conecta a un servidor real de correo.
    public void enviar(String correo, String asunto, String cuerpo) {
        System.out.println("\n--- CONFIRMACION DE CORREO (SIMULADA) ---");
        System.out.println("Destinatario: " + correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + cuerpo);
        System.out.println("----------------------------------------");
    }
}
