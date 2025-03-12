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
class AerolineaRepositoryTest {

    @Test
    void findAllByOrderByIdDesc() {
    }

    @Test
    void findAllByOrderByIdAsc() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByIdLessThan() {
    }

    @Test
    void findByNombreContaining() {
    }

    @Test
    void obtenerAerolineasOrdenadasAsc() {
    }

    @Test
    void obtenerAerolineasOrdenadasDesc() {
    }

    @Test
    void obtenerAerolineasConVuelos() {
    }

    @Test
    void buscarAerolineasPorVuelo() {
    }

    @Test
    void contarVuelosPorAerolinea() {
    }
}