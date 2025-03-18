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

import java.util.*;

import static org.assertj.core.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AerolineaRepositoryTest {

    @Autowired
    private AerolineaRepository aerolineaRepository;

    @Autowired
    private VueloRepository vueloRepository;

    private List<Aerolinea> crearAerolineas() {
        Vuelo vuelo1 = vueloRepository.save(Vuelo.builder()
                        .numeroVuelo(UUID.fromString("2804220f-481c-4a12-a548-1edc9b40e82c"))
                        .origen("Bogotá")
                        .destino("Medellín")
                        .build());

        Vuelo vuelo2 = vueloRepository.save(Vuelo.builder()
                        .numeroVuelo(UUID.fromString("cc3df970-5f38-468b-96ec-4818265bfff3"))
                        .origen("Cali")
                        .destino("Cartagena")
                        .build());

        Set<Vuelo> vuelos = new HashSet<>(List.of(vuelo1, vuelo2));

        Aerolinea a1 = Aerolinea.builder()
                .nombre("Avianca")
                .vuelos(vuelos)
                .build();

        Aerolinea a2 = Aerolinea.builder()
                .nombre("LATAM")
                .vuelos(vuelos)
                .build();

        vuelo1.addAerolinea(a1);
        vuelo1.addAerolinea(a2);
        vuelo2.addAerolinea(a1);
        vuelo2.addAerolinea(a2);

        aerolineaRepository.saveAll(List.of(a1, a2));

        vueloRepository.saveAll(List.of(vuelo1, vuelo2));

        return List.of(a1, a2);
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