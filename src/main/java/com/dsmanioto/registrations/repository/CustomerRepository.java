package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
