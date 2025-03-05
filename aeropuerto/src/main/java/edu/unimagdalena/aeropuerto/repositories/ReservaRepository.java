package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Optional<Reserva> findById(long id);
    Optional<Reserva> findByCodigoReserva(String codigoReserva);
    Optional<Reserva> findByCodigoaAndAndId(String codigo, long id);
    Optional<Reserva> getReservaByCodigo(String codigo);
    List<Reserva> getReservas();

    @Query("select r from Reserva r where r.codigoReserva = ?1")
    Optional<Reserva> buscarPorCodigoReserva(UUID codigo);

    @Query("select r from Reserva r where r.pasajero = ?1")
    List<Reserva> buscarPorPasajeroId(Long pasajeroId);

    @Query("select r from Reserva r where r.vuelo = ?1")
    List<Reserva> buscarPorVueloId(Long vueloId);

    @Query("select count(r) from Reserva r where r.vuelo = ?1")
    long ContarPorVueloId(Long vueloId);

    @Query("select count(r) > 0 from Reserva r where r.pasajero = ?1 AND r.vuelo = ?2")
    boolean ContarPorPasajeroYVueloId(Long pasajeroId, Long vueloId);
}
