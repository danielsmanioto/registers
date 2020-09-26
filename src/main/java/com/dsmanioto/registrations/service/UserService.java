package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.UserReg;
import com.dsmanioto.registrations.repository.UserRepository;
import com.dsmanioto.registrations.util.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private static final String PASSWORD_DEFAULT = "change-me";

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(UserReg user) {
        repository.save(user);

        log.info("User save as success {}", user);
    }

    public List<UserReg> findAll() {
        return repository.findAll();
    }

    public void deleteByLogin(String login) {
        repository.deleteById(login);
    }

    public void resetPassword(String login) {
        UserReg user = Optional.ofNullable(repository.findByLogin(login)).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setPassword(PasswordEncoder.encoder(getDefaultPassword()));
        repository.save(user);
    }

    private String getDefaultPassword() {
        return PASSWORD_DEFAULT;
    }

}
