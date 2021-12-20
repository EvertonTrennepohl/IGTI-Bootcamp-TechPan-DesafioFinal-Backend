package igti.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import igti.desafio.dto.ProdutoDTO;
import igti.desafio.service.ProdutoService;

@RestController
@Transactional
public class ProdutoController {
	
	// Injeção de dependência pode ser feita desta forma.
	@Autowired
	private ProdutoService produtoService;
	
	/* Injeção de dependência feita no construtor. 
	@Autowired 
	public ProdutoController (ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	*/

	@GetMapping("/cardapio")
	public List<ProdutoDTO> listaProdutos() {
		
		List<ProdutoDTO> lista = produtoService.findAll();
		return lista;		
	} 
}