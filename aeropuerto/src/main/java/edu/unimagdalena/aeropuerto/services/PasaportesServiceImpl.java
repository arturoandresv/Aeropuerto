package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.repositories.PasaporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasaportesServiceImpl implements PasaporteService {

    private final PasaporteRepository pasaporteRepository;

    @Autowired
    public PasaportesServiceImpl(PasaporteRepository pasaporteRepository) {
        this.pasaporteRepository = pasaporteRepository;
    }

    @Override
    public Optional<Pasaporte> findById(Long id) {
        return pasaporteRepository.findById(id);
    }

    @Override
    public Optional<Pasaporte> findByNumero(String numero) {
        return pasaporteRepository.findByNumero(numero);
    }

    @Override
    public Optional<Pasaporte> findByIdAndNumero(Long id, String numero) {
        return pasaporteRepository.findByIdAndNumero(id, numero);
    }

    @Override
    public List<Pasaporte> findAllByOrderByIdAsc() {
        return pasaporteRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Pasaporte> findAllByOrderByIdDesc() {
        return pasaporteRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Pasaporte> obtenerPasaportesOrdenadosAsc() {
        return pasaporteRepository.obtenerPasaportesOrdenadosAsc();
    }

    @Override
    public Long contarPasaportes() {
        return pasaporteRepository.contarPasaportes();
    }

    @Override
    public Pasaporte buscarPorNumero(String numero) {
        return pasaporteRepository.buscarPorNumero(numero);
    }

    @Override
    public List<Pasaporte> buscarPorListaIds(List<Long> ids) {
        return pasaporteRepository.buscarPorListaIds(ids);
    }

    @Override
    public List<Pasaporte> buscarPorNumeroParcial(String numero) {
        return pasaporteRepository.buscarPorNumeroParcial(numero);
    }
}
