package com.dsmanioto.registrations.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@Entity
public class User extends AbstractEntity {

    @Id
    @Column(unique = true)
    @NotEmpty
    private String login;

    @NotEmpty
    @JsonIgnore
    private String password;

    private boolean enabled;

}
