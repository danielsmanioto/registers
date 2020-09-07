package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.controller.dto.UserDTO;
import com.dsmanioto.registrations.model.UserReg;
import com.dsmanioto.registrations.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void save(UserDTO userDTO) {
        UserReg user = UserReg.builder()
                .login(userDTO.getLogin())
                .password(userDTO.getPassword())
                .build();
        repository.save(user);

        log.info("User save as success {}", user);
    }

    public  Iterable<UserReg> findAll() {
        return repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserReg user = Optional.ofNullable(repository.findByLogin(username)).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USE", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USE");

        return new User(user.getLogin(), user.getPassword(), user.getAdmin() ? authorityListAdmin : authorityListUser);
    }
}
