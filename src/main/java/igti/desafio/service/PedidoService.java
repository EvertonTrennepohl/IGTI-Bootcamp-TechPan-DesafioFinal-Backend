package igti.desafio.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import igti.desafio.dto.PedidoDTO;
import igti.desafio.modelo.Pedido;
import igti.desafio.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public PedidoDTO realizaPedido(PedidoDTO pedidoDTO) {
		pedidoDTO.setDataHora(LocalDateTime.now());
		pedidoDTO.setSituacao(PedidoDTO.SITUACAO_AGUARDANDO);
		return new PedidoDTO(pedidoRepository.save(new Pedido(pedidoDTO)));
	}

	public List<PedidoDTO> findAll() {
		List<Pedido> pedidos = pedidoRepository.findAll(Sort.by("dataHora").descending());
		return pedidos.stream().map(p -> new PedidoDTO(p)).collect(Collectors.toList());
	}
	
	public PedidoDTO obtemPedido(Integer idPedido) {
		return new PedidoDTO((pedidoRepository.findById(idPedido).get()));
	}
	
	public PedidoDTO atualizaSituacaoPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = pedidoRepository.findById(pedidoDTO.getId()).get();
		pedido.setSituacao(pedidoDTO.getSituacao());
		return new PedidoDTO(pedidoRepository.save(pedido));
	}

}
