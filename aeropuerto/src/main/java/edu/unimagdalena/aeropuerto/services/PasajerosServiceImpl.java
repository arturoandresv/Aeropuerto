package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.repositories.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajerosServiceImpl implements PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    @Autowired
    public PasajerosServiceImpl(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public Optional<Pasajero> findAllByNombre(String nombre) {
        return pasajeroRepository.findAllByNombre(nombre);
    }

    @Override
    public List<Pasajero> findAllByOrderByIdDesc() {
        return pasajeroRepository.findAllByOrderByIdDesc();
    }

    @Override
    public List<Pasajero> findAllByOrderByIdAsc() {
        return pasajeroRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Optional<Pasajero> findAllById(Long id) {
        return pasajeroRepository.findAllById(id);
    }

    @Override
    public List<Pasajero> findAllByOrderByNombreAsc() {
        return pasajeroRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Long TotalDePasajeros() {
        return pasajeroRepository.TotalDePasajeros();
    }

    @Override
    public List<Pasajero> MostrarTodosLosPasajeros() {
        return pasajeroRepository.MostrarTodosLosPasajeros();
    }

    @Override
    public Pasajero BuscarPorNID(String nid) {
        return pasajeroRepository.BuscarPorNID(nid);
    }

    @Override
    public Pasajero BuscarPorNumeroDePasaporte(String numero) {
        return pasajeroRepository.BuscarPorNumeroDePasaporte(numero);
    }

    @Override
    public List<Pasajero> BuscarPasajerosConReservas() {
        return pasajeroRepository.BuscarPasajerosConReservas();
    }
}
