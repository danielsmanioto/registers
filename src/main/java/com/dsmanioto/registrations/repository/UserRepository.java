package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserReg, String> {

    UserReg findByLogin(String login);

    void deleteByLogin(String login);
}
