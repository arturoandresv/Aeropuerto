package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PasaporteRepository extends JpaRepository<Pasaporte, Long> {
    Optional<Pasaporte> findByid(Long id);
    Optional<Pasaporte> findByNumero(String numero);
    Optional<Pasaporte> findByIdAndNumero(long id, String numero);
    List<Pasaporte> findAllByOrderByIdDesc();
    List<Pasaporte> findAllByOrderByIdAsc();

    @Query("select p from Pasaporte p order by p.numero asc")
    List<Pasaporte> obtenerPasaportesOrdenadosAsc();

    @Query("select count (p) from Pasaporte p")
    Long contarPasaportes();

    @Query("select p from Pasaporte p where lower(p.numero) = lower(?1)")
    Pasaporte buscarPorNumero(String numero);

    @Query("select p from Pasaporte p where p.id in ?1")
    List<Pasaporte> buscarPorListaIds(List<Long> ids);

    @Query("select p from Pasaporte p where p.numero like %?1%")
    List<Pasaporte> buscarPorNumeroParcial(String numero);

}
