package com.matias.mystore.repositories;

import com.matias.mystore.domain.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}