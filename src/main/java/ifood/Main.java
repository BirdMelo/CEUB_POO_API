package ifood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ifood.cliente.ClienteController;
import ifood.cliente.ClienteRepository;
@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClienteController clienteController;

    @Override
    public void run(String... args) throws Exception {

    }
}
