package edu.unimagdalena.aeropuerto.dtos;

import java.util.UUID;

public record ReservaDTO(Long id,
                         UUID codigoReserva,
                         PasajeroDTO pasajeroDTO,
                         VueloDTO vueloDTO) {
}
