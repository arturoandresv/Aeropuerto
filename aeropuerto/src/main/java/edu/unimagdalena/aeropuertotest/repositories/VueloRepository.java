package edu.unimagdalena.aeropuertotest.repositories;

import edu.unimagdalena.aeropuertotest.entities.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VueloRepository extends JpaRepository<Vuelo, Long> {
    Optional<Vuelo> findById(long id);
    List<Vuelo> findAllById(long id);
    List<Vuelo> findAllByOrigen(String origen);
    List<Vuelo> findAllByDestino(String destino);
    Optional<Vuelo> findByNumeroVuelo(UUID numeroVuelo);

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
