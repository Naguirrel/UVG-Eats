import java.util.Timer;
import java.util.TimerTask;

public class Pedido {
    private int id_Pedido; 
    private String restaurante;
    private int id_cliente; 
    private String producto; 
    private int monto; 
    private String estado; 
    private int tiempo; 
    private String detalle; 
    private Timer timer;
    private Pedidos pedidos; // Instancia de la clase Pedidos

    public Pedido(int id_Pedido, String restaurante, int id_cliente, String producto, int monto, String estado, int tiempo, String detalle, Pedidos pedidos) {
        this.id_Pedido = id_Pedido;
        this.restaurante = restaurante;
        this.id_cliente = id_cliente;
        this.producto = producto;
        this.monto = monto;
        this.estado = estado;
        this.tiempo = tiempo;
        this.detalle = detalle;
        this.timer = new Timer(); 
        this.pedidos = pedidos;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }
    
    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }
    
    public String getRestaurante() {
        return restaurante;
    }
    
    public void setRestaurante(String restaurante) {
        this.restaurante = restaurante;
    }

    public int getCliente() {
        return id_cliente;
    }
    
    public void setCliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getProducto() {
        return producto;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
    
    public int getMonto() {
        return monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public int getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    // Método para actualizar el estado del pedido
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Iniciar el temporizador y agregar el pedido a la lista correspondiente
    public void iniciarTemporizador() {
        // Agregar el pedido a la lista correspondiente en Pedidos
        pedidos.agregarPedido(this);

        // Calcular tiempo estimado de entrega en función de la carga del restaurante
        int pedidosPendientes = obtenerCantidadPedidosEnRestaurante(restaurante);
        this.tiempo = 180 + (pedidosPendientes * 120); // 3 minutos base + 2 minutos por cada pedido pendiente

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (tiempo > 0) {
                    tiempo--;
                } else {
                    estado = "Su pedido está listo para la entrega";
                    timer.cancel();
                    // Eliminar el pedido cuando el tiempo llegue a 0
                    pedidos.eliminarPedidoPorId(id_Pedido);
                }
            }
        };
        //Actualización de timer por segundo
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    //obtener la cantidad de pedidos en la lista del restaurante especificado
    private int obtenerCantidadPedidosEnRestaurante(String restaurante) {
        switch (restaurante) {
            case "Barista":
                return pedidos.getBarista().size();
            case "Cafe":
                return pedidos.getCafe().size();
            case "Gitane":
                return pedidos.getGitane().size();
            case "Saul":
                return pedidos.getSaul().size();
            case "Mixtas":
                return pedidos.getMixtas().size();
            case "Sarita":
                return pedidos.getSarita().size();
            case "Panitos":
                return pedidos.getPanitos().size();
            case "Go_green":
                return pedidos.getGo_green().size();
            default:
                return 0;
        }
    }

    public String getTiempoFormateado() {
        int minutos = tiempo / 60;
        int segundos = tiempo % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public String generarResumen() {
        return "Pedido #" + id_Pedido + " del restaurante " + restaurante + "\n" +
               "Producto: " + producto + "\n" +
               "Monto: " + monto + "\n" +
               "Estado actual: " + estado + "\n" +
               "Tiempo restante: " + getTiempoFormateado() + "\n" +
               "Detalles: " + detalle;
    }
}
