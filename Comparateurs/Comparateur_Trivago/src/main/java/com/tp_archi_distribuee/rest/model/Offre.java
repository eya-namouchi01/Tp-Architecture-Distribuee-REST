package com.tp_archi_distribuee.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offre {

    private int id;
    private double prix;

    private LocalDate dateDebutDisponibilite;
    private LocalDate dateFinDisponibilite;

    private int nbreLits;

    private Hotel hotel;
    private Chambre chambre;
    private Agence agence;

    @Override
    public String toString() {
        return "Offre{id=" + id + "}";
    }
}
