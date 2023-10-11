package com.matias.mystore.services;

import com.matias.mystore.domain.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDto> obtenerTodasLasFacturas();

    InvoiceDto obtenerFacturaPorId(Long id);

    InvoiceDto crearFactura(InvoiceDto invoiceDto);

    InvoiceDto actualizarFactura(Long id, InvoiceDto invoiceDto);

    void eliminarFactura(Long id);
    
}
