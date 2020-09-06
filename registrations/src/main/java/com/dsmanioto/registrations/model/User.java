package com.dsmanioto.registrations.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@Entity
public class User {

    @Id
    private String login;

    private String password;

    private boolean enabled;

}
