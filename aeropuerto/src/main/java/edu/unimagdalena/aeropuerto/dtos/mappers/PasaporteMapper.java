package edu.unimagdalena.aeropuerto.dtos.mappers;

import edu.unimagdalena.aeropuerto.dtos.PasaporteDTO;
import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PasajeroMapper.class})
public interface PasaporteMapper {

    @Mapping(target = "pasajeroDTO", source = "pasajero")
    PasaporteDTO pasaporteToPasaporteDTO(Pasaporte pasaporte);

}
