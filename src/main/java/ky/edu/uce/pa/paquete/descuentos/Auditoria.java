package ky.edu.uce.pa.paquete.descuentos;

import jakarta.enterprise.context.Dependent;

import java.util.UUID;

@Dependent
public class Auditoria {

    private final String id = UUID.randomUUID().toString();

    public void registrar(String mensaje) {
        System.out.println("[Auditoria " + corto() + "] " + mensaje);
    }

    public String getId() {
        return id;
    }

    private String corto() {
        return id.substring(0, 8);
    }
}
