package com.tp_archi_distribuee.rest.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    @Getter
    @Setter
    private LocalDate dateEntree;
    @Getter
    @Setter
    private LocalDate dateSortie;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "client_email")
    private Client client;

}
