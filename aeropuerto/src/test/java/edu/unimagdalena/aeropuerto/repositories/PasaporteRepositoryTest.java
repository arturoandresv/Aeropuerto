package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.entities.Pasaporte;
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
    private PasaporteRepository pasaporteRepository;

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
}
