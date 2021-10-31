package com.dsmanioto.registrations.auth;

import com.dsmanioto.registrations.model.UserReg;
import com.dsmanioto.registrations.repository.UserRepository;
import com.dsmanioto.registrations.util.CurrentSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAuthentication implements UserDetailsService {

    private final UserRepository repository;
    private final CurrentSession currentSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserReg user = Optional.ofNullable(repository.findByLogin(username)).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USE", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USE");

        currentSession.setUserReg(user);
        log.info("Session setted or updated");
        return new User(user.getLogin(), user.getPassword(), user.getAdmin() ? authorityListAdmin : authorityListUser);
    }

}
