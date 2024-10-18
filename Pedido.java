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

    public Pedido(int id_Pedido, String restaurante, int id_cliente, String producto, int monto, String estado, int tiempo, String detalle) {
        this.id_Pedido = id_Pedido;
        this.restaurante = restaurante;
        this.id_cliente = id_cliente;
        this.producto = producto;
        this.monto = monto;
        this.estado = estado;
        this.tiempo = tiempo;
        this.detalle = detalle;
        this.timer = new Timer(); 
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

    public void iniciarTemporizador() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (tiempo > 0) {
                    tiempo--;
                } else {
                    estado = "Su pedido está listo para la entrega";
                    timer.cancel();
                }
            }
        };
        //Actualización de timer por segundo 
        timer.scheduleAtFixedRate(task, 0, 1000);
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
