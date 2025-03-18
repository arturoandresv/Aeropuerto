package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.entities.Reserva;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PasajeroRepositoryTest {

    @Autowired
    private PasajeroRepository pasajeroRepository;

    private Pasajero crearPasajeroEjemplo() {
        return Pasajero.builder()
                .nombre("Carlos")
                .NID("ABC123")
                .build();
    }

    @Test
    void testFindAllByNombre() {
        Pasajero pasajero = crearPasajeroEjemplo();
        pasajeroRepository.save(pasajero);

        Optional<Pasajero> result = pasajeroRepository.findAllByNombre("Carlos");
        assertTrue(result.isPresent());
        assertEquals("ABC123", result.get().getNID());
    }

    @Test
    void testFindAllByOrderByIdDesc() {
        Pasajero p1 = crearPasajeroEjemplo();
        pasajeroRepository.save(p1);

        Pasajero p2 = Pasajero.builder().nombre("Ana").NID("DEF456").build();
        pasajeroRepository.save(p2);

        List<Pasajero> result = pasajeroRepository.findAllByOrderByIdDesc();
        assertEquals(2, result.size());
        assertEquals("Ana", result.get(0).getNombre());
    }

    @Test
    void testFindAllByOrderByIdAsc() {
        Pasajero p1 = crearPasajeroEjemplo();
        pasajeroRepository.save(p1);

        Pasajero p2 = Pasajero.builder().nombre("Ana").NID("DEF456").build();
        pasajeroRepository.save(p2);

        List<Pasajero> result = pasajeroRepository.findAllByOrderByIdAsc();
        assertEquals(2, result.size());
        assertEquals("Carlos", result.get(0).getNombre());
    }

    @Test
    void testAllFindById() {
        Pasajero pasajero = crearPasajeroEjemplo();
        pasajeroRepository.save(pasajero);

        Optional<Pasajero> result = pasajeroRepository.findAllById(pasajero.getId());
        assertTrue(result.isPresent());
        assertEquals("Carlos", result.get().getNombre());
    }

    @Test
    void testFindAllByOrderByNombreAsc() {
        pasajeroRepository.save(Pasajero.builder().nombre("Zara").NID("999").build());
        pasajeroRepository.save(Pasajero.builder().nombre("Ana").NID("888").build());

        List<Pasajero> result = pasajeroRepository.findAllByOrderByNombreAsc();
        assertEquals(2, result.size());
        assertEquals("Ana", result.get(0).getNombre());
    }

    @Test
    void testTotalDePasajeros() {
        pasajeroRepository.save(crearPasajeroEjemplo());
        pasajeroRepository.save(Pasajero.builder().nombre("Laura").NID("LMN789").build());

        Long total = pasajeroRepository.TotalDePasajeros();
        assertEquals(2L, total);
    }

    @Test
    void testMostrarTodosLosPasajeros() {
        pasajeroRepository.save(crearPasajeroEjemplo());
        pasajeroRepository.save(Pasajero.builder().nombre("Laura").NID("LMN789").build());

        List<Pasajero> result = pasajeroRepository.MostrarTodosLosPasajeros();
        assertEquals(2, result.size());
    }

    @Test
    void testBuscarPorNID() {
        Pasajero pasajero = crearPasajeroEjemplo();
        pasajeroRepository.save(pasajero);

        Pasajero result = pasajeroRepository.BuscarPorNID("ABC123");
        assertNotNull(result);
        assertEquals("Carlos", result.getNombre());
    }

    @Autowired
    PasaporteRepository pasaporteRepository;

    @Test
    void testBuscarPorNumeroDePasaporte() {
        Pasajero pasajero = crearPasajeroEjemplo();
        pasajeroRepository.save(pasajero);

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("123")
                .pasajero(pasajero)
                .build();

        pasaporteRepository.save(pasaporte);

        Pasajero result = pasajeroRepository.BuscarPorNumeroDePasaporte("123");
        assertNotNull(result);
        assertEquals("Carlos", result.getNombre());
    }

    @Autowired
    ReservaRepository reservaRepository;

    @Test
    void testBuscarPasajerosConReservas() {
        Pasajero pasajero = crearPasajeroEjemplo();
        pasajeroRepository.save(pasajero);

        Reserva reserva = Reserva.builder()
                .codigoReserva(UUID.randomUUID())
                .pasajero(pasajero)
                .build();

        reservaRepository.save(reserva);

        List<Pasajero> result = pasajeroRepository.BuscarPasajerosConReservas();
        assertFalse(result.isEmpty());
        assertEquals("Carlos", result.get(0).getNombre());
    }
}