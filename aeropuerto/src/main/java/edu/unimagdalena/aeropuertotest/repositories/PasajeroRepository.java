package edu.unimagdalena.aeropuertotest.repositories;


import edu.unimagdalena.aeropuertotest.entities.Pasajero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {

    Optional<Pasajero> findAllByNombre(String nombre);
    List<Pasajero> findAllByOrderByIdDesc();
    List<Pasajero> findAllByOrderByIdAsc();
    Optional<Pasajero> findAllById(Long id);
    List<Pasajero> findAllByOrderByNombreAsc();

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
