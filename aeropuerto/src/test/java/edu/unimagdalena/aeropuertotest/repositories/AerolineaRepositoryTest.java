package edu.unimagdalena.aeropuertotest.repositories;

import edu.unimagdalena.aeropuertotest.entities.Aerolinea;
import edu.unimagdalena.aeropuertotest.entities.Vuelo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.Set;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AerolineaRepositoryTest {

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17.4")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

//    @Autowired
//    private AerolineaRepository aerolineaRepository;

//    @Test
//    public void obtenerAerolineasOrdenadasAsc(){
//        Aerolinea aerolinea = Aerolinea.builder()
//                .nombre("Avianca")
//                .build();
//
//        aerolineaRepository.save(aerolinea);
//
//        aerolineaRepository.obtenerAerolineasOrdenadasAsc();
//
//    }






}
