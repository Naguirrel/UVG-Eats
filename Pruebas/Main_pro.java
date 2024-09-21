import java.io.*;
import java.util.*;

public class Main_pro {
    private static final String CSV_FILE_PATH = "usuarios.csv";
    private static int nextId = 1;

    public static void main(String[] args) {
        List<Usuario> usuarios = cargarUsuarios();

        Usuario nuevoUsuario = new Usuario(nextId++, "Juan", "Perez", 20, "Ingeniería", "2021001", "1234567890");
        usuarios.add(nuevoUsuario);
        guardarUsuarios(usuarios);

        modificarUsuario(usuarios, 1, "nombre", "Carlos");
        guardarUsuarios(usuarios);

        eliminarUsuario(usuarios, 1);
        guardarUsuarios(usuarios);

        mostrarUsuarios(usuarios);
    }

    public static List<Usuario> cargarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] campos = linea.split(",");
                Usuario usuario = new Usuario(
                    Integer.parseInt(campos[0]), campos[1], campos[2],
                    Integer.parseInt(campos[3]), campos[4], campos[5], campos[6]
                );
                usuarios.add(usuario);
                nextId = Math.max(nextId, usuario.getId() + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    public static void guardarUsuarios(List<Usuario> usuarios) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modificarUsuario(List<Usuario> usuarios, int id, String campo, String nuevoValor) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getId() == id) {
                switch (campo.toLowerCase()) {
                    case "nombre":
                        usuario = new Usuario(id, nuevoValor, usuario.getApellido(), usuario.getEdad(), usuario.getCarrera(), usuario.getCarnet(), usuario.getNumTarjeta());
                        break;
                    case "apellido":
                        usuario = new Usuario(id, usuario.getNombre(), nuevoValor, usuario.getEdad(), usuario.getCarrera(), usuario.getCarnet(), usuario.getNumTarjeta());
                        break;
                    case "edad":
                        usuario = new Usuario(id, usuario.getNombre(), usuario.getApellido(), Integer.parseInt(nuevoValor), usuario.getCarrera(), usuario.getCarnet(), usuario.getNumTarjeta());
                        break;
                    case "carrera":
                        usuario = new Usuario(id, usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), nuevoValor, usuario.getCarnet(), usuario.getNumTarjeta());
                        break;
                    case "carnet":
                        usuario = new Usuario(id, usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), usuario.getCarrera(), nuevoValor, usuario.getNumTarjeta());
                        break;
                    case "num_tarjeta":
                        usuario = new Usuario(id, usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), usuario.getCarrera(), usuario.getCarnet(), nuevoValor);
                        break;
                }
                usuarios.set(i, usuario);
                break;
            }
        }
    }

    public static void eliminarUsuario(List<Usuario> usuarios, int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    public static void mostrarUsuarios(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}
