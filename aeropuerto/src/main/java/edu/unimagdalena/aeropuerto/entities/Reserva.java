package edu.unimagdalena.aeropuerto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private UUID codigoReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pasajero_id")
    private Pasajero pasajero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vuelo_id")
    private Vuelo vuelo;
}
