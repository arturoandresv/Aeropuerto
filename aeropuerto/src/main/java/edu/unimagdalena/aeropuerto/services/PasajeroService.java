package edu.unimagdalena.aeropuerto.services;

import edu.unimagdalena.aeropuerto.entities.Pasajero;

import java.util.List;
import java.util.Optional;

public interface PasajeroService {

    Optional<Pasajero> findAllByNombre(String nombre);

    List<Pasajero> findAllByOrderByIdDesc();

    List<Pasajero> findAllByOrderByIdAsc();

    Optional<Pasajero> findAllById(Long id);

    List<Pasajero> findAllByOrderByNombreAsc();

    Long TotalDePasajeros();

    List<Pasajero> MostrarTodosLosPasajeros();

    Pasajero BuscarPorNID(String nid);

    Pasajero BuscarPorNumeroDePasaporte(String numero);

    List<Pasajero> BuscarPasajerosConReservas();
}
