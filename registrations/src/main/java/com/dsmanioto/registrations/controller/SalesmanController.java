package com.dsmanioto.registrations.controller;

import com.dsmanioto.registrations.controller.dto.ProductDTO;
import com.dsmanioto.registrations.controller.dto.SalesmanDTO;
import com.dsmanioto.registrations.service.SalesmanService;
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
@RequestMapping("/salesmans")
public class SalesmanController {

    private  static final String PAG_SALESMAN_PRODUCT_LIST = "salesmans/salesman-list";
    private  static final String PAG_SALESMAN_ADD_SALESMAN = "salesmans/add-salesman";

    private final SalesmanService service;

    @Autowired
    public SalesmanController(SalesmanService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole(ADMIN)")
    @GetMapping("/signup")
    public String showSignUpForm(SalesmanDTO salesmanDTO) {
        return PAG_SALESMAN_ADD_SALESMAN;
    }

    @PostMapping("/save")
    public String save(@Valid SalesmanDTO salesmanDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return PAG_SALESMAN_ADD_SALESMAN;
        }

        service.save(salesmanDTO);

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
        model.addAttribute("salesmans", service.findAll());
        return PAG_SALESMAN_PRODUCT_LIST;
    }

}
