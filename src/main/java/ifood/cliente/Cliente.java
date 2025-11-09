package ifood.cliente;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import ifood.pedido.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private String senha_hash;
    private String email;
    @CreationTimestamp
    private Instant data_cadastro;
    private Status_Conta status_conta;
    private String cpf;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) // Um Cliente tem Vários Pedidos
    private List<Pedido> pedidos = new ArrayList<>();
    
	public Cliente() {}
	
    //CREATE CONSTRUTOR
    public Cliente(String nome, String senha_hash, String email, String cpf) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.email = email;
    	this.senha_hash = senha_hash;
    	
    	this.status_conta = Status_Conta.Ativo;
    	this.data_cadastro = Instant.now();
    }
    
    //UPDATE CONSTRUTOR
    public Cliente(String nome, String senha_hash, String email, String cpf, Status_Conta status_conta) {
    	this.nome = nome;
    	this.cpf = cpf;
    	this.email = email;
    	this.senha_hash = senha_hash;
    	
    	this.status_conta = status_conta;
    }
    
    public String getSenha_hash() {
		return senha_hash;
	}
	public void setSenha_hash(String senha_hash) {
		this.senha_hash = senha_hash;
	}
	public Status_Conta getStatus_conta() {
		return status_conta;
	}
	public void setStatus_conta(Status_Conta status_conta) {
		this.status_conta = status_conta;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idcliente) {
        this.idCliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha_hash;
    }

    public void setSenha(String senha) {
        this.senha_hash = senha;
    }

    public Instant getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Instant data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status_Conta getStatusConta() {
        return status_conta;
    }

    public void setStatusConta(Status_Conta statusConta) {
        this.status_conta = statusConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
