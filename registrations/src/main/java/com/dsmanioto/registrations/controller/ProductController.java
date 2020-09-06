package com.dsmanioto.registrations.controller;

import com.dsmanioto.registrations.controller.model.ProductDTO;
import com.dsmanioto.registrations.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/signup")
    public String showSignUpForm(ProductDTO productDTO) {
        return "products/add-product";
    }

    @PostMapping("/save")
    public String save(@Validated ProductDTO productDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "products/add-product";
        }

        service.save(productDTO);

        return "products/saved-success";
    }

    @GetMapping("/list")
    public String showUpdateForm(Model model) {
        model.addAttribute("products", service.findAll());
        return "products/list";
    }

}
