package ifood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifood.pessoa.Pessoa;
import ifood.pessoa.PessoaRepository;

import java.util.List;
@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        //READ
        List<Pessoa> pessoas = pessoaRepository.findAll();
        for (Pessoa pessoa : pessoas) {
            System.out.printf("Nome: %s\nEmail: %s\n", pessoa.getNome(), pessoa.getEmail());
        }

    }
}
