package ifood.pedido;

import java.time.Instant;

import org.springframework.data.annotation.Id;

import ifood.cliente.Cliente;
import ifood.endereco.Endereco;
import ifood.entregador.Entregador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private Long idPedido;
	private Status_Pedido status_pedido;
	private Double valorFrete;
	private Double valorTotal;
	private Double valorSubTotal;
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
	public Pedido(Double valorFrete, Double valorTotal, Double valorSubTotal, Instant data_hora_pedido) {
		this.valorFrete = valorFrete;
		this.valorTotal = valorTotal;
		this.valorSubTotal = valorSubTotal;
		
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

	public Status_Pedido getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(Status_Pedido status_pedido) {
		this.status_pedido = status_pedido;
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
