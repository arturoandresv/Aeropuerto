package edu.unimagdalena.aeropuerto.dtos;

public record PasaporteDTO(Long id,
                           String nombre,
                           PasajeroDTO pasajero) {
}
