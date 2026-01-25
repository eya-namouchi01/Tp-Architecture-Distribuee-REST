package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.Offre;

import java.time.LocalDate;
import java.util.List;

public interface ComparateurServiceInterface {
    List<Offre> comparerOffres(
            LocalDate dateDebut,
            LocalDate dateFin,
            int nbrePersonne,
            double prixMin,
            double prixMax,
            String categorie,
            String ville
    );
}
