package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.entities.Vuelo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AerolineaRepositoryTest {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Test
    void findAllByOrderByIdDesc() {
        Vuelo vuelo1 = Vuelo.builder()
                .id(1L)
                .origen("Bogotá")
                .destino("Medellín")
                .build();

        Vuelo vuelo2 = Vuelo.builder()
                .id(2L)
                .origen("Cali")
                .destino("Cartagena")
                .build();

        Set<Vuelo> vuelos = new HashSet<>();
        vuelos.add(vuelo1);
        vuelos.add(vuelo2);

        Aerolinea aerolinea = Aerolinea.builder()
                .nombre("Avianca")
                .vuelos(vuelos)
                .build();
        Aerolinea aerolinea1 = Aerolinea.builder()
                .nombre("Dorado")
                .vuelos(vuelos)
                .build();

        List<Aerolinea> aerolineas = aerolineaRepository.findAllByOrderByIdDesc();
        Assertions.assertThat(aerolineas.get(0).getNombre()).isEqualTo(aerolinea.getNombre());

    }

    @Test
    void findAllByOrderByIdAsc() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByIdLessThan() {
    }

    @Test
    void findByNombreContaining() {
    }

    @Test
    void obtenerAerolineasOrdenadasAsc() {
    }

    @Test
    void obtenerAerolineasOrdenadasDesc() {
    }

    @Test
    void obtenerAerolineasConVuelos() {
    }

    @Test
    void buscarAerolineasPorVuelo() {
    }

    @Test
    void contarVuelosPorAerolinea() {
    }
}