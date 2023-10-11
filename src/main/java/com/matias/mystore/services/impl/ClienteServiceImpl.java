package com.matias.mystore.services.impl;


import com.matias.mystore.domain.dto.ClienteDto;
import com.matias.mystore.domain.entities.Cliente;
import com.matias.mystore.domain.mappers.ClienteMapper;
import com.matias.mystore.repositories.ClienteRepository;
import com.matias.mystore.services.ClienteService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper = Mappers.getMapper(ClienteMapper.class);

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteDto> obtenerTodosLosClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::fromClienteToClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDto> obtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(clienteMapper::fromClienteToClienteDTO);
    }
    @Override
    public List<ClienteDto> obtenerClientePorNombre(String nombre) {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findClienteByNombre(nombre);
        return clientes.stream()
                .map(clienteMapper::fromClienteToClienteDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ClienteDto crearCliente(ClienteDto clienteDTO) {
        Cliente cliente = clienteMapper.fromclienteDTOtoCliente(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.fromClienteToClienteDTO(cliente);
    }

    @Override
    public ClienteDto actualizarCliente(Long id, ClienteDto clienteDTO) {
        if (clienteRepository.existsById(id)) {
            clienteDTO.setClienteId(id);
            Cliente cliente = clienteMapper.fromclienteDTOtoCliente(clienteDTO);
            cliente = clienteRepository.save(cliente);
            return clienteMapper.fromClienteToClienteDTO(cliente);
        }
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Boolean existByNombre(String nombre){

        return clienteRepository.existsByNombre(nombre);

    }

    @Override
    public Boolean existByCorreo(String correo){

        return clienteRepository.existsByCorreoElectronico(correo);

    }
}