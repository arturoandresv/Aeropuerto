package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.repositories.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineasServiceImpl implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;

    @Autowired
    public AerolineasServiceImpl(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public List<Aerolinea> findAllByOrderByIdDesc() {
        return aerolineaRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Aerolinea> findAllByOrderByIdAsc() {
        return aerolineaRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Aerolinea> findByid(Long id) {
        return aerolineaRepository.findByid(id);
    }

    @Override
    public List<Aerolinea> findByIdLessThan(Long id) {
        return aerolineaRepository.findByIdLessThan(id);
    }

    @Override
    public List<Aerolinea> findByNombreContaining(String nombre) {
        return aerolineaRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Aerolinea> obtenerAerolineasOrdenadasAsc() {
        return aerolineaRepository.obtenerAerolineasOrdenadasAsc();
    }

    @Override
    public List<Aerolinea> obtenerAerolineasOrdenadaDesc() {
        return aerolineaRepository.obtenerAerolineasOrdenadasDesc();
    }

    @Override
    public List<Aerolinea> obtenerAerolineasConVuelos() {
        return aerolineaRepository.obtenerAerolineasConVuelos();
    }

    @Override
    public List<Aerolinea> buscarAerolineasPorVuelo(Long vueloId) {
        return aerolineaRepository.buscarAerolineasPorVuelo(vueloId);
    }

    @Override
    public Long contarVuelosPorAerolinea(Long aerolineaId) {
        return aerolineaRepository.contarVuelosPorAerolinea(aerolineaId);
    }
}
