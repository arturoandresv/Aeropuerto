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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        Pasaporte expected = pasaporteRepository.findById(pasaporte.getId()).get();
        Assertions.assertEquals(expected.getId(), pasaporte.getId());

    }

    @Test
    void findByNumero() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        Optional<Pasaporte> expected = pasaporteRepository.findByNumero(pasaporte.getNumero());
        Assertions.assertTrue(expected.isPresent());

    }

    @Test
    void findByIdAndNumero() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        Optional<Pasaporte> expected = pasaporteRepository.findByIdAndNumero(pasaporte.getId(), pasaporte.getNumero());
        Assertions.assertTrue(expected.isPresent());
    }

    @Test
    void findAllByOrderByIdDesc() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);
        List<Pasaporte> expected = pasaporteRepository.findAllByOrderByIdDesc();
        Assertions.assertTrue(expected.size() > 0);

    }

    @Test
    void findAllByOrderByIdAsc() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        List<Pasaporte> expected = pasaporteRepository.findAllByOrderByIdAsc();
        Assertions.assertTrue(expected.size() > 0);
    }

    @Test
    void obtenerPasaportesOrdenadosAsc() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        List<Pasaporte> expected = pasaporteRepository.findAllByOrderByIdDesc();
        Assertions.assertTrue(expected.size() > 0);
    }

    @Test
    void contarPasaportes() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);

        Long count = pasaporteRepository.contarPasaportes();
        Assertions.assertEquals(1, count);
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

        Pasaporte expected = pasaporteRepository.buscarPorNumero(pasaporte.getNumero());
        Assertions.assertEquals(expected.getNumero(), pasaporte.getNumero());
    }

    @Test
    void buscarPorListaIds() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);
        List<Long> ids = new ArrayList<>();
        ids.add(pasaporte.getId());
        List<Pasaporte> expected = pasaporteRepository.buscarPorListaIds(ids);
        Assertions.assertTrue(expected.size() > 0);



    }

    @Test
    void buscarPorNumeroParcial() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();

        pasaporteRepository.save(pasaporte);



    }
}