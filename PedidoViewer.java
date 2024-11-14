import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

public class PedidoViewer {

    private Pedido pedido;
    private JEditorPane editorPane;

    public PedidoViewer(Pedido pedido) {
        this.pedido = pedido;
    }

    public void mostrarPedido() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Detalle del Pedido");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            editorPane = new JEditorPane();
            editorPane.setEditable(false);
            editorPane.setContentType("text/html");

            cargarContenidoHTML();  // Cargar contenido inicial

            JScrollPane scrollPane = new JScrollPane(editorPane);
            frame.add(scrollPane);
            frame.setVisible(true);

            // Iniciar temporizador para actualizar el tiempo dinámicamente
            pedido.setOnUpdate(this::cargarContenidoHTML);  // Refrescar contenido cada segundo
            pedido.iniciarTemporizador();
        });
    }

    private void cargarContenidoHTML() {
        SwingUtilities.invokeLater(() -> {
            try {
                String htmlContent = new String(Files.readAllBytes(Paths.get("C:/Users/chipe/Desktop/uvg/Semestre_2/POO/Proyecto/Fase_3/pedido_en_html.html")));

                htmlContent = htmlContent.replace("idPedido", String.valueOf(pedido.getId_Pedido()));
                htmlContent = htmlContent.replace("restaurante", pedido.getRestaurante());
                htmlContent = htmlContent.replace("producto", pedido.getProducto());
                htmlContent = htmlContent.replace("monto", String.valueOf(pedido.getMonto()));
                htmlContent = htmlContent.replace("estado", pedido.getEstado());
                htmlContent = htmlContent.replace("tiempoRestante", pedido.getTiempoFormateado());
                htmlContent = htmlContent.replace("detalle", pedido.getDetalle());

                editorPane.setText(htmlContent);
            } catch (IOException e) {
                e.printStackTrace();
                editorPane.setText("<html><body><h1>Error cargando el archivo HTML</h1></body></html>");
            }
        });
    }

    public static void main(String[] args) {
        Pedidos pedidos = new Pedidos();
        Pedido pedido = new Pedido(123, "Barista", 456, "Latte", 50, "En preparación", 20, "Extra shot", pedidos);

        PedidoViewer viewer = new PedidoViewer(pedido);
        viewer.mostrarPedido();
    }
}
