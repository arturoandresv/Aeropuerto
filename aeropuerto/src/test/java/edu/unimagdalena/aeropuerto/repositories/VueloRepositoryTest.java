package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.entities.Vuelo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@Import(TestcontainersConfiguration.class)
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VueloRepositoryTest {

    @Autowired
    private VueloRepository vueloRepository;
    @Autowired
    private AerolineaRepository aerolineaRepository;

    private Vuelo crearVueloEjemplo1(){
        return Vuelo.builder()
                .numeroVuelo(UUID.randomUUID())
                .origen("Bogota")
                .destino("Medellin")
                .build();
    }

    @Test
    void findById() {
        Vuelo vuelo = vueloRepository.save(crearVueloEjemplo1());
        Optional<Vuelo> vuelo1 = vueloRepository.findById(vuelo.getId());
        assertTrue(vuelo1.isPresent());
        assertEquals(vuelo.getId(), vuelo1.get().getId());
    }

    @Test
    void findAllById() {
        Vuelo vuelo = vueloRepository.save(crearVueloEjemplo1());
        List<Vuelo> vuelos = vueloRepository.findAllById(vuelo.getId());
        assertFalse(vuelos.isEmpty());
        assertEquals(vuelo.getId(), vuelos.get(0).getId());
    }

    @Test
    void findAllByOrigen() {
        Vuelo vuelo = vueloRepository.save(crearVueloEjemplo1());
        List<Vuelo> vuelos = vueloRepository.findAllByOrigen("Bogota");
        assertFalse(vuelos.isEmpty());
        assertEquals("Bogota", vuelos.get(0).getOrigen());
    }

    @Test
    void findAllByDestino() {
        Vuelo vuelo = vueloRepository.save(crearVueloEjemplo1());
        List<Vuelo> vuelos = vueloRepository.findAllByDestino("Medellin");
        assertFalse(vuelos.isEmpty());
        assertEquals("Medellin", vuelos.get(0).getDestino());
    }

    @Test
    void findByNumeroVuelo() {
        Vuelo vuelo = vueloRepository.save(crearVueloEjemplo1());
        Optional<Vuelo> resultVuelo = vueloRepository.findByNumeroVuelo(vuelo.getNumeroVuelo());
        assertTrue(resultVuelo.isPresent());
        assertEquals(vuelo.getNumeroVuelo(), resultVuelo.get().getNumeroVuelo());
    }

    @Test
    void obtenerVuelosOrdenadosAsc() {
        vueloRepository.save(crearVueloEjemplo1());
        vueloRepository.save(Vuelo.builder().numeroVuelo(UUID.randomUUID()).origen("Cartagena").destino("Cali").build());
        List<Vuelo> vuelos = vueloRepository.obtenerVuelosOrdenadosAsc();
        assertFalse(vuelos.isEmpty());
        assertTrue(vuelos.get(0).getOrigen().compareTo(vuelos.get(1).getOrigen()) < 0);
    }

    @Test
    void obtenerVuelosOrdenadasDesc() {
        vueloRepository.save(crearVueloEjemplo1());
        vueloRepository.save(Vuelo.builder().numeroVuelo(UUID.randomUUID()).origen("Cartagena").destino("Cali").build());
        List<Vuelo> vuelos = vueloRepository.obtenerVuelosOrdenadosDesc();
        assertFalse(vuelos.isEmpty());
        assertTrue(vuelos.get(0).getOrigen().compareTo(vuelos.get(1).getOrigen()) > 0);
    }

    @Test
    void obtenerVuelosConAerolineas() {
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre("Avianca");
        Aerolinea aerolineaGuardada = aerolineaRepository.save(aerolinea);
        vueloRepository.save(Vuelo.builder().numeroVuelo(UUID.randomUUID()).origen("Cartagena").destino("Cali").aerolineas(List.of(aerolineaGuardada)).build());

        List<Vuelo> vuelos = vueloRepository.obtenerVuelosConAerolineas();
        assertFalse(vuelos.isEmpty());
        assertFalse(vuelos.get(0).getAerolineas().isEmpty());
    }

    @Test
    void buscarVueloPorId() {
        Vuelo vuelo = vueloRepository.save(crearVueloEjemplo1());
        List<Vuelo> vuelos = vueloRepository.buscarVueloPorId(vuelo.getId());
        assertFalse(vuelos.isEmpty());
        assertEquals(vuelo.getId(), vuelos.get(0).getId());
    }

    @Test
    void contarVuelosPorAerolinea() {
        // Crear una aerolínea de prueba
        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre("Latam");

        // Guardar la aerolínea en la base de datos
        aerolinea = aerolineaRepository.save(aerolinea);

        // Crear vuelos asociados a la aerolínea
        Vuelo vuelo1 = Vuelo.builder()
                .numeroVuelo(UUID.randomUUID())
                .origen("Bogotá")
                .destino("Medellín")
                .aerolineas(List.of(aerolinea))
                .build();

        Vuelo vuelo2 = Vuelo.builder()
                .numeroVuelo(UUID.randomUUID())
                .origen("Cali")
                .destino("Cartagena")
                .aerolineas(List.of(aerolinea))
                .build();

        // Guardar los vuelos en la base de datos
        vueloRepository.save(vuelo1);
        vueloRepository.save(vuelo2);

        // Ejecutar el método a probar
        Long count = vueloRepository.contarVuelosPorAerolinea(aerolinea.getId());

        // Verificar que el número de vuelos es el esperado
        assertEquals(2, count);
    }
}