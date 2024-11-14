import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final Pedidos pedidos;

    public PedidoController(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id) {
        Optional<Pedido> pedido = pedidos.getPedidoById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> agregarPedido(@RequestBody Pedido nuevoPedido) {
        pedidos.agregarPedido(nuevoPedido);
        return ResponseEntity.ok("Pedido agregado con éxito");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable int id) {
        if (pedidos.getPedidoById(id).isPresent()) {
            pedidos.eliminarPedido(id);
            return ResponseEntity.ok("Pedido eliminado con éxito");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
