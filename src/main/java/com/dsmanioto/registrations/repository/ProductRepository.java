package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
