import java.util.ArrayList;

public class Pedidos {

    private ArrayList<Pedido> Barista = new ArrayList<>();
    private ArrayList<Pedido> Cafe = new ArrayList<>();
    private ArrayList<Pedido> Gitane = new ArrayList<>();
    private ArrayList<Pedido> Saul = new ArrayList<>();
    private ArrayList<Pedido> Mixtas = new ArrayList<>();
    private ArrayList<Pedido> Sarita = new ArrayList<>();
    private ArrayList<Pedido> Panitos = new ArrayList<>();
    private ArrayList<Pedido> Go_green = new ArrayList<>();

    // Método para agregar un objeto Pedido a la lista correspondiente
    public void agregarPedido(Pedido pedido) {
        String restaurante = pedido.getRestaurante();
        switch (restaurante) {
            case "Barista":
                Barista.add(pedido);
                break;
            case "Cafe":
                Cafe.add(pedido);
                break;
            case "Gitane":
                Gitane.add(pedido);
                break;
            case "Saul":
                Saul.add(pedido);
                break;
            case "Mixtas":
                Mixtas.add(pedido);
                break;
            case "Sarita":
                Sarita.add(pedido);
                break;
            case "Panitos":
                Panitos.add(pedido);
                break;
            case "Go_green":
                Go_green.add(pedido);
                break;
            default:
                break;
        }
    }

    // Getters para las listas de cada restaurante
    public ArrayList<Pedido> getBarista() {
        return Barista;
    }

    public ArrayList<Pedido> getCafe() {
        return Cafe;
    }

    public ArrayList<Pedido> getGitane() {
        return Gitane;
    }

    public ArrayList<Pedido> getSaul() {
        return Saul;
    }

    public ArrayList<Pedido> getMixtas() {
        return Mixtas;
    }

    public ArrayList<Pedido> getSarita() {
        return Sarita;
    }

    public ArrayList<Pedido> getPanitos() {
        return Panitos;
    }

    public ArrayList<Pedido> getGo_green() {
        return Go_green;
    }

    // Método para eliminar un pedido por ID de las listas
    public boolean eliminarPedidoPorId(int idPedido) {
        if (eliminarDeLista(Barista, idPedido)) return true;
        if (eliminarDeLista(Cafe, idPedido)) return true;
        if (eliminarDeLista(Gitane, idPedido)) return true;
        if (eliminarDeLista(Saul, idPedido)) return true;
        if (eliminarDeLista(Mixtas, idPedido)) return true;
        if (eliminarDeLista(Sarita, idPedido)) return true;
        if (eliminarDeLista(Panitos, idPedido)) return true;
        if (eliminarDeLista(Go_green, idPedido)) return true;
        return false;
    }

    // Método auxiliar para eliminar un pedido de una lista específica por ID
    private boolean eliminarDeLista(ArrayList<Pedido> lista, int idPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getId_Pedido() == idPedido) {
                lista.remove(pedido);
                return true;
            }
        }
        return false;
    }

    // Método para buscar un pedido por ID en todas las listas y devolverlo
    public Pedido buscarPedidoPorId(int idPedido) {
        Pedido pedidoEncontrado = buscarEnLista(Barista, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        pedidoEncontrado = buscarEnLista(Cafe, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        pedidoEncontrado = buscarEnLista(Gitane, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        pedidoEncontrado = buscarEnLista(Saul, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        pedidoEncontrado = buscarEnLista(Mixtas, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        pedidoEncontrado = buscarEnLista(Sarita, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        pedidoEncontrado = buscarEnLista(Panitos, idPedido);
        if (pedidoEncontrado != null) return pedidoEncontrado;

        return buscarEnLista(Go_green, idPedido);
    }

    // Método auxiliar para buscar un pedido en una lista específica por ID
    private Pedido buscarEnLista(ArrayList<Pedido> lista, int idPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getId_Pedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }
}
