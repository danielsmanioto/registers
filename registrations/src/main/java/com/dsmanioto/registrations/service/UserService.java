package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.controller.dto.UserDTO;
import com.dsmanioto.registrations.model.User;
import com.dsmanioto.registrations.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(UserDTO userDTO) {
        User user = User.builder()
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .build();
        repository.save(user);

        log.info("User save as success {}", user);
    }

    public  Iterable<User> findAll() {
        return repository.findAll();
    }
}
