import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class vistaInicioSesionreal {

    // Lista para almacenar usuarios registrados
    private ArrayList<Usuario> listaUsuarios;

    public vistaInicioSesion() {
        // Inicializar la lista de usuarios
        listaUsuarios = new ArrayList<>();
        
        // Ejemplo de usuarios pre-registrados (esto se reemplazaría con la lógica de base de datos real)
        listaUsuarios.add(new Usuario(1, "Juan Salguero", "sal24374@uvg.edu.gt", "Jpsa241105"));
        listaUsuarios.add(new Usuario(2, "Jane Doe", "jane@example.com", "mypassword"));
    }