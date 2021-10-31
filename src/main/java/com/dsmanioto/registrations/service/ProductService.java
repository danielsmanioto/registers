package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Product;
import com.dsmanioto.registrations.repository.ProductRepository;
import com.dsmanioto.registrations.util.CurrentSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CurrentSession currentSession;

    public void save(Product product) {
        if (Objects.isNull(product.getUserReg())) {
            product.setUserReg(currentSession.getUserReg());
        }
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
        if (Objects.isNull(login) && Objects.isNull(name)) {
            return findAll();
        } else {
            if (Objects.nonNull(login)) {
                return repository.findByUserRegLogin(login);
            }
            return repository.findByName(name);
        }
    }

}
