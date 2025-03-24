package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Reserva;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservaService {

    Optional<Reserva> findById(Long id);

    Optional<Reserva> findByCodigoReserva(UUID codigoReserva);

    Optional<Reserva> findByCodigoReservaAndId(UUID codigoReserva, Long id);

    List<Reserva> findAllByOrderByIdDesc();

    List<Reserva> findAllByOrderByIdAsc();

    Optional<Reserva> buscarPorCodigoReserva(UUID codigo);

    List<Reserva> buscarPorPasajeroId(Long pasajeroId);

    List<Reserva> buscarPorVueloId(Long vueloId);

    int ContarPorVueloId(Long vueloId);

    int ContarPorPasajeroYVueloId(Long pasajeroId, Long vueloId);
}
