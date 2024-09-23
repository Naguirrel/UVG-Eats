import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrototipoParte1 {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Selecciona un Restaurante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        
        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon wallpaper = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/Fondo logo restaurantes.jpeg");
                g.drawImage(wallpaper.getImage(), 0, 0, 1024, 768, this);  
            }
        };

        panelConFondo.setLayout(null);
    }
}