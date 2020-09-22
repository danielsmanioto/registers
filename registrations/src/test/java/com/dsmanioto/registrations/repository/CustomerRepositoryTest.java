package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("local")
public class CustomerRepositoryTest {

    private final CustomerRepository repository;

    @Autowired
    public CustomerRepositoryTest(CustomerRepository repository) {
        this.repository = repository;
    }

    @Test
    public void validateSaveSuccess() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));
        validateAllFields(customerSaved, customerSaved);
    }

    @Test
    public void validateFindById() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(customerSaved.getId());
        validateAllFields(customerSaved, customer.get());
    }

    @Test
    public void validateDeleteById() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(customerSaved.getId());
        Assertions.assertEquals(customerSaved.getId(), customer.get().getId());
        Assertions.assertEquals(customerSaved.getName(), customer.get().getName());

        repository.deleteById(customerSaved.getId());
        customer = repository.findById(customerSaved.getId());
        org.assertj.core.api.Assertions.assertThat(customer).isEmpty();
    }

    @Test
    public void validateDelete() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(customerSaved.getId());
        validateAllFields(customerSaved, customerSaved);

        repository.delete(customer.get());
        customer = repository.findById(customerSaved.getId());
        org.assertj.core.api.Assertions.assertThat(customer).isEmpty();
    }

    @Test
    public void validateUpdateName() {
        final Customer customerSaved = repository.save(createCustomer("Daniel"));

        Optional<Customer> customer = repository.findById(customerSaved.getId());
        validateAllFields(customerSaved, customerSaved);

        Customer customerToUpdate = customer.get();
        customerToUpdate.setName("Carol");
        repository.save(customerToUpdate);

        Assertions.assertEquals("Carol", repository.findById(customerSaved.getId()).get().getName());
    }

    private Customer createCustomer(String name) {
        return Customer.builder()
                .id(new Random().nextLong())
                .name(name)
                .email(name + ".personal@smanioto.com")
                .build();
    }

    private void validateAllFields(Customer customerSaved, Customer customerSaved2) {
        Assertions.assertEquals(customerSaved.getId(), customerSaved2.getId());
        Assertions.assertEquals(customerSaved.getName(), customerSaved2.getName());
        Assertions.assertEquals(customerSaved.getEmail(), customerSaved2.getEmail());
    }

}
