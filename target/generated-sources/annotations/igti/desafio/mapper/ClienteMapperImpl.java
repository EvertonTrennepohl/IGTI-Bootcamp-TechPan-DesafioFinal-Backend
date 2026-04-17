package igti.desafio.mapper;

import igti.desafio.dto.ClienteDTO;
import igti.desafio.dto.ClienteDTO.ClienteDTOBuilder;
import igti.desafio.modelo.Cliente;
import igti.desafio.modelo.Cliente.ClienteBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-16T23:01:48-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.13 (Azul Systems, Inc.)"
)
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public Cliente toModel(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteBuilder cliente = Cliente.builder();

        cliente.id( clienteDTO.getId() );
        cliente.nome( clienteDTO.getNome() );
        cliente.email( clienteDTO.getEmail() );
        cliente.senha( clienteDTO.getSenha() );
        cliente.endereco( clienteDTO.getEndereco() );

        return cliente.build();
    }

    @Override
    public ClienteDTO toDTO(Cliente cliente) {
        if ( cliente == null ) {
            return null;
        }

        ClienteDTOBuilder clienteDTO = ClienteDTO.builder();

        clienteDTO.id( cliente.getId() );
        clienteDTO.nome( cliente.getNome() );
        clienteDTO.email( cliente.getEmail() );
        clienteDTO.senha( cliente.getSenha() );
        clienteDTO.endereco( cliente.getEndereco() );

        return clienteDTO.build();
    }
}
