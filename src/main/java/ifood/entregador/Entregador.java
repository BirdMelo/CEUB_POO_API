package ifood.entregador;

import java.util.ArrayList;
import java.util.List;

import ifood.pedido.Pedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Entregador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntregador;
	private String nome;
	private String cnpj;
	private Double avaliacaoMedia;
	@Enumerated(EnumType.STRING)
	private Status_Atual statusAtual;
	@OneToMany(mappedBy = "entregador", cascade = CascadeType.ALL) // Um Entregador tem vários Pedidos
    private List<Pedido> pedidos = new ArrayList<>();
	
	public Entregador() {}
	//Create Constructor
	public Entregador(String nome, String cnpj) {
		this.nome = nome;
    	this.cnpj = cnpj;
    	this.statusAtual = Status_Atual.Online;
	}
	//Update Constructor
	public Entregador(String nome, String cnpj, Status_Atual status_atual) {
		this.nome = nome;
    	this.cnpj = cnpj;
    	
    	this.statusAtual = status_atual;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public Long getIdEntregador() {
		return idEntregador;
	}
	public void setIdEntregador(Long idEntregador) {
		this.idEntregador = idEntregador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Double getAvaliacaoMedia() {
		return avaliacaoMedia;
	}
	public void setAvaliacaoMedia(Double avaliacaoMedia) {
		this.avaliacaoMedia = avaliacaoMedia;
	}
	public Status_Atual getStatusAtual() {
		return statusAtual;
	}
	public void setStatusAtual(Status_Atual statusAtual) {
		this.statusAtual = statusAtual;
	}
}
