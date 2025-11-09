package ifood.endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//CREATE
	public Endereco salvar(Endereco endereco) {
		if(enderecoRepository.existsByCpf(endereco.getCep())) {
			throw new RuntimeException("CEP já registrado");
		}
		if(
				endereco.getCep() 		== null ||
				endereco.getUf() 		== null ||
				endereco.getCidade() 	== null ||
				endereco.getRua() 		== null ||
				endereco.getBairro() 	== null) 
		{
			throw new RuntimeException("Erro na criação de endereço: Dados necessarios incompletos");
			
		}
		return enderecoRepository.save(endereco);
	}
}
