package edu.unimagdalena.aeropuerto.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne(optional = false)
    @JoinColumn(name="pasajero_id", referencedColumnName = "id")
    private Pasajero pasajero;

}
