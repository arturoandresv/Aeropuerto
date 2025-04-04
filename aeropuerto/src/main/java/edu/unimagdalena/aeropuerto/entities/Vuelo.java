package edu.unimagdalena.aeropuerto.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private UUID numeroVuelo;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "AEROLINEA_VUELO",
            joinColumns = @JoinColumn(name = "VUELO_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "AEROLINEA_ID", referencedColumnName = "id")
    )
    private List<Aerolinea> aerolineas = new ArrayList<>();

    public void addAerolinea(Aerolinea aerolinea) {
        this.aerolineas.add(aerolinea);
    }

    @OneToMany(mappedBy = "vuelo")
    private Set<Reserva> reservas;

}
