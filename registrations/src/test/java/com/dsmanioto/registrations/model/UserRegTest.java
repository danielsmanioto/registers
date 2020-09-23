package com.dsmanioto.registrations.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRegTest {

    @Test
    public void validateFields() {
        UserReg user = UserReg.builder()
                .login("daniel")
                .password("12345")
                .admin(false)
                .build();

        Assertions.assertEquals("daniel", user.getLogin());
        Assertions.assertEquals("12345", user.getPassword());
        Assertions.assertFalse(user.getAdmin());
    }

}
