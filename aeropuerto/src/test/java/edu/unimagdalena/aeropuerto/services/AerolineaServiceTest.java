package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.repositories.AerolineaRepository;
import org.assertj.core.util.Arrays;
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
class AerolineaServiceTest {

    @Mock
    private AerolineaRepository aerolineaRepository;

    @InjectMocks
    private AerolineasServiceImpl aerolineaService;

    @Test
    void findAllByOrderByIdDesc() {
        Aerolinea aerolinea1 = Aerolinea.builder().id(1L).nombre("Latam").build();
        Aerolinea aerolinea2 = Aerolinea.builder().id(2L).nombre("Avianca").build();

        when(aerolineaRepository.findAllByOrderByIdDesc()).thenReturn(List.of(aerolinea2, aerolinea1));
        List<Aerolinea> aerolineas = aerolineaService.findAllByOrderByIdDesc();
        assertEquals(2, aerolineas.size());
        assertEquals("Avianca", aerolineas.get(0).getNombre());
        verify(aerolineaRepository, times(1)).findAllByOrderByIdDesc();
    }

    @Test
    void findAllByOrderByIdAsc() {
        Aerolinea aerolinea1 = Aerolinea.builder().id(1L).nombre("Latam").build();
        Aerolinea aerolinea2 = Aerolinea.builder().id(2L).nombre("Avianca").build();

        when(aerolineaRepository.findAllByOrderByIdAsc()).thenReturn(List.of(aerolinea1, aerolinea2));
        List<Aerolinea> aerolineas = aerolineaService.findAllByOrderByIdAsc();
        assertEquals(2, aerolineas.size());
        assertEquals("Latam", aerolineas.get(0).getNombre());
        verify(aerolineaRepository, times(1)).findAllByOrderByIdAsc();
    }

    @Test
    void findByid() {
        Aerolinea aerolinea = Aerolinea.builder().id(1L).nombre("Latam").build();

        when(aerolineaRepository.findByid(1L)).thenReturn(Optional.of(aerolinea));

        Optional<Aerolinea> aerolinea1 = aerolineaService.findByid(1L);
        assertTrue(aerolinea1.isPresent());
        assertEquals("Latam", aerolinea1.get().getNombre());
        verify(aerolineaRepository, times(1)).findByid(1L);
    }

    @Test
    void findByIdLessThan() {
        Aerolinea aerolinea = Aerolinea.builder().id(1L).nombre("Latam").build();
        when(aerolineaRepository.findByIdLessThan(2L)).thenReturn(List.of(aerolinea));
        List<Aerolinea> aerolineas = aerolineaService.findByIdLessThan(2L);
        assertEquals(1, aerolineas.size());
        assertEquals("Latam", aerolineas.get(0).getNombre());
        verify(aerolineaRepository, times(1)).findByIdLessThan(2L);
    }

    @Test
    void findByNombreContaining() {
        Aerolinea aerolinea = Aerolinea.builder().id(1L).nombre("Latam Airlines").build();
        when(aerolineaRepository.findByNombreContaining("Latam")).thenReturn(List.of(aerolinea));
        List<Aerolinea> aerolineas = aerolineaService.findByNombreContaining("Latam");

        assertEquals(1, aerolineas.size());
        assertTrue(aerolineas.get(0).getNombre().contains("Latam"));
        verify(aerolineaRepository, times(1)).findByNombreContaining("Latam");
    }

    @Test
    void obtenerAerolineasOrdenadasAsc() {
        Aerolinea a1 = Aerolinea.builder().id(1L).nombre("Latam").build();
        Aerolinea a2 = Aerolinea.builder().id(2L).nombre("Avianca").build();

        when(aerolineaRepository.obtenerAerolineasOrdenadasAsc()).thenReturn(List.of(a1, a2));

        List<Aerolinea> result = aerolineaService.obtenerAerolineasOrdenadasAsc();

        assertEquals(2, result.size());
        assertEquals("Latam", result.get(0).getNombre());
        verify(aerolineaRepository, times(1)).obtenerAerolineasOrdenadasAsc();
    }

    @Test
    void obtenerAerolineasOrdenadaDesc() {
        Aerolinea a1 = Aerolinea.builder().id(1L).nombre("Latam").build();
        Aerolinea a2 = Aerolinea.builder().id(2L).nombre("Avianca").build();

        when(aerolineaRepository.obtenerAerolineasOrdenadasDesc()).thenReturn(List.of(a2, a1));

        List<Aerolinea> result = aerolineaService.obtenerAerolineasOrdenadaDesc();

        assertEquals(2, result.size());
        assertEquals("Avianca", result.get(0).getNombre());
        verify(aerolineaRepository, times(1)).obtenerAerolineasOrdenadasDesc();
    }

    @Test
    void obtenerAerolineasConVuelos() {
        Aerolinea a1 = Aerolinea.builder().id(1L).nombre("Latam").build();
        Aerolinea a2 = Aerolinea.builder().id(2L).nombre("Avianca").build();

        when(aerolineaRepository.obtenerAerolineasConVuelos()).thenReturn(List.of(a1, a2));

        List<Aerolinea> result = aerolineaService.obtenerAerolineasConVuelos();

        assertEquals(2, result.size());
        verify(aerolineaRepository, times(1)).obtenerAerolineasConVuelos();
    }

    @Test
    void buscarAerolineasPorVuelo() {
        Aerolinea a1 = Aerolinea.builder().id(1L).nombre("Latam").build();

        when(aerolineaRepository.buscarAerolineasPorVuelo(1L)).thenReturn(List.of(a1));

        List<Aerolinea> result = aerolineaService.buscarAerolineasPorVuelo(1L);

        assertEquals(1, result.size());
        assertEquals("Latam", result.get(0).getNombre());
        verify(aerolineaRepository, times(1)).buscarAerolineasPorVuelo(1L);
    }

    @Test
    void contarVuelosPorAerolinea() {
        when(aerolineaRepository.contarVuelosPorAerolinea(1L)).thenReturn(3L);

        Long count = aerolineaService.contarVuelosPorAerolinea(1L);

        assertEquals(3, count);
        verify(aerolineaRepository, times(1)).contarVuelosPorAerolinea(1L);
    }
}