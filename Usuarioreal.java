public class Usuarioreal {
    private int id;
    private String nombre;
    private String correo;
    private String contraseña;

    public Usuario(int id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    // Getters y setters para cada atributo
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getContraseña() { return contraseña; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
