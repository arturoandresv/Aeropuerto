package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.repositories.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public Pasajero createPasajero(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }
}
