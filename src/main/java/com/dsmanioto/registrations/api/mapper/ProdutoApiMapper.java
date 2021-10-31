package com.dsmanioto.registrations.api.mapper;

import com.dsmanioto.registrations.api.dto.ProdutoApiResponseDTO;
import com.dsmanioto.registrations.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoApiMapper {

    public static ProdutoApiResponseDTO toDto(Product product) {

        return ProdutoApiResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .userLogin(Objects.nonNull(product.getUserReg()) ? product.getUserReg().getLogin() : null)
                .build();
    }

}
