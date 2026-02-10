package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;

import java.time.LocalDate;
import java.util.List;

public interface AgenceDisponibiliteInterface {
    List<Offre> consulterDisponibilite(int agenceId, String login, String motDePasse,
                                       LocalDate dateDebut, LocalDate dateFin,
                                       int nbrePersonne, double prixMin, double prixMax,
                                       Categorie categorie, String ville);

}
