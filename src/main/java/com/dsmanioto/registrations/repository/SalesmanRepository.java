package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
}
