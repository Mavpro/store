package com.matias.mystore.domain.mappers;

import com.matias.mystore.domain.dto.ClienteDto;
import com.matias.mystore.domain.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    @Mapping(source = "id", target = "clienteId")
    ClienteDto fromClienteToClienteDTO(Cliente cliente);

    @Mapping(source = "clienteId", target = "id")
    Cliente fromclienteDTOtoCliente(ClienteDto clienteDTO);
}