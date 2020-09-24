package com.dsmanioto.registrations.controller.dto;

import com.dsmanioto.registrations.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;

    public Product convertToModel() {
        return Product.builder()
                .name(this.name)
                .price(this.price)
                .build();
    }

}
