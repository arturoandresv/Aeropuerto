package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.services.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
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

}
