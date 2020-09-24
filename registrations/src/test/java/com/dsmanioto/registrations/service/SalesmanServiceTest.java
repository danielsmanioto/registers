package com.dsmanioto.registrations.service;

import com.dsmanioto.registrations.model.Salesman;
import com.dsmanioto.registrations.repository.SalesmanRepository;
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
public class SalesmanServiceTest {

    @InjectMocks
    private SalesmanService service;

    @Mock
    private SalesmanRepository repository;

    @Test
    public void validateSave() {
        service.save(createSalesman());
    }

    @Test
    public void validateDeleteById() {
        service.deleteById(1L);
    }

    @Test
    public void validateFindAll() {
        BDDMockito.given(repository.findAll())
                .willReturn(findAllSalesmans());

        List<Salesman> salesman = service.findAll();

        Assertions.assertThat(salesman).isNotNull();
        Assertions.assertThat(salesman.size()).isEqualTo(2);
    }


    private Salesman createSalesman() {
        return Salesman.builder()
                .id(1L)
                .name("Carol")
                .email("asçldlklaskd@asdjklasd.com")
                .build();
    }

    private List<Salesman> findAllSalesmans() {
        return Arrays.asList(createSalesman(), createSalesman());
    }

}
