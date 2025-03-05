package edu.unimagdalena.aeropuerto.repositories;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.entities.Pasajero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PasajeroRepository extends Repository<Pasajero, Long> {

    Optional<Pasajero> findByNombre(String nombre);
    Optional<Pasajero> findByEmail(String email);
    Optional<Pasajero> findByCedula(String cedula);
    Optional<Pasajero> findByTelefono(String telefono);
    Optional<Pasajero> findByCorreoAndNombre(String correo, String nombre);

    @Query("select count(p) from Pasajero p")
    Long TotalDePasajeros();

    @Query("select p from Pasajero p")
    List<Pasajero> MostrarTodosLosPasajeros();

    @Query("select p from Pasajero p where p.NID = ?1")
    Pasajero BuscarPorNID(String nid);

    @Query("select p from Pasajero p where p.pasaporte.numero = ?1")
    Pasajero BuscarPorNumeroDePasaporte(String numero);

    @Query("select distinct p from Pasajero p join p.reservas r")
    List<Pasajero> BuscarPasajerosConReservas();
}
