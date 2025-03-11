package edu.unimagdalena.aeropuertotest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String NID;

    @OneToOne(mappedBy = "pasajero")
    private Pasaporte pasaporte;

    @OneToMany(mappedBy = "pasajero", fetch = FetchType.EAGER)
    private Set<Reserva> reservas;
}
