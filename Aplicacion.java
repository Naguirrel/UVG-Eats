import java.util.Scanner;
import java.util.ArrayList;

public class Aplicacion {
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static Login login = new Login();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Registrar un usuario para prueba
        login.registrarUsuario("juan@gmail.com", "1234");

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    if (login.getUsuarioActual() != null) {
                        hacerPedido();
                    } else {
                        System.out.println("Debes iniciar sesión primero.");
                    }
                    break;
                case 3:
                    if (login.getUsuarioActual() != null) {
                        verPedido();
                    } else {
                        System.out.println("Debes iniciar sesión primero.");
                    }
                    break;
                case 4:
                    cerrarSesion();
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n--- Menú de la Aplicación de Comida ---");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Hacer pedido");
        System.out.println("3. Ver pedido");
        System.out.println("4. Cerrar sesión");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();
        if (login.iniciarSesion(correo, contrasena)) {
            System.out.println("Sesión iniciada con éxito.");
        }
    }

    private static void hacerPedido() {
        System.out.print("Describe tu pedido: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingresa el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        Pedido nuevoPedido = new Pedido(descripcion, precio);
        pedidos.add(nuevoPedido);
        System.out.println("Pedido realizado correctamente.");

        // Enviar correo con el pedido
        String destinatario = login.getUsuarioActual().getCorreoElectronico();
        String asunto = "Confirmación de tu pedido";
        String cuerpo = "Has realizado el siguiente pedido:\n" + nuevoPedido.toString();
        EnviarCorreo.enviar(destinatario, asunto, cuerpo);
    }

    private static void verPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("No tienes pedidos aún.");
        } else {
            System.out.println("--- Tus pedidos ---");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    private static void cerrarSesion() {
        login.cerrarSesion();
    }
}

