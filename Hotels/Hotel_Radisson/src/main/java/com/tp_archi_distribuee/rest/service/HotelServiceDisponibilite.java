package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.exception.InvalidAgenceException;
import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.Agence;
import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;
import com.tp_archi_distribuee.rest.repository.AgenceRepository;
import com.tp_archi_distribuee.rest.repository.HotelRepository;
import com.tp_archi_distribuee.rest.repository.OffreRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class HotelServiceDisponibilite implements HotelServiceDisponibiliteInterface {
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private OffreRepository offreRepo;
    @Autowired
    private AgenceRepository agenceRepo;



    public List<Offre> consulterDisponibilite(int agenceId, String login, String motDePasse, LocalDate dateDebut, LocalDate dateFin, int nbrePersonne,
                                              double prixMin, double prixMax, Categorie categorie, String ville  )
    {
        List<Offre> offresPresentes =
                new ArrayList<>(offreRepo.findByAgenceId(agenceId));

        Agence agence = agenceRepo.findById(agenceId)
                .filter(a -> a.authentifier(login, motDePasse))
                .orElseThrow(() -> new InvalidAgenceException("Les identifiants de l’agence sont incorrects."));


        if (offresPresentes.isEmpty()) {
            throw new OffreException("Aucune offre n’est disponible pour la période et le nombre de personnes indiqués.");
        }

        if (nbrePersonne <= 0 ) {
            throw new OffreException("Le nombre de personnes doit être supérieur à zéro.");
        }

        offresPresentes.removeIf(offre ->
                offre.getPrix() < prixMin ||
                        offre.getPrix() > prixMax ||
                        offre.getNbreLits() < nbrePersonne ||
                        offre.getDateDebutDisponibilte().isAfter(dateDebut) ||
                        offre.getDatefinDisponibilite().isBefore(dateFin) ||
                        !offre.getHotel().getCategorie().equals(categorie) ||
                        !offre.getHotel().getAdresse().getVille().equalsIgnoreCase(ville)
        );


        if (offresPresentes.isEmpty()) {
            throw new OffreException("Aucune offre ne correspond aux critères demandés");
        }

        return new ArrayList<>(offresPresentes);
    }
}



