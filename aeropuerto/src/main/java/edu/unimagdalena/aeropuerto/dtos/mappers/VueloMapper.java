package edu.unimagdalena.aeropuerto.dtos.mappers;

import edu.unimagdalena.aeropuerto.dtos.VueloDTO;
import edu.unimagdalena.aeropuerto.entities.Vuelo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {AerolineaMapper.class, ReservaMapper.class})
public interface VueloMapper {

    @Mapping(target = "aerolineasDTO", source = "aerolineas")
    @Mapping(target = "reservasDTO", source = "reservas")
    VueloDTO vueloToVueloDTO(Vuelo vuelo);

}
