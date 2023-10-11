package com.matias.mystore.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class InvoiceDto {

    private Long invoiceId;

    private LocalDateTime fecha;

    private ClienteDto cliente;

    private List<InvoiceItemDto> items;

}
