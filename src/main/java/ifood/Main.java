package ifood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifood.pessoa.Pessoa;
import ifood.pessoa.PessoaController;
import ifood.pessoa.PessoaRepository;

import java.util.List;
@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaController pessoaController;

    @Override
    public void run(String... args) throws Exception {
        //CREATE
//    	Pessoa p1 = new Pessoa("Marta", "98349bjasdf", "Marta2020@gmail.com", "51241115821");
//    	pessoaController.createPessoa(p1);
    	
    	//READ
//    	List<Pessoa> pessoas = pessoaController.listarPessoa();
//    	pessoas.forEach(pessoa -> {
//    		System.out.println("====================================");
//    		System.out.printf("%d° pessoa\nNome: %s\nCPF: %s\nEmail: %s\n",
//    				pessoa.getIdPessoa(), pessoa.getNome(), pessoa.getCpf(), pessoa.getEmail());
//    		System.out.println("====================================");
//    	});
        //UPDATE
//    	Pessoa p2 = new Pessoa("Yuri", "123345goasnd", "yurisui@gmail.com", "11111111111");
//    	pessoaController.alterarPessoa(4l, p2);
        
        //DELETE
//        pessoaController.excluirPessoa(5l);

    }
}
