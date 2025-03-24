package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Vuelo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VueloService {

    Optional<Vuelo> findById(Long id);

    List<Vuelo> findAllById(Long id);

    List<Vuelo> findAllByOrigen(String origen);

    List<Vuelo> findAllByDestino(String destino);

    Optional<Vuelo> findByNumeroVuelo(UUID numeroVuelo);

    List<Vuelo> obtenerVuelosOrdenadosAsc();

    List<Vuelo> obtenerVuelosOrdenadosDesc();

    List<Vuelo> obtenerVuelosConAerolineas();

    List<Vuelo> buscarVueloPorId(Long vueloId);

    Long contarVuelosPorAerolinea(Long aerolineaId);
}
