package ky.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@TiempoDeInicio
@Interceptor
@Priority (Interceptor.Priority.APPLICATION)
public class TiempodeInicioInterceptor {

    @AroundInvoke 
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("Hora de inicio de la sesion: " + java.time.LocalDateTime.now());

        Object resultado = context.proceed();
        
        System.out.println("Hora de finalizacion de la sesion: " + java.time.LocalDateTime.now());
        
        return resultado;
    }

}
