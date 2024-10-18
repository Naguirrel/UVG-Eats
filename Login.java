import java.util.HashMap;

public class Login {
    private HashMap<String, Usuario> usuariosRegistrados;
    private Usuario usuarioActual;

    public Login() {
        usuariosRegistrados = new HashMap<>();
    }

    public void registrarUsuario(String correoElectronico, String contrasena) {
        if (!usuariosRegistrados.containsKey(correoElectronico)) {
            Usuario nuevoUsuario = new Usuario(correoElectronico, contrasena);
            usuariosRegistrados.put(correoElectronico, nuevoUsuario);
            System.out.println("Usuario registrado correctamente.");
        } else {
            System.out.println("El correo electrónico ya está en uso.");
        }
    }