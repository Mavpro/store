package com.matias.mystore.domain.mappers;

import com.matias.mystore.domain.dto.InvoiceItemDto;
import com.matias.mystore.domain.entities.InvoiceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvoiceItemMapper {
    InvoiceItemMapper INSTANCE = Mappers.getMapper(InvoiceItemMapper.class);

    @Mapping(source = "id", target = "invoiceItemId")
    InvoiceItemDto fromInvoiceItemToInvoiceItemDTO(InvoiceItem invoiceItem);

    @Mapping(source = "invoiceItemId", target = "id")
    InvoiceItem fromclienteDTOtoInvoiceItem(InvoiceItemDto invoiceItemDto);
}