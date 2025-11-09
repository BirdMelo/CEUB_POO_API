package ifood.endereco;

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
@RequestMapping("/api/Endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public Endereco createEndereco(@RequestBody Endereco endereco) {
		return enderecoService.salvar(endereco);
	}
	@GetMapping
	public List<Endereco> listarEndereco() {
		return enderecoService.listarEndereco();
	}
	@PutMapping("/{id}")
	public Endereco alterarEndereco(@PathVariable Long id, @RequestBody Endereco updatedEndereco) {
		return enderecoService.alterar(id, updatedEndereco);
	}
	@DeleteMapping("/{id}")
	public void excluirEndereco(@PathVariable Long id) {
		enderecoService.delete(id);
	}
}
