package com.dsmanioto.registrations.controller.dto;

import com.dsmanioto.registrations.model.UserReg;
import com.dsmanioto.registrations.util.PasswordEncoder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String login;
    private String password;

    public UserReg convertToModel() {
        return UserReg.builder()
                .login(login)
                .password(PasswordEncoder.encoder(password))
                .admin(false)
                .build();
    }
}
