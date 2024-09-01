package proyect.proy1.com.losglobitos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class controlador {

    private inventario inventario;
    private List<pedido> pedidos;

    // Constructor
    public controlador() {
        this.inventario = new inventario();
        this.pedidos = new ArrayList<>();
    }

    // Método para crear un nuevo pedido y generar una factura
    public void crearPedido() {
        Scanner scanner = new Scanner(System.in);

        // Recibir datos del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el contacto del cliente: ");
        String contactoCliente = scanner.nextLine();
        cliente cliente = new cliente(nombreCliente, contactoCliente);

        // Crear una lista de productos para el pedido
        List<producto> productos = new ArrayList<>();
        System.out.print("Ingrese la cantidad de productos a agregar: ");
        int cantidadProductos = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        for (int i = 0; i < cantidadProductos; i++) {
            System.out.print("Ingrese el nombre del producto: ");
            String nombreProducto = scanner.nextLine();
            System.out.print("Ingrese la descripción del producto: ");
            String descripcionProducto = scanner.nextLine();
            System.out.print("¿Es importado? (true/false): ");
            boolean esImportado = scanner.nextBoolean();
            System.out.print("Ingrese el precio del producto: ");
            double precioProducto = scanner.nextDouble();
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidadProducto = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            producto nuevoProducto = new producto(nombreProducto, descripcionProducto, esImportado, precioProducto, cantidadProducto);
            productos.add(nuevoProducto);
            //inventario.agregarProducto(nuevoProducto, cantidadProducto);
        }

        // Crear el pedido y agregarlo a la lista de pedidos
        pedido nuevoPedido = new pedido(cliente, productos);
        pedidos.add(nuevoPedido);

        // Generar factura para el pedido
        double impuesto = 0.16; // Ejemplo: 16% de impuesto
        factura nuevaFactura = new factura(nuevoPedido, impuesto);
        nuevaFactura.mostrarFactura();

        System.out.println("Pedido y factura creados exitosamente para el cliente: " + cliente.getNombre());
    }

    // Método para mostrar inventario
    public void mostrarInventario() {
        // Lógica para mostrar los productos en inventario (ejemplo básico)
        // Implementar lógica detallada según necesidad
        System.out.println("Inventario de productos:");
        // Aquí agregarías un loop para mostrar cada producto
    }

    // Método principal para iniciar la aplicación
    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Crear Pedido");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    crearPedido();
                    break;
                case 2:
                    mostrarInventario();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }
}
