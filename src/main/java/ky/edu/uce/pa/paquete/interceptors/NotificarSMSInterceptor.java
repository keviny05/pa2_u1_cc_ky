package ky.edu.uce.pa.paquete.interceptors;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ky.edu.uce.pa.paquete.pedidos.Notificacion;
import ky.edu.uce.pa.paquete.pedidos.Pedido;

@NotificarSMS
@Interceptor
public class NotificarSMSInterceptor {

    @Inject
    @Named("sms")
    private Notificacion notificacionSMS;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        
        Object resultado = context.proceed();

        Pedido pedido = null;

        for (Object valor : context.getParameters()) {
            if (valor instanceof Pedido) {
                pedido = (Pedido) valor;
                break;
            }
        }

        System.out.println("----------------------------------------");

        if (pedido == null) {
            System.out.println("NotificarSMS: el metodo " + context.getMethod().getName()
                    + " no recibe un Pedido, no se envia SMS");
            return resultado;
        }

        String mensaje = "Hola " + pedido.getCliente() + ", tu pedido de "
                + pedido.getProducto() + " por $" + pedido.getTotal()
                + " fue realizado con exito";

        this.notificacionSMS.enviar(pedido.getTelefono(), mensaje);

        return resultado;
    }
        
}

