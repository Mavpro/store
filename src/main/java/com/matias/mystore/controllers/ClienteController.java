package com.matias.mystore.controllers;

import com.matias.mystore.domain.dto.ClienteDto;
import com.matias.mystore.domain.dto.CustomResponse;
import com.matias.mystore.domain.entities.Cliente;
import com.matias.mystore.domain.mappers.ClienteMapper;
import com.matias.mystore.services.ClienteService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    ClienteMapper clienteMapper;

    @GetMapping
    public ResponseEntity<CustomResponse<List<ClienteDto>>> getAllClientes(@RequestParam(required = false) String nombre, @RequestParam(required = false) String apellido) {
        CustomResponse<List<ClienteDto>> response = new CustomResponse<>();
        try {
            List<ClienteDto> clientes = new ArrayList<>();
            if (nombre == null) {
                clientes.addAll(clienteService.obtenerTodosLosClientes());
                System.out.println(1);
            }
            else {
                clienteService.obtenerClientePorNombre(nombre).forEach(clientes::add);
            }
            if (clientes.isEmpty() || clientes.size() == 0) {
                response.setMessage("No hay clientes para listar.");
                response.setError(true);
                response.setData(clientes);
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            }else {
                response.setMessage("Listado de clientes exitoso.");
                response.setError(false);
                response.setData(clientes);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            response.setMessage("Problemas para realizar solicitud.");
            response.setError(true);
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<CustomResponse<ClienteDto>> save(@RequestBody ClienteDto body) {
        CustomResponse<ClienteDto> response = new CustomResponse<>();
        try {
            if (clienteService.existByNombre(body.getNombre())) {
                response.setMessage("El nombre ya existe.");
                response.setError(true);
                response.setData(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }

            if (clienteService.existByCorreo(body.getCorreoElectronico())){
                response.setMessage("Email ya existe");
                response.setError(true);
                response.setData(null);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }

            ClienteDto persistCliente = clienteService.crearCliente(body);

            response.setMessage("Usuario creado exitosamente.");
            response.setError(false);
            response.setData(new ClienteDto(persistCliente));
            return new ResponseEntity(response, HttpStatus.OK);

        } catch (Exception e) {

            response.setMessage("Fallo la creacion del usuario: " + e.getMessage());
            response.setError(true);
            response.setData(null);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse<ClienteDto>> update(@RequestBody ClienteDto body, @PathVariable("id") Long id) {
        CustomResponse<ClienteDto> response = new CustomResponse<>();
        try {
            Optional<ClienteDto> entity = clienteService.obtenerClientePorId(id);
            System.out.println(entity.toString());
            if (entity.isPresent()) {
                body.setClienteId(id);
                System.out.println(body.toString());
                ClienteDto persist = clienteService.actualizarCliente(id,body);
                System.out.println(persist.toString());
                response.setMessage("Cliente update sucessfully");
                response.setError(false);
                response.setData(new ClienteDto(persist));
            } else {
                response.setMessage("Cliente not found");
                response.setError(true);
                response.setData(null);
            }

               return new ResponseEntity(response, HttpStatus.OK);
            } catch (Exception e) {

            response.setMessage("Cliente update unsucessfully");
            response.setError(true);
            response.setData(null);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<ClienteDto>> findById(@PathVariable("id") Long id) {
        CustomResponse<ClienteDto> response = new CustomResponse<>();
        try {
            Optional<ClienteDto> entity = clienteService.obtenerClientePorId(id);
            if (entity.isPresent()) {
                response.setMessage("Cliente obtenido exitosamente.");
                response.setError(false);
                response.setData(new ClienteDto(entity.get()));
            } else {
                response.setMessage("Cliente no existe.");
                response.setError(true);
                response.setData(null);
            }

            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {

            response.setMessage("Comment obtain unsucessfully");
            response.setError(true);
            response.setData(null);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }



}