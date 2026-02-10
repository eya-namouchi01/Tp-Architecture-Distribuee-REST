package com.tp_archi_distribuee.rest.service;

import java.time.LocalDate;

public interface AgenceReservationInterface {

    String effectuerReservation(
            int offreId,
            int agenceId,
            String login,
            String motDePasse,
            String email,
            String nom,
            LocalDate dateDebut,
            LocalDate dateFin
    );
}
