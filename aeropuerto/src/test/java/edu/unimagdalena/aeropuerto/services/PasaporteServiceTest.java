package edu.unimagdalena.aeropuerto.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.repositories.PasaporteRepository;
import org.junit.jupiter.api.Assertions;
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

        Assertions.assertNotNull(createdPasaporte.getId());
        Assertions.assertEquals("12345", createdPasaporte.getNumero());
        Assertions.assertEquals("Jose", createdPasaporte.getPasajero().getNombre());

    }

    @Test
    void findByNumero() {

    }
}