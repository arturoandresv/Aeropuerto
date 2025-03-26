package edu.unimagdalena.aeropuerto.dtos.mappers;

import edu.unimagdalena.aeropuerto.dtos.AerolineaDTO;
import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {VueloMapper.class})
public interface AerolineaMapper {

    @Mapping(target = "vuelosDTO", source = "vuelos")
    AerolineaDTO aerolineaToAerolineaDTO(Aerolinea aerolinea);

}
