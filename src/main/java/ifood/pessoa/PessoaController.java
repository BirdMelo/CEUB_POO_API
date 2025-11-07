package ifood.pessoa;

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
@RequestMapping("/api/pessoas")
public class PessoaController {
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.salvar(pessoa);
	}
	@GetMapping
	public List<Pessoa> listarPessoa() {
		return pessoaService.listarPessoa();
	}
	@PutMapping("/{id}")
	public Pessoa alterarPessoa(@PathVariable Long id, @RequestBody Pessoa updatedPessoa) {
		return pessoaService.alterar(id, updatedPessoa);
	}
	@DeleteMapping("/{id}")
	public void excluirPessoa(@PathVariable Long id) {
		pessoaService.delete(id);
	}
	
}
