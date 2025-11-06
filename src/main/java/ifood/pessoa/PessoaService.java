package ifood.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    //READ
    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }
    //CREATE
    public Pessoa salvar(Pessoa pessoa) {
    	if(pessoaRepository.existsByCpf(pessoa.getCpf())) {
    		throw new RuntimeException("CPF já existente");
    	}
    	if(pessoa.getCpf() == null || pessoa.getEmail() == null || pessoa.getNome() == null || pessoa.getSenha() == null) {
    		throw new RuntimeException("Pessoa não possui todas as caracteristicas necessarias");
    	}
    	return pessoaRepository.save(pessoa);
    }
    //UPDATE
    public Pessoa alterar(Long id, Pessoa updatedPessoa) {
    	Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o ID: " + id));
    	if(updatedPessoa.getCpf() == null || updatedPessoa.getEmail() == null || updatedPessoa.getNome() == null || updatedPessoa.getSenha() == null) {
    		throw new RuntimeException("Dados novos estão incompletos para alteração");
    	}
    	Optional<Pessoa> pessoaComCpfIgual = pessoaRepository.findByCpf(updatedPessoa.getCpf());
    	if(pessoaComCpfIgual.isPresent() && !pessoaComCpfIgual.get().getIdPessoa().equals(id)) {
    		throw new RuntimeException("CPF registrado em outra pessoa");
    	}
    	pessoa.setCpf(updatedPessoa.getCpf());
    	pessoa.setEmail(updatedPessoa.getEmail());
    	pessoa.setNome(updatedPessoa.getNome());
    	pessoa.setSenha(updatedPessoa.getSenha());
    	pessoa.setStatusConta(updatedPessoa.getStatusConta());
    	
    	return pessoaRepository.save(pessoa);
    }
}
