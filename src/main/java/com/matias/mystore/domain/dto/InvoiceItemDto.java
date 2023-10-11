package com.matias.mystore.domain.dto;

import lombok.Data;

@Data
public class InvoiceItemDto {

    private Long invoiceItemId;

    private Integer cantidad;

    private ProductoDto producto;

    private Double precioUnitario;

    private Double importe;

    private String DataInservible;



}
