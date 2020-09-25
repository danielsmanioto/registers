package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Customer;
import com.dsmanioto.registrations.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

@ActiveProfiles("local")
@SpringBootTest
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService service;

    @Mock
    private CustomerRepository repository;

    private List<Customer> findAllCustomers() {
        return Arrays.asList(createCustomer(), createCustomer());
    }

    @Test
    public void validateSave() {
        BDDMockito.given(repository.save(createCustomer()))
                .willReturn(createCustomerWithId());

        service.save(createCustomer());
    }

    @Test
    public void validateFindAll() {
        BDDMockito.given(repository.findAll())
                .willReturn(findAllCustomers());

        List<Customer> customers = service.findAll();
        Assertions.assertThat(customers).isNotNull();
        Assertions.assertThat(customers.size()).isEqualTo(2);
    }

    @Test
    public void validateDeleteById() {
        service.deleteById(1L);
    }

    private Customer createCustomerWithId() {
        return Customer.builder()
                .id(1L)
                .name("Daniel")
                .email("daniel.smanioto@gmail.com")
                .build();
    }

    private Customer createCustomer() {
        return Customer.builder()
                .name("Daniel")
                .email("daniel.smanioto@gmail.com")
                .build();
    }

}
