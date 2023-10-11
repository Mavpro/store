package com.matias.mystore.domain.mappers;

import com.matias.mystore.domain.dto.ProductoDto;
import com.matias.mystore.domain.dto.ProductoDto;
import com.matias.mystore.domain.entities.Producto;
import com.matias.mystore.domain.entities.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoMapper {
    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    @Mapping(source = "id", target = "productoId")
    ProductoDto fromProductoToProductoDTO(Producto producto);

    @Mapping(source = "productoId", target = "id")
    Producto fromProductoDTOtoProducto(ProductoDto productoDTO);
}