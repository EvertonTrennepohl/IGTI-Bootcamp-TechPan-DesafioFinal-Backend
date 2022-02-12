package igti.desafio.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import igti.desafio.dto.ClienteDTO;
import igti.desafio.mapper.ClienteMapper;
import igti.desafio.repository.ClienteRepository;

@Service
public class ClienteDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ClienteDTO cliente = buscaCliente(username);
		if (cliente == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(cliente.getNome(), cliente.getSenha(), Collections.emptyList());
	}
	
	private ClienteDTO buscaCliente(String username) {
//		Falta tratar a excessão, caso clienteRepository retorn null
		return clienteMapper.toDTO (clienteRepository.findByEmail(username).get());
	}

}
