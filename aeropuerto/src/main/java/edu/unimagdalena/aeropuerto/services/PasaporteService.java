package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.repositories.PasaporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PasaporteService {

    private final PasaporteRepository pasaporteRepository;

    @Autowired
    public PasaporteService(PasaporteRepository pasaporteRepository) {
        this.pasaporteRepository = pasaporteRepository;
    }

    public Pasaporte createPasaporte(Pasaporte pasaporte) {
        return pasaporteRepository.save(pasaporte);
    }

    public Optional<Pasaporte> findByNumero(String numero) {
        return pasaporteRepository.findByNumero(numero);
    }

}
