package com.matias.mystore.repositories;

import com.matias.mystore.domain.entities.Producto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Long> {


}
