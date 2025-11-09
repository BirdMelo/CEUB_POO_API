package ifood.entregador;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
	
	boolean existsByCnpj(String cnpj);
	Optional<Entregador> findByCnpj(String cnpj);
}
