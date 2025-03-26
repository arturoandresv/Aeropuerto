package edu.unimagdalena.aeropuerto.dtos;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record VueloDTO(Long id,
                       UUID numeroVuelo,
                       String origen,
                       String destino,
                       List<AerolineaDTO> aerolineasDTO,
                       Set<ReservaDTO> reservasDTO) {
}
