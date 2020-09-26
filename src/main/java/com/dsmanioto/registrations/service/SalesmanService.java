package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Salesman;
import com.dsmanioto.registrations.repository.SalesmanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SalesmanService {

    private final SalesmanRepository repository;

    @Autowired
    public SalesmanService(SalesmanRepository repository) {
        this.repository = repository;
    }

    public void save(Salesman salesman) {
        repository.save(salesman);

        log.info("Salesman save as success {}", salesman);
    }

    public List<Salesman> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
