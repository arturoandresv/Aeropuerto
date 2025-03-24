package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Vuelo;
import edu.unimagdalena.aeropuerto.repositories.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VuelosServiceImpl implements VueloService {

    private final VueloRepository vueloRepository;

    @Autowired
    public VuelosServiceImpl(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @Override
    public Optional<Vuelo> findById(Long id) {
        return vueloRepository.findById(id);
    }

    @Override
    public List<Vuelo> findAllById(Long id) {
        return vueloRepository.findAllById(id);
    }

    @Override
    public List<Vuelo> findAllByOrigen(String origen) {
        return vueloRepository.findAllByOrigen(origen);
    }

    @Override
    public List<Vuelo> findAllByDestino(String destino) {
        return vueloRepository.findAllByDestino(destino);
    }

    @Override
    public Optional<Vuelo> findByNumeroVuelo(UUID numeroVuelo) {
        return vueloRepository.findByNumeroVuelo(numeroVuelo);
    }

    @Override
    public List<Vuelo> obtenerVuelosOrdenadosAsc() {
        return vueloRepository.obtenerVuelosOrdenadosAsc();
    }

    @Override
    public List<Vuelo> obtenerVuelosOrdenadosDesc() {
        return vueloRepository.obtenerVuelosOrdenadosDesc();
    }

    @Override
    public List<Vuelo> obtenerVuelosConAerolineas() {
        return vueloRepository.obtenerVuelosConAerolineas();
    }

    @Override
    public List<Vuelo> buscarVueloPorId(Long vueloId) {
        return vueloRepository.buscarVueloPorId(vueloId);
    }

    @Override
    public Long contarVuelosPorAerolinea(Long aerolineaId) {
        return vueloRepository.contarVuelosPorAerolinea(aerolineaId);
    }
}
