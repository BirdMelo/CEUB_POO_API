package ifood.endereco;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	boolean existsByCep(String cep);
	Optional<Endereco> findByCep(String cep);

}
