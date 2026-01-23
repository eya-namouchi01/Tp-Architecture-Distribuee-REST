package com.tp_archi_distribuee.rest.controller;

import com.tp_archi_distribuee.rest.exception.InvalidAgenceException;
import com.tp_archi_distribuee.rest.exception.OffreException;
import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;
import com.tp_archi_distribuee.rest.service.HotelServiceDisponibilite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/disponibilite")
public class HotelDisponibiliteController {

    @Autowired
    private HotelServiceDisponibilite service;

    @GetMapping("/chercher/{agenceId}")
    public List<Offre> consulterDisponibilite(
            @PathVariable int agenceId,
            @RequestParam String login,
            @RequestParam String motDePasse,
            @RequestParam LocalDate dateDebut,
            @RequestParam LocalDate dateFin,
            @RequestParam int nbrePersonne,
            @RequestParam double prixMin,
            @RequestParam double prixMax,
            @RequestParam Categorie categorie,
            @RequestParam String ville
    ) throws InvalidAgenceException, OffreException {

        return service.consulterDisponibilite(
                agenceId, login, motDePasse, dateDebut, dateFin,
                nbrePersonne, prixMin, prixMax, categorie, ville
        );
    }
}
