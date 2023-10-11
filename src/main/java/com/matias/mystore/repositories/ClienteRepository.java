package com.matias.mystore.repositories;

import com.matias.mystore.domain.entities.Cliente;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.invoke.CallSite;
import java.util.List;
import java.util.Optional;


public interface ClienteRepository extends CrudRepository<Cliente, Long> {
List<Cliente> findClienteByNombre(String nombre);
Boolean existsByNombre(String nombre);
Boolean existsByCorreoElectronico(String correo);





}