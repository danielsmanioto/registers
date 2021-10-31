package com.dsmanioto.registrations.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ProductTest {

    @Test
    void validateFields() {
        Product product = Product.builder()
                .id(1L)
                .name("Coca cola 2l")
                .price(BigDecimal.valueOf(2.98))
                .build();

        Assertions.assertEquals(1L, product.getId() );
        Assertions.assertEquals("Coca cola 2l", product.getName());
        Assertions.assertEquals(BigDecimal.valueOf(2.98), product.getPrice());
    }

}
