package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.controller.model.ProductDTO;
import com.dsmanioto.registrations.model.Product;
import com.dsmanioto.registrations.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void save(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .build();
        repository.save(product);

        log.info("Product save as success {}", product);
    }

    public Iterable<Product> findAll() {
        return repository.findAll();
    }
}
