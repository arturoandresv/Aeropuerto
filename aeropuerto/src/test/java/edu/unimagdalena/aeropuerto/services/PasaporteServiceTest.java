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

    }

    @Test
    void findByid() {

    }

    @Test
    void findByIdAndNumero() {

    }

    @Test
    void findAllByOrderByIdDesc() {

    }

    @Test
    void findAllByOrderByIdAsc() {

    }

    @Test
    void obtenerPasaportesOrdenadosAsc() {

    }

    @Test
    void contarPasaportes() {

    }

    @Test
    void buscarPorNumero() {

    }

    @Test
    void buscarPorListaIds() {

    }

    @Test
    void buscarPorNumeroParcial() {

    }

}