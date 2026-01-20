package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;


import java.util.ArrayList;
import java.util.Date;

public interface HotelServiceDisponibiliteInterface {

    ArrayList<Offre> consulterDisponibilite(int agenceId, String login, String motDePasse, Date dateDebut, Date dateFin, int nbrePersonne,
                                            double prixMin, double prixMax, Categorie categorie, String ville  );
}