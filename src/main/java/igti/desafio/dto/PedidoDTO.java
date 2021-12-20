package igti.desafio.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import igti.desafio.modelo.ItemPedido;
import igti.desafio.modelo.Pedido;

public class PedidoDTO {
	
	private Integer id;
	private LocalDateTime dataHora;
	private String situacao;
	private List<ItemPedido> itens = new ArrayList<>();
	
	public static String SITUACAO_AGUARDANDO = "Aguardando";
	public static String SITUACAO_EM_PREPARACAO = "Em preparação";
	public static String SITUACAO_SAIU_PARA_ENTREGA = "Saiu para entrega";
	public static String SITUACAO_ENTREGUE = "Entregue";
	
	public PedidoDTO (Pedido pedido) {
		this.id = pedido.getId();
		this.dataHora = pedido.getDataHora();
		this.situacao = pedido.getSituacao();
		this.itens = pedido.getItens();
	}
	
	public PedidoDTO() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
}
