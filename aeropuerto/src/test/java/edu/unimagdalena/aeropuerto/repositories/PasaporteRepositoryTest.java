package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import static org.junit.jupiter.api.Assertions.*;
@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PasaporteRepositoryTest {

    @Autowired
    private PasaporteRepository pasaporteRepository;

    @Test
    void findByid() {
    }

    @Test
    void findByNumero() {
    }

    @Test
    void findByIdAndNumero() {
    }

    @Test
    void findAllByOrderByIdDesc() {
    }

    @Test
    void findAllByOrderByIdAsc() {
    }

    @Test
    void obtenerPasaportesOrdenadosAsc() {
    }

    @Test
    void contarPasaportes() {
    }


    @Test
    public void buscarPorNumero() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        Pasaporte expected = pasaporteRepository.buscarPorNumero("12345");
        Assertions.assertEquals(expected.getNumero(), pasaporte.getNumero());
    }

    @Test
    void buscarPorListaIds() {
    }

    @Test
    void buscarPorNumeroParcial() {
    }
}