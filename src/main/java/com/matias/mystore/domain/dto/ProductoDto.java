package com.matias.mystore.domain.dto;

import lombok.Data;

@Data
public class ProductoDto {

    private Long productoId;

    private String nombre;

    private String descripcion;

    private Double precio;

}