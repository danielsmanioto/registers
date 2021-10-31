package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Product;
import com.dsmanioto.registrations.model.UserReg;
import com.dsmanioto.registrations.repository.ProductRepository;
import com.dsmanioto.registrations.util.CurrentSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@ActiveProfiles("local")
@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    @Mock
    private CurrentSession currentSession;

    @Test
    public void validateSave() {
        BDDMockito.when(currentSession.getUserReg()).thenReturn(criarUser());
        service.save(createProduct());
    }

    private UserReg criarUser() {
        return UserReg.builder()
                .admin(true)
                .login("daniel")
                .build();
    }

    @Test
    public void validateDeleteById() {
        service.deleteById(1L);
    }

    @Test
    public void validateFindAll() {
        BDDMockito.given(repository.findAll())
                .willReturn(findAllProducts());

        List<Product> products = service.findAll();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(3);
    }

    private Product createProduct() {
        return Product.builder()
                .name("coca cola")
                .price(BigDecimal.valueOf(2.98))
                .build();
    }

    private List<Product> findAllProducts() {
        return Arrays.asList(createProduct(), createProduct(), createProduct());
    }

}
