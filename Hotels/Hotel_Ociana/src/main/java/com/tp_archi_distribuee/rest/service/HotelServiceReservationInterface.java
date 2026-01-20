package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.model.CreditCard;


import java.util.Date;

public interface HotelServiceReservationInterface {
    void effectuerReservation(int offreId, int agenceId, String login, String motDePasse, String email, String nom, CreditCard creditCard,
                                Date datedebutReserv, Date datefinReserv );
}
