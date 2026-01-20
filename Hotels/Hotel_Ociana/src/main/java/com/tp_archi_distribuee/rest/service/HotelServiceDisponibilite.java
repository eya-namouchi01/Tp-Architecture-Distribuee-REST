package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.exception.InvalidAgenceException;
import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.Agence;
import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;
import com.tp_archi_distribuee.rest.repository.AgenceRepository;
import com.tp_archi_distribuee.rest.repository.HotelRepository;
import com.tp_archi_distribuee.rest.repository.OffreRepository;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


@Service
public class HotelServiceDisponibilite implements HotelServiceDisponibiliteInterface {
    @Autowired
    private HotelRepository hotelRepo;
    @Autowired
    private OffreRepository offreRepo;
    @Autowired
    private AgenceRepository agenceRepo;



    public ArrayList<Offre> consulterDisponibilite(int agenceId, String login, String motDePasse, Date dateDebut, Date dateFin, int nbrePersonne,
                                                   double prixMin, double prixMax, Categorie categorie, String ville  )
    {
        ArrayList<Offre> offresPresentes= new ArrayList<Offre>(offreRepo.findByAgenceId(agenceId));

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
                !offre.getHotel().getCategorie().equals(categorie) ||
                        !offre.getHotel().getAdresse().getVille().equalsIgnoreCase(ville)||
                        offre.getPrix() < prixMin ||
                        offre.getPrix() > prixMax ||

                dateDebut.before(offre.getDateDebutDisponibilte()) ||
                        dateFin.after(offre.getDatefinDisponibilite()) ||
                        offre.getNbreLits() < nbrePersonne
        );

        if (offresPresentes.isEmpty()) {
            throw new OffreException("Aucune offre ne correspond aux critères demandés");
        }
        return offresPresentes;
    }
}



