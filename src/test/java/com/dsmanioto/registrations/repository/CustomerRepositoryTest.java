package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("local")
class CustomerRepositoryTest {

    private final CustomerRepository repository;

    @Autowired
    public CustomerRepositoryTest(CustomerRepository repository) {
        this.repository = repository;
    }

    @Test
    public void validateSaveSuccess() {
        final Customer customer = createCustomer("Daniel");
        final Customer customerSaved = repository.save(customer);
        validateAllFields(customerSaved, customer);
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
        validateAllFields(customerSaved, customer.get());

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
                .name(name)
                .email(name + ".personal@smanioto.com")
                .build();
    }

    private void validateAllFields(Customer customerSaved, Customer customer) {
        Assertions.assertEquals(customerSaved.getName(), customer.getName());
        Assertions.assertEquals(customerSaved.getEmail(), customer.getEmail());
    }

}
