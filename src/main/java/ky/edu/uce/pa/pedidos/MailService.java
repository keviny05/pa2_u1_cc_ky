package ky.edu.uce.pa.pedidos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

@ApplicationScoped //Delego el control al contenedor ArC de CDI para que gestione el ciclo de vida de la clase
//@RequestScoped
//@Singleton 
public class MailService {
    public void enviar(String correo, String asunto, String cuerpo){
        System.out.println("Enviando correo a: "+ correo);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
        System.out.println("Correo enviado con exito");
    }

}
