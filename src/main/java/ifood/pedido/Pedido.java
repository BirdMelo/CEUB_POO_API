package ifood.pedido;

import java.time.Instant;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

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
	
}
