package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Product;
import com.dsmanioto.registrations.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Product> findProductsByParameters(String login, String name) {
        List<Product> productsModel = new ArrayList<>();
        if (Objects.isNull(login) && Objects.isNull(name)) {
            return findAll();
        } else {
            if (Objects.nonNull(login)) {
                return repository.findByUserRegLogin(login);
            }
            if (Objects.nonNull(name)) {
                return repository.findByName(name);
            }
        }
        return productsModel;
    }
}
