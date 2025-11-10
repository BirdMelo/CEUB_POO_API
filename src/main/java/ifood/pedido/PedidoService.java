package ifood.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	//READ
	public List<Pedido> listarPedido() {
		return pedidoRepository.findAll();
	}
	//CREATE
    public Pedido salvar(Pedido pedido) {
    	if(pedidoRepository.existsById(pedido.getIdPedido())) {
    		throw new RuntimeException("Pedido já existente");
    	}
    	if(
    			pedido.getvalorFrete() == null ||
    			pedido.getvalorSubTotal() == null)
    	{
    		throw new RuntimeException("pedido não possui todas as caracteristicas necessarias");
    	}
    	return pedidoRepository.save(pedido);
    }
    //UPDATE
    public Pedido alterar(Long id, Pedido updatedPedido) {
    	Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido inexistente"));
    	if(updatedPedido.getvalorFrete() != pedido.getvalorFrete() || updatedPedido.getvalorSubTotal() != pedido.getvalorSubTotal()) {
    		throw new RuntimeException("Não pode ter alterações nos valores.");
    	}
    	pedido.setStatusPedido(updatedPedido.getStatusPedido());
    	return pedidoRepository.save(pedido);
    }
    //DELETE
    public void delete(Long id) {
    	if(!pedidoRepository.existsById(id)) {
    		throw new RuntimeException("pedido com id "+id+" não existe");
    	}
    	pedidoRepository.deleteById(id);
    }
}
