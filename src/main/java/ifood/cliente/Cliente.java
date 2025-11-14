package ifood.cliente;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import ifood.pedido.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long idCliente;
    private String nome;
    private String senhaHash;
    private String email;
    @CreationTimestamp
    private Instant dataCadastro;
    @Enumerated(EnumType.STRING)
    private Status_Conta statusConta;
    private String cpf;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) // Um Cliente tem Vários Pedidos
    private List<Pedido> pedidos = new ArrayList<>();
    
	public Cliente() {}
	
    //CREATE CONSTRUTOR
    public Cliente(String nome, String senhaHash, String email, String cpf) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.email = email;
    	this.senhaHash = senhaHash;
    	
    	this.statusConta = Status_Conta.Ativo;
    	this.dataCadastro = Instant.now();
    }
    
    //UPDATE CONSTRUTOR
    public Cliente(String nome, String senhaHash, String email, String cpf, Status_Conta status_conta) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.email = email;
    	this.senhaHash = senhaHash;
    	this.statusConta = status_conta;
    }

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenhaHash() {
		return senhaHash;
	}

	public void setSenhaHash(String senhaHash) {
		this.senhaHash = senhaHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Instant dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Status_Conta getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(Status_Conta statusConta) {
		this.statusConta = statusConta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
    
    
    
}
