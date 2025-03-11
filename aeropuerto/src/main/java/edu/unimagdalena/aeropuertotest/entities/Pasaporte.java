package edu.unimagdalena.aeropuertotest.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pasaporte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name="pasajero_id", referencedColumnName = "id")
    private Pasajero pasajero;

}
