package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.services.PasaporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pasaportes")
public class PasaporteController {

    private final PasaporteService pasaporteService;

    @Autowired
    public PasaporteController(PasaporteService pasaporteService) {
        this.pasaporteService = pasaporteService;
    }

}
