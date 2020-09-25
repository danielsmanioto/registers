package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Customer;
import com.dsmanioto.registrations.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void save(Customer customer) {
        repository.save(customer);

        log.info("Customer save as success {}", customer);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}


