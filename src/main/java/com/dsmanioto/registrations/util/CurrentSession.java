package com.dsmanioto.registrations.util;

import com.dsmanioto.registrations.model.UserReg;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class CurrentSession {

    private UserReg userReg;

}
