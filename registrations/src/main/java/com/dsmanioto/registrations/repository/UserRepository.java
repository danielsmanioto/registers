package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
