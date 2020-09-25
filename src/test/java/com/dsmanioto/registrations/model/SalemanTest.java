package com.dsmanioto.registrations.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SalemanTest {

    @Test
    public void validateFields() {
        Salesman salesman = Salesman.builder()
                .id(1L)
                .name("Daniel")
                .email("daniel@aksdklasd.com")
                .build();

        Assertions.assertEquals(1L, salesman.getId());
        Assertions.assertEquals("Daniel", salesman.getName());
        Assertions.assertEquals("daniel@aksdklasd.com", salesman.getEmail());
    }

}
