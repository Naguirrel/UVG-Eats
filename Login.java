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
    public boolean iniciarSesion(String correoElectronico, String contrasena) {
        if (usuariosRegistrados.containsKey(correoElectronico)) {
            Usuario usuario = usuariosRegistrados.get(correoElectronico);
            if (usuario.verificarContrasena(contrasena)) {
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso.");
                return true;
            } else {
                System.out.println("Contraseña incorrecta.");
            }
        } else {
            System.out.println("Correo electrónico no encontrado.");
        }
        return false;
    }

    public void cerrarSesion() {
        if (usuarioActual != null) {
            System.out.println("Sesión cerrada para " + usuarioActual.getCorreoElectronico());
            usuarioActual = null;
        } else {
            System.out.println("No hay usuario activo.");
        }
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
