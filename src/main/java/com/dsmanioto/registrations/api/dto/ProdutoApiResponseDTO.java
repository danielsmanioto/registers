package com.dsmanioto.registrations.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ProdutoApiResponseDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private String userLogin;

}
