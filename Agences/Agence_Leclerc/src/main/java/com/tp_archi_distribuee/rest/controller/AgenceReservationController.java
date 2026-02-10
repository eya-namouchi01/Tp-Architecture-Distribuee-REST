package com.tp_archi_distribuee.rest.controller;

import com.tp_archi_distribuee.rest.model.CreditCard;
import com.tp_archi_distribuee.rest.service.AgenceReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/agence/reservation")
public class AgenceReservationController {

    @Autowired
    private AgenceReservationService service;

    @PostMapping("/effectuer")
    public String effectuerReservation(
            @RequestParam("offreId") int offreId,
            @RequestParam("agenceId") int agenceId,
            @RequestParam("login") String login,
            @RequestParam("motDePasse") String motDePasse,
            @RequestParam("email") String email,
            @RequestParam("nom") String nom,
            @RequestBody CreditCard creditCard,
            @RequestParam("dateDebut") LocalDate dateDebut,
            @RequestParam("dateFin") LocalDate dateFin

    ) {
        return service.effectuerReservation(
                offreId, agenceId, login, motDePasse,
                email, nom, creditCard, dateDebut, dateFin
        );
    }
}