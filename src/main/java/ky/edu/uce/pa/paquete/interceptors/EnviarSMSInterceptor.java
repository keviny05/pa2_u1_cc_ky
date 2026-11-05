package ky.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ky.edu.uce.pa.paquete.pedidos.Pedido;
import ky.edu.uce.pa.paquete.pedidos.SMSService;

@EnviarSMS 
@Interceptor
@Priority(Interceptor.Priority.APPLICATION + 3)
public class EnviarSMSInterceptor {
    @Inject 
    private SMSService smsService;


    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("Interceptando el metodo: " + context.getMethod().getName() + " para enviar un SMS");


        Object resultado = context.proceed();

        System.out.println("El método se ejecutó correctamente. Procediendo a enviar el SMS...");


        Object[] valores = context.getParameters();
        
        if (valores != null && valores.length > 0 && valores[0] instanceof Pedido) {
            Pedido pedido = (Pedido) valores[0];

            String cliente = pedido.getCliente();
            String telefono = pedido.getTelefono();
            double total = pedido.getTotal();

            String mensaje = "Hola " + cliente + ", su pedido por un total de $" + total + " ha sido procesado con éxito.";

            this.smsService.enviar(telefono, mensaje);
            
            System.out.println("SMS enviado exitosamente a: " + telefono);
        } else {
            System.out.println("No se encontró un objeto Pedido en los parámetros para enviar el SMS.");
        }

        return resultado;
    }



}
