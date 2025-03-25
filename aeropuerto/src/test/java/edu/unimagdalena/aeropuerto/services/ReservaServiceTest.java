package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Reserva;
import edu.unimagdalena.aeropuerto.repositories.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservasServiceImpl reservaService;

    @Test
    void findById() {
        Reserva reserva = Reserva.builder()
                .id(1L)
                .codigoReserva(UUID.randomUUID())
                .build();

        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        Optional<Reserva> result = reservaService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(reservaRepository, times(1)).findById(1L);
    }

    @Test
    void findByCodigoReserva() {
        Reserva reserva = Reserva.builder()
                .codigoReserva(UUID.randomUUID())
                .build();

        when(reservaRepository.findByCodigoReserva(reserva.getCodigoReserva())).thenReturn(Optional.of(reserva));

        Optional<Reserva> result = reservaService.findByCodigoReserva(reserva.getCodigoReserva());

        assertTrue(result.isPresent());
        assertEquals(reserva.getCodigoReserva(), result.get().getCodigoReserva());
        verify(reservaRepository, times(1)).findByCodigoReserva(reserva.getCodigoReserva());
    }

    @Test
    void findByCodigoReservaAndId() {
        Reserva reserva = Reserva.builder()
                .id(1L)
                .codigoReserva(UUID.randomUUID())
                .build();

        when(reservaRepository.findByCodigoReservaAndId(reserva.getCodigoReserva(), 1L)).thenReturn(Optional.of(reserva));

        Optional<Reserva> result = reservaService.findByCodigoReservaAndId(reserva.getCodigoReserva(), 1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals(reserva.getCodigoReserva(), result.get().getCodigoReserva());
        verify(reservaRepository, times(1)).findByCodigoReservaAndId(reserva.getCodigoReserva(), 1L);
    }

    @Test
    void findAllByOrderByIdDesc() {
        List<Reserva> reservas = List.of(
                Reserva.builder().id(2L).build(),
                Reserva.builder().id(1L).build()
        );

        when(reservaRepository.findAllByOrderByIdDesc()).thenReturn(reservas);

        List<Reserva> result = reservaService.findAllByOrderByIdDesc();

        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).getId());
        verify(reservaRepository, times(1)).findAllByOrderByIdDesc();
    }

    @Test
    void findAllByOrderByIdAsc() {
        List<Reserva> reservas = List.of(
                Reserva.builder().id(1L).build(),
                Reserva.builder().id(2L).build()
        );

        when(reservaRepository.findAllByOrderByIdAsc()).thenReturn(reservas);

        List<Reserva> result = reservaService.findAllByOrderByIdAsc();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        verify(reservaRepository, times(1)).findAllByOrderByIdAsc();
    }

    @Test
    void buscarPorCodigoReserva() {
        Reserva reserva = Reserva.builder()
                .codigoReserva(UUID.randomUUID())
                .build();

        when(reservaRepository.buscarPorCodigoReserva(reserva.getCodigoReserva())).thenReturn(Optional.of(reserva));

        Optional<Reserva> result = reservaService.buscarPorCodigoReserva(reserva.getCodigoReserva());

        assertTrue(result.isPresent());
        assertEquals(reserva.getCodigoReserva(), result.get().getCodigoReserva());
        verify(reservaRepository, times(1)).buscarPorCodigoReserva(reserva.getCodigoReserva());
    }

    @Test
    void buscarPorPasajeroId() {
        List<Reserva> reservas = List.of(
                Reserva.builder().id(1L).build(),
                Reserva.builder().id(2L).build()
        );

        when(reservaRepository.buscarPorPasajeroId(1L)).thenReturn(reservas);

        List<Reserva> result = reservaService.buscarPorPasajeroId(1L);

        assertEquals(2, result.size());
        verify(reservaRepository, times(1)).buscarPorPasajeroId(1L);
    }

    @Test
    void buscarPorVueloId() {
        List<Reserva> reservas = List.of(
                Reserva.builder().id(3L).build(),
                Reserva.builder().id(4L).build()
        );

        when(reservaRepository.buscarPorVueloId(2L)).thenReturn(reservas);

        List<Reserva> result = reservaService.buscarPorVueloId(2L);

        assertEquals(2, result.size());
        verify(reservaRepository, times(1)).buscarPorVueloId(2L);
    }

    @Test
    void contarPorVueloId() {
        when(reservaRepository.ContarPorVueloId(2L)).thenReturn(5);

        int count = reservaService.ContarPorVueloId(2L);

        assertEquals(5, count);
        verify(reservaRepository, times(1)).ContarPorVueloId(2L);
    }

    @Test
    void contarPorPasajeroYVueloId() {
        when(reservaRepository.ContarPorPasajeroYVueloId(1L, 2L)).thenReturn(3);

        int count = reservaService.ContarPorPasajeroYVueloId(1L, 2L);

        assertEquals(3, count);
        verify(reservaRepository, times(1)).ContarPorPasajeroYVueloId(1L, 2L);
    }
}