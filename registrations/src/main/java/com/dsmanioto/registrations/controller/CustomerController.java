package com.dsmanioto.registrations.controller;

import com.dsmanioto.registrations.controller.dto.CustomerDTO;
import com.dsmanioto.registrations.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/signup")
    public String showSignUpForm(CustomerDTO customerDTO) {
        return "customers/add-customer";
    }

    @PostMapping("/save")
    public String save(@Validated CustomerDTO customerDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "customers/add-customer";
        }

        service.save(customerDTO);

        return "customers/saved-success";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("customers", service.findAll());
        return "customers/list";
    }

}
