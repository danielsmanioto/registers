package com.dsmanioto.registrations.controller.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {

    private String name;

    private BigDecimal price;

}
