package ky.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ky.edu.uce.pa.paquete.pedidos.AuditoriaService;
import ky.edu.uce.pa.paquete.pedidos.MailService;
import ky.edu.uce.pa.paquete.pedidos.Pedido;

@EnviarMail 
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 4)
public class EnviarMailInterceptor {

    @Inject 
    private MailService mailService;


    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("Interceptando el metodo: " + context.getMethod().getName() + " para enviar un correo electronico");


        Object resultado = context.proceed();

        System.out.println("El método se ejecutó correctamente. Procediendo a enviar el correo...");

        Object[] valores = context.getParameters();
        
        if (valores != null && valores.length > 0 && valores[0] instanceof Pedido) {
            Pedido pedido = (Pedido) valores[0];

            String cliente = pedido.getCliente();
            String correoDestino = pedido.getCorreo();
            double total = pedido.getTotal();

            String mensaje = "Hola " + cliente + ", su pedido por un total de $" + total + " ha sido procesado con éxito.";

            this.mailService.enviar(correoDestino, mensaje);
            
            System.out.println("Correo enviado exitosamente a: " + correoDestino);
        } else {
            System.out.println("No se encontró un objeto Pedido en los parámetros para enviar el correo.");
        }

        return resultado;
    }



}
