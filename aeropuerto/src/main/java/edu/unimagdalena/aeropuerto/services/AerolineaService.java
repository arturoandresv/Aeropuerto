package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.repositories.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AerolineaService {

    private final AerolineaRepository aerolineaRepository;

    @Autowired
    public AerolineaService(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    public Aerolinea createAerolinea(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }
}
