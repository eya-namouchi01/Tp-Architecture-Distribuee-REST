package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgenceDisponibiliteService implements AgenceDisponibiliteInterface {

    private final String HOTEL_OCEANIA_URL =
            "http://localhost:8080/hotel_oceania/disponibilite/chercher";

    private final String HOTEL_RADISSON_URL =
            "http://localhost:8082/hotel_radisson/disponibilite/chercher";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Offre> consulterDisponibilite(
            int agenceId,
            String login,
            String motDePasse,
            LocalDate dateDebut,
            LocalDate dateFin,
            int nbrePersonne,
            double prixMin,
            double prixMax,
            Categorie categorie,
            String ville
    ) {

        List<Offre> resultat = new ArrayList<>();

        resultat.addAll(
                appelerHotel(
                        HOTEL_OCEANIA_URL,
                        agenceId, login, motDePasse,
                        dateDebut, dateFin,
                        nbrePersonne, prixMin, prixMax,
                        categorie, ville
                )
        );

        resultat.addAll(
                appelerHotel(
                        HOTEL_RADISSON_URL,
                        agenceId, login, motDePasse,
                        dateDebut, dateFin,
                        nbrePersonne, prixMin, prixMax,
                        categorie, ville
                )
        );

        if (resultat.isEmpty()) {
            throw new OffreException("Aucune offre n’est disponible");
        }

        return resultat;
    }

    private List<Offre> appelerHotel(
            String baseUrl,
            int agenceId,
            String login,
            String motDePasse,
            LocalDate dateDebut,
            LocalDate dateFin,
            int nbrePersonne,
            double prixMin,
            double prixMax,
            Categorie categorie,
            String ville
    ) {

        String url = baseUrl + "/" + agenceId +
                "?login=" + login +
                "&motDePasse=" + motDePasse +
                "&dateDebut=" + dateDebut +
                "&dateFin=" + dateFin +
                "&nbrePersonne=" + nbrePersonne +
                "&prixMin=" + prixMin +
                "&prixMax=" + prixMax +
                "&categorie=" + categorie +
                "&ville=" + ville;

        try {
            Offre[] offres = restTemplate.getForObject(url, Offre[].class);
            return offres == null ? List.of() : List.of(offres);
        } catch (Exception e) {
            return List.of();
        }
    }
}
