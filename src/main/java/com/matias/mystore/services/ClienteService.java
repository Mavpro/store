package com.matias.mystore.services;

import com.matias.mystore.domain.dto.ClienteDto;
import com.matias.mystore.domain.entities.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
 List<ClienteDto> obtenerTodosLosClientes();

 Optional<ClienteDto> obtenerClientePorId(Long id);

 List<ClienteDto> obtenerClientePorNombre(String nombre);

 ClienteDto crearCliente(ClienteDto clienteDTO);

 ClienteDto actualizarCliente(Long id, ClienteDto clienteDTO);

 void eliminarCliente(Long id);

 Boolean existByNombre(String nombre);

 Boolean existByCorreo(String correo);
}



