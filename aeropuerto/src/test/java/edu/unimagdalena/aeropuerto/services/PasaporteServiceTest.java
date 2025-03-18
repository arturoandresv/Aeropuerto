package edu.unimagdalena.aeropuerto.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.repositories.PasaporteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


class PasaporteServiceTest {

    @Mock
    private PasaporteRepository pasaporteRepository;

    @InjectMocks
    private PasaporteService pasaporteService;

    public PasaporteServiceTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPasaporte() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("12345")
                        .build())
                .build();

        when(pasaporteRepository.save(any(Pasaporte.class)))
                .thenReturn(Pasaporte.builder()
                        .id(1L)
                        .numero("12345")
                        .pasajero(Pasajero.builder()
                                .nombre("Jose")
                                .NID("12345")
                                .build())
                        .build());

        Pasaporte createdPasaporte = pasaporteService.createPasaporte(pasaporte);

        assertNotNull(createdPasaporte.getId());
        assertEquals("12345", createdPasaporte.getNumero());
        assertEquals("Jose", createdPasaporte.getPasajero().getNombre());
        verify(pasaporteRepository, times(1)).save(pasaporte);

    }

    @Test
    void findByNumero() {
        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("09876")
                .pasajero(Pasajero.builder()
                        .nombre("Juan")
                        .NID("12346")
                        .build())
                .build();

        when(pasaporteRepository.findByNumero("09876")).thenReturn(Optional.of(pasaporte1));
        Optional<Pasaporte> result = pasaporteService.findByNumero("09876");
        assertTrue(result.isPresent());
        assertEquals("09876", result.get().getNumero());
        verify(pasaporteRepository, times(1)).findByNumero("09876");
    }
    @Test
    void findByid() {
        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("09876")
                .id(1L)
                .pasajero(Pasajero.builder()
                        .nombre("Juan")
                        .NID("12346")
                        .build())
                .build();

        when(pasaporteRepository.findById(1L)).thenReturn(Optional.of(pasaporte1));
        Optional<Pasaporte> result = pasaporteService.findByid(1L);

        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(pasaporteRepository, times(1)).findById(1L);
    }

    @Test
    void findByIdAndNumero() {
        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("09876")
                .id(1L)
                .pasajero(Pasajero.builder()
                        .nombre("Juan")
                        .NID("12346")
                        .build())
                .build();

        when(pasaporteRepository.findByIdAndNumero(1L, "09876")).thenReturn(Optional.of(pasaporte1));
        Optional<Pasaporte> result = pasaporteService.findByIdAndNumero(1L, "09876");
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals("09876", result.get().getNumero());
        verify(pasaporteRepository, times(1)).findByIdAndNumero(1L, "09876");
    }

    @Test
    void findAllByOrderByIdDesc() {
        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("12345")
                .id(1L)
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("12345")
                        .build())
                .build();
        Pasaporte pasaporte2 = Pasaporte.builder()
                .numero("67890")
                .id(2L)
                .pasajero(Pasajero.builder()
                        .nombre("Maria")
                        .NID("67890")
                        .build())
                .build();
        List<Pasaporte> pasaportes = Arrays.asList(pasaporte2, pasaporte1);
        when(pasaporteRepository.findAllByOrderByIdDesc()).thenReturn(pasaportes);
        List<Pasaporte> result = pasaporteService.findAllByOrderByIdDesc();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(2L, result.get(0).getId());
        assertEquals(1L, result.get(1).getId());
        verify(pasaporteRepository, times(1)).findAllByOrderByIdDesc();
    }

    @Test
    void findAllByOrderByIdAsc() {
        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("12345")
                .id(1L)
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("12345")
                        .build())
                .build();
        Pasaporte pasaporte2 = Pasaporte.builder()
                .numero("67890")
                .id(2L)
                .pasajero(Pasajero.builder()
                        .nombre("Maria")
                        .NID("67890")
                        .build())
                .build();

        when(pasaporteRepository.findAllByOrderByIdAsc()).thenReturn(List.of(pasaporte1, pasaporte2));
        List<Pasaporte> result = pasaporteService.findAllByOrderByIdAsc();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
        verify(pasaporteRepository, times(1)).findAllByOrderByIdAsc();
    }

    @Test
    void obtenerPasaportesOrdenadosAsc() {

        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("12345")
                        .build())
                .build();
        Pasaporte pasaporte2 = Pasaporte.builder()
                .numero("67890")
                .pasajero(Pasajero.builder()
                        .nombre("Maria")
                        .NID("67890")
                        .build())
                .build();

        when(pasaporteRepository.obtenerPasaportesOrdenadosAsc()).thenReturn(List.of(pasaporte1, pasaporte2));

        List<Pasaporte> pasaportes = pasaporteService.obtenerPasaportesOrdenadosAsc();

        assertNotNull(pasaportes);
        assertEquals(2, pasaportes.size());
        assertEquals("12345", pasaportes.get(0).getNumero());
        assertEquals("67890", pasaportes.get(1).getNumero());
        verify(pasaporteRepository, times(1)).obtenerPasaportesOrdenadosAsc();

    }

    @Test
    void contarPasaportes() {

        when(pasaporteRepository.contarPasaportes()).thenReturn(2L);

        Long numeroPasaportes = pasaporteService.contarPasaportes();

        assertNotNull(numeroPasaportes);
        assertEquals(2L, numeroPasaportes);
        verify(pasaporteRepository, times(1)).contarPasaportes();

    }

    @Test
    void buscarPorNumero() {

        Pasaporte pasaporte = Pasaporte.builder()
                .numero("67890")
                .pasajero(Pasajero.builder()
                        .nombre("Maria")
                        .NID("67890")
                        .build())
                .build();
        when(pasaporteRepository.buscarPorNumero("67890")).thenReturn(pasaporte);

        Pasaporte result = pasaporteService.buscarPorNumero("67890");

        assertNotNull(result);
        assertEquals("67890", result.getNumero());
        verify(pasaporteRepository, times(1)).buscarPorNumero("67890");

    }

    @Test
    void buscarPorListaIds() {

        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("12345")
                        .build())
                .build();
        Pasaporte pasaporte2 = Pasaporte.builder()
                .numero("67890")
                .pasajero(Pasajero.builder()
                        .nombre("Maria")
                        .NID("67890")
                        .build())
                .build();
        Pasaporte pasaporte3 = Pasaporte.builder()
                .numero("12390")
                .pasajero(Pasajero.builder()
                        .nombre("Pedro")
                        .NID("12390")
                        .build())
                .build();

        List<Long> ids = List.of(1L,3L);

        when(pasaporteRepository.buscarPorListaIds(ids)).thenReturn(List.of(pasaporte1, pasaporte3));

        List<Pasaporte> pasaportes = pasaporteService.buscarPorListaIds(ids);

        assertNotNull(pasaportes);
        assertEquals(2, pasaportes.size());
        assertEquals("12345", pasaportes.get(0).getNumero());
        assertEquals("12390", pasaportes.get(1).getNumero());
        verify(pasaporteRepository, times(1)).buscarPorListaIds(ids);

    }

    @Test
    void buscarPorNumeroParcial() {

        Pasaporte pasaporte1 = Pasaporte.builder()
                .numero("12345")
                .pasajero(Pasajero.builder()
                        .nombre("Jose")
                        .NID("12345")
                        .build())
                .build();
        Pasaporte pasaporte2 = Pasaporte.builder()
                .numero("67890")
                .pasajero(Pasajero.builder()
                        .nombre("Maria")
                        .NID("67890")
                        .build())
                .build();
        Pasaporte pasaporte3 = Pasaporte.builder()
                .numero("12390")
                .pasajero(Pasajero.builder()
                        .nombre("Pedro")
                        .NID("12390")
                        .build())
                .build();

        when(pasaporteRepository.buscarPorNumeroParcial("123")).thenReturn(List.of(pasaporte1, pasaporte3));

        List<Pasaporte> pasaportes = pasaporteService.buscarPorNumeroParcial("123");

        assertNotNull(pasaportes);
        assertEquals(2, pasaportes.size());
        assertEquals("12345", pasaportes.get(0).getNumero());
        assertEquals("12390", pasaportes.get(1).getNumero());
        verify(pasaporteRepository, times(1)).buscarPorNumeroParcial("123");

    }

}