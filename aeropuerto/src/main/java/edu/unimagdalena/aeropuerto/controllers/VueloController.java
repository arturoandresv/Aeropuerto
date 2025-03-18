package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.entities.Vuelo;
import edu.unimagdalena.aeropuerto.services.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @PostMapping
    public ResponseEntity<Vuelo> createVuelo(@RequestBody Vuelo vuelo) {
        Vuelo createdVuelo = vueloService.createVuelo(vuelo);
        return new ResponseEntity<>(createdVuelo, HttpStatus.CREATED);
    }


}
