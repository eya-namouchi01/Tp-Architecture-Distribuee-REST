package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.CreditCard;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class AgenceReservationService {

    private final String HOTEL_BELLAROIA_URL =
            "http://localhost:8081/hotel_belaroia/reservation/effectuer";

    private final String HOTEL_RADISSON_URL =
            "http://localhost:8082/hotel_radisson/reservation/effectuer";

    public String effectuerReservation(
            int offreId,
            int agenceId,
            String login,
            String motDePasse,
            String email,
            String nom,
            CreditCard creditCard,
            LocalDate dateDebut,
            LocalDate dateFin
    ) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreditCard> entity = new HttpEntity<>(creditCard, headers);

        String params =
                "?offreId=" + offreId +
                        "&agenceId=" + agenceId +
                        "&login=" + login +
                        "&motDePasse=" + motDePasse +
                        "&email=" + email +
                        "&nom=" + nom +
                        "&dateDebut=" + dateDebut +
                        "&dateFin=" + dateFin;

        try {
            return restTemplate.postForObject(
                    HOTEL_BELLAROIA_URL + params,
                    entity,
                    String.class
            );
        } catch (RestClientException e) {
        }

        try {
            return restTemplate.postForObject(
                    HOTEL_RADISSON_URL + params,
                    entity,
                    String.class
            );
        } catch (RestClientException e) {
            throw new RuntimeException("Réservation impossible dans les hôtels");
        }
    }
}
