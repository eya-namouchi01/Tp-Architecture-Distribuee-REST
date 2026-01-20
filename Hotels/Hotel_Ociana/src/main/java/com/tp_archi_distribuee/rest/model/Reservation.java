package com.tp_archi_distribuee.rest.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reservation {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;
    @Getter
    @Setter
    private Date dateEntree;
    @Getter
    @Setter
    private Date dateSortie;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "client_email")
    private Client client;

}
