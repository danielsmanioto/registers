package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesmanRepository extends JpaRepository<Salesman, Long> {
}
