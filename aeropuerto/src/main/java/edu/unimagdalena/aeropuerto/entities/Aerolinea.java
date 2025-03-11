package edu.unimagdalena.aeropuerto.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "aerolineas")
    private Set<Vuelo> vuelos;

}
