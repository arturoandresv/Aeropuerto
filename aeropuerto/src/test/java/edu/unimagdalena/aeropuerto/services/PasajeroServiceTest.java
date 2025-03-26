package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.repositories.PasajeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PasajeroServiceTest {

    @Mock
    private PasajeroRepository pasajeroRepository;

    @InjectMocks
    private PasajerosServiceImpl pasajeroService;

    @Test
    void findAllByNombre() {
        Pasajero pasajero = Pasajero.builder().id(1L).nombre("Juan").NID("12345").build();

        when(pasajeroRepository.findAllByNombre("Juan")).thenReturn(Optional.of(pasajero));

        Optional<Pasajero> result = pasajeroService.findAllByNombre("Juan");

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
        verify(pasajeroRepository, times(1)).findAllByNombre("Juan");
    }

    @Test
    void findAllByOrderByIdDesc() {
        Pasajero p1 = Pasajero.builder().id(1L).nombre("Juan").build();
        Pasajero p2 = Pasajero.builder().id(2L).nombre("Pedro").build();

        when(pasajeroRepository.findAllByOrderByIdDesc()).thenReturn(List.of(p2, p1));

        List<Pasajero> result = pasajeroService.findAllByOrderByIdDesc();

        assertEquals(2, result.size());
        assertEquals("Pedro", result.get(0).getNombre());
        verify(pasajeroRepository, times(1)).findAllByOrderByIdDesc();
    }

    @Test
    void findAllByOrderByIdAsc() {
        Pasajero p1 = Pasajero.builder().id(1L).nombre("Juan").build();
        Pasajero p2 = Pasajero.builder().id(2L).nombre("Pedro").build();

        when(pasajeroRepository.findAllByOrderByIdAsc()).thenReturn(List.of(p1, p2));

        List<Pasajero> result = pasajeroService.findAllByOrderByIdAsc();

        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getNombre());
        verify(pasajeroRepository, times(1)).findAllByOrderByIdAsc();
    }

    @Test
    void findAllById() {
        Pasajero pasajero = Pasajero.builder().id(1L).nombre("Juan").build();

        when(pasajeroRepository.findAllById(1L)).thenReturn(Optional.of(pasajero));

        Optional<Pasajero> result = pasajeroService.findAllById(1L);

        assertTrue(result.isPresent());
        assertEquals("Juan", result.get().getNombre());
        verify(pasajeroRepository, times(1)).findAllById(1L);
    }

    @Test
    void findAllByOrderByNombreAsc() {
        Pasajero p1 = Pasajero.builder().id(1L).nombre("Carlos").build();
        Pasajero p2 = Pasajero.builder().id(2L).nombre("Juan").build();

        when(pasajeroRepository.findAllByOrderByNombreAsc()).thenReturn(List.of(p1, p2));

        List<Pasajero> result = pasajeroService.findAllByOrderByNombreAsc();

        assertEquals(2, result.size());
        assertEquals("Carlos", result.get(0).getNombre());
        verify(pasajeroRepository, times(1)).findAllByOrderByNombreAsc();
    }

    @Test
    void totalDePasajeros() {
        when(pasajeroRepository.TotalDePasajeros()).thenReturn(10L);

        Long count = pasajeroService.TotalDePasajeros();

        assertEquals(10, count);
        verify(pasajeroRepository, times(1)).TotalDePasajeros();
    }

    @Test
    void mostrarTodosLosPasajeros() {
        Pasajero p1 = Pasajero.builder().id(1L).nombre("Carlos").build();
        Pasajero p2 = Pasajero.builder().id(2L).nombre("Juan").build();

        when(pasajeroRepository.MostrarTodosLosPasajeros()).thenReturn(List.of(p1, p2));

        List<Pasajero> result = pasajeroService.MostrarTodosLosPasajeros();

        assertEquals(2, result.size());
        verify(pasajeroRepository, times(1)).MostrarTodosLosPasajeros();
    }

    @Test
    void buscarPorNID() {
        Pasajero pasajero = Pasajero.builder().id(1L).nombre("Juan").NID("12345").build();

        when(pasajeroRepository.BuscarPorNID("12345")).thenReturn(pasajero);

        Pasajero result = pasajeroService.BuscarPorNID("12345");

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(pasajeroRepository, times(1)).BuscarPorNID("12345");
    }

    @Test
    void buscarPorNumeroDePasaporte() {
        Pasajero pasajero = Pasajero.builder().id(1L).nombre("Juan").NID("12345").build();

        when(pasajeroRepository.BuscarPorNumeroDePasaporte("09876")).thenReturn(pasajero);

        Pasajero result = pasajeroService.BuscarPorNumeroDePasaporte("09876");

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(pasajeroRepository, times(1)).BuscarPorNumeroDePasaporte("09876");
    }

    @Test
    void buscarPasajerosConReservas() {
        Pasajero p1 = Pasajero.builder().id(1L).nombre("Carlos").build();
        Pasajero p2 = Pasajero.builder().id(2L).nombre("Juan").build();

        when(pasajeroRepository.BuscarPasajerosConReservas()).thenReturn(List.of(p1, p2));

        List<Pasajero> result = pasajeroService.BuscarPasajerosConReservas();

        assertEquals(2, result.size());
        verify(pasajeroRepository, times(1)).BuscarPasajerosConReservas();
    }
}