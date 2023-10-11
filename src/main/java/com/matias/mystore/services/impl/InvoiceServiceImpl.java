package com.matias.mystore.services.impl;

import com.matias.mystore.domain.dto.InvoiceDto;
import com.matias.mystore.domain.entities.Invoice;
import com.matias.mystore.domain.mappers.InvoiceMapper;
import com.matias.mystore.repositories.InvoiceRepository;
import com.matias.mystore.services.InvoiceService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper = Mappers.getMapper(InvoiceMapper.class);

    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<InvoiceDto> obtenerTodasLasFacturas() {
        List<Invoice> facturas = (List<Invoice>) invoiceRepository.findAll();
        return facturas.stream()
                .map(invoiceMapper::fromInvoiceToInvoiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDto obtenerFacturaPorId(Long id) {
        Invoice factura = invoiceRepository.findById(id).orElse(null);
        return (factura != null) ? invoiceMapper.fromInvoiceToInvoiceDTO(factura) : null;
    }

    @Override
    public InvoiceDto crearFactura(InvoiceDto invoiceDTO) {
        Invoice factura = invoiceMapper.fromInvoiceDTOtoInvoice(invoiceDTO);
        factura = invoiceRepository.save(factura);
        return invoiceMapper.fromInvoiceToInvoiceDTO(factura);
    }

    @Override
    public InvoiceDto actualizarFactura(Long id, InvoiceDto invoiceDTO) {
        if (invoiceRepository.existsById(id)) {
            invoiceDTO.setInvoiceId(id);
            Invoice factura = invoiceMapper.fromInvoiceDTOtoInvoice(invoiceDTO);
            factura = invoiceRepository.save(factura);
            return invoiceMapper.fromInvoiceToInvoiceDTO(factura);
        }
        return null;
    }

    @Override
    public void eliminarFactura(Long id) {
        invoiceRepository.deleteById(id);
    }
}