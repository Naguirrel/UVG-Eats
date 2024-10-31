import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Mainreal {
    public static void main(String[] args) {
        // Crear el frame principal de la aplicación
        JFrame frame = new JFrame("UVG-EATS - Inicio de Sesión");
        frame.setSize(350, 650);
        frame.setDefaultCloseOperation(     JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setLayout(null);
        
        // Crear un panel y establecer el color de fondo
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 350, 650); // Ajustar el tamaño del panel al tamaño del frame
        frame.add(panel);

        // Crear la vista de inicio de sesión y mostrar el formulario
        vistaInicioSesion vista = new vistaInicioSesion();
        vista.mostrarFormulario(frame);

        // Mostrar el frame
        frame.setVisible(true);
    }
}
