package ifood.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
