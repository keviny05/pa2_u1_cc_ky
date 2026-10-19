package     ky.edu.uce.pa.paquete.restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRestaurante {
    private final List<Plato> platos = new ArrayList<>();

    public MenuRestaurante() {
        platos.add(new Plato("Hamburguesa", "Carne, queso, lechuga y tomate", 5.50));
        platos.add(new Plato("Pizza familiar", "Pizza de queso y pepperoni", 12.00));
        platos.add(new Plato("Pollo asado", "Pollo con papas y ensalada", 7.00));
        platos.add(new Plato("Ensalada César", "Lechuga, pollo, queso y aderezo", 4.50));
        platos.add(new Plato("Jugo natural", "Jugo de frutas de temporada", 1.50));
    }

    public List<Plato> getPlatos() { return Collections.unmodifiableList(platos); }

    public void mostrarMenu() {
        System.out.println("\n===== MENU SABOR EXPRESS =====");
        for (int i = 0; i < platos.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, platos.get(i));
        }
        System.out.println("==============================");
    }

    public Plato buscarPlato(int numero) {
        if (numero < 1 || numero > platos.size()) return null;
        return platos.get(numero - 1);
    }
}
