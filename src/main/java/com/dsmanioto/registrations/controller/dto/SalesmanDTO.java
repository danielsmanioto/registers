package com.dsmanioto.registrations.controller.dto;

import com.dsmanioto.registrations.model.Salesman;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesmanDTO {

    private Long id;
    private String name;
    private String email;

    public Salesman convertToModel() {
        return Salesman.builder()
                .id(id)
                .name(name)
                .email(email)
                .build();
    }

}
