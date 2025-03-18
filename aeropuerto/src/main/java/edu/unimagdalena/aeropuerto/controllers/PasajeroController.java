package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.entities.Pasajero;
import edu.unimagdalena.aeropuerto.services.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    @Autowired
    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @PostMapping
    public ResponseEntity<Pasajero> createPasajero(@RequestBody Pasajero pasajero) {
        Pasajero createdPasajero = pasajeroService.createPasajero(pasajero);
        return new ResponseEntity<>(createdPasajero, HttpStatus.CREATED);
    }
}
