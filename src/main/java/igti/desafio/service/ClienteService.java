package igti.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import igti.desafio.dto.ClienteDTO;
import igti.desafio.mapper.ClienteMapper;
import igti.desafio.modelo.Cliente;
import igti.desafio.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;
	
	public ClienteDTO salvaCliente(ClienteDTO clienteDTO) {
		Cliente clienteSalvar = clienteMapper.toModel(clienteDTO);
		return clienteMapper.toDTO(clienteRepository.save(clienteSalvar));
	}

	public List<ClienteDTO> listaClientes() {
		List<Cliente> clientes = clienteRepository.findAll(Sort.by("nome").ascending());
		return clientes.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
	}

}
