
package ifood.pedido;

import java.time.Instant;

import ifood.cliente.Cliente;
import ifood.endereco.Endereco;
import ifood.entregador.Entregador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private Long idPedido;
	@Enumerated(EnumType.STRING)
	private Status_Pedido statusPedido;
	@Column( columnDefinition="decimal(10,2)")
	private Double valorFrete;
	@Column( columnDefinition="decimal(10,2)")
	private Double valorTotal;
	@Column( columnDefinition="decimal(10,2)")
	private Double valorSubTotal;
	private Instant dataHoraPedido;
	
	@ManyToOne // Vários Pedidos para um Cliente
	@JoinColumn(name = "idCliente") // Foreign key column
	private Cliente cliente;
	
	@OneToOne // Um Pedidos para um Entregador
	@JoinColumn(name = "idEntregador") // Foreign key column
	private Entregador entregador;
	
	@OneToOne // Um Pedidos para um Endereco
	@JoinColumn(name = "idEndereco") // Foreign key column
	private Endereco endereco;

	public Pedido() {}
	//Create Constructor
	public Pedido(Double valorFrete, Double valorSubTotal) {
		this.valorFrete = valorFrete;
		this.valorSubTotal = valorSubTotal;
		
		this.valorTotal = valorFrete + valorSubTotal;
		this.dataHoraPedido = Instant.now();
		this.statusPedido = Status_Pedido.Pendente;
	}
	//Update Constructor
	public Pedido(Status_Pedido status_pedido) {
		this.statusPedido = status_pedido;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Status_Pedido getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(Status_Pedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Double getValorSubTotal() {
		return valorSubTotal;
	}
	public void setValorSubTotal(Double valorSubTotal) {
		this.valorSubTotal = valorSubTotal;
	}
	public Instant getDataHoraPedido() {
		return dataHoraPedido;
	}
	public void setDataHoraPedido(Instant dataHoraPedido) {
		this.dataHoraPedido = dataHoraPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Entregador getEntregador() {
		return entregador;
	}
	public void setEntregador(Entregador entregador) {
		this.entregador = entregador;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}

