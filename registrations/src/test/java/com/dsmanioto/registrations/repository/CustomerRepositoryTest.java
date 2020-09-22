package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("local")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void validateSaveSuccess() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));
        Assertions.assertEquals(1L, customerSaved.getId());
        Assertions.assertEquals("Daniel", customerSaved.getName());
        Assertions.assertEquals("daniel@alksjdklajsdqe.com", customerSaved.getEmail());
    }

    @Test
    public void validateFindById() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(1L);

        Assertions.assertEquals(1L, customer.get().getId());
        Assertions.assertEquals("Daniel", customer.get().getName());
        Assertions.assertEquals("daniel@alksjdklajsdqe.com", customer.get().getEmail());
    }

    @Test
    public void validateDeleteById() {
        repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(1L);
        Assertions.assertEquals(1L, customer.get().getId());
        Assertions.assertEquals("Daniel", customer.get().getName());

        repository.deleteById(1L);
        customer = repository.findById(1L);
        org.assertj.core.api.Assertions.assertThat(customer).isEmpty();
    }

    @Test
    public void validateUpdateName() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(customerSaved.getId());
        Assertions.assertEquals(customerSaved.getId(), customer.get().getId());
        Assertions.assertEquals("Daniel", customer.get().getName());

        Customer customerToUpdate = customer.get();
        customerToUpdate.setName("Carol");
        repository.save(customerToUpdate);

        Assertions.assertEquals("Carol", repository.findById(customerSaved.getId()).get().getName());
    }

    private Customer createCustomer(String name) {
        return Customer.builder()
                .id(1L)
                .name(name)
                .email("daniel@alksjdklajsdqe.com")
                .build();
    }

}
