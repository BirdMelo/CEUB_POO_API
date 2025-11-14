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
    public Cliente salvar(Cliente cliente) {
    	if(clienteRepository.existsByCpf(cliente.getCpf())) {
    		throw new RuntimeException("CPF já existente");
    	}
    	if(cliente.getCpf() == null || cliente.getEmail() == null || cliente.getNome() == null || cliente.getSenhaHash() == null) {
    		throw new RuntimeException("Cliente não possui todas as caracteristicas necessarias");
    	}
    	return clienteRepository.save(cliente);
    }
    //UPDATE
    public Cliente alterar(Long id, Cliente updatedCliente) {
    	Cliente Cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrada com o ID: " + id));
    	if(updatedCliente.getCpf() == null || updatedCliente.getEmail() == null || updatedCliente.getNome() == null || updatedCliente.getSenhaHash() == null) {
    		throw new RuntimeException("Dados novos estão incompletos para alteração");
    	}
    	Optional<Cliente> clienteComCpfIgual = clienteRepository.findByCpf(updatedCliente.getCpf());
    	if(clienteComCpfIgual.isPresent() && !clienteComCpfIgual.get().getIdCliente().equals(id)) {
    		throw new RuntimeException("CPF registrado em outra Cliente");
    	}
    	Cliente.setCpf(updatedCliente.getCpf());
    	Cliente.setEmail(updatedCliente.getEmail());
    	Cliente.setNome(updatedCliente.getNome());
    	Cliente.setSenhaHash(updatedCliente.getSenhaHash());
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
