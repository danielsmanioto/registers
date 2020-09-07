package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.UserReg;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserReg, String> {

    UserReg findByLogin(String login);

}
