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