
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
	private Status_Pedido status_pedido;
	@Column(name = "valor_frete", columnDefinition="decimal(10,2)")
	private Double valor_frete;
	@Column(name = "valor_total", columnDefinition="decimal(10,2)")
	private Double valor_total;
	@Column(name = "valor_subTotal", columnDefinition="decimal(10,2)")
	private Double valor_subTotal;
	@Column(name = "data_hora_pedido")
	private Instant data_hora_pedido;
	
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
	public Pedido(Double valor_frete, Double valor_subTotal) {
		this.valor_frete = valor_frete;
		this.valor_subTotal = valor_subTotal;
		
		this.valor_total = valor_frete + valor_subTotal;
		this.data_hora_pedido = Instant.now();
		this.status_pedido = Status_Pedido.Pendente;
	}
	//Update Constructor
	public Pedido(Status_Pedido status_pedido) {
		this.status_pedido = status_pedido;
	}
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Status_Pedido getStatusPedido() {
		return status_pedido;
	}

	public void setStatusPedido(Status_Pedido status_pedido) {
		this.status_pedido = status_pedido;
	}

	public Double getvalorFrete() {
		return valor_frete;
	}

	public void setvalorFrete(Double valor_frete) {
		this.valor_frete = valor_frete;
	}

	public Double getvalorTotal() {
		return valor_total;
	}

	public void setvalorTotal(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Double getvalorSubTotal() {
		return valor_subTotal;
	}

	public void setvalorSubTotal(Double valor_subTotal) {
		this.valor_subTotal = valor_subTotal;
	}

	public Instant getData_hora_pedido() {
		return data_hora_pedido;
	}

	public void setData_hora_pedido(Instant data_hora_pedido) {
		this.data_hora_pedido = data_hora_pedido;
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

