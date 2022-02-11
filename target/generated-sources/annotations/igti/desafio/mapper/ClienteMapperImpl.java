package igti.desafio.mapper;

import igti.desafio.dto.ClienteDTO;
import igti.desafio.dto.ClienteDTO.ClienteDTOBuilder;
import igti.desafio.modelo.Cliente;
import igti.desafio.modelo.Cliente.ClienteBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-11T11:17:01-0300",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.50.v20210914-1429, environment: Java 17.0.1 (Eclipse Adoptium)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toModel(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteBuilder cliente = Cliente.builder();

        cliente.email( clienteDTO.getEmail() );
        cliente.endereco( clienteDTO.getEndereco() );
        cliente.id( clienteDTO.getId() );
        cliente.nome( clienteDTO.getNome() );
        cliente.senha( clienteDTO.getSenha() );

        return cliente.build();
    }

    @Override
    public ClienteDTO toDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTOBuilder clienteDTO = ClienteDTO.builder();

        clienteDTO.email( cliente.getEmail() );
        clienteDTO.endereco( cliente.getEndereco() );
        clienteDTO.id( cliente.getId() );
        clienteDTO.nome( cliente.getNome() );
        clienteDTO.senha( cliente.getSenha() );

        return clienteDTO.build();
    }
}
