package edu.unimagdalena.aeropuerto.repositories;

import org.junit.jupiter.api.Test;
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
class ReservaRepositoryTest {

    @Test
    void findById() {
    }

    @Test
    void findByCodigoReserva() {
    }

    @Test
    void findByCodigoReservaAndId() {
    }

    @Test
    void findAllByOrderByIdDesc() {
    }

    @Test
    void findAllByOrderByIdAsc() {
    }

    @Test
    void buscarPorCodigoReserva() {
    }

    @Test
    void buscarPorPasajeroId() {
    }

    @Test
    void buscarPorVueloId() {
    }

    @Test
    void contarPorVueloId() {
    }

    @Test
    void contarPorPasajeroYVueloId() {
    }
}