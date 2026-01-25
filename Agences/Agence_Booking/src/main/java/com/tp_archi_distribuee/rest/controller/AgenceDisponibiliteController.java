package com.tp_archi_distribuee.rest.controller;

import com.tp_archi_distribuee.rest.model.Categorie;
import com.tp_archi_distribuee.rest.model.Offre;
import com.tp_archi_distribuee.rest.service.AgenceDisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agence")
public class AgenceDisponibiliteController {

    @Autowired
    private AgenceDisponibiliteService service;

    @GetMapping("/disponibilite")
    public List<Offre> consulterDisponibilite(
            @RequestParam("agenceId") int agenceId,
            @RequestParam("login") String login,
            @RequestParam("motDePasse") String motDePasse,
            @RequestParam("dateDebut") LocalDate dateDebut,
            @RequestParam("dateFin") LocalDate dateFin,
            @RequestParam("nbrePersonne") int nbrePersonne,
            @RequestParam("prixMin") double prixMin,
            @RequestParam("prixMax") double prixMax,
            @RequestParam("categorie") Categorie categorie,
            @RequestParam("ville") String ville
    ) {
        return service.consulterDisponibilite(
                agenceId, login, motDePasse,
                dateDebut, dateFin,
                nbrePersonne, prixMin, prixMax,
                categorie, ville
        );
    }
}
