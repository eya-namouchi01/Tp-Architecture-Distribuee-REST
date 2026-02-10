package com.tp_archi_distribuee.rest.controller;

import com.tp_archi_distribuee.rest.exception.ClientException;
import com.tp_archi_distribuee.rest.exception.InvalidAgenceException;
import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.CreditCard;
import com.tp_archi_distribuee.rest.service.HotelServiceReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/reservation")
public class HotelReservationController {

    @Autowired
    private HotelServiceReservation service;

    @PostMapping("/effectuer")
    public String effectuerReservation(
            @RequestParam int offreId,
            @RequestParam int agenceId,
            @RequestParam String login,
            @RequestParam String motDePasse,
            @RequestParam String email,
            @RequestParam String nom,
            @RequestBody CreditCard creditCard,
            @RequestParam  LocalDate dateDebut,
            @RequestParam LocalDate dateFin
    ) throws InvalidAgenceException, OffreException, ClientException {

        service.effectuerReservation(
                offreId, agenceId, login, motDePasse, email, nom, creditCard, dateDebut, dateFin
        );
        return "Réservation effectuée avec succès";
    }
}
