package com.dsmanioto.registrations.repository;

import com.dsmanioto.registrations.model.Salesman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("local")
class SalesmanRepositoryTest {

    private final SalesmanRepository repository;

    @Autowired
    public SalesmanRepositoryTest(SalesmanRepository repository) {
        this.repository = repository;
    }

    @Test
    public void validateSaveSuccess() {
        final Salesman salesman = createSalesman("Daniel");
        final Salesman salesmanSaved = repository.save(salesman);
        validateAllFields(salesmanSaved, salesman);
    }

    @Test
    public void validateFindById() {
        final Salesman salesmanSaved = repository.save(createSalesman("Daniel"));

        Optional<Salesman> salesman = repository.findById(salesmanSaved.getId());
        validateAllFields(salesmanSaved, salesman.get());
    }

    @Test
    public void validateDeleteById() {
        final Salesman salesmanSaved = repository.save(createSalesman("Daniel"));

        Optional<Salesman> salesman = repository.findById(salesmanSaved.getId());
        Assertions.assertEquals(salesmanSaved.getId(), salesman.get().getId());
        Assertions.assertEquals(salesmanSaved.getName(), salesman.get().getName());

        repository.deleteById(salesmanSaved.getId());
        salesman = repository.findById(salesmanSaved.getId());
        org.assertj.core.api.Assertions.assertThat(salesman).isEmpty();
    }

    @Test
    public void validateUpdateName() {
        Salesman salesman = createSalesman("Daniel");
        final Salesman salesmanSaved = repository.save(salesman);
        validateAllFields(salesmanSaved, salesman);

        salesman = repository.findById(salesmanSaved.getId()).get();
        validateAllFields(salesmanSaved, salesman);

        salesman.setName("Carol");
        repository.save(salesman);

        Assertions.assertEquals("Carol", repository.findById(salesmanSaved.getId()).get().getName());
    }

    @Test
    public void validateTestAllSort() {
        int qtdeDataBefore = repository.findAll().size();
        repository.save(createSalesman("Daniel"));
        repository.save(createSalesman("Daniela"));
        repository.save(createSalesman("Carol"));
        repository.save(createSalesman("Daniel"));
        repository.save(createSalesman("Durvalino"));
        repository.save(createSalesman("Eutalia"));
        repository.save(createSalesman("Anta"));

        List<Salesman> salesmans = repository.findAll(Sort.by("name"));
        Assertions.assertEquals(7 + qtdeDataBefore, salesmans.size());
        Assertions.assertEquals("Anta", salesmans.get(0).getName());
    }

    private Salesman createSalesman(String name) {
        return Salesman.builder()
                .name(name)
                .email(name + "@gmail.com")
                .build();
    }

    private void validateAllFields(Salesman salesmanSaved, Salesman salesman) {
        Assertions.assertEquals(salesmanSaved.getName(), salesman.getName());
        Assertions.assertEquals(salesmanSaved.getEmail(), salesman.getEmail());
    }

}
