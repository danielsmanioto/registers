package com.dsmanioto.registrations.api.mapper;

import com.dsmanioto.registrations.api.dto.ProdutoApiResponseDTO;
import com.dsmanioto.registrations.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoApiMapper {

    public static ProdutoApiResponseDTO toDto(Product product) {

        return ProdutoApiResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .userLogin(product.getUserReg().getLogin())
                .build();
    }

}
