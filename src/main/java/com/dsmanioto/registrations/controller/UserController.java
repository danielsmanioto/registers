package com.dsmanioto.registrations.controller;

import com.dsmanioto.registrations.controller.dto.UserDTO;
import com.dsmanioto.registrations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private  static final String PAG_USER_LIST = "users/users-list";
    private  static final String PAG_USER_ADD_PRODUCT = "users/add-user";

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole(ADMIN)")
    @GetMapping("/signup")
    public String showSignUpForm(UserDTO userDTO) {
        return PAG_USER_ADD_PRODUCT;
    }

    @PostMapping("/save")
    public String save(@Valid UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return PAG_USER_ADD_PRODUCT;
        }

        service.save(userDTO.convertToModel());

        return loadListPag(model);
    }

    @GetMapping("/delete/{login}")
    public String deleteById(@PathVariable("login") String login, Model model) {
        service.deleteByLogin(login);

        return loadListPag(model);
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        return loadListPag(model);
    }

    @GetMapping("/reset-password/{login}")
    public String resetPassword(@PathVariable("login") String login, Model model) {
        service.resetPassword(login);
        return loadListPag(model);
    }

    private String loadListPag(Model model) {
        model.addAttribute("users", service.findAll());
        return PAG_USER_LIST;
    }
}
