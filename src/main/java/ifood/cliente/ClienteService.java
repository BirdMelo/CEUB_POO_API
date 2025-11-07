package ifood.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    //READ
    public List<Cliente> listarCliente() {
        return clienteRepository.findAll();
    }
    //CREATE
    public Cliente salvar(Cliente Cliente) {
    	if(clienteRepository.existsByCpf(Cliente.getCpf())) {
    		throw new RuntimeException("CPF já existente");
    	}
    	if(Cliente.getCpf() == null || Cliente.getEmail() == null || Cliente.getNome() == null || Cliente.getSenha() == null) {
    		throw new RuntimeException("Cliente não possui todas as caracteristicas necessarias");
    	}
    	return clienteRepository.save(Cliente);
    }
    //UPDATE
    public Cliente alterar(Long id, Cliente updatedCliente) {
    	Cliente Cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrada com o ID: " + id));
    	if(updatedCliente.getCpf() == null || updatedCliente.getEmail() == null || updatedCliente.getNome() == null || updatedCliente.getSenha() == null) {
    		throw new RuntimeException("Dados novos estão incompletos para alteração");
    	}
    	Optional<Cliente> clienteComCpfIgual = clienteRepository.findByCpf(updatedCliente.getCpf());
    	if(clienteComCpfIgual.isPresent() && !clienteComCpfIgual.get().getIdCliente().equals(id)) {
    		throw new RuntimeException("CPF registrado em outra Cliente");
    	}
    	Cliente.setCpf(updatedCliente.getCpf());
    	Cliente.setEmail(updatedCliente.getEmail());
    	Cliente.setNome(updatedCliente.getNome());
    	Cliente.setSenha(updatedCliente.getSenha());
    	Cliente.setStatusConta(updatedCliente.getStatusConta());
    	
    	return clienteRepository.save(Cliente);
    }
    //DELETE
    public void delete(Long id) {
    	if(!clienteRepository.existsById(id)) {
    		throw new RuntimeException("Cliente com id "+id+" não existe");
    	}
    	clienteRepository.deleteById(id);
    }
}
