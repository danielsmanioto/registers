package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
