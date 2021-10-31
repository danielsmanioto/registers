package com.dsmanioto.registrations.api;

import com.dsmanioto.registrations.api.dto.ProdutoApiResponseDTO;
import com.dsmanioto.registrations.api.mapper.ProdutoApiMapper;
import com.dsmanioto.registrations.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
@RequiredArgsConstructor
public class ProdutoAPIController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Set<ProdutoApiResponseDTO>> findProducts() {
        var productsDto = productService.findAll().stream()
                .map(p -> ProdutoApiMapper.toDto(p))
                .collect(Collectors.toSet());
        return ResponseEntity.ok(productsDto);
    }

    @GetMapping("/by_params")
    public ResponseEntity<List<ProdutoApiResponseDTO>> findProductsByParam(@RequestParam(value = "login", required = false) String login,
                                                                           @RequestParam(value = "name", required = false) String name) {
        var productsDto = productService.findProductsByParameters(login, name).stream()
                .map(p -> ProdutoApiMapper.toDto(p))
                .collect(Collectors.toList());
        return ResponseEntity.ok(productsDto);
    }

}
