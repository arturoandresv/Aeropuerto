package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {

    List<Aerolinea> findAllByOrderByIdDesc();
    List<Aerolinea> findAllByOrderByIdAsc();
    Optional<Aerolinea> findByid(Long id);
    List<Aerolinea> findByIdLessThan(Long id);
    List<Aerolinea> findByNombreContaining(String nombre);

    @Query("select a from Aerolinea a order by a.nombre asc")
    List<Aerolinea> obtenerAerolineasOrdenadasAsc();

    @Query("select a from Aerolinea a order by a.nombre desc")
    List<Aerolinea> obtenerAerolineasOrdenadasDesc();

    @Query("select distinct a from Aerolinea a join a.vuelos v")
    List<Aerolinea> obtenerAerolineasConVuelos();

    @Query("select a from Aerolinea a join a.vuelos v where v.id = ?1")
    List<Aerolinea> buscarAerolineasPorVuelo(Long vueloId);

    @Query("select count(v) from Aerolinea a join a.vuelos v where a.id = ?1")
    Long contarVuelosPorAerolinea(Long aerolineaId);

}
