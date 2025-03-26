package edu.unimagdalena.aeropuerto.dtos;

import java.util.Set;

public record AerolineaDTO(Long id,
                           String nombre,
                           Set<VueloDTO> vuelosDTO) {
}
