package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("local")
class ProductRepositoryTest {

    private final ProductRepository repository;

    @Autowired
    public ProductRepositoryTest(ProductRepository repository) {
        this.repository = repository;
    }

    @Test
    public void validateInsertProduct() {
        Product product = createProduct("coca cola", BigDecimal.valueOf(2.90));
        Product productSaved = repository.save(product);
        validateFields(product, productSaved);
    }

    private void validateFields(Product product, Product productSaved) {
        Assertions.assertEquals(product.getName(), productSaved.getName());
        Assertions.assertEquals(product.getPrice(), productSaved.getPrice());
    }

    private Product createProduct(String name, BigDecimal price) {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }

}
