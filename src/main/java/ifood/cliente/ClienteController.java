package ifood.cliente;

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
@RequestMapping("/api/Clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente Cliente) {
		return clienteService.salvar(Cliente);
	}
	@GetMapping
	public List<Cliente> listarCliente() {
		return clienteService.listarCliente();
	}
	@PutMapping("/{id}")
	public Cliente alterarCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
		return clienteService.alterar(id, updatedCliente);
	}
	@DeleteMapping("/{id}")
	public void excluirCliente(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
}
