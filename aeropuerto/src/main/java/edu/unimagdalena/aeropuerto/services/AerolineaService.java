package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;

import java.util.List;
import java.util.Optional;

public interface AerolineaService {

    List<Aerolinea> findAllByOrderByIdDesc();

    List<Aerolinea> findAllByOrderByIdAsc();

    Optional<Aerolinea> findByid(Long id);

    List<Aerolinea> findByIdLessThan(Long id);

    List<Aerolinea> findByNombreContaining(String nombre);

    List<Aerolinea> obtenerAerolineasOrdenadasAsc();

    List<Aerolinea> obtenerAerolineasOrdenadaDesc();

    List<Aerolinea> obtenerAerolineasConVuelos();

    List<Aerolinea> buscarAerolineasPorVuelo(Long vueloId);

    Long contarVuelosPorAerolinea(Long aerolineaId);

}
