package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.entities.Pasaporte;
import edu.unimagdalena.aeropuerto.services.PasaporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pasaportes")
public class PasaporteController {

    private final PasaporteService pasaporteService;

    @Autowired
    public PasaporteController(PasaporteService pasaporteService) {
        this.pasaporteService = pasaporteService;
    }

    @PostMapping
    public ResponseEntity<Pasaporte> createPasaporte(@RequestBody Pasaporte pasaporte) {
        Pasaporte createdPasaporte = pasaporteService.createPasaporte(pasaporte);
        return new ResponseEntity<>(createdPasaporte, HttpStatus.CREATED);
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Pasaporte> findByNumero(@PathVariable String numero) {
        Optional<Pasaporte> pasaporte = pasaporteService.findByNumero(numero);
        return pasaporte.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
