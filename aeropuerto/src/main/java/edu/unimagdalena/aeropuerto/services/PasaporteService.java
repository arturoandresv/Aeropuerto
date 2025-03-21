package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;

import java.util.List;
import java.util.Optional;

public interface PasaporteService {

    Optional<Pasaporte> findById(Long id);

    Optional<Pasaporte> findByNumero(String numero);

    Optional<Pasaporte> findByIdAndNumero(Long id, String numero);

    List<Pasaporte> findAllByOrderByIdAsc();

    List<Pasaporte> findAllByOrderByIdDesc();

    List<Pasaporte> obtenerPasaportesOrdenadosAsc();

    Long contarPasaportes();

    Pasaporte buscarPorNumero(String numero);

    List<Pasaporte> buscarPorListaIds(List<Long> ids);

    List<Pasaporte> buscarPorNumeroParcial(String numero);

}
