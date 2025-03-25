package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Vuelo;
import edu.unimagdalena.aeropuerto.repositories.VueloRepository;
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
class VueloServiceTest {

    @Mock
    private VueloRepository vueloRepository;

    @InjectMocks
    private VuelosServiceImpl vueloService;

    @Test
    void findById() {
        Vuelo vuelo = Vuelo.builder().id(1L).build();
        when(vueloRepository.findById(1L)).thenReturn(Optional.of(vuelo));

        Optional<Vuelo> result = vueloService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(vueloRepository, times(1)).findById(1L);
    }

    @Test
    void findAllById() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().id(1L).build(), Vuelo.builder().id(2L).build());
        when(vueloRepository.findAllById(1L)).thenReturn(vuelos);

        List<Vuelo> result = vueloService.findAllById(1L);

        assertEquals(2, result.size());
        verify(vueloRepository, times(1)).findAllById(1L);
    }

    @Test
    void findAllByOrigen() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().origen("Bogotá").build());
        when(vueloRepository.findAllByOrigen("Bogotá")).thenReturn(vuelos);

        List<Vuelo> result = vueloService.findAllByOrigen("Bogotá");

        assertEquals(1, result.size());
        assertEquals("Bogotá", result.get(0).getOrigen());
        verify(vueloRepository, times(1)).findAllByOrigen("Bogotá");
    }

    @Test
    void findAllByDestino() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().destino("Medellín").build());
        when(vueloRepository.findAllByDestino("Medellín")).thenReturn(vuelos);

        List<Vuelo> result = vueloService.findAllByDestino("Medellín");

        assertEquals(1, result.size());
        assertEquals("Medellín", result.get(0).getDestino());
        verify(vueloRepository, times(1)).findAllByDestino("Medellín");
    }

    @Test
    void findByNumeroVuelo() {
        Vuelo vuelo = Vuelo.builder().numeroVuelo(UUID.randomUUID()).build();
        when(vueloRepository.findByNumeroVuelo(vuelo.getNumeroVuelo())).thenReturn(Optional.of(vuelo));

        Optional<Vuelo> result = vueloService.findByNumeroVuelo(vuelo.getNumeroVuelo());

        assertTrue(result.isPresent());
        assertEquals(vuelo.getNumeroVuelo(), result.get().getNumeroVuelo());
        verify(vueloRepository, times(1)).findByNumeroVuelo(vuelo.getNumeroVuelo());
    }

    @Test
    void obtenerVuelosOrdenadosAsc() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().id(1L).build(), Vuelo.builder().id(2L).build());
        when(vueloRepository.obtenerVuelosOrdenadosAsc()).thenReturn(vuelos);

        List<Vuelo> result = vueloService.obtenerVuelosOrdenadosAsc();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        verify(vueloRepository, times(1)).obtenerVuelosOrdenadosAsc();
    }

    @Test
    void obtenerVuelosOrdenadosDesc() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().id(2L).build(), Vuelo.builder().id(1L).build());
        when(vueloRepository.obtenerVuelosOrdenadosDesc()).thenReturn(vuelos);

        List<Vuelo> result = vueloService.obtenerVuelosOrdenadosDesc();

        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).getId());
        verify(vueloRepository, times(1)).obtenerVuelosOrdenadosDesc();
    }

    @Test
    void obtenerVuelosConAerolineas() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().id(1L).build(), Vuelo.builder().id(2L).build());
        when(vueloRepository.obtenerVuelosConAerolineas()).thenReturn(vuelos);

        List<Vuelo> result = vueloService.obtenerVuelosConAerolineas();

        assertEquals(2, result.size());
        verify(vueloRepository, times(1)).obtenerVuelosConAerolineas();
    }

    @Test
    void buscarVueloPorId() {
        List<Vuelo> vuelos = List.of(Vuelo.builder().id(1L).build());
        when(vueloRepository.buscarVueloPorId(1L)).thenReturn(vuelos);

        List<Vuelo> result = vueloService.buscarVueloPorId(1L);

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId());
        verify(vueloRepository, times(1)).buscarVueloPorId(1L);
    }

    @Test
    void contarVuelosPorAerolinea() {
        when(vueloRepository.contarVuelosPorAerolinea(1L)).thenReturn(3L);

        Long count = vueloService.contarVuelosPorAerolinea(1L);

        assertEquals(3L, count);
        verify(vueloRepository, times(1)).contarVuelosPorAerolinea(1L);
    }
}