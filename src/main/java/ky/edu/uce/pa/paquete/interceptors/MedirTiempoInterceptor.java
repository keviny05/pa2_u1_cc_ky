package ky.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import ky.edu.uce.pa.paquete.pedidos.AuditoriaService;

@MedirTiempo 
@Interceptor
@Priority (Interceptor.Priority.APPLICATION + 1)
public class MedirTiempoInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("Interceptando el metodo: " + context.getMethod().getName() + " para medir el tiempo de ejecucion");

        long inicio = System.currentTimeMillis();

        Object resultado = context.proceed();

        long fin = System.currentTimeMillis();
        long duracionMilis = fin - inicio;

        String nombreMetodo = context.getMethod().getName();
        System.out.println("El metodo [" + nombreMetodo + "] tomo " + duracionMilis + " ms en ejecutarse.");

        return resultado;
    }


}
