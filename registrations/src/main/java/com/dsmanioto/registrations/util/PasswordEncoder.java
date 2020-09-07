package com.dsmanioto.registrations.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public String encoder(String password) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        return bCrypt.encode(password);
    }

}
