package com.matias.mystore.services;

import com.matias.mystore.domain.dto.ProductoDto;

import java.util.List;

public interface ProductoService {
    List<ProductoDto> obtenerTodosLosProductos();

    ProductoDto obtenerProductoPorId(Long id);

    ProductoDto crearProducto(ProductoDto productoDTO);

    ProductoDto actualizarProducto(Long id, ProductoDto productoDTO);

    void eliminarProducto(Long id);
}
