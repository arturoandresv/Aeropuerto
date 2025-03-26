package edu.unimagdalena.aeropuerto.dtos.mappers;

import edu.unimagdalena.aeropuerto.dtos.PasajeroDTO;
import edu.unimagdalena.aeropuerto.entities.Pasajero;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PasaporteMapper.class, ReservaMapper.class})
public interface PasajeroMapper {

    @Mapping(target = "pasaporteDTO", source = "pasaporte")
    @Mapping(target = "reservasDTO", source = "reservas")
    PasajeroDTO pasajeroToPasajeroDTO(Pasajero pasajero);

}
