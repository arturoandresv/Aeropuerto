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
class VueloRepositoryTest {

    @Test
    void findById() {

    }

    @Test
    void findAllById() {
    }

    @Test
    void findAllByOrigen() {
    }

    @Test
    void findAllByDestino() {
    }

    @Test
    void findByNumeroVuelo() {
    }

    @Test
    void obtenerVuelosOrdenadosAsc() {
    }

    @Test
    void obtenerVuelosOrdenadasDesc() {
    }

    @Test
    void obtenerVuelosConAerolineas() {
    }

    @Test
    void buscarVueloPorId() {
    }

    @Test
    void contarVuelosPorAerolinea() {
    }
}