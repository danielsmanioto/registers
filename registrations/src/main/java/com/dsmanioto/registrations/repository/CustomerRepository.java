package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
