package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PasaporteRepository extends JpaRepository<Pasaporte, Integer> {
    Optional<Pasaporte> findById(Long id);
    Optional<Pasaporte> findByNumero(String numero);
    Optional<Pasaporte> getById(Long id);
    List<Pasaporte> getByNumero(String numero);
    Optional<Pasaporte> getByIdAndNumero(long id, String numero);

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
