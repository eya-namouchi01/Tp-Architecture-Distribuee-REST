package com.tp_archi_distribuee.rest.controller;

import com.tp_archi_distribuee.rest.model.Offre;
import com.tp_archi_distribuee.rest.service.ComparateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comparateur")
public class ComparateurController {

    @Autowired
    private ComparateurService service;

    @GetMapping("/offres")
    public List<Offre> comparer(
            @RequestParam LocalDate dateDebut,
            @RequestParam LocalDate dateFin,
            @RequestParam int nbrePersonne,
            @RequestParam double prixMin,
            @RequestParam double prixMax,
            @RequestParam String categorie,
            @RequestParam String ville
    ) {
        return service.comparerOffres(dateDebut, dateFin, nbrePersonne, prixMin, prixMax, categorie, ville);
    }
}
