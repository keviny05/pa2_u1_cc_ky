
package ky.edu.uce.pa.paquete;

import ky.edu.uce.pa.paquete.restaurante.Pedido;
import ky.edu.uce.pa.paquete.restaurante.PedidoService;
import ky.edu.uce.pa.paquete.restaurante.Plato;



public class App {
    public static void main(String[] args) {
    
        PedidoService pedidoService = new PedidoService();

        try {
  
            Plato platoDirecto = new Plato(
                "Hamburguesa Clásica", 
                "Carne, queso, lechuga y tomate", 
                5.50
            );


            Pedido pedido = new Pedido(
                "Carlos Pérez",           
                platoDirecto,             
                2,                        
                "carlos.perez@email.com"  
            );


            pedidoService.realizar(pedido);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en el pedido: " + e.getMessage());
        }
    }
}