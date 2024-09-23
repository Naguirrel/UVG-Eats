//COMMIT 1 HASTA E INICIO KLK
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrototipoRestaurantesConImagenes {

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

//SEGUNDO COMMIT AQUI CREA EL BOTON DE BARISTA SIUUUUU        
        ImageIcon baristaIcon = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/Barista.jpeg");
        JButton btnBarista = new JButton(baristaIcon);
        btnBarista.setBounds(50, 100, 150, 150);  
        
        panelConFondo.add(btnBarista);

        
        btnBarista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMenuBarista();  
            }
        });

        
        frame.add(panelConFondo);
        frame.setVisible(true);
    }

// AQUI CREA EL MENU DE BARISTA VISCA EL BARCA    
    private static void mostrarMenuBarista() {
        JFrame menuFrame = new JFrame("Menú Barista");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(600, 400);
        menuFrame.setLayout(null); 

       
        ImageIcon encabezadoBarista = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/barista-2.png");
        JLabel imgBarista = new JLabel(encabezadoBarista);
        imgBarista.setBounds(10, 10, 500, 100); 
        menuFrame.add(imgBarista);

        
        ImageIcon bebidasCalientesIcon = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/bebidas calientes.jpg");
        JButton btnBebidasCalientes = new JButton(bebidasCalientesIcon);
        btnBebidasCalientes.setBounds(50, 150, 200, 200); 
        menuFrame.add(btnBebidasCalientes);

        
        btnBebidasCalientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProductosBebidasCalientes(); 
            }
        });

        
        ImageIcon bebidasFriasIcon = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/bebidas frias.jpg");
        JButton btnBebidasFrias = new JButton(bebidasFriasIcon);
        btnBebidasFrias.setBounds(250, 150, 200, 200);
        menuFrame.add(btnBebidasFrias);

        
        ImageIcon comidasIcon = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/comida.jpg");
        JButton btnComidas = new JButton(comidasIcon);
        btnComidas.setBounds(250, 350, 200, 200);
        menuFrame.add(btnComidas);

        
        ImageIcon postresIcon = new ImageIcon("C:/Documentos/Pat/uvg/2do Semestre/POO/prototipo restaurantes/postres.jpg");
        JButton btnPostres = new JButton(postresIcon);
        btnPostres.setBounds(50, 350, 200, 200);
        menuFrame.add(btnPostres);

        
        menuFrame.setVisible(true);
    }

