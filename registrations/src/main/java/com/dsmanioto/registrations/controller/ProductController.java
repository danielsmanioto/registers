package com.dsmanioto.registrations.controller;

import com.dsmanioto.registrations.controller.dto.ProductDTO;
import com.dsmanioto.registrations.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private  static final String PAG_PRODUCTS_PRODUCT_LIST = "products/product-list";
    private  static final String PAG_PRODUCTS_ADD_PRODUCT  = "products/add-product";

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole(ADMIN)")
    @GetMapping("/signup")
    public String showSignUpForm(ProductDTO productDTO) {
        return PAG_PRODUCTS_ADD_PRODUCT;
    }

    @PostMapping("/save")
    public String save(@Valid ProductDTO productDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return PAG_PRODUCTS_ADD_PRODUCT;
        }

        service.save(productDTO);

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
        model.addAttribute("products", service.findAll());
        return PAG_PRODUCTS_PRODUCT_LIST;
    }

}
