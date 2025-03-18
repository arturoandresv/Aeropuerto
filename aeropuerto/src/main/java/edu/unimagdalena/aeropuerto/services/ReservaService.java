package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Reserva;
import edu.unimagdalena.aeropuerto.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva createReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}
