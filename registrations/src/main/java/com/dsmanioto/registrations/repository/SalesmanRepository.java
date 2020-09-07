package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Salesman;
import org.springframework.data.repository.CrudRepository;

public interface SalesmanRepository extends CrudRepository<Salesman, Long> {
}
