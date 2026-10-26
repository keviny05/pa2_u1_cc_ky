# Simulador de descuentos con Quarkus
## Preguntas de análisis

**1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?**

IoC: ninguna clase de negocio se crea con `new`, el contenedor ArC crea y administra `VentaService`, `DescuentoRegular`, `DescuentoVIP` y `Auditoria`, y decide cuándo nacen y mueren.

DI: es el mecanismo con el que el contenedor entrega esas dependencias a `VentaService`: por constructor las dos calculadoras y por atributo `Auditoria`.

**2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?**

Permiten distinguir entre varios componentes que implementan el mismo tipo. Con `@Named("regular")` y `@Named("vip")` en las clases y en los puntos de inyección, el contenedor sabe exactamente qué implementación de `CalculadoraDescuento` inyectar. Sin ellos, el tipo por sí solo es ambiguo.

**3. ¿Cuál es la diferencia entre `@ApplicationScoped` y `@Dependent`?**

`@ApplicationScoped`: una única instancia accedida mediante proxy cliente compartida por toda la aplicación, creada y destruida al cerrar el contenedor. 

`@Dependent`: no hay instancia compartida; cada punto de inyección recibe una instancia nueva cuyo ciclo de vida depende del componente que la recibe en la salida se ve en los UUID distintos de `Auditoria`.

**4. ¿Por qué las instancias `@ApplicationScoped` pueden reutilizarse entre varias ventas?**

Porque el contenedor mantiene una sola instancia durante toda la vida de la aplicación y todas las inyecciones apuntan a ella. Estos componentes no guardan estado propio por venta solo un UUID inmutable y lógica de cálculo, así que es seguro compartirlos. El mismo UUID de `VentaService` en las 4 ventas lo demuestra.

**5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de `CalculadoraDescuento`?**

Habría dos componentes candidatos `DescuentoRegular` y `DescuentoVIP` por lo que ArC lanzaría `AmbiguousResolutionException` (error de despliegue: *Ambiguous dependencies for type CalculadoraDescuento*) y la aplicación no arrancaría.

