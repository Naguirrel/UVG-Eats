public class Usuario {
    private String correoElectronico;
    private String contrasena;

    public Usuario(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }
}