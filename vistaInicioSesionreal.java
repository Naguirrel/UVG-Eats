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
         // Campo de contraseña
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(32, 379, 280, 30);
        passwordField.setToolTipText("Contraseña");
        passwordField.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
        passwordField.setBackground(Color.WHITE);
        frame.add(passwordField);
        
        // Etiquetas y campo de texto para el correo electrónico
        JLabel welcomeLbl = new JLabel("¡Bienvenid@ a UVG-EATS!");
        welcomeLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 19));
        welcomeLbl.setBounds(68, 100, 240, 50);
        frame.getContentPane().add(welcomeLbl);
        
        JTextField txtCorreoElectronico = new JTextField();
        txtCorreoElectronico.setToolTipText("Correo Electrónico");
        txtCorreoElectronico.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16)); // Asegurarse que sea texto plano
        txtCorreoElectronico.setBackground(Color.WHITE);
        txtCorreoElectronico.setBounds(32, 330, 285, 30);
        frame.getContentPane().add(txtCorreoElectronico);
        
        JLabel lblCorreoElectronico = new JLabel("Correo electrónico:");
        lblCorreoElectronico.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        lblCorreoElectronico.setBounds(115, 300, 110, 36);
        frame.getContentPane().add(lblCorreoElectronico);
        
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
        lblContraseña.setBounds(137, 350, 70, 36);
        frame.getContentPane().add(lblContraseña);
        
        // Botón para crear cuenta
        JButton createAccountBtn = new JButton("Crear Cuenta");
        createAccountBtn.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
        createAccountBtn.setBounds(109, 513, 121, 30);
        createAccountBtn.setBackground(Color.WHITE);
        createAccountBtn.addActionListener(e -> redireccionarCrearCuenta(frame));
        frame.getContentPane().add(createAccountBtn);
        // Botón para iniciar sesión
        JButton loginBtn_1 = new JButton("Iniciar Sesión");
        loginBtn_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
        loginBtn_1.setBounds(109, 450, 121, 47);
        loginBtn_1.setBackground(Color.WHITE);
        loginBtn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validaciones para el inicio de sesión
                String email = txtCorreoElectronico.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                
                if (email.isEmpty() || password.isEmpty()) {
                    mostrarError("Debe de ingresar un correo y su contraseña respectiva.");
                    return;
                } else if (!email.contains("@")) {
                    mostrarError("Debe de ingresar una dirección de correo válida");
                    return;
                } else {
                    Usuario usuarioActual = buscarUsuarioPorCorreo(email);
                    if (usuarioActual != null && usuarioActual.getContraseña().equals(password)) {
                        redireccionarDashboard(frame, usuarioActual);
                    } else {
                        mostrarError("Las credenciales ingresadas no son correctas, vuelva a intentar.");
                    }
                }
            }
        });
        frame.getContentPane().add(loginBtn_1);
    }

    private Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }
        return null;
    }
    public void drawMainButtons(JFrame frame, Usuario usuarioActual) {
        frame.getContentPane().removeAll();
        frame.repaint();
        JLabel cerrarSesionLbl = new JLabel("Cerrar Sesión");
        cerrarSesionLbl.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
        cerrarSesionLbl.setForeground(Color.DARK_GRAY);
        cerrarSesionLbl.setBounds(254, 11, 80, 14);
        cerrarSesionLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                mostrarFormulario(frame);
            }
            @Override public void mouseEntered(java.awt.event.MouseEvent e) { cerrarSesionLbl.setForeground(Color.LIGHT_GRAY); }
            @Override public void mouseExited(java.awt.event.MouseEvent e) { cerrarSesionLbl.setForeground(Color.DARK_GRAY); }
        });
        frame.getContentPane().add(cerrarSesionLbl);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Ha ocurrido un error.", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarExito(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }

    public void redireccionarCrearCuenta(JFrame frame) {
        // Lógica para mostrar el formulario de creación de cuenta
    }

    public void redireccionarDashboard(JFrame frame, Usuario usuarioActual) {
        drawMainButtons(frame, usuarioActual);
    }
}
