package ifood.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository entregadorRepository;
    //READ
    public List<Entregador> listarEntregador() {
        return entregadorRepository.findAll();
    }
    //CREATE
    public Entregador salvar(Entregador entregador) {
    	if(entregadorRepository.existsByCnpj(entregador.getCnpj())) {
    		throw new RuntimeException("CNPJ já existente");
    	}
    	if(entregador.getCnpj() == null || entregador.getNome() == null || entregador.getStatus_atual() == null) {
    		throw new RuntimeException("O entregador não possui todas as caracteristicas necessarias");
    	}
    	return entregadorRepository.save(entregador);
    }
    //UPDATE
    public Entregador alterar(Long id, Entregador updatedentregador) {
    	Entregador entregador = entregadorRepository.findById(id).orElseThrow(() -> new RuntimeException("entregador não encontrada com o ID: " + id));
    	if(updatedentregador.getCnpj() == null || updatedentregador.getNome() == null) {
    		throw new RuntimeException("Dados novos estão incompletos para alteração");
    	}
    	Optional<Entregador> entregadorComCnpjIgual = entregadorRepository.findByCnpj(updatedentregador.getCnpj());
    	if(entregadorComCnpjIgual.isPresent() && !entregadorComCnpjIgual.get().getIdEntregador().equals(id)) {
    		throw new RuntimeException("CNPJ registrado em outro entregador");
    	}
    	entregador.setCnpj(updatedentregador.getCnpj());
    	entregador.setNome(updatedentregador.getNome());
    	entregador.setStatus_atual(updatedentregador.getStatus_atual());
    	
    	return entregadorRepository.save(entregador);
    }
    //DELETE
    public void delete(Long id) {
    	if(!entregadorRepository.existsById(id)) {
    		throw new RuntimeException("entregador com id "+id+" não existe");
    	}
    	entregadorRepository.deleteById(id);
    }
}
