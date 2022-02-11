package igti.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.dto.PedidoDTO;
import igti.desafio.service.PedidoService;

@RestController
@Transactional
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/pedido")
	public PedidoDTO realizaPedido(@RequestBody PedidoDTO pedidoDTO) {
		return pedidoService.realizaPedido(pedidoDTO);
	}
	
	
	@GetMapping("/pedido/{idPedido}")
	public PedidoDTO obtemPedido(@PathVariable Integer idPedido) {
		return pedidoService.obtemPedido(idPedido);
	}
	
	@GetMapping("/pedidos")
	public List<PedidoDTO> listaPedidos() {
		List<PedidoDTO> lista = pedidoService.findAll();
		return lista;
	}
	
	@PutMapping("/pedido/{idPedido}")
	public PedidoDTO atualizaSituacaoPedido (@PathVariable Integer idPedido, @RequestBody PedidoDTO pedidoDTO) {
		return pedidoService.atualizaSituacaoPedido(pedidoDTO);
	}

}
