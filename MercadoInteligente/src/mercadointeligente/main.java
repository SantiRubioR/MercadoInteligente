
package mercadointeligente;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class main {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>();
        List<Integer> cantidad = new ArrayList<>();
        List<Double> precios = new ArrayList<>();
        menu.add("Monitor");
        cantidad.add(5);
        precios.add(75.0);
        menu.add("Grafica");
        cantidad.add(10);
        precios.add(145.0);
        menu.add("Mouse");
        cantidad.add(12);
        precios.add(35.0);
 
        // Se inicializan las listas para guardar el pedido del cliente
        List<String> pedido = new ArrayList<>();
        List<Double> totalPedido = new ArrayList<>();
 
        // Scanner para leer la entrada del usuario
        Scanner entrada = new Scanner(System.in);
        boolean salir = false;
 
        while (!salir) {
            // Menú de opciones
            System.out.println("");
            System.out.println("-- MENU --");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i) + " - Cantidad: " + cantidad.get(i) + " - $ " + precios.get(i));
            }
 
            System.out.println("");
            System.out.println("1. AGREGAR PRODUCTO AL CARRITO");
            System.out.println("2. VER CARRITO Y TOTAL A PAGAR");
            System.out.println("3. ELIMINAR PRODUCTO DEL CARRITO");
            System.out.println("4. FINALIZAR COMPRA");
            System.out.println("5. SALIR");
            System.out.println("");
            System.out.print("Elige una opción: ");
            int opcion = entrada.nextInt();
 
            switch (opcion) {
                case 1:
            System.out.println("Seleccione el número del producto que desea añadir al carrito:");
            int seleccion = entrada.nextInt();
 
            if (seleccion > 0 && seleccion <= menu.size()) {
            int index = seleccion - 1;
 
            // 🔹 Verificar si hay stock disponible
            if (cantidad.get(index) > 0) {
            pedido.add(menu.get(index));
            totalPedido.add(precios.get(index));
 
            // 🔹 Reducir la cantidad disponible en inventario
            cantidad.set(index, cantidad.get(index) - 1);
 
            System.out.println(menu.get(index) + " *** Se ha añadido al pedido");
            } else {
            System.out.println("Lo siento, " + menu.get(index) + " está agotado.");
            }
            } else {
            System.out.println("Opción inválida");
            }
            break;
 
                case 2:
                    System.out.println("");
                    System.out.println("Inventario actual");
                    if (pedido.isEmpty()) {
                    System.out.println("El carrito está vacío.");
                    } else {
                    double total = 0;
                    for (int i = 0; i < pedido.size(); i++) {
                    System.out.println((i + 1) + ". " + pedido.get(i) + " - $ " + totalPedido.get(i));
                    total += totalPedido.get(i);
                    }
                    System.out.println("");
                    System.out.println("Total a pagar: $" + total);
                    }
                    break;
 
                case 3:
                    System.out.println("Seleccione el número del producto que desea eliminar del carrito:");
                    for (int i = 0; i < pedido.size(); i++) {
                        System.out.println((i + 1) + ". " + pedido.get(i) + " - $ " + totalPedido.get(i));
                    }
 
                    int seleccionEliminar = entrada.nextInt();
                    if (seleccionEliminar > 0 && seleccionEliminar <= pedido.size()) {
                        System.out.println(pedido.get(seleccionEliminar - 1) + " *** Se ha eliminado del carrito");
                        pedido.remove(seleccionEliminar - 1);
                        totalPedido.remove(seleccionEliminar - 1);
                    } else {
                        System.out.println("Opción inválida");
                    }
                    break;
 
                case 4:
   
                    if (pedido.isEmpty()) {
                        System.out.println("No tienes productos en el carrito.");
                    } else {
                        
                        System.out.println("");
                        System.out.println("Ticket de compra 1279");
                        System.out.println("");
                        System.out.println("Productos comprados:");
                        double totalFinal = 0;
                        for (int i = 0; i < pedido.size(); i++) {
                            System.out.println((i + 1) + ". " + pedido.get(i) + " - $ " + totalPedido.get(i));
                            totalFinal += totalPedido.get(i);
                        }
                        System.out.println("Total a pagar: $" + totalFinal);
                        System.out.println("");
                        System.out.println("--- COMPRA FINALIZADA ---");
                        System.out.println("");
                        System.out.println("¡Gracias por tu compra!");
                    }
                    
                    break;

 
                case 5:
                    System.out.println("Saliendo del programa...");
                    salir = true;
                    break;
 
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        entrada.close();
    }
}
