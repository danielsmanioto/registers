package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Product;
import com.dsmanioto.registrations.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(Product product) {
        repository.save(product);

        log.info("Product save as success {}", product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);

        log.info("Product {} deleted as success.", id);
    }

}
