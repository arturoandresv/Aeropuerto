package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Vuelo;
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

import java.util.Optional;
import java.util.UUID;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class VueloRepositoryTest {

    @Container
    public static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:17.4")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    @Autowired
    private VueloRepository vueloRepository;

    @Test
    public void testFindByNumeroVuelo() {
        Vuelo vuelo = Vuelo.builder()
                .numeroVuelo(UUID.fromString("290c6a96-f43b-4cd8-873d-28a6da984038"))
                .origen("Colombia")
                .destino("España")
                .build();

        vueloRepository.save(vuelo);
        Optional<Vuelo> vuelo1 = vueloRepository.findByNumeroVuelo(vuelo.getNumeroVuelo());
        Assertions.assertTrue(vuelo1.isPresent());
    }
}
