package ifood.endereco;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	//READ
	public List<Endereco> listarEndereco() {
		return enderecoRepository.findAll();
	}
	
	//CREATE
	public Endereco salvar(Endereco endereco) {
		if(enderecoRepository.existsByCep(endereco.getCep())) {
			throw new RuntimeException("CEP já registrado");
		}
		if(verificarNovoEndereco(endereco)) {
			throw new RuntimeException("Erro na criação de endereço: Dados necessarios incompletos");
			
		}
		return enderecoRepository.save(endereco);
	}
	
	//UPDATE
	public Endereco alterar(Long id, Endereco updatedEndereco) {
		Endereco endereco = enderecoRepository.findById(id).orElseThrow(()-> new RuntimeException("Endereco não encontrado com ID:"+id));
		if(verificarNovoEndereco(updatedEndereco)) {
			throw new RuntimeException("Dados novos estão incompletos para alteração.");
		}
		Optional<Endereco> enderecoComCepIgual = enderecoRepository.findByCep(updatedEndereco.getCep());
		if(enderecoComCepIgual.isPresent() && !enderecoComCepIgual.get().getIdEndereco().equals(id) ) {
			throw new RuntimeException("CEP registrado em outro endereço.");
		}
		endereco.setCep(updatedEndereco.getCep());
		endereco.setRua(updatedEndereco.getRua());
		endereco.setBairro(updatedEndereco.getBairro());
		endereco.setComplemento(updatedEndereco.getComplemento());
		endereco.setCidade(updatedEndereco.getCidade());
		endereco.setUf(updatedEndereco.getUf());
		
		return enderecoRepository.save(endereco);
	}
	
	//DELETE
	public void delete(Long id) {
		if(!enderecoRepository.existsById(id)) {
			throw new RuntimeException("Endereço com id "+id+" não existe");
		}
		enderecoRepository.deleteById(id);
	}
	private static boolean verificarNovoEndereco(Endereco endereco) {
		if(
				endereco.getCep() 		== null ||
				endereco.getUf() 		== null ||
				endereco.getCidade() 	== null ||
				endereco.getRua() 		== null ||
				endereco.getBairro() 	== null) 
		{
			return true;
			
		}
		return false;
		
	}
}
