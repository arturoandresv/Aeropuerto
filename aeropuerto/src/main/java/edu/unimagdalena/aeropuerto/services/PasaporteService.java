package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.repositories.PasaporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<Pasaporte> findByid(Long id) {
        return pasaporteRepository.findById(id);
    }

    public Optional<Pasaporte> findByIdAndNumero(Long id, String numero) {
        return pasaporteRepository.findByIdAndNumero(id, numero);
    }

    public List<Pasaporte> findAllByOrderByIdDesc(){
        return pasaporteRepository.findAllByOrderByIdDesc();
    }

    public List<Pasaporte> findAllByOrderByIdAsc(){
        return pasaporteRepository.findAllByOrderByIdAsc();
    }

    public List<Pasaporte> obtenerPasaportesOrdenadosAsc(){
        return pasaporteRepository.obtenerPasaportesOrdenadosAsc();
    }

    public Long contarPasaportes() {
        return pasaporteRepository.contarPasaportes();
    }

    public Pasaporte buscarPorNumero(String numero) {
        return pasaporteRepository.buscarPorNumero(numero);
    }

    public List<Pasaporte> buscarPorListaIds(List<Long> ids) {
        return pasaporteRepository.buscarPorListaIds(ids);
    }

    public List<Pasaporte> buscarPorNumeroParcial(String numero) {
        return pasaporteRepository.buscarPorNumeroParcial(numero);
    }



}
