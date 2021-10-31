package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByUserRegLogin(String login);

}
