package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
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
class PasajeroRepositoryTest {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    @Test
    void findAllByNombre() {
    }

    @Test
    void findAllByOrderByIdDesc() {
    }

    @Test
    void findAllByOrderByIdAsc() {
    }

    @Test
    void findAllById() {
    }

    @Test
    void findAllByOrderByNombreAsc() {
    }

    @Test
    void totalDePasajeros() {
    }

    @Test
    void mostrarTodosLosPasajeros() {
    }

    @Test
    void buscarPorNID() {
    }

    @Test
    void buscarPorNumeroDePasaporte() {
    }

    @Test
    void buscarPasajerosConReservas() {
    }
}