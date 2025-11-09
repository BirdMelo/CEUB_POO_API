
package ifood.entregador;

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
@RequestMapping("/api/Entregador")
public class EntregadorController {
	@Autowired
	private EntregadorService EntregadorService;
	
	@PostMapping
	public Entregador createEntregador(@RequestBody Entregador Entregador) {
		return EntregadorService.salvar(Entregador);
	}
	@GetMapping
	public List<Entregador> listarEntregador() {
		return EntregadorService.listarEntregador();
	}
	@PutMapping("/{id}")
	public Entregador alterarEntregador(@PathVariable Long id, @RequestBody Entregador updatedEntregador) {
		return EntregadorService.alterar(id, updatedEntregador);
	}
	@DeleteMapping("/{id}")
	public void excluirEntregador(@PathVariable Long id) {
		EntregadorService.delete(id);
	}
	
}
