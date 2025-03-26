package edu.unimagdalena.aeropuerto.dtos.mappers;

import edu.unimagdalena.aeropuerto.dtos.ReservaDTO;
import edu.unimagdalena.aeropuerto.entities.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VueloMapper.class, PasajeroMapper.class})
public interface ReservaMapper {

    @Mapping(target = "pasajeroDTO", source = "pasajero")
    @Mapping(target = "vueloDTO", source = "vuelo")
    ReservaDTO reservaToReservaDTO(Reserva reserva);

}
