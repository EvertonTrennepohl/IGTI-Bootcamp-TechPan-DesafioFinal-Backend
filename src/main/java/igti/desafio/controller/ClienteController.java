package igti.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.dto.ClienteDTO;
import igti.desafio.service.ClienteService;

@RestController
@Transactional
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ClienteDTO salvarCliente(@RequestBody ClienteDTO clienteDTO) {
		return clienteService.salvaCliente(clienteDTO);
	}
	
	@GetMapping
	public List<ClienteDTO> listaClientes() {
		List<ClienteDTO> clientes = clienteService.listaClientes();
		return clientes;
	}
}
