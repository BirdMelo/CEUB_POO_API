package ifood.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Pedido createPedido(@RequestBody Pedido pedido) {
		return pedidoService.salvar(pedido);
	}
	@GetMapping
	public List<Pedido> listarPedido() {
		return pedidoService.listarPedido();
	}
	@PutMapping("/{id}")
	public Pedido alterarPedido(@PathVariable Long id, @RequestBody Pedido updatedPedido) {
		return pedidoService.alterar(id, updatedPedido);
	}
	@DeleteMapping("/{id}")
	public void excluirPedido(@PathVariable Long id) {
		pedidoService.delete(id);
	}

}
