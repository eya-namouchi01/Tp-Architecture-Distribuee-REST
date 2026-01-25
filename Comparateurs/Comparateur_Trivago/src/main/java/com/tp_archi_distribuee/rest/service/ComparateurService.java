package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.Offre;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ComparateurService implements ComparateurServiceInterface{

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String AGENCE_LECLERC_URL =
            "http://localhost:8084/agence_booking/agence/disponibilite";


    public List<Offre> comparerOffres(
            LocalDate dateDebut,
            LocalDate dateFin,
            int nbrePersonne,
            double prixMin,
            double prixMax,
            String categorie,
            String ville
    ) {

        Offre[] offres = restTemplate.getForObject(
                AGENCE_LECLERC_URL +
                        "?agenceId=1" +
                        "&login=login1" +
                        "&motDePasse=pass1" +
                        "&dateDebut=" + dateDebut +
                        "&dateFin=" + dateFin +
                        "&nbrePersonne=" + nbrePersonne +
                        "&prixMin=" + prixMin +
                        "&prixMax=" + prixMax +
                        "&categorie=" + categorie +
                        "&ville=" + ville,
                Offre[].class
        );

        return offres != null ? Arrays.asList(offres) : List.of();
    }
}
