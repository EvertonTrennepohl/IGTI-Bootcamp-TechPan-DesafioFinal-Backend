package igti.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import igti.desafio.dto.ProdutoDTO;
import igti.desafio.modelo.Produto;
import igti.desafio.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List <ProdutoDTO> findAll() {
		List <Produto> produtos = produtoRepository.findAll();
		return produtos.stream().map(p -> new ProdutoDTO(p)).collect(Collectors.toList());
	}

}
