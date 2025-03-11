package edu.unimagdalena.aeropuertotest.repositories;

import edu.unimagdalena.aeropuertotest.entities.Pasajero;
import edu.unimagdalena.aeropuertotest.entities.Pasaporte;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PasaporteRepositoryTest {

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17.4")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @Autowired
    public PasaporteRepository pasaporteRepository;

    @Autowired
    public PasajeroRepository pasajeroRepository;

    @Test
    public void buscarPasaportePorNumero() {
        Pasajero pasajero = Pasajero.builder()
                .nombre("Jose")
                .NID("6789")
                .build();

        pasajero = pasajeroRepository.save(pasajero);

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(pasajero)
                .build();

        pasaporteRepository.save(pasaporte);

        Pasaporte expected = pasaporteRepository.buscarPorNumero("12345");
        Assertions.assertEquals(expected.getNumero(), pasaporte.getNumero());
    }
}
