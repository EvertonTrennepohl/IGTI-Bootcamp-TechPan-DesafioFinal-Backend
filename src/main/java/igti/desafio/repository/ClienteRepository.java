package igti.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import igti.desafio.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	Optional<Cliente> findByEmail(String email);

}
