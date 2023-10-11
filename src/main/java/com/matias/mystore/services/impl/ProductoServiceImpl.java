package com.matias.mystore.services.impl;

import com.matias.mystore.domain.dto.ProductoDto;
import com.matias.mystore.domain.entities.Producto;
import com.matias.mystore.domain.mappers.ProductoMapper;
import com.matias.mystore.repositories.ProductoRepository;
import com.matias.mystore.services.ProductoService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoDto> obtenerTodosLosProductos() {
        List<Producto> productos = (List<Producto>) productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::fromProductoToProductoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id).orElse(null);
        return (producto != null) ? productoMapper.fromProductoToProductoDTO(producto) : null;
    }

    @Override
    public ProductoDto crearProducto(ProductoDto productoDTO) {
        Producto producto = productoMapper.fromProductoDTOtoProducto(productoDTO);
        producto = productoRepository.save(producto);
        return productoMapper.fromProductoToProductoDTO(producto);
    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoDto productoDTO) {
        if (productoRepository.existsById(id)) {
            productoDTO.setProductoId(id);
            Producto producto = productoMapper.fromProductoDTOtoProducto(productoDTO);
            producto = productoRepository.save(producto);
            return productoMapper.fromProductoToProductoDTO(producto);
        }
        return null;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
