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
    public void mostrarFormulario(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
        
        Image iconImage = new ImageIcon(this.getClass().getResource("img1/IMG_3273.png")).getImage();
        frame.setIconImage(iconImage);

        JLabel imgTwitter = new JLabel("");
        Image imgTwit = new ImageIcon(this.getClass().getResource("img1/X.png")).getImage();
        imgTwitter.setIcon(new ImageIcon(imgTwit));
        imgTwitter.setBounds(180, 25, 50, 50);
        frame.getContentPane().add(imgTwitter);
        
        JLabel imgInsta = new JLabel("");
        Image imgIg = new ImageIcon(this.getClass().getResource("img1/ig.png")).getImage();
        imgInsta.setIcon(new ImageIcon(imgIg));
        imgInsta.setBounds(110, 25, 50, 50);
        frame.getContentPane().add(imgInsta);

        JLabel anun = new JLabel("¡Visítanos en redes sociales!");
        anun.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
        anun.setBounds(87, 80, 180, 36);
        frame.getContentPane().add(anun);

        JLabel logoImageLabel = new JLabel();
        Image logoImage = new ImageIcon(this.getClass().getResource("img1/uvg150.png")).getImage();
        logoImageLabel.setIcon(new ImageIcon(logoImage));
        logoImageLabel.setBounds(100, 150, 125, 100);
        frame.getContentPane().add(logoImageLabel);