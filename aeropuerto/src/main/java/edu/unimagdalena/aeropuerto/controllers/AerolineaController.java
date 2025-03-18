package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.entities.Aerolinea;
import edu.unimagdalena.aeropuerto.services.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aerolineas")
public class AerolineaController {

    private final AerolineaService aerolineaService;

    @Autowired
    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @PostMapping
    public ResponseEntity<Aerolinea> createAerolinea(@RequestBody Aerolinea aerolinea) {
        Aerolinea createdAerolinea = aerolineaService.createAerolinea(aerolinea);
        return new ResponseEntity<>(createdAerolinea, HttpStatus.CREATED);
    }
}
