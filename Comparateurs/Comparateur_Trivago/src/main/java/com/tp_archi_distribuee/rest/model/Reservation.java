package com.tp_archi_distribuee.rest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class Reservation {

    private int id;
    private Offre offre;
    private LocalDate dateEntree;
    private LocalDate dateSortie;
    private Client client;

    @Override
    public String toString() {
        return "Reservation{id=" + id + "}";
    }
}
