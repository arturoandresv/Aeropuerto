package edu.unimagdalena.aeropuerto.dtos;

import java.util.Set;

public record PasajeroDTO(Long id,
                          String nombre,
                          String NID,
                          PasaporteDTO pasaporteDTO,
                          Set<ReservaDTO> ReservasDTO) {
}
