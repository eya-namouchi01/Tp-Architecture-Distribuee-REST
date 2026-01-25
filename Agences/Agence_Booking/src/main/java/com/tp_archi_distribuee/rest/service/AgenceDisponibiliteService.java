package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;



@Service
public class AgenceDisponibiliteService implements AgenceDisponibiliteInterface {

    private final String HOTEL_URL =
            "http://localhost:8080/hotel_oceania/disponibilite/chercher";

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

        RestTemplate rest = new RestTemplate();

        String url =
                HOTEL_URL + "/" + agenceId +
                        "?login=" + login +
                        "&motDePasse=" + motDePasse +
                        "&dateDebut=" + dateDebut +
                        "&dateFin=" + dateFin +
                        "&nbrePersonne=" + nbrePersonne +
                        "&prixMin=" + prixMin +
                        "&prixMax=" + prixMax +
                        "&categorie=" + categorie +
                        "&ville=" + ville;

        Offre[] offres = rest.getForObject(url, Offre[].class);

        if (offres == null || offres.length == 0) {
            throw new OffreException("Aucune offre n’est disponible");
        }

        return List.of(offres);
    }
}
