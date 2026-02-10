package com.tp_archi_distribuee.rest.service;

import com.tp_archi_distribuee.rest.exception.ClientException;
import com.tp_archi_distribuee.rest.exception.InvalidAgenceException;
import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.*;
import com.tp_archi_distribuee.rest.repository.AgenceRepository;
import com.tp_archi_distribuee.rest.repository.ClientRepository;
import com.tp_archi_distribuee.rest.repository.OffreRepository;
import com.tp_archi_distribuee.rest.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class HotelServiceReservation implements HotelServiceReservationInterface{
    @Autowired
    private OffreRepository offreRepo;
    @Autowired
    private ReservationRepository reservartionRepo;
    @Autowired
    private AgenceRepository agenceRepo;
    @Autowired
    private ClientRepository clientRepo;

    public void effectuerReservation(int offreId, int agenceId, String login, String motDePasse, String email, String nom, CreditCard creditCard,
                                     LocalDate datedebutReserv, LocalDate datefinReserv )
    {
        Offre offre= offreRepo.findById(offreId)
                .orElseThrow(() -> new OffreException("Aucune offre dont cet identifiant n'est disponible"));
        Agence agence = agenceRepo.findById(agenceId)
                .filter(a -> a.authentifier(login, motDePasse))
                .orElseThrow(() -> new InvalidAgenceException("Les identifiants de l’agence sont incorrects."));


        Client client = clientRepo.findByEmail(email)
                .orElseThrow(() -> new ClientException("Vos identifiants sont incorrects."));
        if (
                !client.getCreditCard().getDateExpiration().equals(creditCard.getDateExpiration()) ||
                        !client.getCreditCard().getCvv().equals(creditCard.getCvv()) ||
                        !client.getCreditCard().getNumCarte().equals(creditCard.getNumCarte())
        ) {
            throw new ClientException("Vos identifiants sont incorrects.");
        }


        Reservation reservation = new Reservation();
        reservation.setOffre(offre);
        reservation.setDateEntree(datedebutReserv);
        reservation.setDateSortie(datefinReserv);
        reservation.setClient(client);

        reservartionRepo.save(reservation);
        System.out.println("Reservation effectuée avec succès");
    }
}
