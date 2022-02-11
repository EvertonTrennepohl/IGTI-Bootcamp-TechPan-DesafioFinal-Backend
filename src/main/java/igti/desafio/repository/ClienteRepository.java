package igti.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import igti.desafio.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
