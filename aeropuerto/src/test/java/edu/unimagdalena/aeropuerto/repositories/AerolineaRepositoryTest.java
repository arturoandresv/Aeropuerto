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
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AerolineaRepositoryTest {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    private List<Aerolinea> crearAerolineas() {
        Vuelo vuelo1 = Vuelo.builder()
                .origen("Bogotá")
                .destino("Medellín")
                .build();

        Vuelo vuelo2 = Vuelo.builder()
                .origen("Cali")
                .destino("Cartagena")
                .build();

        Set<Vuelo> vuelos = new HashSet<>();
        vuelos.add(vuelo1);
        vuelos.add(vuelo2);

        Aerolinea a1 = Aerolinea.builder()
                .nombre("Avianca")
                .vuelos(vuelos)
                .build();

        Aerolinea a2 = Aerolinea.builder()
                .nombre("LATAM")
                .vuelos(vuelos)
                .build();

        return aerolineaRepository.saveAll(List.of(a1, a2));
    }

    @Test
    void findAllByOrderByIdDesc() {
        crearAerolineas();
        List<Aerolinea> result = aerolineaRepository.findAllByOrderByIdDesc();
        assertThat(result).isNotEmpty();
    }

    @Test
    void findAllByOrderByIdAsc() {
        crearAerolineas();
        List<Aerolinea> result = aerolineaRepository.findAllByOrderByIdAsc();
        assertThat(result).isNotEmpty();
    }

    @Test
    void findById() {
        List<Aerolinea> aerolineas = crearAerolineas();
        Optional<Aerolinea> result = aerolineaRepository.findByid(aerolineas.get(0).getId());
        assertThat(result).isPresent();
    }

    @Test
    void findByIdLessThan() {
        List<Aerolinea> aerolineas = crearAerolineas();
        Long id = aerolineas.get(1).getId() + 1;
        List<Aerolinea> result = aerolineaRepository.findByIdLessThan(id);
        assertThat(result).isNotEmpty();
    }

    @Test
    void findByNombreContaining() {
        crearAerolineas();
        List<Aerolinea> result = aerolineaRepository.findByNombreContaining("via");
        assertThat(result).isNotEmpty();
    }

    @Test
    void obtenerAerolineasOrdenadasAsc() {
        crearAerolineas();
        List<Aerolinea> result = aerolineaRepository.obtenerAerolineasOrdenadasAsc();
        assertThat(result).isNotEmpty();
    }

    @Test
    void obtenerAerolineasOrdenadasDesc() {
        crearAerolineas();
        List<Aerolinea> result = aerolineaRepository.obtenerAerolineasOrdenadasDesc();
        assertThat(result).isNotEmpty();
    }

    @Test
    void obtenerAerolineasConVuelos() {
        crearAerolineas();
        List<Aerolinea> result = aerolineaRepository.obtenerAerolineasConVuelos();
        assertThat(result).isNotEmpty();
    }

    @Test
    void buscarAerolineasPorVuelo() {
        List<Aerolinea> aerolineas = crearAerolineas();
        Vuelo vuelo = aerolineas.get(0).getVuelos().iterator().next();
        List<Aerolinea> result = aerolineaRepository.buscarAerolineasPorVuelo(vuelo.getId());
        assertThat(result).isNotEmpty();
    }

    @Test
    void contarVuelosPorAerolinea() {
        List<Aerolinea> aerolineas = crearAerolineas();
        Long count = aerolineaRepository.contarVuelosPorAerolinea(aerolineas.get(0).getId());
        assertThat(count).isGreaterThan(0);
    }
}