package edu.unimagdalena.aeropuerto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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
