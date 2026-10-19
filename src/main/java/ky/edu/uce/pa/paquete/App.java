
package ky.edu.uce.pa.paquete;

import java.util.Scanner;

import ky.edu.uce.pa.paquete.restaurante.MenuRestaurante;
import ky.edu.uce.pa.paquete.restaurante.Pedido;
import ky.edu.uce.pa.paquete.restaurante.PedidoService;
import ky.edu.uce.pa.paquete.restaurante.Plato;




public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            MenuRestaurante menu = new MenuRestaurante();
            PedidoService pedidoService = new PedidoService();

            System.out.println("   BIENVENIDO A SABOR EXPRESS");
            menu.mostrarMenu();

            System.out.print("Nombre del cliente: ");
            String cliente = scanner.nextLine().trim();

            System.out.print("Numero del plato que desea: ");
            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un numero de plato valido.");
                return;
            }

            Plato plato = menu.buscarPlato(opcion);
            if (plato == null) {
                System.out.println("Error: el plato seleccionado no existe.");
                return;
            }

            System.out.print("Cantidad: ");
            int cantidad;
            try {
                cantidad = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese una cantidad numerica.");
                return;
            }

            System.out.print("Correo electronico: ");
            String correo = scanner.nextLine().trim();

            try {
                Pedido pedido = new Pedido(cliente, plato, cantidad, correo);
                pedidoService.realizar(pedido);
                System.out.println("\nGracias por comprar en Sabor Express.");
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo registrar el pedido: " + e.getMessage());
            }
        }
    }
}
