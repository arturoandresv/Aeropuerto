package edu.unimagdalena.aeropuerto.controllers;

import edu.unimagdalena.aeropuerto.entities.Reserva;
import edu.unimagdalena.aeropuerto.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva createdReserva = reservaService.createReserva(reserva);
        return new ResponseEntity<>(createdReserva, HttpStatus.CREATED);
    }
}
