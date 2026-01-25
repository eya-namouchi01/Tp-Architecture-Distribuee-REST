package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.CreditCard;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class AgenceReservationService {

    private final String HOTEL_RESERVATION_URL =
            "http://localhost:8080/hotel_oceania/reservation/effectuer";

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

        String url =
                HOTEL_RESERVATION_URL +
                        "?offreId=" + offreId +
                        "&agenceId=" + agenceId +
                        "&login=" + login +
                        "&motDePasse=" + motDePasse +
                        "&email=" + email +
                        "&nom=" + nom +
                        "&dateDebut=" + dateDebut +
                        "&dateFin=" + dateFin;

        return restTemplate.postForObject(url, entity, String.class);
    }}
