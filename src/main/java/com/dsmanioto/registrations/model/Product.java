package com.dsmanioto.registrations.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Nome do produto é obrigatório")
    private String name;

    @NotNull(message = "preço do produto é obrigatório")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "login")
    private UserReg userReg;

}
