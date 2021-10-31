package com.dsmanioto.registrations.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void validateFields() {
        Customer customer = Customer.builder()
                .id(1L)
                .name("Daniel")
                .email("daniel@alksjdklajsdqe.com")
                .build();

        Assertions.assertEquals(1L, customer.getId());
        Assertions.assertEquals("Daniel", customer.getName());
        Assertions.assertEquals("daniel@alksjdklajsdqe.com", customer.getEmail());
    }

}
