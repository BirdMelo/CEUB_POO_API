package ifood.pessoa;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }
}
