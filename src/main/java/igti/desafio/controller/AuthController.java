package igti.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.dto.ClienteDTO;

@RestController
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder bCryptoPasswordEncoder;
	
	@PostMapping("/login")
	public void login(@RequestBody ClienteDTO clienteDTO) {
		clienteDTO.setSenha(bCryptoPasswordEncoder.encode(clienteDTO.getSenha()));
	}
}
