package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.entities.Reserva;
import edu.unimagdalena.aeropuerto.entities.Vuelo;
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
class ReservaRepositoryTest {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private PasajeroRepository pasajeroRepository;
    @Autowired
    private VueloRepository vueloRepository;
    private Reserva crearReservaEjemplo1() {
        Pasajero pasajero = Pasajero.builder()
                .nombre("Juan Pérez")
                .NID("12345")
                .build();
        pasajero = pasajeroRepository.save(pasajero); // Guardar en la BD

        Vuelo vuelo = Vuelo.builder()
                .numeroVuelo(UUID.randomUUID())
                .origen("Bogotá")
                .destino("Medellín")
                .build();
        vuelo = vueloRepository.save(vuelo); // Guardar en la BD

        return Reserva.builder()
                .codigoReserva(UUID.randomUUID())
                .pasajero(pasajero) // Asociar pasajero persistido
                .vuelo(vuelo) // Asociar vuelo persistido
                .build();
    }
    private Reserva crearReservaEjemplo2() {
        Pasajero pasajero = Pasajero.builder()
                .nombre("Pedro Barrios")
                .NID("67890")
                .build();
        pasajero = pasajeroRepository.save(pasajero); // Guardar en la BD

        Vuelo vuelo = Vuelo.builder()
                .numeroVuelo(UUID.randomUUID())
                .origen("Cali")
                .destino("Medellín")
                .build();
        vuelo = vueloRepository.save(vuelo); // Guardar en la BD

        return Reserva.builder()
                .codigoReserva(UUID.randomUUID())
                .pasajero(pasajero) // Asociar pasajero persistido
                .vuelo(vuelo) // Asociar vuelo persistido
                .build();
    }

    @Test
    void findById() {
        Reserva reserva = crearReservaEjemplo1();
        reserva = reservaRepository.save(reserva);

        Optional<Reserva> result = reservaRepository.findById(reserva.getId());
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), result.get().getId());
    }

    @Test
    void findByCodigoReserva() {
        Reserva reserva = crearReservaEjemplo1();
        reserva = reservaRepository.save(reserva);

        Optional<Reserva> result = reservaRepository.findByCodigoReserva(reserva.getCodigoReserva());
        assertTrue(result.isPresent());
        assertEquals(reserva.getCodigoReserva(), result.get().getCodigoReserva());
    }

    @Test
    void findByCodigoReservaAndId() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);

        Optional<Reserva> reserva = reservaRepository.findByCodigoReservaAndId(reserva1.getCodigoReserva(), reserva1.getId());
        assertTrue(reserva.isPresent());
        assertEquals(reserva1.getId(), reserva.get().getId());
        assertEquals(reserva1.getCodigoReserva(), reserva.get().getCodigoReserva());
    }

    @Test
    void findAllByOrderByIdDesc() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);
        Reserva reserva2 = crearReservaEjemplo2();
        reserva2 = reservaRepository.save(reserva2);

        List<Reserva> reservas = reservaRepository.findAllByOrderByIdDesc();
        assertFalse(reservas.isEmpty());
        assertEquals(reserva2.getId(), reservas.get(0).getId());
    }

    @Test
    void findAllByOrderByIdAsc() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);
        Reserva reserva2 = crearReservaEjemplo2();
        reserva2 = reservaRepository.save(reserva2);

        List<Reserva> reservas = reservaRepository.findAllByOrderByIdAsc();
        assertFalse(reservas.isEmpty());
        assertEquals(reserva1.getId(), reservas.get(0).getId());
    }

    @Test
    void buscarPorCodigoReserva() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);

        Optional<Reserva> reserva = reservaRepository.buscarPorCodigoReserva(reserva1.getCodigoReserva());
        assertTrue(reserva.isPresent());
        assertEquals(reserva1.getId(), reserva.get().getId());
    }

    @Test
    void buscarPorPasajeroId() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);

        List<Reserva> reservas = reservaRepository.buscarPorPasajeroId(reserva1.getPasajero().getId());
        assertFalse(reservas.isEmpty());
        assertEquals(reserva1.getPasajero().getId(), reservas.get(0).getPasajero().getId());
    }

    @Test
    void buscarPorVueloId() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);

        List<Reserva> reservas = reservaRepository.buscarPorVueloId(reserva1.getVuelo().getId());
        assertFalse(reservas.isEmpty());
        assertEquals(reserva1.getVuelo().getId(), reservas.get(0).getVuelo().getId());
    }
    @Test
    void contarPorVueloId() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);

        int resultado = reservaRepository.ContarPorVueloId(reserva1.getVuelo().getId());
        assertEquals(1, resultado);
    }

    @Test
    void contarPorPasajeroYVueloId() {
        Reserva reserva1 = crearReservaEjemplo1();
        reserva1 = reservaRepository.save(reserva1);

        int resultado = reservaRepository.ContarPorPasajeroYVueloId(reserva1.getPasajero().getId(), reserva1.getVuelo().getId());
        assertEquals(1, resultado);
    }
}