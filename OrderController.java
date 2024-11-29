import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final SimpMessagingTemplate messagingTemplate;

    public OrderController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {

        messagingTemplate.convertAndSend("/topic/restaurant", "Nueva orden realizada: " + order.getDetails());

    
        messagingTemplate.convertAndSend("/topic/client/" + order.getClientId(), "Tu orden ha sido recibida y está en preparación.");

        return "Orden creada";
    }

    @PostMapping("/updateStatus")
    public String updateOrderStatus(@RequestParam Long orderId, @RequestParam String status) {
        
        if (status.equals("ready")) {
            messagingTemplate.convertAndSend("/topic/client/" + orderId, "Tu orden está lista para recoger.");
        }

        return "Estado de la orden actualizado";
    }
}
