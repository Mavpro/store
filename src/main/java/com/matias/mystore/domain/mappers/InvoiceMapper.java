package com.matias.mystore.domain.mappers;

import com.matias.mystore.domain.dto.InvoiceDto;
import com.matias.mystore.domain.entities.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    @Mapping(source = "id", target = "invoiceId")
    InvoiceDto fromInvoiceToInvoiceDTO(Invoice invoice);

    @Mapping(source = "invoiceId", target = "id")
    Invoice fromInvoiceDTOtoInvoice(InvoiceDto invoiceDTO);
}