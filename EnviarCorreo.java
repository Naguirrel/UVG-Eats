import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EnviarCorreo {

    public static void enviar(String destinatario, String asunto, String cuerpo) {
        // Dirección de correo y contraseña de la cuenta de Gmail
        String remitente = "tucorreo@gmail.com";  // Cambiar por tu correo de Gmail
        String clave = "tu_contraseña";           // Cambiar por la contraseña de tu cuenta de Gmail

        // Configuración del servidor SMTP de Gmail
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");

        // Autenticación
        Session sesion = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });
