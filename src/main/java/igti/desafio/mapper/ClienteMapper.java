package igti.desafio.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import igti.desafio.dto.ClienteDTO;
import igti.desafio.modelo.Cliente;

@Mapper
public interface ClienteMapper {

	ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
	
	Cliente toModel(ClienteDTO clienteDTO);
	
	ClienteDTO toDTO(Cliente cliente);
}
