package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Vuelo;
import edu.unimagdalena.aeropuerto.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public Vuelo createVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }
}
