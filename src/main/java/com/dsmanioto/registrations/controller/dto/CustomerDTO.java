package com.dsmanioto.registrations.controller.dto;

import com.dsmanioto.registrations.model.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;

    public Customer convertoToModel() {
        return Customer.builder()
                .id(this.id)
                .name(this.name)
                .email(this.email)
                .build();
    }
}
