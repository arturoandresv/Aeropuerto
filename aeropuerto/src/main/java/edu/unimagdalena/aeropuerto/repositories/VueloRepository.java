package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    Optional<Vuelo> findById(long id);
    List<Vuelo> getAllById(long id);
    List<Vuelo> getAllByOrigen(String nombre);
    List<Vuelo> getAllByDestino(String nombre);
    Optional<Vuelo> findByNumeroVuelo(String numeroVuelo);

    @Query("select a from Vuelo a order by a.origen asc")
    List<Vuelo> obtenerVuelosOrdenadosAsc();

    @Query("select a from Vuelo a order by a.origen desc")
    List<Vuelo> obtenerVuelosOrdenadasDesc();

    @Query("select distinct a from Vuelo a join a.aerolineas v")
    List<Vuelo> obtenerVuelosConAerolineas();

    @Query("select v from Vuelo v where v.id = ?1")
    List<Vuelo> buscarVueloPorId(Long vueloId);

    @Query("select count(v) from Vuelo a join a.aerolineas v where a.id = ?1")
    Long contarVuelosPorAerolinea(Long aerolineaId);
}
