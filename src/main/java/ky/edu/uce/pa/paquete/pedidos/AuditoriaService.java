package ky.edu.uce.pa.paquete.pedidos;

import jakarta.inject.Singleton;
import java.time.LocalDateTime;

@Singleton 
public class AuditoriaService {
    public void guardarEnLaBaseDeDatos(String cliente, double total, String correo) {
        // Lógica para guardar la información en la base de datos
        System.out.println("Guardando en la base de datos la auditoria: " + "Cliente: " + cliente + ", Total: " + total + ", Correo: " + correo );
        System.out.println("Con fecha y hora: " + LocalDateTime.now());
    }

}
