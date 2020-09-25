package com.dsmanioto.registrations.controller;

import com.dsmanioto.registrations.controller.dto.CustomerDTO;
import com.dsmanioto.registrations.service.CustomerService;
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
@RequestMapping("/customers")
public class CustomerController {

    private  static final String PAG_CUSTOMERS_LIST = "customers/customer-list";
    private  static final String PAG_CUSTOMERS_ADD_CUSTOMER = "customers/add-customer";

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole(ADMIN)")
    @GetMapping("/signup")
    public String showSignUpForm(CustomerDTO customerDTO) {
        return PAG_CUSTOMERS_ADD_CUSTOMER;
    }

    @PostMapping("/save")
    public String save(@Valid CustomerDTO customerDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return PAG_CUSTOMERS_ADD_CUSTOMER;
        }

        service.save(customerDTO.convertoToModel());

        return loadListPag(model);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id, Model model) {
        service.deleteById(id);

        return loadListPag(model);
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        return loadListPag(model);
    }

    private String loadListPag(Model model) {
        model.addAttribute("customers", service.findAll());
        return PAG_CUSTOMERS_LIST;
    }

}
