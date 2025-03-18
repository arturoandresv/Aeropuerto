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

    private Pasaporte crearPasaporteEjemplo() {
        return Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("6789")
                        .build())
                .build();
    }

    @Test
    void testFindById() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        Optional<Pasaporte> result = pasaporteRepository.findByid(pasaporte.getId());
        assertTrue(result.isPresent());
        assertEquals(pasaporte.getId(), result.get().getId());
    }

    @Test
    void testFindByNumero() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        Optional<Pasaporte> result = pasaporteRepository.findByNumero(pasaporte.getNumero());
        assertTrue(result.isPresent());
        assertEquals("12345", result.get().getNumero());
    }

    @Test
    void testFindByIdAndNumero() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        Optional<Pasaporte> result = pasaporteRepository.findByIdAndNumero(pasaporte.getId(), pasaporte.getNumero());
        assertTrue(result.isPresent());
        assertEquals(pasaporte.getNumero(), result.get().getNumero());
    }

    @Test
    void testFindAllByOrderByIdDesc() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        List<Pasaporte> result = pasaporteRepository.findAllByOrderByIdDesc();
        assertFalse(result.isEmpty());
        assertEquals(pasaporte.getId(), result.get(0).getId()); // El único insertado debe estar primero
    }

    @Test
    void testFindAllByOrderByIdAsc() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        List<Pasaporte> result = pasaporteRepository.findAllByOrderByIdAsc();
        assertFalse(result.isEmpty());
        assertEquals(pasaporte.getId(), result.get(0).getId());
    }

    @Test
    void testObtenerPasaportesOrdenadosAsc() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        List<Pasaporte> result = pasaporteRepository.obtenerPasaportesOrdenadosAsc();
        assertFalse(result.isEmpty());
        assertTrue(result.stream().anyMatch(p -> p.getNumero().equals("12345")));
    }

    @Test
    void testContarPasaportes() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        Long count = pasaporteRepository.contarPasaportes();
        assertEquals(1L, count);
    }

    @Test
    void testBuscarPorNumero() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        Pasaporte result = pasaporteRepository.buscarPorNumero(pasaporte.getNumero());
        assertNotNull(result);
        assertEquals("12345", result.getNumero());
    }

    @Test
    void testBuscarPorListaIds() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        List<Long> ids = new ArrayList<>();
        ids.add(pasaporte.getId());

        List<Pasaporte> result = pasaporteRepository.buscarPorListaIds(ids);
        assertFalse(result.isEmpty());
        assertEquals(pasaporte.getId(), result.get(0).getId());
    }

    @Test
    void testBuscarPorNumeroParcial() {
        Pasaporte pasaporte = crearPasaporteEjemplo();
        pasaporteRepository.save(pasaporte);

        List<Pasaporte> result = pasaporteRepository.buscarPorNumeroParcial("234");
        assertFalse(result.isEmpty());
        assertTrue(result.get(0).getNumero().contains("234"));
    }
}