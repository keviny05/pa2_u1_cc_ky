package ky.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ky.edu.uce.pa.paquete.pedidos.AuditoriaService;
import ky.edu.uce.pa.paquete.pedidos.Pedido;

@Auditoria
@Interceptor 
public class AuditoriaInterceptor {
    
    @Inject 
    private AuditoriaService auditoriaService;

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {

        //Todo lo que esta arriba se ejecuta antes de que se ejecute el metodo interceptado
        Object resultado = context.proceed();
        System.out.println("Retorno: " + resultado);

        String nombreMetodo = context.getMethod().getName();
        System.out.println("Interceptando el metodo: " + nombreMetodo);
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor");

        Parameter[] parametros = context.getMethod().getParameters();
        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = context.getParameters();
        Pedido pedido = (Pedido) valores[0];

        String cliente =  pedido.getCliente();
        double total =  pedido.getTotal();
        String correo = pedido.getCorreo();

        this.auditoriaService.guardarEnLaBaseDeDatos(cliente, total, correo);


        System.out.println("Metodo luego de que se ejecuta el metodo interceptado");
        return resultado;
    }

}
