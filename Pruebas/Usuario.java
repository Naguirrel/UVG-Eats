public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private String carnet;
    private String numTarjeta;

    public Usuario(int id, String nombre, String apellido, int edad, String carrera, String carnet, String numTarjeta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.carnet = carnet;
        this.numTarjeta = numTarjeta;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public String toCSV() {
        return id + "," + nombre + "," + apellido + "," + edad + "," + carrera + "," + carnet + "," + numTarjeta;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Edad: " + edad + 
               ", Carrera: " + carrera + ", Carnet: " + carnet + ", NumTarjeta: " + numTarjeta;
    }
}
