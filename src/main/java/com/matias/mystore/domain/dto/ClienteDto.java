package com.matias.mystore.domain.dto;

import com.matias.mystore.domain.entities.Cliente;
import com.matias.mystore.domain.entities.Invoice;
import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {

    private Long clienteId;

    private String nombre;

    private String correoElectronico;

    private String telefono;

    private List<Invoice> facturas;

    public ClienteDto() {
        super();
    }

    public ClienteDto(Long clienteId, String nombre, String correoElectronico, String telefono, List<Invoice> facturas) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.facturas = facturas;
    }

    public ClienteDto(ClienteDto entidad) {
        this.clienteId = entidad.clienteId;
        this.nombre = entidad.nombre;
        this.correoElectronico = entidad.correoElectronico;
        this.telefono = entidad.telefono;
        this.facturas = entidad.facturas;
    }
}
