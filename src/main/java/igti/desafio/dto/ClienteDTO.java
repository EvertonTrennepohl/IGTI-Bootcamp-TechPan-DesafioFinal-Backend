package igti.desafio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String endereco;


}
