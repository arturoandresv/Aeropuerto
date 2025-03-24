package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Reserva;
import edu.unimagdalena.aeropuerto.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservasServiceImpl implements ReservaService{

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservasServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Optional<Reserva> findByCodigoReserva(UUID codigoReserva) {
        return reservaRepository.findByCodigoReserva(codigoReserva);
    }

    @Override
    public Optional<Reserva> findByCodigoReservaAndId(UUID codigoReserva, Long id) {
        return reservaRepository.findByCodigoReservaAndId(codigoReserva, id);
    }

    @Override
    public List<Reserva> findAllByOrderByIdDesc() {
        return reservaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Reserva> findAllByOrderByIdAsc() {
        return reservaRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Reserva> buscarPorCodigoReserva(UUID codigo) {
        return reservaRepository.buscarPorCodigoReserva(codigo);
    }

    @Override
    public List<Reserva> buscarPorPasajeroId(Long pasajeroId) {
        return reservaRepository.buscarPorPasajeroId(pasajeroId);
    }

    @Override
    public List<Reserva> buscarPorVueloId(Long vueloId) {
        return reservaRepository.buscarPorVueloId(vueloId);
    }

    @Override
    public int ContarPorVueloId(Long vueloId) {
        return reservaRepository.ContarPorVueloId(vueloId);
    }

    @Override
    public int ContarPorPasajeroYVueloId(Long pasajeroId, Long vueloId) {
        return reservaRepository.ContarPorPasajeroYVueloId(pasajeroId, vueloId);
    }
}
