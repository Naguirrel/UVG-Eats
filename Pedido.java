public class Pedido {
    private int id_Pedido; 
    private String restaurante;
    private int id_cliente; 
    private String producto; 
    private int monto; 
    private String estado; 
    private String tiempo; 
    private String detalle; 

    public Pedido(int id_Pedido, String restaurante, int id_cliente, String producto, int monto, String estado, String tiempo, String detalle) {
        this.id_Pedido = id_Pedido;
        this.restaurante = restaurante;
        this.id_cliente = id_cliente;
        this.producto = producto;
        this.monto = monto;
        this.estado = estado;
        this.tiempo = tiempo;
        this.detalle = detalle;
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
    
    public String getTiempo() {
        return tiempo;
    }
    
    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
    
    public String getDetalle() {
        return detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
